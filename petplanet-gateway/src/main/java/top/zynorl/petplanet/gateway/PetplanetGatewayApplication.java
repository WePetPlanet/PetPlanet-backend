package top.zynorl.petplanet.gateway;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.data.redis.RedisFlushMode;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.data.redis.config.annotation.web.server.EnableRedisWebSession;

@EnableRedisWebSession(redisFlushMode = RedisFlushMode.IMMEDIATE)
@SpringBootApplication
@MapperScan("top.zynorl.petplanet.gateway.mapper")
public class PetplanetGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetplanetGatewayApplication.class, args);
    }

}
