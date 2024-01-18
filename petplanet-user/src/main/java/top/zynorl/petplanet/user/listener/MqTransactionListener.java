package top.zynorl.petplanet.user.listener;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;
import top.zynorl.petplanet.common.exception.RepeatConsumptionException;
import top.zynorl.petplanet.user.common.pojo.dto.PublishPostFailedCallbackDTO;
import top.zynorl.petplanet.user.common.pojo.dto.PublishPostTransactionDTO;
import top.zynorl.petplanet.user.sender.TransactionFailedCallbackSender;
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
    private TransactionFailedCallbackSender transactionFailedCallbackSender;
    private static final String postPublishTopic = "post_publish";

    @KafkaListener(containerFactory = "manualImmediateListenerContainerFactory", topics = postPublishTopic)
    public void postPublishListener(String message, Acknowledgment ack) {
        PublishPostTransactionDTO publishPostTransactionDTO = JSONUtil.toBean(message, PublishPostTransactionDTO.class);
        String logKey = postPublishTopic+"_"+publishPostTransactionDTO.getTransactionId();
        try {
            userPostRelationService.saveFromPostPublish(publishPostTransactionDTO);
            log.info(String.format("%s事务执行成功", logKey));
        }catch (RepeatConsumptionException repeatConsumptionException){
            String logMeg = String.format("%s被消费过了，%s", logKey, repeatConsumptionException.getMessage());
            log.warn(logMeg);
        } catch (Exception e){
            // 记录错误信息并触发重试
            log.error(e.getMessage());
            // 给调用方，发送异常
            PublishPostFailedCallbackDTO publishPostFailedCallbackDTO = new PublishPostFailedCallbackDTO();
            publishPostFailedCallbackDTO.setLocationId(publishPostTransactionDTO.getLocationId());
            publishPostFailedCallbackDTO.setPostId(publishPostTransactionDTO.getPostId());
            String jsonStr = JSONUtil.toJsonStr(publishPostFailedCallbackDTO);
            transactionFailedCallbackSender.send(postPublishTopic, publishPostTransactionDTO.getTransactionId() ,jsonStr);
            // TODO 重试逻辑 如果重试服务决定不再重试，或者重试次数已达到上限，则确认消息
        }finally {
            ack.acknowledge();
        }
    }
}
