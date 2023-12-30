package top.zynorl.petplanet.gateway.util;

import cn.hutool.core.date.DateUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import org.apache.commons.lang.time.DateUtils;
import org.springframework.data.redis.connection.convert.StringToDataTypeConverter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.datatype.DatatypeFactory;
import java.security.Key;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * jwt 工具类
 */
public final class JwtTokenUtil {
    private static Key getInstance(String salt) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
//        String apiKey = DatatypeConverter.printBase64Binary(salt.getBytes());
//        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(apiKey);
        SecretKeySpec secretKeySpec = new SecretKeySpec(salt.getBytes(), signatureAlgorithm.getJcaName());
        return secretKeySpec;
    }

    /**
     * 生成token
     * @param claims
     * @param salt
     * @param exp
     * @return
     */
    public static String createJavaWebToken4JwtAuth(Map<String, Object> claims, String salt, Integer exp) {
        String token = Jwts.builder().setClaims(claims).setExpiration(DateUtils.addSeconds(new Date(), exp))
                .signWith(SignatureAlgorithm.HS256, getInstance(salt))
                .compact();
        return token;
    }

    public static Map<String, Object> verifyJavaWebToken(String token, String salt) {
        Map<String, Object> claims = Jwts.parser().setSigningKey(getInstance(salt)).parseClaimsJws(token).getBody();
        return claims;
    }
    public static Authentication getAuthentication(String token, String salt) {
        Map<String, Object> stringObjectMap = verifyJavaWebToken(token, salt);
        if(stringObjectMap == null || stringObjectMap.get("user-info") == null) {
            return null;
        }

        LinkedHashMap<String,Object> userDetails = (LinkedHashMap<String, Object>) stringObjectMap.get("user-info");
        List<GrantedAuthority> authorities = userDetails == null ? AuthorityUtils.NO_AUTHORITIES : AuthorityUtils.commaSeparatedStringToAuthorityList((String) userDetails.get("role"));

        User principal = new User((String) userDetails.get("username"), "", authorities);
        return new UsernamePasswordAuthenticationToken(principal, token, authorities);
    }
}
