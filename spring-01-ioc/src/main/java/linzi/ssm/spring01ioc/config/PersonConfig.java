package linzi.ssm.spring01ioc.config;

import linzi.ssm.spring01ioc.bean.Person;
import linzi.ssm.spring01ioc.conditional.windowsConditional;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration // 告诉spring容器，这是一个配置类。
public class PersonConfig {

    @Conditional(windowsConditional.class)
    @Bean("linzi")
    //4. 在容器中注册一个自己的组件。
    public Person linzi() {
        Person person = new Person();
        person.setName("");
        person.setAge(0);
        person.setGender("");
        return person;
    }

    @Bean("linzi2")
    //4. 在容器中注册一个自己的组件。
    public Person linzi2() {
        Person person = new Person();
        person.setName("");
        person.setAge(0);
        person.setGender("");
        return person;
    }

}
