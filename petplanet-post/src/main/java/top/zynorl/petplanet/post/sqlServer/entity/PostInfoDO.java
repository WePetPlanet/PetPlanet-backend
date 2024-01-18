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
 * 帖子信息表
 * </p>
 *
 * @author zynorl/niuzy
 * @since 2024-01-03
 */
@TableName("post_info")
@ApiModel(value = "PostInfo对象", description = "帖子信息表")
@Data
@Builder
public class PostInfoDO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("文章id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("关联用户id")
    private Long userId;

    @ApiModelProperty("帖子的正文")
    private String content;

    @ApiModelProperty("帖子的标题")
    private String title;

    @ApiModelProperty("点赞数")
    private Integer likeNum;

    @ApiModelProperty("收藏数")
    private Integer collectNum;

    @ApiModelProperty("转发数")
    private Integer forwardNum;

    @ApiModelProperty("浏览数")
    private Integer lookNum;

    @ApiModelProperty("是否不可见")
    private Boolean is_invisible;

    @ApiModelProperty("帖子权限类型")
    private String permissionType;
    @ApiModelProperty("是否为定时发布")
    private Boolean is_timing;

    @ApiModelProperty("帖子标签的名称, 比如狗狗、猫咪")
    private String tagName;

    @ApiModelProperty("发布ip")
    private String ip;

    @ApiModelProperty("帖子发表的地址ID")
    private Long locId;

    @ApiModelProperty("最后评论时间")
    private LocalDateTime lastReviewTime;

    @ApiModelProperty("首次开始编写帖子的时间")
    private LocalDateTime startEditTime;

    @ApiModelProperty("最近帖子修改时间")
    private LocalDateTime lastEditTime;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("最后一次修改时间")
    private LocalDateTime updateTime;

    @ApiModelProperty("1表示删除，实现逻辑删除")
    private Boolean isDelete;

}
