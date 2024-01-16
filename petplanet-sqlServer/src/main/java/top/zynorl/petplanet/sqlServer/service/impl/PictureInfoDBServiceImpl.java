package top.zynorl.petplanet.sqlServer.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.zynorl.petplanet.sqlServer.dao.PictureInfoDAO;
import top.zynorl.petplanet.sqlServer.datasource.annotation.DataSourceSwitch;
import top.zynorl.petplanet.sqlServer.entity.PictureInfoDO;
import top.zynorl.petplanet.sqlServer.service.IPictureInfoDBService;

/**
 * <p>
 * 图片信息表 服务实现类
 * </p>
 *
 * @author zynorl/niuzy
 * @since 2024-01-02
 */
@Service
@DataSourceSwitch(value = "postDataSource")
public class PictureInfoDBServiceImpl extends ServiceImpl<PictureInfoDAO, PictureInfoDO> implements IPictureInfoDBService {

}
