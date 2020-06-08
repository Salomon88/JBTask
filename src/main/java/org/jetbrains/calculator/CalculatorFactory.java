package org.jetbrains.calculator;

import org.jetbrains.calculator.antlr.ANTLRCalcImpl;
import org.jetbrains.calculator.nashorn.NashornCalcImpl;

public class CalculatorFactory {

    public static ICalculator getCalc(String expression) {
//        ICalculator iCalc = new NashornCalcImpl(expression);
        ICalculator iCalc = new ANTLRCalcImpl(expression);
        return iCalc;
    }
}
