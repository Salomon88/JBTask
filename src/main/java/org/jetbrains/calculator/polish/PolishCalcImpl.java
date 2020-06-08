package org.jetbrains.calculator.polish;

import org.jetbrains.calculator.AbstractCalc;

public class PolishCalcImpl extends AbstractCalc {

    public PolishCalcImpl(String expression) {
        super(expression);
    }

    @Override
    public Double evaluate() {
        return 3.3;
    }
}
