package top.zynorl.petplanet.gateway.controller;

import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import top.zynorl.petplanet.common.response.Resp;
import top.zynorl.petplanet.gateway.req.LoginReq;

@RestController
public class LoginController {

    public Mono<Resp> login(LoginReq loginReq) {
        return Mono.just(null);
    }
}
