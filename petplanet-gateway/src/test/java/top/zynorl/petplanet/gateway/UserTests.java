package top.zynorl.petplanet.gateway;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.zynorl.petplanet.gateway.domin.DBUser;
import top.zynorl.petplanet.gateway.mapper.UserMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTests {
    @Autowired
    private UserMapper userMapper;


    @Test
    public void findUserByUsername() {
        DBUser test = userMapper.selectUserByUsername("小红红");
        System.out.println(test);
    }
}
