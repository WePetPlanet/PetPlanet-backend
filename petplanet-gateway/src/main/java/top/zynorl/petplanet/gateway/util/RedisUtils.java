package top.zynorl.petplanet.gateway.util;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Component
public class RedisUtils {

    public static final String ACCESS_TOKEN = "TOKEN_GIFT_";//客户端请求服务器时携带的token参数
    public static final String REFRESH_TOKEN = "REFRESH_GIFT_";//客户端用户刷新token的参数
    public static final String PHONE_VALID_CODE = "PHONE_VALID_CODE_";//客户端短信验证码




    @Resource
    private RedisTemplate<String, String> redisTemplate;

    /**
     * @Description: 设置缓存，k-v形式
     * @param key
     * @param value
     * @param timeout：单位：毫秒
     * @author:
     * @date:
     */
    public void setValue(String key, String value, long timeout ){
        redisTemplate.opsForValue().set(key, value, timeout , TimeUnit.MILLISECONDS);
    }

    /**
     * @Description: 设置access_token的缓存
     * @param userId
     * @param value
     * @param timeout
     * @author:
     * @date:
     */
    public void setToken(Long userId, String value, long timeout){
        setValue(ACCESS_TOKEN + userId, value, timeout);
    }
    /**
     * @Description: 获取缓存，通过key获取value值
     * @param key
     * @return
     * @author:
     * @date:
     */
    public String getValue(String key){
        return redisTemplate.opsForValue().get(key);
    }
    /**
     * @Description: 获取redis中的access_token信息
     * @param userId
     * @return
     * @author:
     * @date:
     */
    public String getToken(Long userId){
        return getValue(ACCESS_TOKEN + userId);
    }

    /**
     * @Description: 删除缓存
     * @param key
     * @author:
     * @date:
     */
    public void delete(String key){
        redisTemplate.delete(key);
    }

}


