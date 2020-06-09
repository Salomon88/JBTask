package org.jetbrains.exceptions;

public class IncorrectSyntaxExpression extends RuntimeException {
    public IncorrectSyntaxExpression(String s) {
        super(s);
    }
}
