package linzi.spring.restful.crud.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component // 默认拦截所有请求.
@WebFilter("/hello") // 原生web注解没有用了, 配置很麻烦, 用拦截器就好了.
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        System.out.println("MyFilter 前置逻辑");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("MyFilter 后置逻辑");
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
