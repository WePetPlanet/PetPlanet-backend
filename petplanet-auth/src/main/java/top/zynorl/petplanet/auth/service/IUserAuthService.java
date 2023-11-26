package top.zynorl.petplanet.auth.service;

import top.zynorl.petplanet.auth.pojo.UserInfoDTO;
import top.zynorl.petplanet.common.common.base.R;

/**
 * @version 1.0
 * @Author niuzy
 * @Date 2023/11/26
 **/
public interface IUserAuthService {
    R<UserInfoDTO> getUserBySession(String sessionId);
}
