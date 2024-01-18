package top.zynorl.petplanet.post.sqlServer.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.zynorl.petplanet.post.sqlServer.entity.LocationInfoDO;

/**
 * <p>
 * 发布帖子时候的位置信息，从第三方接口中获取 Mapper 接口
 * </p>
 *
 * @author zynorl/niuzy
 * @since 2024-01-02
 */
@Mapper
public interface LocationInfoDAO extends BaseMapper<LocationInfoDO> {

}
