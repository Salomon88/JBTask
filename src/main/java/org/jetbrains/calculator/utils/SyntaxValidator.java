package org.jetbrains.calculator.utils;

import org.antlr.v4.runtime.*;
import org.jetbrains.exceptions.IncorrectSyntaxExpression;

public class SyntaxValidator {

    private SyntaxValidator() {
    }

    //TODO  This is a dirty hang to use parser twice. Must be lightweight way
    public static void isSyntaxValid(String expression) {
        org.jetbrains.calculator.antlr.CalcLexer lexer = new org.jetbrains.calculator.antlr.CalcLexer(CharStreams.fromString(expression));
        lexer.addErrorListener(new ErrorSyntaxListener());
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        org.jetbrains.calculator.antlr.CalcParser parser = new org.jetbrains.calculator.antlr.CalcParser(tokenStream);
        parser.stmt();
    }

    private static class ErrorSyntaxListener extends BaseErrorListener {
        @Override
        public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
            throw new IncorrectSyntaxExpression("Expression is invalid at " + charPositionInLine + " position,\n" +
                    msg);
        }
    }
}
