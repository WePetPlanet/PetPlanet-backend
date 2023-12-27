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
    @RequestMapping("/test")
    public Mono<String> test(LoginReq loginReq) {
        return Mono.just("test");
    }
}
