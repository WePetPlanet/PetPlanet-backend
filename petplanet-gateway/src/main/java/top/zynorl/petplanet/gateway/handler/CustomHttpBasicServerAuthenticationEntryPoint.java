package top.zynorl.petplanet.gateway.handler;

import com.alibaba.fastjson.JSON;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.server.authentication.HttpBasicServerAuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

/**
 * 授权出现异常后会执行这个方法
 */
@Component
public class CustomHttpBasicServerAuthenticationEntryPoint extends HttpBasicServerAuthenticationEntryPoint {
    @Override
    public Mono<Void> commence(ServerWebExchange exchange, AuthenticationException e) {
        ServerHttpResponse response = exchange.getResponse();
        response.setStatusCode(HttpStatus.UNAUTHORIZED);
        response.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
        Map<String, Object> result = new HashMap<>();
        result.put("status", HttpStatus.UNAUTHORIZED);
        result.put("message", "鉴权失败");
        byte[] dataBytes = JSON.toJSONString(result).getBytes();
        DataBuffer bodydataBuffer = response.bufferFactory().wrap(dataBytes);
        return response.writeWith(Mono.just(bodydataBuffer));
    }
}
