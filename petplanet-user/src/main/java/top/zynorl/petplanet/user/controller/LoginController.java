package top.zynorl.petplanet.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.zynorl.petplanet.common.base.R;
import top.zynorl.petplanet.user.common.pojo.req.LoginUserReq;

import java.time.Duration;
import java.util.UUID;

/**
 * @version 1.0
 * @Author niuzy
 * @Date 2023/11/25
 **/

@RestController
@RequestMapping("/user")
public class LoginController {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @RequestMapping("/login")
    public R<String> login(@RequestBody LoginUserReq loginUserReq) {
        // TODO: 查数据库，验证账号和密码是否正确, 验证成功返回该用户信息
        if (true) {
            String sessionId = UUID.randomUUID().toString();
            redisTemplate.opsForValue().set(sessionId, "userid", Duration.ofMinutes(30));
            return R.ok(sessionId);
        }
        return R.no("身份验证失败哦！！！");
    }

}
