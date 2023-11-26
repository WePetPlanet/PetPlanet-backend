package top.zynorl.petplanet.auth.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @version 1.0
 * @Author niuzy
 * @Date 2023/11/25
 **/
@ConfigurationProperties(prefix = "auth.user")
@Component
@Data
public class UserAuthConfig {
    private Boolean isDoFilter;
    private List<String> whiteList;
}
