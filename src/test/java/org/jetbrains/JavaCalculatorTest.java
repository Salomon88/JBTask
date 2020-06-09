package org.jetbrains;


import org.jetbrains.calculator.CalculatorFactory;
import org.jetbrains.exceptions.IncorrectSyntaxExpression;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class JavaCalculatorTest {

    public static final CalculatorFactory.EvaluatorType type = CalculatorFactory.EvaluatorType.NASHORN;

    @Test
    public void simpleAddTest() {
        assertEquals(2.0, JavaCalculator.evaluate("1+1", type), 1e-4);
    }

    @Test
    public void simpleSubstractTest() {
        assertEquals(0.0, JavaCalculator.evaluate("1-1", type), 1e-4);
    }

    @Test
    public void simpleMulTest() {
        assertEquals(6.0, JavaCalculator.evaluate("2*3", type), 1e-4);
    }

    @Test
    public void simpleDivTest() {
        assertEquals(4.0, JavaCalculator.evaluate("12/3", type), 1e-4);
    }

    @Test(expected = NullPointerException.class)
    public void nullTest() {
        JavaCalculator.evaluate(null);
    }

    @Test
    public void emptyStringTest() {
        assertEquals(0.0d, JavaCalculator.evaluate(""), 1e-4);
    }

    @Test
    public void onePositiveNumberTest() {
        assertEquals(3.0, JavaCalculator.evaluate("3", type), 1e-4);
    }

    @Test
    public void oneNegativeNumberTest() {
        assertEquals(-3.0, JavaCalculator.evaluate("-3", type), 1e-4);
    }

    //TODO implement floats for Polish implementation
    @Test
    public void oneFloatingNumberTest() {
        assertEquals(3.14, JavaCalculator.evaluate("3.14", type), 1e-4);
    }

    @Test
    public void priorityTest() {
        assertEquals(5, JavaCalculator.evaluate("3+6/3", type), 1e-4);
    }

    @Test
    public void priorityUnaryTest() {
        assertEquals(1, JavaCalculator.evaluate("3+6/-3", type), 1e-4);
    }

    @Test
    public void parens1Test() {
        assertEquals(-1, JavaCalculator.evaluate("(4+1*(2-9))/3", type), 1e-4);
    }

    @Test
    public void parens2Test() {
        assertEquals(7, JavaCalculator.evaluate("(3+4)", type), 1e-4);
    }

    @Test
    public void parensUnaryTest() {
        assertEquals(12.0, JavaCalculator.evaluate("3*(8-+4)", type), 1e-4);
    }

    @Test
    public void spacesTest() {
        assertEquals(7.0, JavaCalculator.evaluate("( 3+4) ", type), 1e-4);
    }

    @Test
    public void float1Test() {
        assertEquals(0.33, JavaCalculator.evaluate("1/3 ", type), 1e-2);
    }

    @Test
    public void float2Test() {
        assertNotEquals(0.4, JavaCalculator.evaluate("1/3 ", type), 1e-2);
    }

    @Test
    public void float3Test() {
        assertEquals(2.0, JavaCalculator.evaluate("6/9*3 ", type), 1e-4);
    }

    //TODO implement floats for Polish implementation
    @Test
    public void float4Test() {
        assertEquals(6.28, JavaCalculator.evaluate("3.14*2 ", type), 1e-4);
    }

    @Test(expected = IncorrectSyntaxExpression.class)
    public void incorrectSyntaxTest() {
        assertEquals(7.0, JavaCalculator.evaluate("a+4 ", type), 1e-4);
    }

    //TODO implement for Polish implementation
    @Test
    public void negativeExpression1Test() {
        assertEquals(-7.0, JavaCalculator.evaluate("-(4+3) ", type), 1e-4);
    }

    @Test
    public void negativeExpression2Test() {
        assertEquals(1.0, JavaCalculator.evaluate("-(3-4) ", type), 1e-4);
    }

//        ICalculator icalc = CalculatorFactory.getCalc();
//        List<Double> doubleList = new ArrayList<String>().stream().map(icalc::evaluate).collect(toList());
}
