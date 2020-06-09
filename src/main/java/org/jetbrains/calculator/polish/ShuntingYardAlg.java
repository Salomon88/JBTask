package org.jetbrains.calculator.polish;

import org.jetbrains.calculator.utils.Utils;

import java.util.*;

import static java.lang.Character.isDigit;
import static java.util.Objects.nonNull;

public class ShuntingYardAlg {

    private ShuntingYardAlg(){}
    public static Deque<Double> polishNotationString(String in) {
        Deque<Character> opStack = new LinkedList<>();
        Deque<Double> output = new LinkedList<>();

        String tmpNumber;
        char curChar;
        for (int i = 0; i < in.length(); i++) {
            curChar = in.charAt(i);

            if (curChar == ' ') continue;

            if (isUnary(opStack, in, i)) {
                char sign = in.charAt(i);
                ++i;
                tmpNumber = parseNumber(in, i);
                output.offerLast(Double.parseDouble(sign + tmpNumber));
                i += tmpNumber.length() - 1;
            } else if (isDigit(curChar)) {
                tmpNumber = parseNumber(in, i);
                output.offerLast(Double.parseDouble(tmpNumber));
                i += tmpNumber.length() - 1;
            } else if (Utils.operationsSet.contains(curChar)) {
                while (!opStack.isEmpty() && opStack.peekLast() != '(' && !isHigherPrecedence(curChar, opStack.peekLast())) {
                    perform(output, opStack.pollLast());
                }
                opStack.offerLast(curChar);
            } else if (curChar == '(') {
                opStack.offerLast(curChar);
            } else if (curChar == ')') {
                while (!opStack.peekLast().equals('(')) {
                    perform(output, opStack.pollLast());
                }
                opStack.pollLast();
            }
        }

        while (!opStack.isEmpty())
            perform(output, opStack.pollLast());
        return output;
    }

    private static String parseNumber(String in, int st) {
        int stopIndex = st;
        char curChar;
        for (int i = st; i < in.length(); i++) {
            curChar = in.charAt(i);
            if (!isDigit(curChar)) break;
            ++stopIndex;
        }
        return in.substring(st, stopIndex);
    }

    private static void perform(Deque<Double> stack, char operator) {
        if(stack.size()==1) return;
        Double right = stack.pollLast();
        Double left = stack.pollLast();
        switch (operator) {
            case '*':
                stack.offerLast(left * right);
                break;
            case '/':
                stack.offerLast(left / right);
                break;
            case '+':
                stack.offerLast(left + right);
                break;
            case '-':
                stack.offerLast(left - right);
        }
    }

    private static boolean isUnary(Deque<Character> stack, String in, int pos) {
        if (in.length() - 1 < pos + 1) return false;
        Character last = stack.peekLast();
        char cur = in.charAt(pos);
        return  (nonNull(last) && last != '(' || pos==0)
                && (cur=='+' || cur=='-')
                && isDigit(in.charAt(pos + 1));
    }

    private static boolean isHigherPrecedence(char cur, char top) {
        return (cur == '*' || cur == '/') && (top == '+' || top == '-') ? true : false;
    }
}
