package linzi.ssm.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody // 单例模式, 每次请求都执行一次目标方法.// 处理请求的控制器
public class HelloWorldController {

    /**
     * SpringBoot所做的工作:
     * 不用整合 tomcat.
     * 不实现 servlet 接口.
     * 自动解决乱码问题.
     */
    @RequestMapping("/hell?")
    public String helloWorld() {
        System.out.println("执行了一次目标方法.");
        return "Hello, SpringMVC!"; // 默认返回值是一个页面, 需要注解 @ResponseBody
    }

}
