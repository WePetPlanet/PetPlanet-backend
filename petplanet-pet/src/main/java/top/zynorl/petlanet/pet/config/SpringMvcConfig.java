package top.zynorl.petlanet.pet.config;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import top.zynorl.petplanet.common.interceptor.AuthUserInterceptor;

@Configuration
public class SpringMvcConfig implements WebMvcConfigurer {



   @Autowired
   AuthUserInterceptor authUserInterceptor;

   @Override
   public void addInterceptors(InterceptorRegistry registry) {
       registry.addInterceptor(authUserInterceptor);
//
//       registry.addInterceptor(memberInterceptor)
//               .addPathPatterns("/**")
//               .excludePathPatterns(
//                       "/member/hello",
//                       "/member/member/send-code",
//                       "/member/member/login"
//               );
   }
}
