package org.jetbrains.calculator;

public class CalculatorFactory {

    public static ICalculator getCalc(String expression) {
        ICalculator iCalc=new NashornCalcImpl(expression);
        return iCalc;
    }
}
