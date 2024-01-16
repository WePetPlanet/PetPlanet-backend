package top.zynorl.petplanet.sqlServer.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.zynorl.petplanet.sqlServer.dao.PostInfoDAO;
import top.zynorl.petplanet.sqlServer.datasource.annotation.DataSourceSwitch;
import top.zynorl.petplanet.sqlServer.entity.PostInfoDO;
import top.zynorl.petplanet.sqlServer.service.IPostInfoDBService;

/**
 * <p>
 * 帖子信息表 服务实现类
 * </p>
 *
 * @author zynorl/niuzy
 * @since 2024-01-02
 */
@Service
@DataSourceSwitch(value = "postDataSource")
public class PostInfoDBServiceImpl extends ServiceImpl<PostInfoDAO, PostInfoDO> implements IPostInfoDBService {

}
