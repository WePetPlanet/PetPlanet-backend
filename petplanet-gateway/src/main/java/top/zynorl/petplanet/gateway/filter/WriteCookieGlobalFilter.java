package top.zynorl.petplanet.gateway.filter;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebSession;
import reactor.core.publisher.Mono;

@Component
public class WriteCookieGlobalFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        WebSession block = exchange.getSession().block();
        System.out.println("转发给下游前的sessionid "+block.getId());
        ServerWebExchange modifiedExchange = exchange.mutate()
                .request(builder -> builder.header(HttpHeaders.COOKIE, "SESSION="+block.getId()+"; Path=/; HttpOnly; SameSite=Lax"))
                .build();
        return chain.filter(modifiedExchange);
    }

    @Override
    public int getOrder() {
        // 设置过滤器的顺序
        return Ordered.HIGHEST_PRECEDENCE;
    }
}