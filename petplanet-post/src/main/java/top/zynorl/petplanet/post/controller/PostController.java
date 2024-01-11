package top.zynorl.petplanet.post.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.zynorl.petplanet.common.base.R;
import top.zynorl.petplanet.post.common.pojo.bo.req.PublishPostReqBO;
import top.zynorl.petplanet.post.common.pojo.req.PublishPostReq;
import top.zynorl.petplanet.post.common.pojo.converter.PostControllerConverter;
import top.zynorl.petplanet.post.service.PostService;

/**
 * @version 1.0
 * @Author niuzy
 * @Date 2024/01/02
 **/
@RestController
@Slf4j
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostService postService;
    @Autowired
    private PostControllerConverter postControllerConverter;
    @RequestMapping("/publish")
    public R<Boolean> publish(@RequestBody PublishPostReq publishPostReq){
        // TODO 获取登录人信息,并将userId添加里面
        PublishPostReqBO publishPostReqBO = postControllerConverter.toPublishPostReqBO(publishPostReq);
        try {
            postService.publishPost(publishPostReqBO);
            return R.ok(true);
        }catch (Exception e){
            log.error("PostController发布失败:"+e.getMessage());
            return R.no("发布失败");
        }
    }
}
