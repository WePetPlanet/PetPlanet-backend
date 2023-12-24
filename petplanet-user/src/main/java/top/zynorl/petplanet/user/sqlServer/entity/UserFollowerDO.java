package top.zynorl.petplanet.user.sqlServer.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 用户粉丝表
 * </p>
 *
 * @author zynorl
 * @since 2023-11-10
 */
@Data
@TableName("user_follower")
@ApiModel(value = "UserFollower对象", description = "用户粉丝表")
public class UserFollowerDO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @ApiModelProperty("user id")
    private Long userId;

    @ApiModelProperty("跟随者的id，即粉丝")
    private Long followerId;

    @ApiModelProperty("关联时间")
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;

    @ApiModelProperty("1表示删除，实现逻辑删除")
    private Integer isDelete;

}
