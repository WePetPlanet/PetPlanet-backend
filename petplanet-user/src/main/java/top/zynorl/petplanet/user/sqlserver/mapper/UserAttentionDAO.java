package top.zynorl.petplanet.user.sqlServer.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.zynorl.petplanet.user.sqlServer.entity.UserAttentionDO;

/**
 * <p>
 * 用户关注表 Mapper 接口
 * </p>
 *
 * @author zynorl
 * @since 2023-11-10
 */
@Mapper
public interface UserAttentionDAO extends BaseMapper<UserAttentionDO> {

}
