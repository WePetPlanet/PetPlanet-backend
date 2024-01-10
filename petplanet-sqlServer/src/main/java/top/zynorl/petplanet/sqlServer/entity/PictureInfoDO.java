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
 * 图片信息表
 * </p>
 *
 * @author zynorl/niuzy
 * @since 2024-01-03
 */
@TableName("picture_info")
@ApiModel(value = "PictureInfo对象", description = "图片信息表")
@Data
@Builder
public class PictureInfoDO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("图片的id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("图片存放在服务器的位置")
    private String url;

    @ApiModelProperty("图片的名称")
    private String name;

    @ApiModelProperty("图片的创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("图片信息更新时间")
    private LocalDateTime updateTime;

    @ApiModelProperty("1表示删除，实现逻辑删除")
    private Boolean isDelete;

}
