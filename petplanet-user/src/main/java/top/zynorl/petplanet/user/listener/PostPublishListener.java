package top.zynorl.petplanet.user.listener;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;
import top.zynorl.petplanet.sqlServer.entity.TransactionRecordDO;
import top.zynorl.petplanet.user.common.pojo.dto.PublishPostDTO;
import top.zynorl.petplanet.user.service.UserPostRelationService;

/**
 * @version 1.0
 * @Author niuzy
 * @Date 2024/01/05
 **/
@Component
@Slf4j
public class PostPublishListener {
    @Autowired
    private UserPostRelationService userPostRelationService;
    private static final String TOPIC = "post_publish";

    @KafkaListener(containerFactory = "manualImmediateListenerContainerFactory", topics = TOPIC)
    public void mq_transaction_listen(TransactionRecordDO message, Acknowledgment ack) {
        String TranId = message.getTransactionId();
        PublishPostDTO dataDTO = JSONUtil.toBean(message.getData(), PublishPostDTO.class);
        try {
            userPostRelationService.saveFromPostPublish(TranId, dataDTO);
            // 处理成功后确认消息
            ack.acknowledge();
        } catch (DuplicateKeyException e) {
            log.warn("重复消费，TranId=" + TranId);
            // 对于重复消费的情况，直接确认消息并返回true（因为这是预期情况而非错误）
            ack.acknowledge();
        } catch (Exception e){
            // 其他异常时，记录错误信息并触发重试
            log.error(e.getMessage());
            // TODO 重试逻辑 如果重试服务决定不再重试，或者重试次数已达到上限，则确认消息
        }
    }
}
