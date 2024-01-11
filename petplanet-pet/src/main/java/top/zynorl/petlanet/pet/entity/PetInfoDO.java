package top.zynorl.petlanet.pet.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 宠物信息表
 * </p>
 *
 * @author zynorl/niuzy
 * @since 2024-01-03
 */
@TableName("pet_info")
@Data
@Builder
public class PetInfoDO implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

//    @ApiModelProperty("主人")
    private Long userId;

    private String name;

//    @ApiModelProperty("宠物头像，url, 资源服务器")
    private String photo;

//    @ApiModelProperty("宠物简介")
    private String introduction;

//    @ApiModelProperty("宠物出生日期")
    private LocalDateTime birthday;

//    @ApiModelProperty("宠物的状态：1.正常、2.流浪、3.已领养、4.死亡")
    private Integer status;

//    @ApiModelProperty("宠物死亡时间")
    private LocalDateTime deathTime;

//    @ApiModelProperty("宠物注册时间")
    private LocalDateTime createTime;

//    @ApiModelProperty("宠物信息更新时间")
    private LocalDateTime updateTime;

//    @ApiModelProperty("1表示删除，实现逻辑删除")
    private Boolean isDelete;

}
