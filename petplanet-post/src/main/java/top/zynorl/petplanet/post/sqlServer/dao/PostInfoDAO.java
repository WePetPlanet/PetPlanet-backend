package top.zynorl.petplanet.post.sqlServer.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.zynorl.petplanet.post.sqlServer.entity.PostInfoDO;

/**
 * <p>
 * 帖子信息表 Mapper 接口
 * </p>
 *
 * @author zynorl/niuzy
 * @since 2024-01-02
 */
@Mapper
public interface PostInfoDAO extends BaseMapper<PostInfoDO> {

}
