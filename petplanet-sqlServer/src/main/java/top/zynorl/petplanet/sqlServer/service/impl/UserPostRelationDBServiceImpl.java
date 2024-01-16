package top.zynorl.petplanet.sqlServer.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.zynorl.petplanet.sqlServer.dao.UserPostRelationDAO;
import top.zynorl.petplanet.sqlServer.datasource.annotation.DataSourceSwitch;
import top.zynorl.petplanet.sqlServer.entity.UserPostRelationDO;
import top.zynorl.petplanet.sqlServer.service.IUserPostRelationDBService;

/**
 * <p>
 * 用户与帖子的关联表 服务实现类
 * </p>
 *
 * @author zynorl/niuzy
 * @since 2024-01-02
 */
@Service
@DataSourceSwitch(value = "userDataSource")
public class UserPostRelationDBServiceImpl extends ServiceImpl<UserPostRelationDAO, UserPostRelationDO> implements IUserPostRelationDBService {

}
