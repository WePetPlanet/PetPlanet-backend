package top.zynorl.petplanet.post.common.pojo.converter;

import org.mapstruct.Mapper;
import top.zynorl.petplanet.common.converter.BaseConverter;
import top.zynorl.petplanet.common.converter.ConverterConfig;
import top.zynorl.petplanet.post.common.pojo.bo.PublishPostReqBO;
import top.zynorl.petplanet.post.common.pojo.req.PublishPostReq;

/**
 * @version 1.0
 * @Author niuzy
 * @Date 2024/01/02
 **/
@Mapper(config = ConverterConfig.class)
public interface PostControllerConverter extends BaseConverter {
    PublishPostReqBO toPublishPostReqBO(PublishPostReq publishPostReq);
}
