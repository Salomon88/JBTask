package org.jetbrains.calculator;

import org.jetbrains.calculator.antlr.ANTLRCalcImpl;
import org.jetbrains.calculator.nashorn.NashornCalcImpl;
import org.jetbrains.calculator.polish.PolishCalcImpl;

import static java.util.Objects.isNull;

public final class CalculatorFactory {

    public static ICalculator getCalc(String expression, EvaluatotType evaluatotType) {
        if(isNull(evaluatotType)) return new ANTLRCalcImpl(expression);
        switch (evaluatotType) {
            case POLISH:
                return new PolishCalcImpl(expression);
            case NASHORN:
                return new NashornCalcImpl(expression);
            default:
                return new ANTLRCalcImpl(expression);
        }
    }

    public enum EvaluatotType {
        ANTLR,
        NASHORN,
        POLISH
    }
}
