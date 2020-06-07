package org.jetbrains.calculator;

public abstract class AbstractCalc implements ICalculator {

    protected final String expression;

    AbstractCalc(String expression) {
        this.expression = expression;
    }
}
