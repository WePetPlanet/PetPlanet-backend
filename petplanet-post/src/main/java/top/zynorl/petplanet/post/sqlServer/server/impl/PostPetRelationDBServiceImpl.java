package top.zynorl.petplanet.post.sqlServer.server.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.zynorl.petplanet.post.sqlServer.dao.PostPetRelationDAO;
import top.zynorl.petplanet.post.sqlServer.entity.PostPetRelationDO;
import top.zynorl.petplanet.post.sqlServer.server.IPostPetRelationDBService;

/**
 * <p>
 * 宠物与帖子的映射表 服务实现类
 * </p>
 *
 * @author zynorl/niuzy
 * @since 2024-01-02
 */
@Service
public class PostPetRelationDBServiceImpl extends ServiceImpl<PostPetRelationDAO, PostPetRelationDO> implements IPostPetRelationDBService {

}
