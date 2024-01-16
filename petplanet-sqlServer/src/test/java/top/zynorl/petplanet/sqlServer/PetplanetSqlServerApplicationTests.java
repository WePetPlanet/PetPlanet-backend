package top.zynorl.petplanet.sqlServer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.zynorl.petplanet.sqlServer.entity.UserInfoDO;
import top.zynorl.petplanet.sqlServer.service.IUserInfoDBService;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PetplanetSqlServerApplicationTests {

    @Autowired
    private IUserInfoDBService userInfoDBService;

    @Test
    public void contextLoads() {
    }
    @Test
    public void testDynamicDataSource(){
        List<UserInfoDO> userInfoDOS = userInfoDBService.getUserInfoDOListByKeyword("zynorl");
        if(userInfoDOS==null || userInfoDOS.isEmpty()){
            System.out.println("没有查询到信息");
        }else {
            userInfoDOS.forEach(userInfoDO ->
                    System.out.println(userInfoDO.getUsername())
            );
        }
    }


}
