package linzi.mybatis.starter.config;

import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class MyBatisConfig {

    @Bean
    PageInterceptor pageInterceptor(Interceptor interceptor) {
        // 1.创建分页插件对象.
        PageInterceptor pageInterceptor = new PageInterceptor();
        // 2.设置一些参数.
        Properties properties = new Properties();
        // 分页合理化, 请求访问超过限度, 跳回第一页或者最后一页.
        properties.setProperty("reasonable", "true");
        interceptor.setProperties(properties);
        return pageInterceptor;
    }

}
