package top.zynorl.petplanet.post.sqlServer.server.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.zynorl.petplanet.post.sqlServer.dao.PostCommentRelationDAO;
import top.zynorl.petplanet.post.sqlServer.entity.PostCommentRelationDO;
import top.zynorl.petplanet.post.sqlServer.server.IPostCommentRelationDBService;

/**
 * <p>
 * 帖子与评论映射表，包含多级评论 服务实现类
 * </p>
 *
 * @author zynorl/niuzy
 * @since 2024-01-02
 */
@Service
public class PostCommentRelationDBServiceImpl extends ServiceImpl<PostCommentRelationDAO, PostCommentRelationDO> implements IPostCommentRelationDBService {

}
