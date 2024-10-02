package linzi.ssm.spring01ioc;

import linzi.ssm.spring01ioc.bean.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * 这个是主程序类
 */
@SpringBootApplication
public class Spring01IocApplication {

    public static void main(String[] args) {
        //1. 跑起一个Spring应用。
        //2. ConfigurableApplicationContext extends ApplicationContext，
        //	是Spring应用上下文对象，是一个ioc容器。
        ConfigurableApplicationContext ioc = SpringApplication.run(Spring01IocApplication.class, args);
        System.out.println(ioc);
        System.out.println("<--------------------------------->");

        //3. 获取容器中所有组件的名字。
        String[] names = ioc.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }

    }

    @Bean
    //4. 在容器中注册一个自己的组件。
    public Person person() {
        Person person = new Person();
        person.setName("");
        person.setAge(0);
        person.setGender("");
        return person;
    }

}
