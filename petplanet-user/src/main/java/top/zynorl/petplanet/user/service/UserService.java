package top.zynorl.petplanet.user.service;

import top.zynorl.petplanet.user.common.pojo.base.BaseResPage;
import top.zynorl.petplanet.user.common.pojo.bo.GetUserListReqBO;
import top.zynorl.petplanet.user.common.pojo.bo.UserInfoBO;

/**
 * Created by zynorl on 2023/11/10 20:32
 */
public interface UserService {

    /**
     * 获取用户分页列表
     * @param getUserListReqBO
     * @return
     */
    BaseResPage<UserInfoBO> getUserInfoListByKeyword(GetUserListReqBO getUserListReqBO);
}
