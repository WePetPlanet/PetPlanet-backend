package top.zynorl.petplanet.sqlServer.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.zynorl.petplanet.sqlServer.entity.PictureInfoDO;

/**
 * <p>
 * 图片信息表 Mapper 接口
 * </p>
 *
 * @author zynorl/niuzy
 * @since 2024-01-02
 */
@Mapper
public interface PictureInfoDAO extends BaseMapper<PictureInfoDO> {

}
