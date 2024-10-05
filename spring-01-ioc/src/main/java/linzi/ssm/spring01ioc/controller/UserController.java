package linzi.ssm.spring01ioc.controller;

import linzi.ssm.spring01ioc.bean.Person;
import linzi.ssm.spring01ioc.service.UserService;
import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;

@Data
@ToString
@Controller
public class UserController {

    /**
     * 自动装配的流程（先找类型，再找名字）。
     *  1.按照类型找到这个组件，有且找到一个，直接注入。
     *      1.1 如果本身有多个组件，使用方法名或者变量名。
     */
    @Autowired // 自动装配，即Spring调用容器的getBean。
    UserService userService;

    @Autowired
    List<Person> persons; // 把整个类型的组件都拿来。

    @Autowired
    Map<String, Person> personMap;
    // personMap={linzi=Person(name=, age=0, gender=), linzi2=Person(name=, age=0, gender=)}

    @Autowired
    ApplicationContext applicationContext;
}
