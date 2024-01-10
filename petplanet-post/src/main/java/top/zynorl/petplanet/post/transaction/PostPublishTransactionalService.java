package top.zynorl.petplanet.post.transaction;

import cn.hutool.core.lang.UUID;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.zynorl.petplanet.common.enums.TransactionStatusEnum;
import top.zynorl.petplanet.mongoserver.entity.PostMO;
import top.zynorl.petplanet.mongoserver.service.PostMOService;
import top.zynorl.petplanet.post.common.pojo.bo.req.PublishPostReqBO;
import top.zynorl.petplanet.post.common.pojo.converter.PostServiceConverter;
import top.zynorl.petplanet.post.common.pojo.dto.PublishPostDTO;
import top.zynorl.petplanet.sqlServer.entity.LocationInfoDO;
import top.zynorl.petplanet.sqlServer.entity.TransactionRecordDO;
import top.zynorl.petplanet.sqlServer.service.ILocationInfoDBService;
import top.zynorl.petplanet.sqlServer.service.ITransactionRecordService;

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
    private ITransactionRecordService transactionRecordService;
    @Autowired
    private PostServiceConverter postServiceConverter;

    private PostMO post = null;
    private LocationInfoDO locationInfoDO = null;
    private final PublishPostDTO publishPostDTO = new PublishPostDTO();

    @Override
    public boolean doProcess(PublishPostReqBO publishPostReqBO) {
        String transactionId = UUID.randomUUID().toString(true);
        if (!doTry(publishPostReqBO)) {
            return false;
        }
        try {
            confirm(transactionId, post, locationInfoDO);
        } catch (Exception e) {
            cancel(transactionId);
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
        } catch (Exception e) {
            log.error("转化出错" + e.getMessage());
            return false;
        }
        return true;
    }


    private void confirm(String transactionId, PostMO post, LocationInfoDO locationInfoDO) {
        String postId = postMOService.savePost(post);
        locationInfoDBService.save(locationInfoDO);
        publishPostDTO.setPostId(postId);
        String jsonStr = JSONUtil.toJsonStr(publishPostDTO);
        TransactionRecordDO transactionRecordDO = TransactionRecordDO.builder()
                .status(TransactionStatusEnum.STARTED.getCode()).transactionId(transactionId).data(jsonStr).build();
        transactionRecordService.save(transactionRecordDO);
    }


    private void cancel(String transactionId) {
        postMOService.deletePostByTransactionId(transactionId);
        locationInfoDBService.deleteByTransactionId(transactionId);
        transactionRecordService.deleteByTransactionId(transactionId);
    }
}
