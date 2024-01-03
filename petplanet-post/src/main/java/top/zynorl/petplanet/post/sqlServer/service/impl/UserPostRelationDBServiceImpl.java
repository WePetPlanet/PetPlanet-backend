package top.zynorl.petplanet.post.sqlServer.service.impl;

import top.zynorl.petplanet.post.sqlServer.entity.UserPostRelationDO;
import top.zynorl.petplanet.post.sqlServer.mapper.UserPostRelationDAO;
import top.zynorl.petplanet.post.sqlServer.service.IUserPostRelationDBService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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
