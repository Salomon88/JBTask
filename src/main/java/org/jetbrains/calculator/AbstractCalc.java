package org.jetbrains.calculator;

public abstract class AbstractCalc implements ICalculator {
    protected final String expression;

    public AbstractCalc(String expression) {
        this.expression = expression;
    }
}
