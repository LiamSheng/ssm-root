package linzi.ssm.spring01ioc.config;

import linzi.ssm.spring01ioc.bean.Person;
import linzi.ssm.spring01ioc.conditional.windowsConditional;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration // 告诉spring容器，这是一个配置类。
public class PersonConfig {

    @Conditional(windowsConditional.class)
    @Bean("linzi")
    //4. 在容器中注册一个自己的组件。
    public Person linzi() {
        Person person = new Person();
        person.setName("linzi");
        person.setAge(0);
        person.setGender("");
        return person;
    }

    @Primary // 适用于同类型多组建的情况。
    @Bean("linzi2")
    //4. 在容器中注册一个自己的组件。
    public Person linzi2() {
        Person person = new Person();
        person.setName("linzi2");
        person.setAge(0);
        person.setGender("");
        return person;
    }

}
