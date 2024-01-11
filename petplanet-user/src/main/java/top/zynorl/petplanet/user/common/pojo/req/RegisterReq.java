package top.zynorl.petplanet.user.common.pojo.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 前端发送的用户注册请求
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegisterReq {
    private String username;
    private String password;
}
