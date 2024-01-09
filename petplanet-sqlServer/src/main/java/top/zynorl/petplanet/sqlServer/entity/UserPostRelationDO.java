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
 * 用户与帖子的关联表
 * </p>
 *
 * @author zynorl/niuzy
 * @since 2024-01-03
 */
@TableName("user_post_relation")
@ApiModel(value = "UserPostRelation对象", description = "用户与帖子的关联表")
@Data
@Builder
public class UserPostRelationDO implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("用户id")
    private Long userId;

    @ApiModelProperty("帖子id")
    private Long postId;

    @ApiModelProperty("用户发布帖子的时间")
    private LocalDateTime createTime;

    @ApiModelProperty("用户更新帖子的时间")
    private LocalDateTime updateTime;

    @ApiModelProperty("1表示删除，实现逻辑删除")
    private Boolean isDelete;

}
