package top.zynorl.petplanet.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.zynorl.petplanet.common.response.Resp;
import top.zynorl.petplanet.user.sqlServer.entity.UserInfoDO;
import top.zynorl.petplanet.user.sqlServer.service.IUserInfoDBService;
import top.zynorl.petplanet.user.common.pojo.req.RegisterReq;
import top.zynorl.petplanet.user.service.UserService;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class RegisterController {
    @Autowired
    private IUserInfoDBService userService;


    @PostMapping("/register")
    public Resp<Object> register(@Valid  @RequestBody RegisterReq registerReq) {
        UserInfoDO userInfoDO = new UserInfoDO();
        userInfoDO.setUsername(registerReq.getUsername());
        userInfoDO.setPassword(registerReq.getPassword());
        userService.save(userInfoDO);
        return new Resp<>().SUCCESS("success");
    }
}
