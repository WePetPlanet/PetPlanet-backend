package top.zynorl.petplanet.sqlServer.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.zynorl.petplanet.sqlServer.dao.UserBlacklistDAO;
import top.zynorl.petplanet.sqlServer.datasource.annotation.DataSourceSwitch;
import top.zynorl.petplanet.sqlServer.entity.UserBlacklistDO;
import top.zynorl.petplanet.sqlServer.service.IUserBlacklistDBService;

/**
 * <p>
 * 用户黑名单表 服务实现类
 * </p>
 *
 * @author zynorl/niuzy
 * @since 2024-01-02
 */
@Service
@DataSourceSwitch(value = "userDataSource")
public class UserBlacklistDBServiceImpl extends ServiceImpl<UserBlacklistDAO, UserBlacklistDO> implements IUserBlacklistDBService {

}
