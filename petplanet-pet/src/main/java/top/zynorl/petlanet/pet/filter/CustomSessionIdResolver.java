package top.zynorl.petlanet.pet.filter;



import org.springframework.session.web.http.CookieHttpSessionIdResolver;
import org.springframework.session.web.http.HttpSessionIdResolver;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 重写SESSION解析器，让下游微服务可以从从gateway传过来的cookie中获取到SESSION
 */
public class CustomSessionIdResolver implements HttpSessionIdResolver {

    private String sessionIdCookieName = "SESSION";


    @Override
    public List<String> resolveSessionIds(HttpServletRequest httpServletRequest) {
        Cookie[] cookies = httpServletRequest.getCookies();
        for (Cookie cookie : cookies) {
            if(cookie.getName().equals(sessionIdCookieName)) {
                return Arrays.asList(cookie.getValue());
            }
        }
        return Collections.emptyList();
    }

    @Override
    public void setSessionId(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, String s) {

    }

    @Override
    public void expireSession(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

    }
}
