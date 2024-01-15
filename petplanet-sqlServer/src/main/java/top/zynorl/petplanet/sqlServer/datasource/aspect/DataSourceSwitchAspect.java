package top.zynorl.petplanet.sqlServer.datasource.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import top.zynorl.petplanet.sqlServer.datasource.annotation.DataSourceSwitch;
import top.zynorl.petplanet.sqlServer.datasource.context.DataSourceContextHolder;

/**
 * Created by zynorl on 2024/1/15 13:58
 */
@Configuration
@Aspect
public class DataSourceSwitchAspect {
    @Pointcut("@annotation(top.zynorl.petplanet.sqlServer.datasource.annotation.DataSourceSwitch)")
    public void aopPoint() {
    }
    @Around("aopPoint() && @annotation(dataSourceSwitch)")
    public Object switchDataSource(ProceedingJoinPoint pjp, DataSourceSwitch dataSourceSwitch) throws Throwable {
        String targetDataSource = dataSourceSwitch.value();
        DataSourceContextHolder.setDataSourceType(targetDataSource); // 假设你有一个全局的DataSourceContextHolder用来存储当前线程的数据源
        try {
            return pjp.proceed(); // 执行目标方法
        } finally {
            DataSourceContextHolder.clearDataSourceType(); // 方法执行完后清除数据源上下文信息
        }
    }

}
