package top.zynorl.petplanet.post.sqlServer.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 发布帖子时候的位置信息，从第三方接口中获取
 * </p>
 *
 * @author zynorl/niuzy
 * @since 2024-01-02
 */
@TableName("location_info")
@ApiModel(value = "LocationInfo对象", description = "发布帖子时候的位置信息，从第三方接口中获取")
public class LocationInfo implements Serializable {

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
    private Byte isDelete;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return "LocationInfo{" +
            "id = " + id +
            ", name = " + name +
            ", address = " + address +
            ", nation = " + nation +
            ", province = " + province +
            ", city = " + city +
            ", district = " + district +
            ", lat = " + lat +
            ", lng = " + lng +
            ", createTime = " + createTime +
            ", updateTime = " + updateTime +
            ", isDelete = " + isDelete +
        "}";
    }
}
