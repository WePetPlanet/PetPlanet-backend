package top.zynorl.petplanet.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.core.io.buffer.DefaultDataBufferFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UserDetailsRepositoryReactiveAuthenticationManager;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.context.NoOpServerSecurityContextRepository;
import reactor.core.publisher.Mono;
import top.zynorl.petplanet.gateway.filter.JwtTokenAuthenticationFilter;
import top.zynorl.petplanet.gateway.handler.AuthenticationFailHandler;
import top.zynorl.petplanet.gateway.handler.AuthenticationSuccessHandler;
import top.zynorl.petplanet.gateway.handler.CustomHttpBasicServerAuthenticationEntryPoint;
import top.zynorl.petplanet.gateway.handler.TimingLogoutSuccessHandler;
import top.zynorl.petplanet.gateway.service.SecurityUserDetailService;

@EnableWebFluxSecurity
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //security的鉴权排除的url列表
    private static final String[] excludedAuthPages = {
            "/auth/login",
    };

    // 实现该处的reactiveUserDetailsService


    @Bean
    public ReactiveAuthenticationManager reactiveAuthenticationManager(SecurityUserDetailService userDetailsService, PasswordEncoder passwordEncoder) {
        UserDetailsRepositoryReactiveAuthenticationManager authenticationManager = new UserDetailsRepositoryReactiveAuthenticationManager(userDetailsService);
        authenticationManager.setPasswordEncoder(passwordEncoder);
        return authenticationManager;
    }

    @Bean
    public SecurityWebFilterChain securityFilterChain(ServerHttpSecurity http,
                                                      CustomHttpBasicServerAuthenticationEntryPoint customHttpBasicServerAuthenticationEntryPoint,
                                                      AuthenticationSuccessHandler authenticationSuccessHandler,
                                                      AuthenticationFailHandler authenticationFailHandler,
                                                      TimingLogoutSuccessHandler timingLogoutSuccessHandler,
                                                      JwtProperties jwtProperties,
                                                      ReactiveAuthenticationManager reactiveAuthenticationManager) throws Exception {
        http.csrf().disable()
                .httpBasic().disable()
                .authenticationManager(reactiveAuthenticationManager)
                .exceptionHandling()
                .authenticationEntryPoint(customHttpBasicServerAuthenticationEntryPoint) // 自定义authenticationEntryPoint
                .accessDeniedHandler((swe, e)-> {
                    swe.getResponse().setStatusCode(HttpStatus.FORBIDDEN);
                    return swe.getResponse().writeWith(Mono.just(new DefaultDataBufferFactory().wrap("FORBIDDEN".getBytes())));
                })
                .and()
                .securityContextRepository(NoOpServerSecurityContextRepository.getInstance())
                .authorizeExchange()
                .pathMatchers(excludedAuthPages).permitAll() //白名单
                .pathMatchers(HttpMethod.OPTIONS).permitAll()// option请求默认放行
                .anyExchange()
                .authenticated()
                .and()
                .formLogin().loginPage("/auth/login")
                .authenticationSuccessHandler(authenticationSuccessHandler) // authenticationSuccessHandler
                .authenticationFailureHandler(authenticationFailHandler) // authenticationFailureHandler
                .and()
                .logout().logoutUrl("/auth/logout") //退出
                .logoutSuccessHandler(timingLogoutSuccessHandler) // logoutSuccessHandler
                .and()
                .addFilterAt(new JwtTokenAuthenticationFilter(jwtProperties), SecurityWebFiltersOrder.HTTP_BASIC) //  增加tokenFilter
                ;

        return http.build();
    }
}
