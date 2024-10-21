package linzi.ssm.spring.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.junit.jupiter.api.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Order(2)// 数字越小, 优先级越高, 默认是按照类名字母顺序排序.
//@Component
@Aspect// 表明这是一个 Spring 的切面类.
public class LogAspect02 {

    @Pointcut("execution(int *(int, int))")
    public void pointCut() {
        // 空方法, 目的是抽取切入点表达式.
    };

    @Before(value = "pointCut()")
    public void logStart(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature(); // 拿到方法的全签名.
        String methodName = signature.getName();// 获取方法名.
        Object[] args = joinPoint.getArgs();// 目标方法传来的参数的值.
        System.out.println("[切面-日志2] logStart... "+ methodName + Arrays.asList(args));
    }

    @After(value = "pointCut()")
    public void logEnd(JoinPoint joinPoint) {
        System.out.println("[切面-日志2] logEnd..." + joinPoint.getSignature().getName());
    }

    @AfterReturning(value = "pointCut()", returning = "result")
    public void logReturn(JoinPoint joinPoint, Object result) {
        System.out.println("[切面-日志2] logReturn..." + result);
    }

    @AfterThrowing(value = "pointCut()", throwing = "e")
    public void logException(JoinPoint joinPoint, Throwable e) {
        // 如果指明了 e 是某一种异常, 则不一定会除触发这个切面方法.
        try {
            if (e != null) {
                System.out.println("[切面-日志2] logException..." + joinPoint.getSignature().getName() + e.getMessage());
            }
        } catch (Exception ex) {
            System.out.println("抛出异常!");
        }
    }

}
