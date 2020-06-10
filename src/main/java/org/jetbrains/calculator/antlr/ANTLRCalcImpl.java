package org.jetbrains.calculator.antlr;

import org.antlr.v4.runtime.*;
import org.jetbrains.calculator.AbstractCalc;
import org.jetbrains.exceptions.IncorrectSyntaxExpression;

public class ANTLRCalcImpl extends AbstractCalc {

    @Override
    public Double evaluate(String expression) {
        org.jetbrains.calculator.antlr.CalcLexer lexer = new org.jetbrains.calculator.antlr.CalcLexer(CharStreams.fromString(expression));
        lexer.addErrorListener(new BaseErrorListener() {
            @Override
            public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
                throw new IncorrectSyntaxExpression("Expression is invalid at " + charPositionInLine + " position,\n" +
                        msg);
            }
        });
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        org.jetbrains.calculator.antlr.CalcParser parser = new org.jetbrains.calculator.antlr.CalcParser(tokenStream);
        org.jetbrains.calculator.antlr.CalcParser.StmtContext stmt = parser.stmt();
        return new EvaluateVisitor().visit(stmt.expr());
    }
}
