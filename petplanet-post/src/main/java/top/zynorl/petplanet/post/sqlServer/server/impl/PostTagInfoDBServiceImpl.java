package top.zynorl.petplanet.post.sqlServer.server.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.zynorl.petplanet.post.sqlServer.dao.PostTagInfoDAO;
import top.zynorl.petplanet.post.sqlServer.entity.PostTagInfoDO;
import top.zynorl.petplanet.post.sqlServer.server.IPostTagInfoDBService;

/**
 * <p>
 * 帖子标签基本信息表 服务实现类
 * </p>
 *
 * @author zynorl/niuzy
 * @since 2024-01-02
 */
@Service
public class PostTagInfoDBServiceImpl extends ServiceImpl<PostTagInfoDAO, PostTagInfoDO> implements IPostTagInfoDBService {

}
