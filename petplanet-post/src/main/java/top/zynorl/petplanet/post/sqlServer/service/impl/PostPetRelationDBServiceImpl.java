package top.zynorl.petplanet.post.sqlServer.service.impl;

import top.zynorl.petplanet.post.sqlServer.entity.PostPetRelationDO;
import top.zynorl.petplanet.post.sqlServer.mapper.PostPetRelationDAO;
import top.zynorl.petplanet.post.sqlServer.service.IPostPetRelationDBService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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
