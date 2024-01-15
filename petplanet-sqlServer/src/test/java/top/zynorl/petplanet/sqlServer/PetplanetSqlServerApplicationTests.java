package top.zynorl.petplanet.sqlServer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.zynorl.petplanet.sqlServer.entity.UserInfoDO;
import top.zynorl.petplanet.sqlServer.service.IUserInfoDBService;
import top.zynorl.petplanet.sqlServer.service.impl.UserInfoDBServiceImpl;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PetplanetSqlServerApplicationTests {

    @Autowired
    private UserInfoDBServiceImpl userInfoDBService;

    @Test
    public void contextLoads() {
    }
    @Test
    public void testDynamicDataSource(){
        List<UserInfoDO> hhh = userInfoDBService.getUserInfoDOListByKeyword("hhh");
        if(hhh==null){
            System.out.println("8888888888888888");
        }else {
            hhh.forEach(userInfoDO ->
                    System.out.printf(userInfoDO.getUsername())
            );
        }
    }


}
