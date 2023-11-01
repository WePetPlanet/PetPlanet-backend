package top.zynorl.petplanet.user.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by zynorl on 2023/11/1 10:12
 */
@Configuration
@MapperScan("top.zynorl.petplanet.user.mbg.mapper")
public class MyBatisConfig {

}
