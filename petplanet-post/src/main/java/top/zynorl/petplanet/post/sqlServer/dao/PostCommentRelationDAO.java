package top.zynorl.petplanet.post.sqlServer.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.zynorl.petplanet.post.sqlServer.entity.PostCommentRelationDO;

/**
 * <p>
 * 帖子与评论映射表，包含多级评论 Mapper 接口
 * </p>
 *
 * @author zynorl/niuzy
 * @since 2024-01-02
 */
@Mapper
public interface PostCommentRelationDAO extends BaseMapper<PostCommentRelationDO> {

}
