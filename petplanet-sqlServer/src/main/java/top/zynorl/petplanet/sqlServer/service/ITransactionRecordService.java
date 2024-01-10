package top.zynorl.petplanet.sqlServer.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.zynorl.petplanet.sqlServer.entity.TransactionRecordDO;

/**
 * <p>
 * 事务记录表 服务类
 * </p>
 *
 * @author zynorl/niuzy
 * @since 2024-01-05
 */
public interface ITransactionRecordService extends IService<TransactionRecordDO> {
    /**
     * 根据分布式事务Id，删除记录
     * @param transactionId
     */
    void deleteByTransactionId(String transactionId);

}
