package org.jetbrains;

import org.jetbrains.calculator.CalculatorFactory;

public class JavaCalculator {
    private JavaCalculator() {
    }

    /*
    Create a simple calculator that given a string of operators (), +, -, *, / and numbers separated by spaces
    returns the value of that expression

    Example: JavaCalculator.evaluate("1 + 1") => 2
     */
    public static Double evaluate(String expression) {
        return evaluate(expression, null);
    }

    /**
     * @param expression  - math expression like `3+3*3`
     * @param type - Enum that determines algorithm of execution
     * @return  - Double value of calculation
     **/

    public static Double evaluate(String expression, CalculatorFactory.EvaluatorType type) {
        return CalculatorFactory.getCalc(type).evaluate(expression);
    }
}
