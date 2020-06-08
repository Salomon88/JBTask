package org.jetbrains.calculator.polish;

import org.jetbrains.calculator.AbstractCalc;

import java.util.Deque;
import java.util.Stack;

public class PolishCalcImpl extends AbstractCalc {

    public PolishCalcImpl(String expression) {
        super(expression);
    }

    @Override
    public Double evaluate() {
        Deque<Double> stack = ShuntingYardAlg.polishNotationString(expression);
        return stack.pollLast();
    }

    public static void main(String[] args) {
        //System.out.println(new PolishCalcImpl("5+7/3").evaluate());
//        System.out.println(new PolishCalcImpl("3*6/3").evaluate());
//        System.out.println(new PolishCalcImpl("(4+1*(2-9))/3").evaluate());
//        System.out.println(new PolishCalcImpl("-3+1").evaluate());
//        System.out.println(new PolishCalcImpl("-3*-1").evaluate());
//        System.out.println(new PolishCalcImpl("-3*-1").evaluate());
        //System.out.println(new PolishCalcImpl("3*+1").evaluate());
        System.out.println(new PolishCalcImpl("3*(8-+4)").evaluate());
    }
}
