package linzi.ssm.spring01ioc.config;

import linzi.ssm.spring01ioc.datasource.MyDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

// @Profile({"dev", "default"}) // 整体激活的方式。
@Configuration
public class DataSourceConfig {
    /**
     * 1. 定义一个环境标识。
     * 2. 激活环境标识，告诉 Spring 当前是什么环境，不说就是 default。
     */

    // 模拟的开发数据源
    @Bean // 放入容器中
    @Profile({"dev", "default"}) // 需要切换的时候去 application.properties 修改 spring.profiles.active 的值
    public MyDataSource dev() {
        MyDataSource myDataSource = new MyDataSource();
        myDataSource.setUrl("jdbc:mysql://localhost:3306/dev");
        myDataSource.setUsername("root");
        myDataSource.setPassword("123456");
        return myDataSource;
    }

    // 模拟的测试环境数据源
    @Bean
    @Profile("test")
    public MyDataSource test() {
        MyDataSource myDataSource = new MyDataSource();
        myDataSource.setUrl("jdbc:mysql://localhost:3306/test");
        myDataSource.setUsername("root");
        myDataSource.setPassword("123456");
        return myDataSource;
    }

    // 模拟的生产环境的数据源
    @Bean
    @Profile("prod")
    public MyDataSource prod() {
        MyDataSource myDataSource = new MyDataSource();
        myDataSource.setUrl("jdbc:mysql://localhost:3306/prod");
        myDataSource.setUsername("root");
        myDataSource.setPassword("123456");
        return myDataSource;
    }


}
