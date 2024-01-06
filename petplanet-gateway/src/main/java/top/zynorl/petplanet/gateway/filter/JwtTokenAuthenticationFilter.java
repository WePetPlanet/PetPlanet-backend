package top.zynorl.petplanet.gateway.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import org.springframework.web.server.WebSession;
import reactor.core.publisher.Mono;
import top.zynorl.petplanet.common.util.JwtUtil;
import top.zynorl.petplanet.gateway.config.JwtProperties;
import top.zynorl.petplanet.gateway.util.JwtTokenUtil;

public class JwtTokenAuthenticationFilter implements WebFilter {

    private final JwtProperties jwtProperties;

    public JwtTokenAuthenticationFilter(JwtProperties jwtProperties) {
        this.jwtProperties = jwtProperties;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange serverWebExchange, WebFilterChain webFilterChain) {
        String token = resolveToken(serverWebExchange.getRequest());
        if(StringUtils.hasLength(token)) {
            // 验证token有效性
            Authentication authentication = JwtTokenUtil.getAuthentication(token, jwtProperties.getSecretKey());
            if (authentication != null) {
                //将授权信息写入session
                serverWebExchange.getSession().subscribe(webSession -> {
                    System.out.println(webSession.getId());
                });
                return webFilterChain.filter(serverWebExchange)
                        .subscriberContext(ReactiveSecurityContextHolder.withAuthentication(authentication));
            }

        }


        return webFilterChain.filter(serverWebExchange);
    }

    private String resolveToken(ServerHttpRequest request) {
        String x_token = request.getHeaders().getFirst("Authorization");
        if(StringUtils.hasLength(x_token)) {
            return x_token;
        }

        return null;
    }
}
