package top.zynorl.petplanet.post.service;

import top.zynorl.petplanet.post.common.pojo.bo.req.PublishPostReqBO;

/**
 * @version 1.0
 * @Author niuzy
 * @Date 2024/01/03
 **/
public interface PostService {
    /**
     * 发布帖子
     * @param publishPostReqBO
     * @return
     */
    void publishPost(PublishPostReqBO publishPostReqBO);
}
