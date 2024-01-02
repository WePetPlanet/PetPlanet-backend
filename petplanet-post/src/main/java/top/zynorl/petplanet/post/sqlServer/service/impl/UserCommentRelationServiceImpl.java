package top.zynorl.petplanet.post.sqlServer.service.impl;

import top.zynorl.petplanet.post.sqlServer.entity.UserCommentRelation;
import top.zynorl.petplanet.post.sqlServer.mapper.UserCommentRelationMapper;
import top.zynorl.petplanet.post.sqlServer.service.IUserCommentRelationService;
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
public class UserCommentRelationServiceImpl extends ServiceImpl<UserCommentRelationMapper, UserCommentRelation> implements IUserCommentRelationService {

}
