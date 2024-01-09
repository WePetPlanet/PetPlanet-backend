package top.zynorl.petplanet.post.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zynorl.petplanet.mongoserver.service.PostMOService;
import top.zynorl.petplanet.post.common.pojo.bo.req.PublishPostReqBO;
import top.zynorl.petplanet.post.common.pojo.converter.PostServiceConverter;
import top.zynorl.petplanet.mongoserver.entity.PostMO;
import top.zynorl.petplanet.post.service.PostService;

import java.time.LocalDateTime;

/**
 * @version 1.0
 * @Author niuzy
 * @Date 2024/01/03
 **/
@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostServiceConverter postServiceConverter;
    @Autowired
    private PostMOService postMOService;
    @Override
    public Boolean publishPost(PublishPostReqBO publishPostReqBO) {
        // 最近帖子修改时间
        publishPostReqBO.setLastEditTime(LocalDateTime.now());
        // 解构出post，保存到mongoDB
        PostMO post = postServiceConverter.toPostMO(publishPostReqBO);
        postMOService.savePost(post);
        // 解构出loc，保存到mysql中
        // 解构出user，跨服务保存到user服务中

        return null;
    }
}
