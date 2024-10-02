package linzi.ssm.spring01ioc;

import linzi.ssm.spring01ioc.bean.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Map;

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
//        String[] names = ioc.getBeanDefinitionNames();
//        for (String name : names) {
//            System.out.println(name);
//        }

        //5. 获取容器中的组建对象。
        // 组件的四大特性：名字，类型，对象和作用域。
        //  名字：默认是方法名，但是可以使用 @Bean("新名字") 修改，要求全局唯一。
        //      重复名字的组件，容器只添加第一个对象。

        //5.1 按照组件的名字获取对象，需要强转。
        Person linzi = (Person) ioc.getBean("linzi");
        //5.2 按照组件的类型获取对象，不需要强转但是要保证是唯一的。
        Person linzi2 = ioc.getBean(Person.class);
        //5.3 按照类型获取一类对象。
        Map<String, Person> persons = ioc.getBeansOfType(Person.class);
    }

    @Bean("linzi")
    //4. 在容器中注册一个自己的组件。
    public Person person() {
        Person person = new Person();
        person.setName("");
        person.setAge(0);
        person.setGender("");
        return person;
    }

}
