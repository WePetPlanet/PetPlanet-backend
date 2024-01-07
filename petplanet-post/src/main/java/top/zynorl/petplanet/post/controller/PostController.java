package top.zynorl.petplanet.post.controller;

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
        Boolean isOk = postService.publishPost(publishPostReqBO);
        if(isOk){
            return R.ok(true);
        }else {
            return R.no("发布失败");
        }
    }
}
