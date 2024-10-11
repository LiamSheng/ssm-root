package linzi.ssm.spring01ioc.bean;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.Data;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
@Component
public class User implements InitializingBean, DisposableBean {

    private String username;
    private String password;
    private Person person;

    public User() {
        System.out.println("User构造器...");
    }

    @Autowired
    public void setPerson(Person person) {
        System.out.println("生命周期的AutoWired自动注入阶段。");
        this.person = person;
    }

    public void initUser() {
        System.out.println("生命周期指定的初始化...");
    }

    public void destroyUser() {
        System.out.println("@Bean注解指定的销毁...");
    }

    /**
     * 属性设置之后就开始调用
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet...");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy...");
    }

    @PostConstruct //构造器之后
    public void postConstruct() {
        System.out.println("postConstruct...");
    }

    @PreDestroy //销毁方法之前
    public void preDestroy() {
        System.out.println("preDestroy...");
    }
}
