package top.zynorl.petplanet.post.sqlServer.service.impl;

import top.zynorl.petplanet.post.sqlServer.entity.LocationInfo;
import top.zynorl.petplanet.post.sqlServer.mapper.LocationInfoMapper;
import top.zynorl.petplanet.post.sqlServer.service.ILocationInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 发布帖子时候的位置信息，从第三方接口中获取 服务实现类
 * </p>
 *
 * @author zynorl/niuzy
 * @since 2024-01-02
 */
@Service
public class LocationInfoServiceImpl extends ServiceImpl<LocationInfoMapper, LocationInfo> implements ILocationInfoService {

}
