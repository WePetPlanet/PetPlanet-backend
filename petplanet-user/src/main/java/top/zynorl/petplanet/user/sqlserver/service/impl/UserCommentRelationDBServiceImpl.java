package top.zynorl.petplanet.user.sqlServer.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.zynorl.petplanet.user.sqlServer.entity.UserCommentRelationDO;
import top.zynorl.petplanet.user.sqlServer.mapper.UserCommentRelationDAO;
import top.zynorl.petplanet.user.sqlServer.service.IUserCommentRelationDBService;

/**
 * <p>
 * 用户与评论的关联表 服务实现类
 * </p>
 *
 * @author zynorl
 * @since 2023-11-10
 */
@Service
public class UserCommentRelationDBServiceImpl extends ServiceImpl<UserCommentRelationDAO, UserCommentRelationDO> implements IUserCommentRelationDBService {

}
