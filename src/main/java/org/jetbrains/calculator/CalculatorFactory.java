package org.jetbrains.calculator;

import org.jetbrains.calculator.antlr.ANTLRCalcImpl;
import org.jetbrains.calculator.nashorn.NashornCalcImpl;
import org.jetbrains.calculator.polish.PolishCalcImpl;

import java.lang.reflect.Proxy;

import static java.util.Objects.isNull;
import static org.jetbrains.calculator.CalculatorFactory.EvaluatorType.ANTLR;

public final class CalculatorFactory {

    public static ICalculator getCalc(EvaluatorType evaluatorType) {
        if(isNull(evaluatorType)) evaluatorType = ANTLR;
        ICalculator iCalculator;
        switch (evaluatorType) {
            case POLISH:
                iCalculator = new PolishCalcImpl();
                break;
            case NASHORN:
                iCalculator = new NashornCalcImpl();
                break;
            default:
                iCalculator = new ANTLRCalcImpl();
        }
        return   (ICalculator) Proxy.newProxyInstance(
                        CalculatorFactory.class.getClassLoader(),
                        new Class[] {ICalculator.class},
                        new CalcInvocationHandler(iCalculator)
        );

    }

    public enum EvaluatorType {
        ANTLR,
        NASHORN,
        POLISH
    }
}
