package top.zynorl.petplanet.post.sqlServer.service.impl;

import top.zynorl.petplanet.post.sqlServer.entity.PostPictureRelationDO;
import top.zynorl.petplanet.post.sqlServer.mapper.PostPictureRelationDAO;
import top.zynorl.petplanet.post.sqlServer.service.IPostPictureRelationDBService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 帖子与其图片集映射表 服务实现类
 * </p>
 *
 * @author zynorl/niuzy
 * @since 2024-01-02
 */
@Service
public class PostPictureRelationDBServiceImpl extends ServiceImpl<PostPictureRelationDAO, PostPictureRelationDO> implements IPostPictureRelationDBService {

}
