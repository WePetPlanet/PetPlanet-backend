package top.zynorl.petplanet.user.common.converter;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import top.zynorl.petplanet.common.base.BaseResPage;
import top.zynorl.petplanet.common.converter.BaseConverter;
import top.zynorl.petplanet.common.converter.ConverterConfig;
import top.zynorl.petplanet.user.common.pojo.bo.UserInfoBO;
import top.zynorl.petplanet.user.sqlServer.entity.UserInfoDO;

import java.util.List;

/**
 * Created by zynorl on 2023/11/12 16:31
 */
@Mapper(config = ConverterConfig.class)
public interface UserServiceConverter extends BaseConverter {

    UserInfoBO toUserInfoBO(UserInfoDO userInfoDO);

    @IterableMapping(elementTargetType = UserInfoBO.class)
    List<UserInfoBO> toUserInfoBOList(List<UserInfoDO> userInfoDOList);

    BaseResPage<UserInfoBO> toUserInfoBOBaseResPage(BaseResPage<UserInfoDO> userInfoDOBaseResPage);
}
