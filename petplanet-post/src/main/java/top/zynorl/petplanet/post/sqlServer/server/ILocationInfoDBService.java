package top.zynorl.petplanet.post.sqlServer.server;


import com.baomidou.mybatisplus.extension.service.IService;
import top.zynorl.petplanet.post.sqlServer.entity.LocationInfoDO;

/**
 * <p>
 * 发布帖子时候的位置信息，从第三方接口中获取 服务类
 * </p>
 *
 * @author zynorl/niuzy
 * @since 2024-01-02
 */
public interface ILocationInfoDBService extends IService<LocationInfoDO> {

    /**
     * 根据分布式事务ID，删除记录
     */
    void deleteByTransactionId(String transactionId);

}
