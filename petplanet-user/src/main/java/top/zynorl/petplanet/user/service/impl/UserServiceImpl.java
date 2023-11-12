package top.zynorl.petplanet.user.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zynorl.petplanet.common.common.base.BaseResPage;
import top.zynorl.petplanet.user.common.converter.UserServiceConverter;
import top.zynorl.petplanet.user.common.pojo.bo.GetUserListReqBO;
import top.zynorl.petplanet.user.common.pojo.bo.UserInfoBO;
import top.zynorl.petplanet.user.service.UserService;
import top.zynorl.petplanet.user.sqlServer.entity.UserInfoDO;
import top.zynorl.petplanet.user.sqlServer.service.IUserInfoDBService;

import java.util.List;

/**
 * Created by zynorl on 2023/11/10 20:32
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private IUserInfoDBService iUserInfoDBService;

    @Autowired
    private UserServiceConverter userServiceConverter;

    @Override
    public BaseResPage<UserInfoBO> getUserInfoListByKeyword(GetUserListReqBO getUserListReqBO) {
        PageHelper.startPage(getUserListReqBO.getPageNum(), getUserListReqBO.getPageSize());
        //之后进行查询操作将自动进行分页
        List<UserInfoDO> list = iUserInfoDBService.getUserInfoDOListByKeyword(getUserListReqBO.getKeyword());
        //通过构造PageInfo对象获取分页信息，如当前页码，总页数，总条数
        PageInfo<UserInfoDO> pageInfo = new PageInfo<>(list);
        BaseResPage<UserInfoDO> userInfoDOBaseResPage = new BaseResPage<>(pageInfo);
        return userServiceConverter.toUserInfoBOBaseResPage(userInfoDOBaseResPage);
    }
}
