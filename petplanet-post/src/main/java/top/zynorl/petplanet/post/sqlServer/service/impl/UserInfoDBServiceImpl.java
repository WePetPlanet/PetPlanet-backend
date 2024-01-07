package top.zynorl.petplanet.post.sqlServer.service.impl;

import top.zynorl.petplanet.post.sqlServer.entity.UserInfoDO;
import top.zynorl.petplanet.post.sqlServer.mapper.UserInfoDAO;
import top.zynorl.petplanet.post.sqlServer.service.IUserInfoDBService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
