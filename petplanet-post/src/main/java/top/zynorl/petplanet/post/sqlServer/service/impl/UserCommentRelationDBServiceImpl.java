package top.zynorl.petplanet.post.sqlServer.service.impl;

import top.zynorl.petplanet.post.sqlServer.entity.UserCommentRelationDO;
import top.zynorl.petplanet.post.sqlServer.mapper.UserCommentRelationDAO;
import top.zynorl.petplanet.post.sqlServer.service.IUserCommentRelationDBService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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
