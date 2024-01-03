package top.zynorl.petplanet.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.http.HttpCookie;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.session.CookieWebSessionIdResolver;
import org.springframework.web.server.session.WebSessionIdResolver;

import java.util.Base64;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class Config {
    @Bean
    public RedisTemplate<String, ?> getRedisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, ?> template = new RedisTemplate<>();
        template.setKeySerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        template.setEnableTransactionSupport(true);
        template.setConnectionFactory(factory);
        return template;
    }

    @Bean
    public RedisSerializer<String> springSessionDefaultRedisKeySerializer() {
        return new StringRedisSerializer();
    }


//    @Bean
//    public WebSessionIdResolver webSessionIdResolver() {
//        return new CustomWebSessionIdResoler();
//    }
//    private class CustomWebSessionIdResoler extends CookieWebSessionIdResolver {
//        @Override
//        public List<String> resolveSessionIds(ServerWebExchange exchange) {
//            MultiValueMap<String, HttpCookie> cookieMap = exchange.getRequest().getCookies();
//            //获取SESSION
//            List<HttpCookie> cookies = cookieMap.get(getCookieName());
//            if(cookies == null) {
//                return Collections.emptyList();
//            }
//
//            return cookies.stream().map(HttpCookie::getValue).map(this::base64Decode).collect(Collectors.toList());
//        }
//        private String base64Decode(String base64Value) {
//            try {
//                byte[] decode = Base64.getDecoder().decode(base64Value);
//                return new String(decode);
//            } catch (Exception ex) {
//                System.out.println("Unable to Base64 decode value: " + base64Value);
//                return null;
//            }
//        }
//    }




}
