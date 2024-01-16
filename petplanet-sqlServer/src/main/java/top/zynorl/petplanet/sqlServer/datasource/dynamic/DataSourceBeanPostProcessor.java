package top.zynorl.petplanet.sqlServer.datasource.dynamic;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import top.zynorl.petplanet.sqlServer.datasource.annotation.DataSourceSwitch;
import top.zynorl.petplanet.sqlServer.datasource.context.DataSourceContextHolder;

/**
 * Created by zynorl on 2024/1/16 11:38
 */
@Component
public class DataSourceBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> clazz = bean.getClass();
        DataSourceSwitch classLevelAnnotation = clazz.getAnnotation(DataSourceSwitch.class);
        if (classLevelAnnotation != null) {
            // 设置类级别的数据源
            String targetDataSource = classLevelAnnotation.value();
            DataSourceContextHolder.setDataSourceType(targetDataSource);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
