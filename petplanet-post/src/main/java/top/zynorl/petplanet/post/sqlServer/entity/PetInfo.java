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
 * 宠物信息表
 * </p>
 *
 * @author zynorl/niuzy
 * @since 2024-01-02
 */
@TableName("pet_info")
@ApiModel(value = "PetInfo对象", description = "宠物信息表")
public class PetInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("主人")
    private Long userId;

    private String name;

    @ApiModelProperty("宠物头像，url, 资源服务器")
    private String photo;

    @ApiModelProperty("宠物简介")
    private String introduction;

    @ApiModelProperty("宠物出生日期")
    private LocalDateTime birthday;

    @ApiModelProperty("宠物的状态：1.正常、2.流浪、3.已领养、4.死亡")
    private Integer status;

    @ApiModelProperty("宠物死亡时间")
    private LocalDateTime deathTime;

    @ApiModelProperty("宠物注册时间")
    private LocalDateTime createTime;

    @ApiModelProperty("宠物信息更新时间")
    private LocalDateTime updateTime;

    @ApiModelProperty("1表示删除，实现逻辑删除")
    private Byte isDelete;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public LocalDateTime getDeathTime() {
        return deathTime;
    }

    public void setDeathTime(LocalDateTime deathTime) {
        this.deathTime = deathTime;
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
        return "PetInfo{" +
            "id = " + id +
            ", userId = " + userId +
            ", name = " + name +
            ", photo = " + photo +
            ", introduction = " + introduction +
            ", birthday = " + birthday +
            ", status = " + status +
            ", deathTime = " + deathTime +
            ", createTime = " + createTime +
            ", updateTime = " + updateTime +
            ", isDelete = " + isDelete +
        "}";
    }
}
