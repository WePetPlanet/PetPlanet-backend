package top.zynorl.petlanet.pet.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Pet {

    private long id;//宠物id
    private long userId;//宠物主人id
    private String name; //宠物名字
    private String photo;//宠物相册
    private String introduction;//宠物介绍
    private Date birthday;//宠物生日
    private Date createTime;//创建日期
    private Date deathTime;//死亡日期


}
