package top.zynorl.petplanet.auth.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @version 1.0
 * @Author niuzy
 * @Date 2023/11/26
 **/
@Data
public class UserInfoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long userId;
    private String username;
    private String phoneNumber;
    private String email;
}
