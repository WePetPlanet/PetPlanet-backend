package top.zynorl.petplanet.auth.context;

import lombok.Data;
import top.zynorl.petplanet.auth.pojo.UserInfoDTO;

import java.util.Map;

/**
 * @version 1.0
 * @Author niuzy
 * @Date 2023/11/26
 **/
@Data
public class RuntimeContext {
    private Map<String, Object> contextMaps;
    private UserInfoDTO userInfoDTO;
}
