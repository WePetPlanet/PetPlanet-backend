package top.zynorl.petplanet.user.sqlServer.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.zynorl.petplanet.user.sqlServer.dao.UserBlacklistDAO;
import top.zynorl.petplanet.user.sqlServer.entity.UserBlacklistDO;
import top.zynorl.petplanet.user.sqlServer.service.IUserBlacklistDBService;

/**
 * <p>
 * 用户黑名单表 服务实现类
 * </p>
 *
 * @author zynorl/niuzy
 * @since 2024-01-02
 */
@Service
public class UserBlacklistDBServiceImpl extends ServiceImpl<UserBlacklistDAO, UserBlacklistDO> implements IUserBlacklistDBService {

}
