package linzi.ssm.spring.aop;

import linzi.ssm.spring.aop.calculator.Impl.MathCalculatorImpl;
import linzi.ssm.spring.aop.calculator.MathCalculator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@SpringBootApplication
public class Spring02AopApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext ioc = SpringApplication.run(Spring02AopApplication.class, args);
        System.out.println(ioc);
        System.out.println("<--------------------------------->");

        String[] names = ioc.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }

        MathCalculator calculator = ioc.getBean(MathCalculator.class);
        System.out.println(calculator.toString());

    }

}
