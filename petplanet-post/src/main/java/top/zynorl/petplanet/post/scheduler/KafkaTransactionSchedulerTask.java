package top.zynorl.petplanet.post.scheduler;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.util.concurrent.ListenableFutureCallback;
import top.zynorl.petplanet.common.enums.TransactionStatusEnum;
import top.zynorl.petplanet.sqlServer.entity.TransactionRecordDO;
import top.zynorl.petplanet.sqlServer.service.ITransactionRecordService;

import java.util.List;

/**
 * @version 1.0
 * @Author niuzy
 * @Date 2024/01/05
 **/
@Slf4j
@Component
public class KafkaTransactionSchedulerTask {
    private static final String TOPIC = "publish_post";
    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;
    @Autowired
    private ITransactionRecordService transactionRecordService;
    @Scheduled(fixedRate = 2000) // 2秒钟执行一次
    public void executeTask() {
        QueryWrapper<TransactionRecordDO> tranWrapper = new QueryWrapper<>();
        QueryWrapper<TransactionRecordDO> eq = tranWrapper.
                eq("is_delete", 0).eq("status", TransactionStatusEnum.STARTED.getCode());
        List<TransactionRecordDO> list = transactionRecordService.list(eq);
        list.forEach(transactionRecordDO -> {
            kafkaTemplate.send(TOPIC, transactionRecordDO).addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {

                @Override
                public void onFailure(Throwable throwable) {
                    String Msg = String.format("事务id【%s】发送失败:%s", transactionRecordDO.getTransactionId(), throwable.getMessage());
                    log.error(Msg);
                    throw new TransactionSystemException(Msg);
                }

                @Override
                public void onSuccess(SendResult<String, Object> stringObjectSendResult) {
                    String Msg = String.format("事务id【%s】发送成功", transactionRecordDO.getTransactionId());
                    log.info(Msg);
                }
            });
        });
    }


}
