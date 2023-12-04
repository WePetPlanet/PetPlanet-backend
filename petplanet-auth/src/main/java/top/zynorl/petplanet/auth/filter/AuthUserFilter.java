package top.zynorl.petplanet.auth.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import top.zynorl.petplanet.auth.config.UserAuthConfig;
import top.zynorl.petplanet.auth.context.RuntimeContext;
import top.zynorl.petplanet.auth.context.RuntimeContextHolder;
import top.zynorl.petplanet.auth.pojo.UserInfoDTO;
import top.zynorl.petplanet.auth.service.IUserAuthService;
import top.zynorl.petplanet.common.base.R;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;

/**
 * @version 1.0
 * @Author niuzy
 * @Date 2023/11/26
 **/
@Component
@WebFilter(filterName = "authUserFilter", urlPatterns = {"/**"})
public class AuthUserFilter implements Filter {
    private static final Logger log = LoggerFactory.getLogger(AuthUserFilter.class);

    private static final String SESSION = "session";

    @Autowired
    private UserAuthConfig userAuthConfig;

    // TODO 通过fegin远程调用User服务
    @Autowired
    private IUserAuthService userAuthService;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        if (userAuthConfig.getIsDoFilter()) {
            if (!userAuthConfig.getWhiteList().contains(request.getRequestURI())) {
                String sessionId = null;
                if (request.getCookies() != null) {
                    Cookie cookie1 = Arrays.stream(request.getCookies()).
                            filter(cookie -> SESSION.equals(cookie.getName())).findFirst().orElse(null);
                    if (cookie1 != null) {
                        sessionId = cookie1.getValue();
                    }
                    if (StringUtils.isEmpty(sessionId)) {
                        throw new RuntimeException("无用户信息");
                    }
                    R<UserInfoDTO> rt = userAuthService.getUserBySession(sessionId);
                    if (rt.getCode() != 200 || rt.getData() == null) {
                        throw new RuntimeException("无用户信息");
                    }
                    RuntimeContext runtimeContext = new RuntimeContext();
                    runtimeContext.setUserInfoDTO(rt.getData());
                    RuntimeContextHolder.setCurrentRuntimeContext(runtimeContext);
                }
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        if (userAuthConfig.getIsDoFilter()) {
            log.info("用户拦截器已开启");
        }
        Filter.super.init(filterConfig);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
