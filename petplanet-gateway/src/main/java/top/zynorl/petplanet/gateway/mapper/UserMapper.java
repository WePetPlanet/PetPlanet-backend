package top.zynorl.petplanet.gateway.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import top.zynorl.petplanet.gateway.domin.DBUser;

//加入了@Mapper注解，目的就是为了不再写mapper映射文件
@Mapper
public interface UserMapper {
    @Select("select * from user_info where username=#{username}")
    public DBUser selectUserByUsername(String username);
}
