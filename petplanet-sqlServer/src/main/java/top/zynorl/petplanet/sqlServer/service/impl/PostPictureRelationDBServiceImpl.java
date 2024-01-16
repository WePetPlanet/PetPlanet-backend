package top.zynorl.petplanet.sqlServer.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.zynorl.petplanet.sqlServer.dao.PostPictureRelationDAO;
import top.zynorl.petplanet.sqlServer.datasource.annotation.DataSourceSwitch;
import top.zynorl.petplanet.sqlServer.entity.PostPictureRelationDO;
import top.zynorl.petplanet.sqlServer.service.IPostPictureRelationDBService;

/**
 * <p>
 * 帖子与其图片集映射表 服务实现类
 * </p>
 *
 * @author zynorl/niuzy
 * @since 2024-01-02
 */
@Service
@DataSourceSwitch(value = "postDataSource")
public class PostPictureRelationDBServiceImpl extends ServiceImpl<PostPictureRelationDAO, PostPictureRelationDO> implements IPostPictureRelationDBService {

}
