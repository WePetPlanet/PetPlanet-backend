package top.zynorl.petplanet.post.sqlServer.server.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.zynorl.petplanet.post.sqlServer.dao.CommentInfoDAO;
import top.zynorl.petplanet.post.sqlServer.entity.CommentInfoDO;
import top.zynorl.petplanet.post.sqlServer.server.ICommentInfoDBService;

/**
 * <p>
 * 评论信息表 服务实现类
 * </p>
 *
 * @author zynorl/niuzy
 * @since 2024-01-02
 */
@Service
public class CommentInfoDBServiceImpl extends ServiceImpl<CommentInfoDAO, CommentInfoDO> implements ICommentInfoDBService {

}
