package top.zynorl.petplanet.sqlServer.service;


import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;
import top.zynorl.petplanet.sqlServer.entity.UserInfoDO;

import java.util.List;

/**
 * <p>
 * 用户信息表 服务类
 * </p>
 *
 * @author zynorl/niuzy
 * @since 2024-01-02
 */
public interface IUserInfoDBService extends IService<UserInfoDO> {

    /**
     * 根据keyword模糊查询用户名，得到用户信息列表
     */
    List<UserInfoDO> getUserInfoDOListByKeyword(String keyword);

    /**
     * 根据username获取用户记录
     */
    UserInfoDO getByUsername(String username);

}
