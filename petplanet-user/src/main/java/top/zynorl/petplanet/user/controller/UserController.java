package top.zynorl.petplanet.user.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import top.zynorl.petplanet.common.api.CommonPage;
import top.zynorl.petplanet.common.api.CommonResult;
import top.zynorl.petplanet.user.mbg.model.User;
import top.zynorl.petplanet.user.service.impl.UserService;

import java.util.List;


/**
 * Created by zynorl on 2023/11/1 10:12
 * 管理Controller
 */
//  http://localhost:8883/swagger-ui.html
@Api(tags = "UserController", description = "用户管理")
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @ApiOperation("获取所有用户列表")
    @RequestMapping(value = "listAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<User>> getBrandList() {
        return CommonResult.success(userService.listAllUser());
    }

    @ApiOperation("添加用户")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult createBrand(@RequestBody User user) {
        CommonResult commonResult;
        int count = userService.createUser(user);
        if (count == 1) {
            commonResult = CommonResult.success(user);
            LOGGER.debug("createBrand success:{}", user);
        } else {
            commonResult = CommonResult.failed("操作失败");
            LOGGER.debug("createBrand failed:{}", user);
        }
        return commonResult;
    }

    @ApiOperation("更新指定用户信息")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateBrand(@PathVariable("id") Long id, @RequestBody User userDto, BindingResult result) {
        CommonResult commonResult;
        int count = userService.updateUser(id, userDto);
        if (count == 1) {
            commonResult = CommonResult.success(userDto);
            LOGGER.debug("updateBrand success:{}", userDto);
        } else {
            commonResult = CommonResult.failed("操作失败");
            LOGGER.debug("updateBrand failed:{}", userDto);
        }
        return commonResult;
    }

    @ApiOperation("删除指定id的用户")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult deleteBrand(@PathVariable("id") Long id) {
        int count = userService.deleteUser(id);
        if (count == 1) {
            LOGGER.debug("deleteBrand success :id={}", id);
            return CommonResult.success(null);
        } else {
            LOGGER.debug("deleteBrand failed :id={}", id);
            return CommonResult.failed("操作失败");
        }
    }

    @ApiOperation("分页查询用户列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<User>> listBrand(@RequestParam(value = "pageNum", defaultValue = "1")
                                                        @ApiParam("页码") Integer pageNum,
                                                    @RequestParam(value = "pageSize", defaultValue = "3")
                                                        @ApiParam("每页数量") Integer pageSize) {
        List<User> brandList = userService.listUser(pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(brandList));
    }

    @ApiOperation("获取指定id的用户详情")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<User> brand(@PathVariable("id") Long id) {
        return CommonResult.success(userService.getUser(id));
    }
}




