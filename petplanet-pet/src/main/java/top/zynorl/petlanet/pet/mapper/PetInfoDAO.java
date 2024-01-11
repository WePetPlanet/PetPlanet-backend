package top.zynorl.petlanet.pet.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.zynorl.petlanet.pet.entity.PetInfoDO;


/**
 * <p>
 * 宠物信息表 Mapper 接口
 * </p>
 *
 * @author suipeng
 * @since 2024-01-10
 */
@Mapper
public interface PetInfoDAO extends BaseMapper<PetInfoDO> {

}
