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
 * 帖子标签基本信息表
 * </p>
 *
 * @author zynorl/niuzy
 * @since 2024-01-03
 */
@TableName("post_tag_info")
@ApiModel(value = "PostTagInfo对象", description = "帖子标签基本信息表")
@Data
@Builder
public class PostTagInfoDO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("标签id，自增")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("标签名称，如狗狗")
    private String name;

    @ApiModelProperty("标签说明")
    private String mask;

    @ApiModelProperty("信息创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("信息更新时间")
    private LocalDateTime updateTime;

    @ApiModelProperty("默认为0，实现逻辑删除")
    private Boolean isDelete;

}
