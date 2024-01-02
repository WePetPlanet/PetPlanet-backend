package top.zynorl.petplanet.post.sqlServer.service.impl;

import top.zynorl.petplanet.post.sqlServer.entity.UserBlacklist;
import top.zynorl.petplanet.post.sqlServer.mapper.UserBlacklistMapper;
import top.zynorl.petplanet.post.sqlServer.service.IUserBlacklistService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户黑名单表 服务实现类
 * </p>
 *
 * @author zynorl/niuzy
 * @since 2024-01-02
 */
@Service
public class UserBlacklistServiceImpl extends ServiceImpl<UserBlacklistMapper, UserBlacklist> implements IUserBlacklistService {

}
