package top.zynorl.petplanet.user.sqlServer.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 用户关注表
 * </p>
 *
 * @author zynorl
 * @since 2023-11-10
 */
@Data
@TableName("user_attention")
@ApiModel(value = "UserAttention对象", description = "用户关注表")
public class UserAttentionDO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @ApiModelProperty("user id")
    private Long userId;

    @ApiModelProperty("user id关注的人的id")
    private Long attentionId;

    @ApiModelProperty("关联时间")
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;

    @ApiModelProperty("1表示删除，实现逻辑删除")
    private Integer isDelete;

}
