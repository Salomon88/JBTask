package org.jetbrains.calculator.polish;

import org.jetbrains.calculator.AbstractCalc;
import java.util.Deque;

public class PolishCalcImpl extends AbstractCalc {

    public PolishCalcImpl(String expression) {
        super(expression);
    }

    @Override
    public Double evaluate() {
        Deque<Double> stack = ShuntingYardAlg.polishNotationString(expression);
        return stack.pollLast();
    }
}
