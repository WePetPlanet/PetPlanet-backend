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
 * 评论信息表
 * </p>
 *
 * @author zynorl/niuzy
 * @since 2024-01-03
 */
@TableName("comment_info")
@ApiModel(value = "CommentInfo对象", description = "评论信息表")
@Data
@Builder
public class CommentInfoDO implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("帖子ID")
    private Long postId;

    @ApiModelProperty("评论人的ID")
    private Long userId;

    @ApiModelProperty("评论人名称")
    private String username;

    @ApiModelProperty("评论的内容")
    private String text;

    @ApiModelProperty("点赞数")
    private Integer likeNum;

    @ApiModelProperty("回复数")
    private Integer replyNum;

    @ApiModelProperty("0:不可见，1:可见")
    private Byte status;

    @ApiModelProperty("发表ip")
    private String ip;

    @ApiModelProperty("上级ID，如果为0表示文章的顶级评论")
    private Long parentId;

    @ApiModelProperty("评论的创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("评论的更新时间")
    private LocalDateTime updateTime;

    @ApiModelProperty("1表示删除，实现逻辑删除")
    private Boolean isDelete;

}
