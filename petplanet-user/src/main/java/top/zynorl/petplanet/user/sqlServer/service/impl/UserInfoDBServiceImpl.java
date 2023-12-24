package top.zynorl.petplanet.user.sqlServer.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zynorl.petplanet.user.sqlServer.entity.UserInfoDO;
import top.zynorl.petplanet.user.sqlServer.mapper.UserInfoDAO;
import top.zynorl.petplanet.user.sqlServer.service.IUserInfoDBService;

import java.util.List;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author zynorl
 * @since 2023-11-10
 */
@Service
public class UserInfoDBServiceImpl extends ServiceImpl<UserInfoDAO, UserInfoDO> implements IUserInfoDBService {

    @Autowired
    private UserInfoDAO userInfoDAO;

    @Override
    public List<UserInfoDO> getUserInfoDOListByKeyword(String keyword) {

        return userInfoDAO.getUserInfoDOListByKeyword(keyword);
    }
}
