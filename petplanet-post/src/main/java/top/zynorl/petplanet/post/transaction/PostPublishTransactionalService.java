package top.zynorl.petplanet.post.transaction;

import cn.hutool.core.lang.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.util.concurrent.ListenableFutureCallback;
import top.zynorl.petplanet.mongoserver.entity.PostMO;
import top.zynorl.petplanet.mongoserver.service.PostMOService;
import top.zynorl.petplanet.post.common.pojo.bo.req.PublishPostReqBO;
import top.zynorl.petplanet.post.common.pojo.converter.PostServiceConverter;
import top.zynorl.petplanet.post.common.pojo.dto.PublishPostFailedCallbackDTO;
import top.zynorl.petplanet.post.common.pojo.dto.PublishPostTransactionDTO;
import top.zynorl.petplanet.post.sqlServer.entity.LocationInfoDO;
import top.zynorl.petplanet.post.sqlServer.server.ILocationInfoDBService;

import java.time.LocalDateTime;

/**
 * @version 1.0
 * @Author niuzy
 * @Date 2024/01/10
 **/
@Component
@Slf4j
public class PostPublishTransactionalService implements TCCTransactionalService<PublishPostReqBO> {

    @Autowired
    private PostMOService postMOService;
    @Autowired
    private ILocationInfoDBService locationInfoDBService;
    @Autowired
    private PostServiceConverter postServiceConverter;
    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;
    private static final String postPublishTopic = "post_publish";
    private static String postId;
    private static Long locationId;

    private PostMO post = null;
    private LocationInfoDO locationInfoDO = null;
    private final PublishPostTransactionDTO publishPostDTO = new PublishPostTransactionDTO();

    @Override
    public boolean doProcess(PublishPostReqBO publishPostReqBO) {
        String transactionId = UUID.randomUUID().toString(true);
        if (!doTry(publishPostReqBO)) {
            return false;
        }
        try {
            confirm(transactionId, post, locationInfoDO);
        } catch (Exception e) {
            cancel();
            return false;
        }
        return true;
    }

    private boolean doTry(PublishPostReqBO publishPostReqBO) {
        try {
            // 最近帖子修改时间
            publishPostReqBO.setLastEditTime(LocalDateTime.now());
            // 解构出post，保存到mongoDB
            post = postServiceConverter.toPostMO(publishPostReqBO);
            // 解构出loc，保存到mysql中
            locationInfoDO = postServiceConverter.toLocationInfoDO(publishPostReqBO);
            // 解构出user，跨服务保存到user服务中
            publishPostDTO.setUserId(publishPostReqBO.getUserId());
            publishPostDTO.setTopic(postPublishTopic);
        } catch (Exception e) {
            log.error("转化出错" + e.getMessage());
            return false;
        }
        return true;
    }


    private void confirm(String transactionId, PostMO post, LocationInfoDO locationInfoDO) {
        postId = postMOService.savePost(post);
        boolean isOk = locationInfoDBService.save(locationInfoDO);
        if(isOk){
            locationId = locationInfoDO.getId();
        }
        publishPostDTO.setTransactionId(transactionId);
        publishPostDTO.setPostId(postId);
        publishPostDTO.setLocationId(locationId);
        kafkaTemplate.send(postPublishTopic, publishPostDTO).addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onFailure(Throwable throwable) {
                String Msg = String.format("事务id【%s】发送失败:%s, 本地事务回滚", publishPostDTO.getTransactionId(), throwable.getMessage());
                log.error(Msg);
                throw new TransactionSystemException(Msg);
            }

            @Override
            public void onSuccess(SendResult<String, Object> stringObjectSendResult) {
                String Msg = String.format("事务id【%s】发送成功， 本地事务回滚", publishPostDTO.getTransactionId());
                log.info(Msg);
            }
        });
    }


    private void cancel() {
        postMOService.deletePostById(postId);
        locationInfoDBService.removeById(locationId);
    }

    public void DoCancel(PublishPostFailedCallbackDTO publishPostFailedCallbackDTO) {
        postMOService.deletePostById(publishPostFailedCallbackDTO.getPostId());
        locationInfoDBService.removeById(publishPostFailedCallbackDTO.getLocationId());
    }
}
