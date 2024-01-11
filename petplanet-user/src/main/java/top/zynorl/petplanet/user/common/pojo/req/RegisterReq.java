package top.zynorl.petplanet.user.common.pojo.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * 前端发送的用户注册请求
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegisterReq {
    @NotNull(message = "用户名不能为空")
    private String username;
    @NotNull(message = "密码不能为空")
    private String password;
}
