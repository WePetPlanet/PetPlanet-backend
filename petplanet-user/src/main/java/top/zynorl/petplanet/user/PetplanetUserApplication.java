package top.zynorl.petplanet.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"top.zynorl.petplanet.user","top.zynorl.petplanet.sqlServer"})
public class PetplanetUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetplanetUserApplication.class, args);
    }

}
