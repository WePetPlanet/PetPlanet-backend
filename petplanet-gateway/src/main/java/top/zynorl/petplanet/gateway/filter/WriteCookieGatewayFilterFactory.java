//package top.zynorl.petplanet.gateway.filter;
//
//import org.springframework.cloud.gateway.filter.GatewayFilter;
//import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
//import org.springframework.http.HttpHeaders;
//import org.springframework.stereotype.Component;
//import org.springframework.web.server.ServerWebExchange;
//import org.springframework.web.server.WebSession;
//import top.zynorl.petplanet.gateway.util.RedisCache;
//
//import java.util.List;
//
//@Component
//public class WriteCookieGatewayFilterFactory extends AbstractGatewayFilterFactory<WriteCookieGatewayFilterFactory.Config> {
//
//    public WriteCookieGatewayFilterFactory(RedisCache redisCache) {
//        super(Config.class);
//        this.redisCache = redisCache;
//    }
//    private final RedisCache redisCache;
//    @Override
//    public GatewayFilter apply(Config config) {
//        return (exchange, chain) -> {
//            WebSession block = exchange.getSession().block();
//
//
//            List<String> authorization = exchange.getRequest().getHeaders().get("Authorization");
//            String SESSIONID = redisCache.getCacheObject(authorization.get(0));
//            System.out.println("转发给下游前的sessionid 111"+SESSIONID);
//            ServerWebExchange modifiedExchange = exchange.mutate()
//                    .request(builder -> builder.header(HttpHeaders.COOKIE, "SESSION="+SESSIONID))
//                    .build();
//            return chain.filter(modifiedExchange);
//        };
//    }
//
//
//    public static class Config {
//        // 可以在需要的情况下添加配置参数
//    }
//}
