package top.zynorl.petplanet.user.sqlServer.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 用户信息表
 * </p>
 *
 * @author zynorl
 * @since 2023-11-10
 */
@Data
@TableName("user_info")
@ApiModel(value = "UserInfo对象", description = "用户信息表")
public class UserInfoDO implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String username;

    private String phoneNumber;

    private String password;

    @ApiModelProperty("个人简介")
    private String introduction;

    @ApiModelProperty("用户邮箱")
    private String email;

    @ApiModelProperty("所在省份")
    private String address;

    @ApiModelProperty("头像-url-资源服务器")
    private String photo;

    @ApiModelProperty("出生日期")
    private LocalDate birthday;

    @ApiModelProperty("用户注册时间")
    private LocalDateTime createTime;

    @ApiModelProperty("用户信息更新时间")
    private LocalDateTime updateTime;

    @ApiModelProperty("1表示删除，实现逻辑删除")
    private Integer isDelete;

}
