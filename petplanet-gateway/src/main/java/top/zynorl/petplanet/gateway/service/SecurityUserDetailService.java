package top.zynorl.petplanet.gateway.service;

import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class SecurityUserDetailService implements ReactiveUserDetailsService {

    @Override
    public Mono<UserDetails> findByUsername(String username) {
        //这里根据用户名去数据库查账号密码
        UserDetails user = User.withUsername(username).password(new BCryptPasswordEncoder().encode("123456"))
                .roles("admin", "super").authorities("admin").build();
        return Mono.just(user);
    }
}
