package top.zynorl.petplanet.gateway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import top.zynorl.petplanet.gateway.req.LoginReq;

/**
 * 测试类
 */
@RestController
public class TestController {
    @RequestMapping("/user/normal")
    public Mono<String> normal(LoginReq loginReq) {
        return Mono.just("/user/normal");
    }

    @RequestMapping("/user/admin")
    public Mono<String> admin(LoginReq loginReq) {
        return Mono.just("/user/admin");
    }
}
