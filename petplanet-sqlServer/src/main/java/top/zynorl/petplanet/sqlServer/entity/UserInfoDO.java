package top.zynorl.petplanet.sqlServer.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 用户信息表
 * </p>
 *
 * @author zynorl/niuzy
 * @since 2024-01-03
 */
@TableName("user_info")
@ApiModel(value = "UserInfo对象", description = "用户信息表")
@Data
@Builder
public class UserInfoDO implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String username;

    private String phoneNumber;

    private String password;

    @ApiModelProperty("用户权限角色")
    private String role;

    @ApiModelProperty("个人简介")
    private String introduction;

    @ApiModelProperty("用户邮箱")
    private String email;

    @ApiModelProperty("所在省份")
    private String address;

    @ApiModelProperty("头像-url-资源服务器")
    private String url;

    @ApiModelProperty("出生日期")
    private LocalDateTime birthday;

    @ApiModelProperty("用户注册时间")
    private LocalDateTime createTime;

    @ApiModelProperty("用户信息更新时间")
    private LocalDateTime updateTime;

    @ApiModelProperty("1表示删除，实现逻辑删除")
    private Boolean isDelete;

}
