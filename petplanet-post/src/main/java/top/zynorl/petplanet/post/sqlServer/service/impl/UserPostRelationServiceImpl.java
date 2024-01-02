package top.zynorl.petplanet.post.sqlServer.service.impl;

import top.zynorl.petplanet.post.sqlServer.entity.UserPostRelation;
import top.zynorl.petplanet.post.sqlServer.mapper.UserPostRelationMapper;
import top.zynorl.petplanet.post.sqlServer.service.IUserPostRelationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户与帖子的关联表 服务实现类
 * </p>
 *
 * @author zynorl/niuzy
 * @since 2024-01-02
 */
@Service
public class UserPostRelationServiceImpl extends ServiceImpl<UserPostRelationMapper, UserPostRelation> implements IUserPostRelationService {

}
