package top.zynorl.petplanet.gateway.handler;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.server.WebFilterExchange;
import org.springframework.security.web.server.authentication.WebFilterChainServerAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebSession;
import reactor.core.publisher.Mono;
import top.zynorl.petplanet.common.security.AuthUser;
import top.zynorl.petplanet.gateway.config.JwtProperties;
import top.zynorl.petplanet.gateway.domin.AuthUserDetails;
import top.zynorl.petplanet.gateway.util.JwtTokenUtil;
import top.zynorl.petplanet.gateway.util.RedisCache;
import top.zynorl.petplanet.gateway.vo.ResponseResult;
import top.zynorl.petplanet.gateway.vo.ResultCode;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class AuthenticationSuccessHandler extends WebFilterChainServerAuthenticationSuccessHandler {

    private final JwtProperties jwtProperties;

    private final RedisCache redisCache;

    public AuthenticationSuccessHandler(JwtProperties jwtProperties, RedisCache redisCache) {
        this.jwtProperties = jwtProperties;
        this.redisCache = redisCache;
    }


    @Override
    public Mono<Void> onAuthenticationSuccess(WebFilterExchange webFilterExchange, Authentication authentication) {
        ServerWebExchange exchange = webFilterExchange.getExchange();
        ServerHttpResponse response = exchange.getResponse();
        //将授权信息保存到session
        UUID uuid = UUID.randomUUID();
        //将session保存到redis
//        redisCache.setCacheObject(uuid.toString(), authentication.getPrincipal());
//        exchange.getAttributes().put("SESSION", uuid.toString());
//        exchange.getSession().publish(Mono.just(authentication.getPrincipal()));
        WebSession block = webFilterExchange.getExchange().getSession().block();
        if(!block.isStarted()) {
            System.out.println("start web session");
            block.start();
        } else {
            System.out.println("session have started");
            //开启新的认证  这里不允许再次阻塞，不然会报错
            block.invalidate();
        }

        System.out.println(block.getId());
        //获取个人信息
        User principal = (User) authentication.getPrincipal();
        AuthUser authUser = new AuthUser();
        authUser.setUsername(principal.getUsername());
        //要把授权信息写入session
        block.getAttributes().put("authentication", authUser);
        block.save();
        System.out.println("授权信息写入session");


        //设置header
        HttpHeaders headers = response.getHeaders();
        headers.add("Content-Type", "application/json;charset=UTF-8");
        headers.add("Cache-Controll", "no-store,no-cache,must-revalidate,max-age-8");
        //设置body
        ResponseResult<AuthUserDetails> result = ResponseResult.success();
        byte[] dataBytes = {};
        ObjectMapper mapper = new ObjectMapper();
        try {
            User user = (User) authentication.getPrincipal();
            AuthUserDetails userDetails = builduser(user);
            Map<String, Object> map = new HashMap<>(2);
            map.put("user-info", userDetails);
            // 生成token
            String jwtToken = JwtTokenUtil.createJavaWebToken4JwtAuth(map, jwtProperties.getSecretKey(), jwtProperties.getValidateInMs());

            userDetails.setToken(jwtToken);
            result.setData(userDetails);
            dataBytes = mapper.writeValueAsBytes(result);
        }catch (JsonProcessingException e) {
            e.printStackTrace();
            HashMap<String, Object> map = new HashMap<>();
            map.put("status", ResultCode.UNAUTHONICATION.getCode());
            map.put("msg", ResultCode.UNAUTHONICATION.getMsg());
            dataBytes = JSON.toJSONString(map).getBytes();
        }

        DataBuffer bodyDataBuffer = response.bufferFactory().wrap(dataBytes);
        return response.writeWith(Mono.just(bodyDataBuffer));
    }
    private AuthUserDetails builduser(User user) {
        AuthUserDetails authUserDetails = new AuthUserDetails();

        // 从数据库获取
        authUserDetails.setUsername(user.getUsername());
        authUserDetails.setPassword(new BCryptPasswordEncoder().encode("123456"));
        authUserDetails.setRole("admin");

        return authUserDetails;

    }


}
