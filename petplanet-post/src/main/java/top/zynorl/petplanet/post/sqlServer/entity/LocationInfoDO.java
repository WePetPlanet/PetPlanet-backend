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
 * 发布帖子时候的位置信息，从第三方接口中获取
 * </p>
 *
 * @author zynorl/niuzy
 * @since 2024-01-03
 */
@TableName("location_info")
@ApiModel(value = "LocationInfo对象", description = "发布帖子时候的位置信息，从第三方接口中获取")
@Data
@Builder
public class LocationInfoDO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("自增主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("浙江理工大学(下沙校区)")
    private String name;

    @ApiModelProperty("浙江省杭州市钱塘区求实路")
    private String address;

    @ApiModelProperty("中国")
    private String nation;

    @ApiModelProperty("浙江")
    private String province;

    @ApiModelProperty("杭州")
    private String city;

    @ApiModelProperty("钱塘区")
    private String district;

    @ApiModelProperty("纬度")
    private Double lat;

    @ApiModelProperty("经度")
    private Double lng;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;

    @ApiModelProperty("软删除")
    private Boolean isDelete;

}
