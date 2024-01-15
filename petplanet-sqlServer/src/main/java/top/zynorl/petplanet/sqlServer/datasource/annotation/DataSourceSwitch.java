package top.zynorl.petplanet.sqlServer.datasource.annotation;

import java.lang.annotation.*;

/**
 * Created by zynorl on 2024/1/15 13:55
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface DataSourceSwitch {
    String value() default ""; // 数据源名称或标识符
}
