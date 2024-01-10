package top.zynorl.petplanet.common.interceptor;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import top.zynorl.petplanet.common.context.UserAuthContext;
import top.zynorl.petplanet.common.security.AuthUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 拦截器：Spring框架特有的，常用于登录校验，权限校验，请求日志打印
 */
@Component
public class AuthUserInterceptor implements HandlerInterceptor {

    private static final Logger LOG = LoggerFactory.getLogger(AuthUserInterceptor.class);
    @Autowired
    HttpSession httpSession;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取header的token参数
        AuthUser authentication = (AuthUser) httpSession.getAttribute("authentication");
        UserAuthContext.setAuthUserThreadLocal(authentication);
        return true;
    }

}
