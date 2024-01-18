package top.zynorl.petplanet.user.sender;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * Created by zynorl on 2024/1/18 15:41
 */
@Component
@Slf4j
public class TransactionFailedCallbackSender {
    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;

    /**
     *
     * @param topic
     * @param dataJson
     */
    public void send(String topic, String transactionId, String dataJson){
        String logKey = topic+"_"+transactionId;
        kafkaTemplate.send(topic, dataJson).addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onFailure(Throwable throwable) {
                String msg = String.format("%s发送失败:%s",logKey, throwable.getMessage());
                log.error(msg);
                throw new RuntimeException(msg);
            }

            @Override
            public void onSuccess(SendResult<String, Object> stringObjectSendResult) {
                String msg = String.format("%s发送成功",logKey);
                log.info(msg);
            }
        });
    }

}
