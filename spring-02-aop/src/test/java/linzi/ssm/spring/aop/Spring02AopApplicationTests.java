package linzi.ssm.spring.aop;

import linzi.ssm.spring.aop.calculator.Impl.MathCalculatorImpl;
import linzi.ssm.spring.aop.calculator.MathCalculator;
import linzi.ssm.spring.aop.proxy.dynamics.CalculatorDynamicProxy;
import linzi.ssm.spring.aop.proxy.statics.CalculatorStaticProxy;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Proxy;
import java.util.Arrays;

@SpringBootTest
class Spring02AopApplicationTests {

    // 依赖倒置, 依赖抽象接口, 而不是实现.
    @Autowired
    MathCalculator mathCalculator;

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

}
