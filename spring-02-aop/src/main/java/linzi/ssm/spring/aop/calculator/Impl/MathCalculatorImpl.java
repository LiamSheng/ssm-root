package linzi.ssm.spring.aop.calculator.Impl;

import linzi.ssm.spring.aop.calculator.MathCalculator;
import org.springframework.stereotype.Component;

/**
 * 添加日志的方法:
 *  1.硬编码, 业务逻辑和通用逻辑混在一起.
 *  2.静态代理:
 *      创建一个代理对象, 包装这个组件. 业务执行从代理对象开始. 编码时就确定好了代理关系.
 *      只能代理同一个类型的对象, 范围太小了.
 *  3.动态代理:
 *      运行期间才可以决定好代理关系.
 *      目标对象在运行期间会被动态拦截, 插入一段逻辑代码.
 */

@Component
public class MathCalculatorImpl implements MathCalculator {

    @Override
    public int add(int a, int b) {
        return a+b;
    }

    @Override
    public int subtract(int a, int b) {
        return a-b;
    }

    @Override
    public int multiply(int a, int b) {
        return a*b;
    }

    @Override
    public int divide(int a, int b) {
        return a/b;
    }

}
