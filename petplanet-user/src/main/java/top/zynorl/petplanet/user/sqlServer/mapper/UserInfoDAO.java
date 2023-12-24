package top.zynorl.petplanet.user.sqlServer.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.zynorl.petplanet.user.sqlServer.entity.UserInfoDO;

import java.util.List;

/**
 * <p>
 * 用户信息表 Mapper 接口
 * </p>
 *
 * @author zynorl
 * @since 2023-11-10
 */
@Mapper
public interface UserInfoDAO extends BaseMapper<UserInfoDO> {

    /**
     * 根据keyword模糊查询用户名，得到用户信息列表
     */
    List<UserInfoDO> getUserInfoDOListByKeyword(@Param("keyword") String keyword);

}
