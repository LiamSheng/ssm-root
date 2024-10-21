package linzi.ssm.spring.aop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("linzi.ssm.spring.aop")
@EnableAspectJAutoProxy
public class AppConfig {
}
