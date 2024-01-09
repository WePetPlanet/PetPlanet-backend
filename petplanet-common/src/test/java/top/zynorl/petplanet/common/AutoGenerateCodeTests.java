package top.zynorl.petplanet.common;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Types;
import java.util.Collections;

/**
 * Created by zynorl on 2023/11/5 20:09
 */
@SpringBootTest
@Component
@RunWith(SpringRunner.class)
public class AutoGenerateCodeTests {
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;
    @Test
    public void test01(){

        FastAutoGenerator.create(url, username, password)
                .globalConfig(builder -> {
                    builder.author("zynorl/niuzy") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("/Users/zynorl/Desktop/petplanet"); // 指定输出目录
                })
                .dataSourceConfig(builder -> builder.typeConvertHandler((globalConfig, typeRegistry, metaInfo) -> {
                    int typeCode = metaInfo.getJdbcType().TYPE_CODE;
                    if (typeCode == Types.SMALLINT) {
                        // 自定义类型转换
                        return DbColumnType.INTEGER;
                    }
                    return typeRegistry.getColumnType(metaInfo);

                }))
                .packageConfig(builder -> {
                    builder.parent("top.zynorl.petplanet") // 设置父包名
                            .moduleName("post.sqlServer") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, "/Users/zynorl/Desktop/petplanet")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.build();
                            //.addInclude("*"); // 设置需要生成的表名
                            //.addTablePrefix("t_", "c_"); // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }

}
