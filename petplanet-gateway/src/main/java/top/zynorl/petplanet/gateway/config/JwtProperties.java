package top.zynorl.petplanet.gateway.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "timing.jwt")
public class JwtProperties {
    private String secretKey;
    private int validateInMs;

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public int getValidateInMs() {
        return validateInMs;
    }

    public void setValidateInMs(int validateInMs) {
        this.validateInMs = validateInMs;
    }
}
