package top.zynorl.petplanet.post.listener;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import top.zynorl.petplanet.post.common.pojo.dto.PublishPostFailedCallbackDTO;
import top.zynorl.petplanet.post.transaction.PostPublishTransactionalService;

/**
 * @version 1.0
 * @Author niuzy
 * @Date 2024/01/05
 **/
@Component
@Slf4j
public class TransactionFailedCallbackListener {
    private static final String postPublishTopic = "post_publish";
    @Autowired
    private PostPublishTransactionalService postPublishTransactionalService;

    @KafkaListener(topics = postPublishTopic)
    public void postPublishListener(String message) {
        PublishPostFailedCallbackDTO publishPostFailedCallbackDTO = JSONUtil.toBean(message, PublishPostFailedCallbackDTO.class);
        postPublishTransactionalService.DoCancel(publishPostFailedCallbackDTO);
    }
}
