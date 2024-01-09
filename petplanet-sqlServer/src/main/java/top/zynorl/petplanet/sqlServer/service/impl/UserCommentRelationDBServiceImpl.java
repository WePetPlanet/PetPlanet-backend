package top.zynorl.petplanet.sqlServer.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.zynorl.petplanet.sqlServer.dao.UserCommentRelationDAO;
import top.zynorl.petplanet.sqlServer.entity.UserCommentRelationDO;
import top.zynorl.petplanet.sqlServer.service.IUserCommentRelationDBService;

/**
 * <p>
 * 用户与评论的关联表 服务实现类
 * </p>
 *
 * @author zynorl/niuzy
 * @since 2024-01-02
 */
@Service
public class UserCommentRelationDBServiceImpl extends ServiceImpl<UserCommentRelationDAO, UserCommentRelationDO> implements IUserCommentRelationDBService {

}
