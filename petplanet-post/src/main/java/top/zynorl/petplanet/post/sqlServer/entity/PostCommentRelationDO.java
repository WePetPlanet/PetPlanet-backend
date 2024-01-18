package top.zynorl.petplanet.post.sqlServer.entity;

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
 * 帖子与评论映射表，包含多级评论
 * </p>
 *
 * @author zynorl/niuzy
 * @since 2024-01-03
 */
@TableName("post_comment_relation")
@ApiModel(value = "PostCommentRelation对象", description = "帖子与评论映射表，包含多级评论")
@Data
@Builder
public class PostCommentRelationDO implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("帖子的id")
    private Long postId;

    @ApiModelProperty("评论的id，顶级评论")
    private Long commentId;

    @ApiModelProperty("评论的等级，1是顶级评论")
    private Integer level;

    @ApiModelProperty("帖子与上级评论映射（本表）的id，如果level是1，parent_id=-1")
    private Long parentId;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;

    @ApiModelProperty("1表示删除，实现逻辑删除")
    private Boolean isDelete;

}
