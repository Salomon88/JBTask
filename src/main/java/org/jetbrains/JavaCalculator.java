package org.jetbrains;

import org.jetbrains.factory.CalculatorFactory;

public class JavaCalculator {
    /*
    Create a simple calculator that given a string of operators (), +, -, *, / and numbers separated by spaces
    returns the value of that expression

    Example: JavaCalculator.evaluate("1 + 1") => 2
     */
    public static Double evaluate(String expression) {

        if(expression==null) throw new NullPointerException("Expression value can't be null for " +
                JavaCalculator.class.getName());
        if(expression.length()==0) return 0d;
        if(expression.length()==1) return Double.valueOf(expression);

        //return 3.0;
        return CalculatorFactory.getCalc().evaluate(expression);
    }

    public static void main(String[] args) {
        evaluate("3+ 3 *5");
    }
}
