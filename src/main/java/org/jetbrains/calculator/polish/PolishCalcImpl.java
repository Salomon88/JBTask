package org.jetbrains.calculator.polish;

import org.jetbrains.calculator.AbstractCalc;

import java.util.Deque;

public class PolishCalcImpl extends AbstractCalc {

    @Override
    public Double evaluate(String expression) {
        Deque<Double> stack = ShuntingYardAlg.polishNotationString(expression);
        return stack.pollLast();
    }
}
