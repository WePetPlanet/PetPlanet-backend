package top.zynorl.petlanet.pet.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.web.http.CookieSerializer;
import org.springframework.session.web.http.DefaultCookieSerializer;
import org.springframework.session.web.http.HttpSessionIdResolver;
import top.zynorl.petlanet.pet.filter.CustomSessionIdResolver;

@Configuration
public class SessionConfig {
    //https://blog.csdn.net/qq_41358574/article/details/129530334
    @Bean
    public CookieSerializer cookieSerializer() {
        return new DefaultCookieSerializer();
    }

    @Bean
    public HttpSessionIdResolver httpSessionIdResolver(CookieSerializer cookieSerializer) {
        CustomSessionIdResolver sessionIdResolver = new CustomSessionIdResolver();
//        sessionIdResolver.setCookieSerializer(cookieSerializer); // 设置 Cookie 序列化器
        return sessionIdResolver;
    }
}
