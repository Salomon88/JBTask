package org.jetbrains;

import org.jetbrains.calculator.CalculatorFactory;

public class JavaCalculator {
    /*
    Create a simple calculator that given a string of operators (), +, -, *, / and numbers separated by spaces
    returns the value of that expression

    Example: JavaCalculator.evaluate("1 + 1") => 2
     */
    public static Double evaluate(String expression) {

        if (expression == null) throw new NullPointerException("Expression value can't be null for " +
                JavaCalculator.class.getName());
        if (expression.length() == 0) return 0d;
        return CalculatorFactory.getCalc(expression).evaluate();
    }

    public static void main(String[] args) {
        System.out.println(evaluate("3"));
        System.out.println(evaluate("-3"));
        System.out.println(evaluate("+3"));
        System.out.println(evaluate("3+ 3 *5"));
        System.out.println(evaluate("2*3.14"));
        System.out.println(evaluate("2*3.14*-1"));
        System.out.println(evaluate("1+-3*3"));
        System.out.println(evaluate("(3*(1+2)) -6"));
//        ICalculator icalc = CalculatorFactory.getCalc();
//        List<Double> doubleList = new ArrayList<String>().stream().map(icalc::evaluate).collect(toList());
    }
}
