package top.zynorl.petplanet.post;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("top.zynorl.petplanet.*")
public class PetplanetPostApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetplanetPostApplication.class, args);
    }

}
