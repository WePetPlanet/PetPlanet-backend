package top.zynorl.petplanet.post.sqlServer.service.impl;

import top.zynorl.petplanet.post.sqlServer.entity.PetInfoDO;
import top.zynorl.petplanet.post.sqlServer.mapper.PetInfoDAO;
import top.zynorl.petplanet.post.sqlServer.service.IPetInfoDBService;
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
public class PetInfoDBServiceImpl extends ServiceImpl<PetInfoDAO, PetInfoDO> implements IPetInfoDBService {

}
