package top.zynorl.petplanet.user.sqlServer.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.zynorl.petplanet.user.sqlServer.dao.UserPostRelationDAO;
import top.zynorl.petplanet.user.sqlServer.entity.UserPostRelationDO;
import top.zynorl.petplanet.user.sqlServer.service.IUserPostRelationDBService;

/**
 * <p>
 * 用户与帖子的关联表 服务实现类
 * </p>
 *
 * @author zynorl/niuzy
 * @since 2024-01-02
 */
@Service
public class UserPostRelationDBServiceImpl extends ServiceImpl<UserPostRelationDAO, UserPostRelationDO> implements IUserPostRelationDBService {

}
