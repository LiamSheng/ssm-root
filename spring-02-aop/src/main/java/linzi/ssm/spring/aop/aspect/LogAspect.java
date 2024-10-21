package linzi.ssm.spring.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.junit.jupiter.api.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Order(1)// 数字越小, 优先级越高, 默认是按照类名字母顺序排序.
//@Component
@Aspect// 表明这是一个 Spring 的切面类.
public class LogAspect {

    @Pointcut("execution(int *(int, int))")
    public void pointCut() {
        // 空方法, 目的是抽取切入点表达式.
    };

    /**
     * 告诉 Spring, 下面这些通知方法何时何地运行.
     * 何时?
     *  @Before, 方法执行之前.
     *  @AfterReturning, 方法返回结果时.
     *  @AfterThrowing, 方法抛出异常时,
     *  @After, 方法执行之后.
     *
     *  @Around, 环绕通知, 可以控制目标方法是否执行, 修改目标方法执行的结果.
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
     *  通知方法的执行顺序:
     *      1. 正常链路: @Before -> 目标方法 -> @AfterReturn -> @After.
     *      2. 异常链路: @Before -> 目标方法 -> @AfterThrowing -> @After.
     *
     *  JointPoint 包装了当前目标方法的全部信息.
     */
    @Before(value = "pointCut()")
    public void logStart(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature(); // 拿到方法的全签名.
        String methodName = signature.getName();// 获取方法名.
        Object[] args = joinPoint.getArgs();// 目标方法传来的参数的值.
        System.out.println("[切面-日志1] logStart... "+ methodName + Arrays.asList(args));
    }

    @After(value = "pointCut()")
    public void logEnd(JoinPoint joinPoint) {
        System.out.println("[切面-日志1] logEnd..." + joinPoint.getSignature().getName());
    }

    @AfterReturning(value = "pointCut()", returning = "result")
    public void logReturn(JoinPoint joinPoint, Object result) {
        System.out.println("[切面-日志1] logReturn..." + result);
    }

    @AfterThrowing(value = "pointCut()", throwing = "e")
    public void logException(JoinPoint joinPoint, Throwable e) {
        // 如果指明了 e 是某一种异常, 则不一定会除触发这个切面方法.
        System.out.println("[切面-日志1] logException..." + joinPoint.getSignature().getName() + e.getMessage());
    }

}
