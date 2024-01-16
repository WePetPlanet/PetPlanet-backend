package top.zynorl.petplanet.sqlServer.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.zynorl.petplanet.sqlServer.dao.PostPetRelationDAO;
import top.zynorl.petplanet.sqlServer.datasource.annotation.DataSourceSwitch;
import top.zynorl.petplanet.sqlServer.entity.PostPetRelationDO;
import top.zynorl.petplanet.sqlServer.service.IPostPetRelationDBService;

/**
 * <p>
 * 宠物与帖子的映射表 服务实现类
 * </p>
 *
 * @author zynorl/niuzy
 * @since 2024-01-02
 */
@Service
@DataSourceSwitch(value = "postDataSource")
public class PostPetRelationDBServiceImpl extends ServiceImpl<PostPetRelationDAO, PostPetRelationDO> implements IPostPetRelationDBService {

}
