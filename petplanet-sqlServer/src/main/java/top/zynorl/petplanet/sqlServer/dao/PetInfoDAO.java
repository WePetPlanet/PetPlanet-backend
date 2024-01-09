package top.zynorl.petplanet.sqlServer.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.zynorl.petplanet.sqlServer.entity.PetInfoDO;

/**
 * <p>
 * 宠物信息表 Mapper 接口
 * </p>
 *
 * @author zynorl/niuzy
 * @since 2024-01-02
 */
@Mapper
public interface PetInfoDAO extends BaseMapper<PetInfoDO> {

}
