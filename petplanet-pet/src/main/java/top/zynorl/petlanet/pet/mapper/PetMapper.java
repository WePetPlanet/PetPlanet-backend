package top.zynorl.petlanet.pet.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import top.zynorl.petlanet.pet.entity.Pet;

import java.util.Date;
import java.util.List;

/**
 * 宠物类：用来表示单个宠物
 */
@Mapper
@Repository
public interface PetMapper{
    //获取所有某一用户的宠物
    @Select("select * from pet where user_id=#{userId}")
    public List<Pet> findAllByUserId(long userId);
    @Insert("insert into pet(user_id,name,photo,introduction,birthday,create_time,death_time) " +
            "values (#{userId},#{name},#{photo},#{introduction},#{birthday},#{createTime},#{deathTime})")
    public Pet insert(Pet pet);
    @Update("update pet set name=#{name} where id=#{id}")
    public Pet updateName(long id,String name);
    @Update("update pet set photo=#{photo} where id=#{id}")
    public Pet updatePhoto(long id,String photo);
    @Update("update pet set introduction=#{introduction} where id=#{id}")
    public Pet updateIntroductionlong(long id,String introduction);
    @Update("update pet set birthday=#{birthday} where id=#{id}")
    public Pet updateBirthday(long id, Date birthday);
    @Update("update pet set death_time=#{deathTime} where id=#{id}")
    public Pet updateDeathTime(long id,Date deathTime);

}
