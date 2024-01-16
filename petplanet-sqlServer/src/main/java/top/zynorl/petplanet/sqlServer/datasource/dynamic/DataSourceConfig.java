package top.zynorl.petplanet.sqlServer.datasource.dynamic;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import top.zynorl.petplanet.sqlServer.datasource.context.DataSourceContextHolder;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zynorl on 2024/1/15 15:30
 */
@Configuration
public class DataSourceConfig {

    @Bean(name = "defaultDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.db")
    public DataSource defaultDataSource() {
        return DataSourceBuilder.create().build();
    }
    @Bean(name = "userDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.db1")
    public DataSource userDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "postDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.db2")
    public DataSource postDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "petDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.db3")
    public DataSource petDataSource() {
        return DataSourceBuilder.create().build();
    }

    // 实现自定义的RoutingDataSource
    @Bean
    public DataSource dynamicRoutingDataSource() {
        AbstractRoutingDataSource dataSource = new AbstractRoutingDataSource() {
            @Override
            protected Object determineCurrentLookupKey() {
                return DataSourceContextHolder.getDataSourceType();
            }
        };
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put("userDataSource", userDataSource());
        targetDataSources.put("postDataSource", postDataSource());
        targetDataSources.put("petDataSource", postDataSource());
        dataSource.setTargetDataSources(targetDataSources);
        dataSource.setDefaultTargetDataSource(defaultDataSource());
        return dataSource;
    }
}
