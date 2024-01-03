package top.zynorl.petplanet.common.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AuthUser implements Serializable {
    private Long userid;
    private String username;
    private String role;
    private String token;
}
