package top.zynorl.petplanet.sqlServer.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.zynorl.petplanet.sqlServer.dao.TransactionRecordDAO;
import top.zynorl.petplanet.sqlServer.datasource.annotation.DataSourceSwitch;
import top.zynorl.petplanet.sqlServer.entity.TransactionRecordDO;
import top.zynorl.petplanet.sqlServer.service.ITransactionRecordService;

/**
 * <p>
 * 事务记录表 服务实现类
 * </p>
 *
 * @author zynorl/niuzy
 * @since 2024-01-05
 */
@Service
@DataSourceSwitch(value = "postDataSource")
public class TransactionRecordServiceImpl extends ServiceImpl<TransactionRecordDAO, TransactionRecordDO> implements ITransactionRecordService {
    @Override
    public void deleteByTransactionId(String transactionId) {
        QueryWrapper<TransactionRecordDO> queryWrapper = new QueryWrapper<TransactionRecordDO>().eq("transaction_id", transactionId);
        remove(queryWrapper);
    }
}
