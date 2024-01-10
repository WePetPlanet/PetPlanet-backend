package top.zynorl.petplanet.sqlServer.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zynorl.petplanet.sqlServer.dao.UserInfoDAO;
import top.zynorl.petplanet.sqlServer.entity.UserInfoDO;
import top.zynorl.petplanet.sqlServer.service.IUserInfoDBService;

import java.util.List;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author zynorl/niuzy
 * @since 2024-01-02
 */
@Service
public class UserInfoDBServiceImpl extends ServiceImpl<UserInfoDAO, UserInfoDO> implements IUserInfoDBService {
    @Autowired
    private UserInfoDAO userInfoDAO;
    @Override
    public List<UserInfoDO> getUserInfoDOListByKeyword(String keyword) {

        return userInfoDAO.getUserInfoDOListByKeyword(keyword);
    }

    @Override
    public UserInfoDO getByUsername(String username) {
        QueryWrapper<UserInfoDO> queryWrapper = new QueryWrapper<UserInfoDO>().eq("username", username);
        return getOne(queryWrapper);
    }
}
