package top.zynorl.petplanet.post.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zynorl.petplanet.post.common.pojo.bo.req.PublishPostReqBO;
import top.zynorl.petplanet.post.service.PostService;
import top.zynorl.petplanet.post.transaction.PostPublishTransactionalService;

/**
 * @version 1.0
 * @Author niuzy
 * @Date 2024/01/03
 **/
@Service
@Slf4j
public class PostServiceImpl implements PostService {

    @Autowired
    private PostPublishTransactionalService postPublishTransactionalService;

    @Override
    public Boolean publishPost(PublishPostReqBO publishPostReqBO) {
        return postPublishTransactionalService.doProcess(publishPostReqBO);
    }

}
