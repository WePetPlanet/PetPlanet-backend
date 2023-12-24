package top.zynorl.petplanet.user.sqlServer.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.zynorl.petplanet.user.sqlServer.entity.UserCommentRelationDO;

/**
 * <p>
 * 用户与评论的关联表 Mapper 接口
 * </p>
 *
 * @author zynorl
 * @since 2023-11-10
 */
@Mapper
public interface UserCommentRelationDAO extends BaseMapper<UserCommentRelationDO> {

}
