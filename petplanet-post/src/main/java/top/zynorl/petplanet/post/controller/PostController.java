package top.zynorl.petplanet.post.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.zynorl.petplanet.post.common.pojo.bo.PublishPostReqBO;
import top.zynorl.petplanet.post.common.pojo.req.PublishPostReq;
import top.zynorl.petplanet.post.common.pojo.converter.PostControllerConverter;

/**
 * @version 1.0
 * @Author niuzy
 * @Date 2024/01/02
 **/
@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostControllerConverter postControllerConverter;
    @RequestMapping("/publish")
    public void publish(@RequestBody PublishPostReq publishPostReq){
        // TODO 获取登录人信息
        PublishPostReqBO publishPostReqBO = postControllerConverter.toPublishPostReqBO(publishPostReq);


    }
}
