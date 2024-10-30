package linzi.ssm.springmvc.controller;

import linzi.ssm.springmvc.bean.Visitor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

/**
 * 默认规则:
 * 1. 页面进入 templates 文件夹内, 静态资源放入 static 文件夹内.
 */
@Controller// 开发服务端渲染逻辑. Spring 不支持 JSP.
public class ThymeleafController {

    /**
     * 处理首页请求, 跳转到登录页面 login.html
     */
    @RequestMapping(value = "/")
    public String index() {
        // thymeleaf 默认去 templates 找页面 [view name].html
        return "login"; // 返回 View name.
    }

    /**
     * @param model 页面要展示的所有数据.
     */
    @RequestMapping(value = "login.mvc")
    public String login(String username, String password, Model model) {
        System.out.println("username: " + username + " password: " + password);

        // 去数据库查到访客列表...
        List<Visitor> visitorsList = Arrays.asList(
                new Visitor(1L, "Alice", 18),
                new Visitor(2L, "Bob", 12),
                new Visitor(3L, "Charlie", 25),
                new Visitor(4L, "David", 30),
                new Visitor(5L, "Eva", 17),
                new Visitor(6L, "Frank", 23));

        // 去数据库找到登录信息...
        model.addAttribute("name", username);
        model.addAttribute("age", 18);
        model.addAttribute("visitors", visitorsList);


        return "page/success";
    }

}
