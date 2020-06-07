package org.jetbrains;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JavaCalculatorTest {
    @Test
    public void simpleTest() {
        assertEquals("simple addition", 2.0, JavaCalculator.evaluate("1 + 1"), 1e-4);
    }

    @Test(expected = RuntimeException.class)
    public void nullTest() {
        JavaCalculator.evaluate(null);
    }

    @Test
    public void emptyStringTest() {
        assertEquals("simple addition", 0.0d, JavaCalculator.evaluate(""), 1e-4);
    }

    @Test
    public void onePositiveNumberTest() {
        assertEquals("simple addition", 3.0, JavaCalculator.evaluate("3"), 1e-4);
    }


    @Test
    public void oneNegativeNumberTest() {
        assertEquals("simple addition", -3.0, JavaCalculator.evaluate("-3"), 1e-4);
    }

    @Test
    public void oneFloatingNumberTest() {
        assertEquals("simple addition", 3.14, JavaCalculator.evaluate("3.14"), 1e-4);
    }
}
