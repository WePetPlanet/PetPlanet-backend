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
import reactor.core.publisher.Mono;
import top.zynorl.petplanet.gateway.config.JwtProperties;
import top.zynorl.petplanet.gateway.domin.AuthUserDetails;
import top.zynorl.petplanet.gateway.service.SecurityUserDetailService;
import top.zynorl.petplanet.gateway.util.JwtTokenUtil;
import top.zynorl.petplanet.gateway.vo.ResponseResult;
import top.zynorl.petplanet.gateway.vo.ResultCode;

import java.util.HashMap;
import java.util.Map;
@Component
public class AuthenticationSuccessHandler extends WebFilterChainServerAuthenticationSuccessHandler {

    private final JwtProperties jwtProperties;

    public AuthenticationSuccessHandler(JwtProperties jwtProperties) {
        this.jwtProperties = jwtProperties;
    }


    @Override
    public Mono<Void> onAuthenticationSuccess(WebFilterExchange webFilterExchange, Authentication authentication) {
        ServerWebExchange exchange = webFilterExchange.getExchange();
        ServerHttpResponse response = exchange.getResponse();
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
