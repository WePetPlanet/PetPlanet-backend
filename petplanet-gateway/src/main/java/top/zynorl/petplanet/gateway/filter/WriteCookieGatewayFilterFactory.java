package top.zynorl.petplanet.gateway.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebSession;
import reactor.core.publisher.Mono;

@Component
public class WriteCookieGatewayFilterFactory extends AbstractGatewayFilterFactory<WriteCookieGatewayFilterFactory.Config> {

    public WriteCookieGatewayFilterFactory() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            WebSession block = exchange.getSession().block();
            System.out.println("转发给下游前的sessionid "+block.getId());
            ServerWebExchange modifiedExchange = exchange.mutate()
                    .request(builder -> builder.header(HttpHeaders.COOKIE, "SESSION="+block.getId()))
                    .build();
            return chain.filter(modifiedExchange);
        };
    }


    public static class Config {
        // 可以在需要的情况下添加配置参数
    }
}
