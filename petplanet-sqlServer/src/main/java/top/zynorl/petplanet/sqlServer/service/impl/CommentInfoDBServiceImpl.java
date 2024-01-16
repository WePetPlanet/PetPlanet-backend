package top.zynorl.petplanet.sqlServer.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.zynorl.petplanet.sqlServer.dao.CommentInfoDAO;
import top.zynorl.petplanet.sqlServer.datasource.annotation.DataSourceSwitch;
import top.zynorl.petplanet.sqlServer.entity.CommentInfoDO;
import top.zynorl.petplanet.sqlServer.service.ICommentInfoDBService;

/**
 * <p>
 * 评论信息表 服务实现类
 * </p>
 *
 * @author zynorl/niuzy
 * @since 2024-01-02
 */
@Service
@DataSourceSwitch(value = "postDataSource")
public class CommentInfoDBServiceImpl extends ServiceImpl<CommentInfoDAO, CommentInfoDO> implements ICommentInfoDBService {

}
