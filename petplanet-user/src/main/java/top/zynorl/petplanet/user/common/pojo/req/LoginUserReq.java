package top.zynorl.petplanet.user.common.pojo.req;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @version 1.0
 * @Author niuzy
 * @Date 2023/11/25
 **/
@Data
@Accessors(chain = true)
public class LoginUserReq {
    /**
     * 账号
     */
    private String phoneNumber;
    /**
     * 密码
     */
    private String password;
}
