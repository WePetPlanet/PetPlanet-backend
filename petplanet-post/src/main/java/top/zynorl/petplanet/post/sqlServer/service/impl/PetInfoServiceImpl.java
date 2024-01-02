package top.zynorl.petplanet.post.sqlServer.service.impl;

import top.zynorl.petplanet.post.sqlServer.entity.PetInfo;
import top.zynorl.petplanet.post.sqlServer.mapper.PetInfoMapper;
import top.zynorl.petplanet.post.sqlServer.service.IPetInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 宠物信息表 服务实现类
 * </p>
 *
 * @author zynorl/niuzy
 * @since 2024-01-02
 */
@Service
public class PetInfoServiceImpl extends ServiceImpl<PetInfoMapper, PetInfo> implements IPetInfoService {

}
