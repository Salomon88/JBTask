package org.jetbrains.calculator.antlr;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.CharStreams;
import org.jetbrains.calculator.AbstractCalc;

public class ANTLRCalcImpl extends AbstractCalc {

    public ANTLRCalcImpl(String expression) {
        super(expression);
    }

    @Override
    public Double evaluate() {
        org.jetbrains.calculator.antlr.CalcLexer lexer = new org.jetbrains.calculator.antlr.CalcLexer(CharStreams.fromString(expression));
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        org.jetbrains.calculator.antlr.CalcParser parser = new org.jetbrains.calculator.antlr.CalcParser(tokenStream);
        //parser.addErrorListener(new WasperErrorListener());
        org.jetbrains.calculator.antlr.CalcParser.StmtContext stmt = parser.stmt();
        return new EvaluateVisitor().visit(stmt.expr());
    }
}
