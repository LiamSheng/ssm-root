package linzi.ssm.spring01ioc.processor;

import linzi.ssm.spring01ioc.bean.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component // 拦截所有Bean的后置处理器, Spring 运行起来之后所有的 Bean 都会被这个方法处理一遍.
public class MyTestBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("****BEFORE-----Bean: " + bean + "name: " + beanName);
        if (bean instanceof User user) {
            user.setUsername("linzi9506");
        }
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("****AFTER-----Bean: " + bean + "name: " + beanName);
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
    
}
