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
 * 帖子与其图片集映射表
 * </p>
 *
 * @author zynorl/niuzy
 * @since 2024-01-03
 */
@TableName("post_picture_relation")
@ApiModel(value = "PostPictureRelation对象", description = "帖子与其图片集映射表")
@Data
@Builder
public class PostPictureRelationDO implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("帖子的id")
    private Long postId;

    @ApiModelProperty("帖子所对应的图片id")
    private Long pictureId;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;

    @ApiModelProperty("1表示删除，实现逻辑删除")
    private Boolean isDelete;

}
