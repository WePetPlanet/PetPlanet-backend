package top.zynorl.petplanet.post.sqlServer.service.impl;

import top.zynorl.petplanet.post.sqlServer.entity.UserInfo;
import top.zynorl.petplanet.post.sqlServer.mapper.UserInfoMapper;
import top.zynorl.petplanet.post.sqlServer.service.IUserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author zynorl/niuzy
 * @since 2024-01-02
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService {

}
