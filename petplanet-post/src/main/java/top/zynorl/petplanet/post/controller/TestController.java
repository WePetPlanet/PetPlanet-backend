package top.zynorl.petplanet.post.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class TestController {
    @GetMapping("/hello")
    public String hello(HttpSession httpSession)
    {
        return "post hello " + httpSession.getId();
    }
}
