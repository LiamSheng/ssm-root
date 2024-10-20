package linzi.ssm.spring.aop.proxy.dynamics;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class CalculatorDynamicProxy {

    public static Object getProxyInstance(Object object) {
        return Proxy.newProxyInstance(
                object.getClass().getClassLoader(),
                object.getClass().getInterfaces(),
                ((proxy, method, args) -> {
                    System.out.println("[动态代理]" + ": " + args[0] + " " + method.getName()
                            + " " + args[1] + " " + "equals to" + " " + method.invoke(object, args));
                    return method.invoke(object, args);
                })
        );
    }
}
