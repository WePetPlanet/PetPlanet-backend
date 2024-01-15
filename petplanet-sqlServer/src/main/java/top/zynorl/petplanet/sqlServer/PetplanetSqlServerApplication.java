package top.zynorl.petplanet.sqlServer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
@MapperScan("top.zynorl.petplanet.sqlServer.dao")
public class PetplanetSqlServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetplanetSqlServerApplication.class, args);
    }

}
