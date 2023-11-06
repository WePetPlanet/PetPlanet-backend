package top.zynorl.petlanet.pet;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.zynorl.petlanet.pet.mapper.PetMapper;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PetplanetPetApplicationTests {
    @Autowired
    PetMapper petMapper;
    @Test
    public void contextLoads() {

    }

}
