package top.zynorl.petplanet.gateway.filter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebSession;
import reactor.core.publisher.Mono;
import top.zynorl.petplanet.gateway.util.RedisCache;

import java.util.List;

@Component
public class WriteCookieGlobalFilter implements GlobalFilter, Ordered {
    private final RedisCache redisCache;

    public WriteCookieGlobalFilter(RedisCache redisCache) {
        this.redisCache = redisCache;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        WebSession block = exchange.getSession().block();


        List<String> authorization = exchange.getRequest().getHeaders().get("Authorization");
        String SESSIONID = redisCache.getCacheObject(authorization.get(0));
        System.out.println("转发给下游前的sessionid"+SESSIONID);
        ServerWebExchange modifiedExchange = exchange.mutate()
                .request(builder -> builder.header(HttpHeaders.COOKIE, "SESSION="+SESSIONID))
                .build();
        return chain.filter(modifiedExchange);
    }

    @Override
    public int getOrder() {
        // 设置过滤器的顺序
        return Ordered.HIGHEST_PRECEDENCE;
    }
}