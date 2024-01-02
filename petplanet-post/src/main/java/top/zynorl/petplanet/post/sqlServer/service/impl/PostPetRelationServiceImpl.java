package top.zynorl.petplanet.post.sqlServer.service.impl;

import top.zynorl.petplanet.post.sqlServer.entity.PostPetRelation;
import top.zynorl.petplanet.post.sqlServer.mapper.PostPetRelationMapper;
import top.zynorl.petplanet.post.sqlServer.service.IPostPetRelationService;
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
public class PostPetRelationServiceImpl extends ServiceImpl<PostPetRelationMapper, PostPetRelation> implements IPostPetRelationService {

}
