package linzi.ssm.spring.aop.proxy.statics;

import linzi.ssm.spring.aop.calculator.MathCalculator;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
public class CalculatorStaticProxy implements MathCalculator {

    private MathCalculator mathCalculator;

    public CalculatorStaticProxy(MathCalculator mathCalculator) {
        this.mathCalculator = mathCalculator;
    }

    @Override
    public int add(int a, int b) {
        System.out.println("[静态代理日志]-加法: " + a + "+" + b + "=" + mathCalculator.add(a, b));
        return mathCalculator.add(a, b);
    }

    @Override
    public int subtract(int a, int b) {
        System.out.println("[静态代理日志]-减法: " + a + "-" + b + "=" + mathCalculator.subtract(a, b));
        return mathCalculator.subtract(a, b);
    }

    @Override
    public int multiply(int a, int b) {
        System.out.println("[静态代理日志]-乘法" + a + "*" + b + "=" + mathCalculator.multiply(a, b));
        return mathCalculator.multiply(a, b);
    }

    @Override
    public int divide(int a, int b) {
        System.out.println("[静态代理日志]-除法" + a + "/" + b + "=" + mathCalculator.divide(a, b));
        return mathCalculator.divide(a, b);
    }

}