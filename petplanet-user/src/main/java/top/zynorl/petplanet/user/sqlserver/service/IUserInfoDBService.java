package top.zynorl.petplanet.user.sqlServer.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.zynorl.petplanet.user.sqlServer.entity.UserInfoDO;

import java.util.List;

/**
 * <p>
 * 用户信息表 服务类
 * </p>
 *
 * @author zynorl
 * @since 2023-11-10
 */
public interface IUserInfoDBService extends IService<UserInfoDO> {

    /**
     * 根据keyword模糊查询用户名，得到用户信息列表
     */
    List<UserInfoDO> getUserInfoDOListByKeyword(String keyword);

}
