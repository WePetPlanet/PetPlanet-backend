package top.zynorl.petplanet.user.sqlServer.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.zynorl.petplanet.user.sqlServer.entity.UserPostRelationDO;

/**
 * <p>
 * 用户与帖子的关联表 Mapper 接口
 * </p>
 *
 * @author zynorl/niuzy
 * @since 2024-01-02
 */
@Mapper
public interface UserPostRelationDAO extends BaseMapper<UserPostRelationDO> {

}
