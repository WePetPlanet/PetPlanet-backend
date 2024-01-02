package top.zynorl.petlanet.pet.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello(HttpSession session)
    {
        System.out.println(session);
        return "Pet module hello";
    }
}
