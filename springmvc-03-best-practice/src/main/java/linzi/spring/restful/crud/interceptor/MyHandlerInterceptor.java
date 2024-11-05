package linzi.spring.restful.crud.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component // 将拦截器注册为Spring的组件，让SpringMVC知道该拦截器的存在和它所拦截的请求。
public class MyHandlerInterceptor implements HandlerInterceptor {
    /**
     * 预处理方法，在请求被处理之前调用。
     *
     * @param request  当前的HTTP请求
     * @param response 当前的HTTP响应
     * @param handler  处理器（controller）的对象
     * @return 返回true表示继续处理请求；返回false表示中断请求处理
     * @throws Exception 可以抛出异常，表示发生错误
     */
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        System.out.println("[MyHandlerInterceptor]-[preHandle]");
        //response.getWriter().write("No Permission");
        return true; // 继续处理请求
    }

    /**
     * 后处理方法，在请求被处理之后调用，但在视图被渲染之前。
     *
     * @param request      当前的HTTP请求
     * @param response     当前的HTTP响应
     * @param handler      处理器（controller）的对象
     * @param modelAndView 视图模型对象
     * @throws Exception 可以抛出异常，表示发生错误
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("[MyHandlerInterceptor]-[postHandle]");
    }

    /**
     * 完成请求处理后回调方法，在视图渲染之后调用。
     *
     * @param request  当前的HTTP请求
     * @param response 当前的HTTP响应
     * @param handler  处理器（controller）的对象
     * @param ex       处理过程中产生的异常
     * @throws Exception 可以抛出异常，表示发生错误
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("[MyHandlerInterceptor]-[afterCompletion]");
    }
}
