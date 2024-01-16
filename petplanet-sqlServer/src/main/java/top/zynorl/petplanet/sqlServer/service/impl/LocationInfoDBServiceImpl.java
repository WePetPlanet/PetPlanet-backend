package top.zynorl.petplanet.sqlServer.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.zynorl.petplanet.sqlServer.dao.LocationInfoDAO;
import top.zynorl.petplanet.sqlServer.datasource.annotation.DataSourceSwitch;
import top.zynorl.petplanet.sqlServer.entity.LocationInfoDO;
import top.zynorl.petplanet.sqlServer.service.ILocationInfoDBService;

/**
 * <p>
 * 发布帖子时候的位置信息，从第三方接口中获取 服务实现类
 * </p>
 *
 * @author zynorl/niuzy
 * @since 2024-01-02
 */
@Service
@DataSourceSwitch(value = "postDataSource")
public class LocationInfoDBServiceImpl extends ServiceImpl<LocationInfoDAO, LocationInfoDO> implements ILocationInfoDBService {
    @Override
    public void deleteByTransactionId(String transactionId) {
        QueryWrapper<LocationInfoDO> queryWrapper = new QueryWrapper<LocationInfoDO>().eq("transaction_id", transactionId);
        remove(queryWrapper);
    }
}
