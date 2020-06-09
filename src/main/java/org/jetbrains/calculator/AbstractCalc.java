package org.jetbrains.calculator;

import org.jetbrains.calculator.utils.SyntaxValidator;

public abstract class AbstractCalc implements ICalculator {
    protected final String expression;

    public AbstractCalc(String expression) {
        this.expression = expression;
        SyntaxValidator.isSyntaxValid(expression);
    }
}
