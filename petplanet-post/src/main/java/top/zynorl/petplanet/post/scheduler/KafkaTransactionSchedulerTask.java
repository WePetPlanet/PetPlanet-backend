package top.zynorl.petplanet.post.scheduler;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.*;

/**
 * @version 1.0
 * @Author niuzy
 * @Date 2024/01/05
 **/
@Slf4j
@Component
public class KafkaTransactionSchedulerTask {
    private static final String postPublishTopic = "post_publish";
    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Scheduled(fixedRate = 2000) // 2秒钟执行一次
    public void executeTask() {
        String keyPattern = postPublishTopic+"*";
        Map<String, String> map = keyScanner(keyPattern);
        map.entrySet().forEach(entity -> {
            kafkaTemplate.send(postPublishTopic, entity).addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {

                @Override
                public void onFailure(Throwable throwable) {
                    String Msg = String.format("事务id【%s】发送失败:%s", entity.getKey(), throwable.getMessage());
                    log.error(Msg);
                    throw new TransactionSystemException(Msg);
                }

                @Override
                public void onSuccess(SendResult<String, Object> stringObjectSendResult) {
                    String Msg = String.format("事务id【%s】发送成功", entity.getKey());
                    log.info(Msg);
                }
            });
        });
    }

    private Map<String, String> keyScanner(String keyPattern){

        Set<String> keys = redisTemplate.execute((RedisCallback<Set<String>>) connection -> {
            Set<String> binaryKeys = new HashSet<>();
            ScanOptions options = ScanOptions.scanOptions().match(keyPattern).count(100).build();
            Cursor<byte[]> cursor = connection.scan(options);
            while (cursor.hasNext()) {
                binaryKeys.add(new String(cursor.next()));
            }
            return binaryKeys;
        });
        Map<String, String> scans = new HashMap<>();
        assert keys != null;
        for (String key : keys) {
            String value = (String)redisTemplate.opsForValue().get(key);
            String tranId = key.substring(keyPattern.length());
            scans.put(tranId, value);
        }
        return scans;
    }


}
