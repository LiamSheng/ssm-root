package linzi.spring.restful.crud.config;

import linzi.spring.restful.crud.interceptor.MyHandlerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 对 SpringMVC 底层配置, 容器中需要有组件: WebMvcConfigurer
 * 1. 使用 @Bean.
 * 2. 实现接口.
 */
@Configuration // 将此类声明为 Spring 配置类，专门对 SpringMVC 的底层进行配置。
public class MySpringMVCConfig implements WebMvcConfigurer {

    MyHandlerInterceptor myHandlerInterceptor;

    /**
     * Autowire 注解，用于自动注入 MyHandlerInterceptor 依赖
     *
     * @param myHandlerInterceptor Spring 容器中注册的拦截器组件
     */
    @Autowired
    public void setMyHandlerInterceptor(MyHandlerInterceptor myHandlerInterceptor) {
        this.myHandlerInterceptor = myHandlerInterceptor;
    }

    /**
     * 添加拦截器到 SpringMVC 配置中
     *
     * @param registry 拦截器注册器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myHandlerInterceptor)
                .addPathPatterns("/**"); // 拦截所有的请求
    }

    // 方式1. 通过匿名类将组件加入到容器中
    /*
    @Bean
    WebMvcConfigurer myWebMvcConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                // 在这里可以添加自定义的视图控制器配置
            }
        };
    }
    */
}
