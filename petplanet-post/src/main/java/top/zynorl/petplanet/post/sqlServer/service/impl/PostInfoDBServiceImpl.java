package top.zynorl.petplanet.post.sqlServer.service.impl;

import top.zynorl.petplanet.post.sqlServer.entity.PostInfoDO;
import top.zynorl.petplanet.post.sqlServer.mapper.PostInfoDAO;
import top.zynorl.petplanet.post.sqlServer.service.IPostInfoDBService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 帖子信息表 服务实现类
 * </p>
 *
 * @author zynorl/niuzy
 * @since 2024-01-02
 */
@Service
public class PostInfoDBServiceImpl extends ServiceImpl<PostInfoDAO, PostInfoDO> implements IPostInfoDBService {

}
