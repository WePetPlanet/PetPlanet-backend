package top.zynorl.petplanet.gateway.controller;

import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import top.zynorl.petplanet.gateway.req.LoginReq;

import java.net.http.HttpRequest;

/**
 * 测试类
 */
@RestController
public class TestController {
    @RequestMapping("/session/get")
    public Mono<ServerHttpRequest> sessionGet(ServerWebExchange exchange) {
        ServerHttpRequest request = exchange.getRequest();
        return Mono.just(request);
    }
    @RequestMapping("/user/normal")
    public Mono<String> normal(LoginReq loginReq) {
        return Mono.just("/user/normal");
    }

    @RequestMapping("/user/admin")
    public Mono<String> admin(LoginReq loginReq) {
        return Mono.just("/user/admin");
    }
}
