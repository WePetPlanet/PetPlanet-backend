package top.zynorl.petplanet.sqlServer.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.zynorl.petplanet.sqlServer.dao.PostCommentRelationDAO;
import top.zynorl.petplanet.sqlServer.datasource.annotation.DataSourceSwitch;
import top.zynorl.petplanet.sqlServer.entity.PostCommentRelationDO;
import top.zynorl.petplanet.sqlServer.service.IPostCommentRelationDBService;

/**
 * <p>
 * 帖子与评论映射表，包含多级评论 服务实现类
 * </p>
 *
 * @author zynorl/niuzy
 * @since 2024-01-02
 */
@Service
@DataSourceSwitch(value = "postDataSource")
public class PostCommentRelationDBServiceImpl extends ServiceImpl<PostCommentRelationDAO, PostCommentRelationDO> implements IPostCommentRelationDBService {

}
