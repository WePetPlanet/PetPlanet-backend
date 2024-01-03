package top.zynorl.petlanet.pet.controller;

import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.zynorl.petplanet.common.security.AuthUser;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello(HttpSession session, HttpServletRequest request)
    {

        try {
            AuthUser authentication = (AuthUser) session.getAttribute("authentication");
            if(authentication == null) {
                System.out.println("未能正确获取session");
            }
            System.out.println(authentication);
        }catch (Exception e) {
            System.out.println("未能正确获取session");
        }

        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            System.out.println(cookie.getName()+"-->"+cookie.getValue());
        }
        System.out.println(session.getId());
        return "Pet module hello "+session.getId();
    }
}
