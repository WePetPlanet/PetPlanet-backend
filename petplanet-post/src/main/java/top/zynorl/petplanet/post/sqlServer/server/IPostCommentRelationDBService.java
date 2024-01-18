package top.zynorl.petplanet.post.sqlServer.server;

import com.baomidou.mybatisplus.extension.service.IService;
import top.zynorl.petplanet.post.sqlServer.entity.PostCommentRelationDO;

/**
 * <p>
 * 帖子与评论映射表，包含多级评论 服务类
 * </p>
 *
 * @author zynorl/niuzy
 * @since 2024-01-02
 */
public interface IPostCommentRelationDBService extends IService<PostCommentRelationDO> {

}
