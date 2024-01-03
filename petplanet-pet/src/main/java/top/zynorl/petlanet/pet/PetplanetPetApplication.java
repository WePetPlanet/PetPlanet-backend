package top.zynorl.petlanet.pet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@EnableRedisHttpSession
@SpringBootApplication
public class PetplanetPetApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetplanetPetApplication.class, args);
    }

}
