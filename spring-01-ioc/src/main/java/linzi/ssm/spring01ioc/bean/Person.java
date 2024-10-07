package linzi.ssm.spring01ioc.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 指明属性值来源于这个文件。
 *  1. classpath:person.properties 自己项目的路径下找。
 *  2. classpath*:person.properties 从所有包的类路劲下找。
 */
@PropertySource("classpath:person.properties")
@Data
@Component
public class Person {

    private String name;

    @Value("${person.age}")
    private int age;

    /**
     * 1. @Value("Male") 静态赋值
     * 2. @Value("${}") 从配置文件中取出某一项的值
     * 3. @Value("#{spEL}") 还可以写 Spring 表达式语言
     */
    @Value("#{T(java.util.UUID).randomUUID().toString()}")
    private String gender;

}
