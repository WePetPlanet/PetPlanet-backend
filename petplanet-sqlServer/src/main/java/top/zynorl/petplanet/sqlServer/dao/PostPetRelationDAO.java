package top.zynorl.petplanet.sqlServer.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.zynorl.petplanet.sqlServer.entity.PostPetRelationDO;

/**
 * <p>
 * 宠物与帖子的映射表 Mapper 接口
 * </p>
 *
 * @author zynorl/niuzy
 * @since 2024-01-02
 */
@Mapper
public interface PostPetRelationDAO extends BaseMapper<PostPetRelationDO> {

}
