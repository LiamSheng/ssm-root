package linzi.mybatis.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class Mybatis01StarterApplication {

    public static void main(String[] args) {
        SpringApplication.run(Mybatis01StarterApplication.class, args);
    }

}
