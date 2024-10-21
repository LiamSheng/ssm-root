package linzi.ssm.spring.aop.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect // 表明这是一个 Spring 的切面类
public class LogAspect {
    /**
     * 告诉 Spring, 下面这些通知方法何时何地运行.
     * 何时?
     *  @Before, 方法执行之前.
     *  @AfterReturning, 方法返回结果时.
     *  @AfterThrowing, 方法抛出异常时,
     *  @After, 方法执行之后.
     *
     * 何地?
     *  切入点表达式:
     *      execution(方法的全签名)
     *          全写法: [public] int [linzi.ssm.spring.aop.calculator.MathCalculator.]add(int, int) [throws Exception]
     *          省略法: int add(int, int)
     *          通配符:
     *              * 任意字符.
     *              .. 多个参数, 任意类型.
     *              * *(..) 最省略, 最通配.
     */

    @Before("execution(int *(int, int))")
    public void logStart() {
        System.out.println("[切面-日志] logStart...");
    }

    @After("execution(int *(int, int))")
    public void logEnd() {
        System.out.println("[切面-日志] logEnd...");
    }

    @AfterReturning
    public void logReturn() {
        System.out.println("[切面-日志] logReturn...]");
    }

    @AfterThrowing
    public void logException() {
        System.out.println("[切面-日志] logException...");
    }

}
