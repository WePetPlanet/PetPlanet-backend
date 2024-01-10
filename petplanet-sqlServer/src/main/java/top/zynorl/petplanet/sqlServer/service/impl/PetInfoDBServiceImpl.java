package top.zynorl.petplanet.sqlServer.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.zynorl.petplanet.sqlServer.dao.PetInfoDAO;
import top.zynorl.petplanet.sqlServer.entity.PetInfoDO;
import top.zynorl.petplanet.sqlServer.service.IPetInfoDBService;

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
