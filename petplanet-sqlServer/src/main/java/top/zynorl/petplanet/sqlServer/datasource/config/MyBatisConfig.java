package top.zynorl.petplanet.sqlServer.datasource.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;

/**
 * Created by zynorl on 2024/1/15 15:45
 */
@Configuration
public class MyBatisConfig {
    @Autowired
    private DataSource dynamicRoutingDataSource;


    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dynamicRoutingDataSource);
        ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
        Resource[] mappings = resourcePatternResolver.getResources("classpath:/mapper/*Mapper.xml");
        factoryBean.setMapperLocations(mappings);  // 配置Mapping映射路径
        return factoryBean.getObject();
    }

}
