package top.zynorl.petplanet.post.sqlServer.service.impl;

import top.zynorl.petplanet.post.sqlServer.entity.PostCommentRelation;
import top.zynorl.petplanet.post.sqlServer.mapper.PostCommentRelationMapper;
import top.zynorl.petplanet.post.sqlServer.service.IPostCommentRelationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 帖子与评论映射表，包含多级评论 服务实现类
 * </p>
 *
 * @author zynorl/niuzy
 * @since 2024-01-02
 */
@Service
public class PostCommentRelationServiceImpl extends ServiceImpl<PostCommentRelationMapper, PostCommentRelation> implements IPostCommentRelationService {

}
