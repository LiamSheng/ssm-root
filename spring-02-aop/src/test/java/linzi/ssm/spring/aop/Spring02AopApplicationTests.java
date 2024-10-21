package linzi.ssm.spring.aop;

import linzi.ssm.spring.aop.calculator.Impl.MathCalculatorImpl;
import linzi.ssm.spring.aop.calculator.MathCalculator;
import linzi.ssm.spring.aop.proxy.dynamics.CalculatorDynamicProxy;
import linzi.ssm.spring.aop.proxy.statics.CalculatorStaticProxy;
import org.junit.jupiter.api.Test;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.lang.reflect.Proxy;
import java.util.Arrays;

@SpringBootTest
class Spring02AopApplicationTests {

    // 依赖倒置, 依赖抽象接口, 而不是实现.
    @Autowired
    MathCalculator mathCalculator; // 不再是自身实现, 而是 Spring 的代理对象.

    @Test
    void staticProxyTest() {
        CalculatorStaticProxy calculatorStaticProxy = new CalculatorStaticProxy(mathCalculator);
        calculatorStaticProxy.add(1, 2);
    }

    /**
     * Java 原生支持动态代理.
     *  ClassLoader loader, 用目标对象获取类加载器.
     *  Class<?>[] interfaces, 目标对象实现的接口.
     *  InvocationHandler h,
     *      proxy, 经纪人.
     *      method, 明星.
     *      args, 方法调用的参数.
     *  -----------------------------------------------
     *  动态代理的缺点: 比较麻烦, 而且必须要依赖接口.
     */
    @Test
    void dynamicProxyTest() {
        MathCalculator mathCalculator = new MathCalculatorImpl();
        mathCalculator.add(1, 2);

//        InvocationHandler invocationHandler = new InvocationHandler() {
//            @Override
//            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                return method.invoke(mathCalculator, args);
//            }
//        };

//        InvocationHandler invocationHandler = (proxy, method, args) -> {
//            return null;
//        };

        MathCalculator proxyInstance = (MathCalculator) Proxy.newProxyInstance(
                mathCalculator.getClass().getClassLoader(),
                mathCalculator.getClass().getInterfaces(),
                // InvocationHandler 类似一个拦截器.
                (proxy, method, args) -> {
                    System.out.println("proxy: " + proxy.getClass().getName());
                    System.out.println("method: " + method.getName());
                    System.out.println("args: " + Arrays.asList(args));
                    args[1] = 1000;
                    System.out.println("args: " + Arrays.asList(args));
                    return method.invoke(mathCalculator, args);
                }
        );

        System.out.println(proxyInstance.add(1, 2));

    }

    @Test
    void calculatorDynamicProxyTest() {
        MathCalculator proxyInstance = (MathCalculator) CalculatorDynamicProxy.getProxyInstance(new MathCalculatorImpl());
        proxyInstance.add(1, 2);
        proxyInstance.divide(2, 2);
    }

    /**
     * 切面中的所有通知方法其实就是增强器, 被组织成一个链路, 放进集合中.
     * AOP 的底层原理:
     *  1. Spring 会为每一个被切面切入的组件创建代理对象.(CGLIB 创建的代理对象, 无视接口.)
     *  2. 代理对象中保存了切面类里面所有的通知方法构成的增强器链.
     *  3. 目标方法执行的时候, 会先去增强器链中拿到需要提前执行的通知方法.
     * 使用 AOP 的步骤:
     *      1.在 pom 文件中添加 aop 依赖.
     *      2.编写一个切面类.
     */
    @Test
    void testAOP() {
        mathCalculator.divide(1, 0);
    }

}
