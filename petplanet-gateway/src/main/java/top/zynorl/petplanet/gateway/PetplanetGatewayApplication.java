package top.zynorl.petplanet.gateway;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.data.redis.RedisFlushMode;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.data.redis.config.annotation.web.server.EnableRedisWebSession;
import org.springframework.web.bind.annotation.CrossOrigin;

@EnableRedisWebSession(redisFlushMode = RedisFlushMode.IMMEDIATE)
@SpringBootApplication
@MapperScan("top.zynorl.petplanet.gateway.mapper")
@CrossOrigin
public class PetplanetGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetplanetGatewayApplication.class, args);
    }

}
