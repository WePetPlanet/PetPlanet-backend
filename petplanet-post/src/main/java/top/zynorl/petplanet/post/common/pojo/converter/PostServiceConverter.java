package top.zynorl.petplanet.post.common.pojo.converter;

import org.mapstruct.Mapper;
import top.zynorl.petplanet.common.converter.BaseConverter;
import top.zynorl.petplanet.common.converter.ConverterConfig;
import top.zynorl.petplanet.mongoserver.entity.PostMO;
import top.zynorl.petplanet.post.common.pojo.bo.req.PublishPostReqBO;

/**
 * @version 1.0
 * @Author niuzy
 * @Date 2024/01/03
 **/
@Mapper(config = ConverterConfig.class)
public interface PostServiceConverter extends BaseConverter {
    PostMO toPostMO(PublishPostReqBO publishPostReqBO);
}
