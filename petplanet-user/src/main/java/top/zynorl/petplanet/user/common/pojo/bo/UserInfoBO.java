package top.zynorl.petplanet.user.common.pojo.bo;

import lombok.Data;

import java.time.LocalDate;

/**
 * Created by zynorl on 2023/11/12 14:42
 */
@Data
public class UserInfoBO {

    private Long id;

    private String username;

    private String phoneNumber;

    private String password;

    /**
     * 个人简介
     */
    private String introduction;

    /**
     * 用户邮箱
     */
    private String email;

    /**
     * 所在省份
     */
    private String address;

    /**
     * 头像-url-资源服务器
     */
    private String photo;

    /**
     * 出生日期
     */
    private LocalDate birthday;
}
