package top.zynorl.petplanet.user.listener;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;
import top.zynorl.petplanet.common.enums.TransactionStatusEnum;
import top.zynorl.petplanet.user.common.pojo.dto.PublishPostTransactionDTO;
import top.zynorl.petplanet.user.service.UserPostRelationService;

/**
 * @version 1.0
 * @Author niuzy
 * @Date 2024/01/05
 **/
@Component
@Slf4j
public class MqTransactionListener {
    @Autowired
    private UserPostRelationService userPostRelationService;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    private static final String postPublishTopic = "post_publish";

    @KafkaListener(containerFactory = "manualImmediateListenerContainerFactory", topics = postPublishTopic)
    public void postPublishListener(String message, Acknowledgment ack) {
        PublishPostTransactionDTO publishPostTransactionDTO = JSONUtil.toBean(message, PublishPostTransactionDTO.class);
        String redisKey = publishPostTransactionDTO.getTopic()+publishPostTransactionDTO.getTransactionId();
        String redisValue = (String)redisTemplate.opsForValue().get(redisKey);
        if (redisValue == null) {
            String logMeg = String.format("%s未查询到该事务，已经被消费过，或者无该事务", redisKey);
            log.warn(logMeg);
            throw new DuplicateKeyException("重复消费异常");
        } else if (!TransactionStatusEnum.STARTED.getCode().equals(redisValue)) {
            String logMeg = String.format("%s事务状态异常", redisKey);
            log.warn(logMeg);
            throw new RuntimeException(logMeg);
        }
        try {
            userPostRelationService.saveFromPostPublish(publishPostTransactionDTO);
            redisTemplate.delete(redisKey);
            log.info(String.format("%s事务执行成功", redisKey));
        } catch (Exception e){
            // 记录错误信息并触发重试
            log.error(e.getMessage());
            redisTemplate.opsForValue().setIfPresent(redisKey, TransactionStatusEnum.FAILED.getCode());
            // TODO 重试逻辑 如果重试服务决定不再重试，或者重试次数已达到上限，则确认消息
        }finally {
            ack.acknowledge();
        }
    }
}
