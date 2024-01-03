package top.zynorl.petplanet.post.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zynorl.petplanet.post.common.pojo.dto.PostDTO;
import top.zynorl.petplanet.post.common.pojo.bo.req.PublishPostReqBO;
import top.zynorl.petplanet.post.common.pojo.converter.PostServiceConverter;
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
    @Override
    public Boolean publishPost(PublishPostReqBO publishPostReqBO) {
        // 最近帖子修改时间
        publishPostReqBO.setLastEditTime(LocalDateTime.now());
        // 结构post，保存到mongoDB
//        postServiceConverter.toPostInfo
        PostDTO postDTO = postServiceConverter.toPostDTO(publishPostReqBO);


        return null;
    }
}
