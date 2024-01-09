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
 * 用户粉丝表
 * </p>
 *
 * @author zynorl/niuzy
 * @since 2024-01-03
 */
@TableName("user_follower")
@ApiModel(value = "UserFollower对象", description = "用户粉丝表")
@Data
@Builder
public class UserFollowerDO implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
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
    private Boolean isDelete;

}
