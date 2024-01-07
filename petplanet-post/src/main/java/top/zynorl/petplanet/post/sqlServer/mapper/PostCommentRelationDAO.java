package top.zynorl.petplanet.post.sqlServer.mapper;

import top.zynorl.petplanet.post.sqlServer.entity.PostCommentRelationDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 帖子与评论映射表，包含多级评论 Mapper 接口
 * </p>
 *
 * @author zynorl/niuzy
 * @since 2024-01-02
 */
public interface PostCommentRelationDAO extends BaseMapper<PostCommentRelationDO> {

}
