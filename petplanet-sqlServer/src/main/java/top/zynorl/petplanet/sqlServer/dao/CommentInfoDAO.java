package top.zynorl.petplanet.sqlServer.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.zynorl.petplanet.sqlServer.entity.CommentInfoDO;

/**
 * <p>
 * 评论信息表 Mapper 接口
 * </p>
 *
 * @author zynorl/niuzy
 * @since 2024-01-02
 */
@Mapper
public interface CommentInfoDAO extends BaseMapper<CommentInfoDO> {

}
