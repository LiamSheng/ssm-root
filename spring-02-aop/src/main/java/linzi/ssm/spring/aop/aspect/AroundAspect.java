package linzi.ssm.spring.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.junit.jupiter.api.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class AroundAspect {

    @Pointcut("execution(int *(int, int))")
    public void pointCut() {};

    /**
     * 环绕通知有固定写法
     *  Object: 返回值
     *  ProceedingJoinPoint: 可以继续推进的切点.
     */
    @Around(value = "pointCut()")
    public Object aroundAdvise(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result = null;
        Object[] args = joinPoint.getArgs();// 获取目标方法的参数.

        // 环绕通知 - 前置.
        System.out.println("1-@Before.");

        // 接受传入参数的 proceed, 实现修改目标方法执行的参数.
        try{
            result = joinPoint.proceed(args);// 执行目标方法. 类似反射里的 method.invoke()
            System.out.println("1-@AfterReturning.");
        } catch (Throwable throwable) {
            System.out.println("1-@AfterThrowing");
        } finally {
            System.out.println("1-@After");
        }

        return result;
    }

}
