package top.zynorl.petplanet.user.common.converter;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import top.zynorl.petplanet.common.common.base.BaseResPage;
import top.zynorl.petplanet.common.common.converter.BaseConverter;
import top.zynorl.petplanet.common.common.converter.ConverterConfig;
import top.zynorl.petplanet.user.common.pojo.bo.GetUserListReqBO;
import top.zynorl.petplanet.user.common.pojo.bo.UserInfoBO;
import top.zynorl.petplanet.user.common.pojo.req.GetUserListReq;
import top.zynorl.petplanet.user.common.pojo.vo.UserInfoVO;

import java.util.List;

/**
 * Created by zynorl on 2023/11/12 16:32
 */
@Mapper(config = ConverterConfig.class)
public interface UserControllerConverter extends BaseConverter {

    GetUserListReqBO toGetUserListReqBO(GetUserListReq getUserListReq);

    @Mapping(target = "user_id", source = "id")
    UserInfoVO toUserInfoBO(UserInfoBO userInfoBO);

    @IterableMapping(elementTargetType = UserInfoVO.class)
    List<UserInfoVO> toUserInfoBOList(List<UserInfoBO> userInfoBOList);

    BaseResPage<UserInfoVO> toUserInfoVOBaseResPage(BaseResPage<UserInfoBO> userInfoBOBaseResPage);
}
