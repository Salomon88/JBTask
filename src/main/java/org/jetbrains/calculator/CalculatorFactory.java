package org.jetbrains.calculator;

import org.jetbrains.calculator.antlr.ANTLRCalcImpl;
import org.jetbrains.calculator.nashorn.NashornCalcImpl;
import org.jetbrains.calculator.polish.PolishCalcImpl;

import static java.util.Objects.isNull;

public final class CalculatorFactory {

    public static ICalculator getCalc(EvaluatorType evaluatorType) {
        if(isNull(evaluatorType)) return new ANTLRCalcImpl();
        switch (evaluatorType) {
            case POLISH:
                return new PolishCalcImpl();
            case NASHORN:
                return new NashornCalcImpl();
            default:
                return new ANTLRCalcImpl();
        }
    }

    public enum EvaluatorType {
        ANTLR,
        NASHORN,
        POLISH
    }
}
