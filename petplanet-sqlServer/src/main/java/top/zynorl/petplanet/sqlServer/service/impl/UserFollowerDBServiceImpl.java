package top.zynorl.petplanet.sqlServer.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.zynorl.petplanet.sqlServer.dao.UserFollowerDAO;
import top.zynorl.petplanet.sqlServer.datasource.annotation.DataSourceSwitch;
import top.zynorl.petplanet.sqlServer.entity.UserFollowerDO;
import top.zynorl.petplanet.sqlServer.service.IUserFollowerDBService;

/**
 * <p>
 * 用户粉丝表 服务实现类
 * </p>
 *
 * @author zynorl/niuzy
 * @since 2024-01-02
 */
@Service
@DataSourceSwitch(value = "userDataSource")
public class UserFollowerDBServiceImpl extends ServiceImpl<UserFollowerDAO, UserFollowerDO> implements IUserFollowerDBService {

}
