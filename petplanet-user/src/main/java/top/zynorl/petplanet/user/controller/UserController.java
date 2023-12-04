package top.zynorl.petplanet.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.zynorl.petplanet.common.base.BaseResPage;
import top.zynorl.petplanet.common.base.R;
import top.zynorl.petplanet.user.common.converter.UserControllerConverter;
import top.zynorl.petplanet.user.common.pojo.bo.GetUserListReqBO;
import top.zynorl.petplanet.user.common.pojo.bo.UserInfoBO;
import top.zynorl.petplanet.user.common.pojo.req.GetUserListReq;
import top.zynorl.petplanet.user.common.pojo.vo.UserInfoVO;
import top.zynorl.petplanet.user.service.UserService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zynorl
 * @since 2023-11-05
 */
@RestController
@RequestMapping("/user/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserControllerConverter userControllerConverter;

    @RequestMapping("/hello")
    public String test(){
        return "hello world";
    }

    @RequestMapping("/getUserList")
    public BaseResPage<UserInfoVO> getUserListByPage(@RequestBody GetUserListReq getUserListReq){
        GetUserListReqBO getUserListReqBO = userControllerConverter.toGetUserListReqBO(getUserListReq);
        // 传入当前的登录用户
        getUserListReqBO.setSystem_user_id(null);

        BaseResPage<UserInfoBO> userInfoBOBaseResPage = userService.getUserInfoListByKeyword(getUserListReqBO);
        BaseResPage<UserInfoVO> userInfoVOBaseResPage = userControllerConverter.toUserInfoVOBaseResPage(userInfoBOBaseResPage);
        R<BaseResPage<UserInfoVO>> R = new R<>();
        R.setCode(200);
        R.setMessage("成功");
        R.setData(userInfoVOBaseResPage);
        return userControllerConverter.toUserInfoVOBaseResPage(userInfoBOBaseResPage);

    }
}
