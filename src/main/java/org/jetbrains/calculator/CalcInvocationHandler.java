package org.jetbrains.calculator;

import org.jetbrains.calculator.antlr.ANTLRCalcImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static java.util.Objects.nonNull;
import static org.jetbrains.calculator.utils.SyntaxValidator.isSyntaxValid;


public class CalcInvocationHandler implements InvocationHandler {
    private final ICalculator iCalculator;

    public CalcInvocationHandler(ICalculator iCalculator) {
        this.iCalculator = iCalculator;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        String expression = null;

        if (method.getName().equals("evaluate")) expression = (String) objects[0];
        if (nonNull(expression) && expression.length() == 0) return 0.0d;
        if (nonNull(expression) && !(iCalculator instanceof ANTLRCalcImpl)) isSyntaxValid(expression);

        try {
            return method.invoke(iCalculator, objects);
        } catch (Exception e) {
            throw ((InvocationTargetException) e).getTargetException();
        }
    }
}
