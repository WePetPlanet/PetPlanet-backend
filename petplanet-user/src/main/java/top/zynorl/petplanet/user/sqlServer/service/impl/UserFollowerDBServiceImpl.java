package top.zynorl.petplanet.user.sqlServer.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.zynorl.petplanet.user.sqlServer.entity.UserFollowerDO;
import top.zynorl.petplanet.user.sqlServer.mapper.UserFollowerDAO;
import top.zynorl.petplanet.user.sqlServer.service.IUserFollowerDBService;

/**
 * <p>
 * 用户粉丝表 服务实现类
 * </p>
 *
 * @author zynorl
 * @since 2023-11-10
 */
@Service
public class UserFollowerDBServiceImpl extends ServiceImpl<UserFollowerDAO, UserFollowerDO> implements IUserFollowerDBService {

}
