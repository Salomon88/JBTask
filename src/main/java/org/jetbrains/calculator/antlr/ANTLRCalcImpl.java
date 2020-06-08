package org.jetbrains.calculator.antlr;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.tree.ParseTree;
import org.jetbrains.calculator.AbstractCalc;
import org.jetbrains.calculator.antlr.gen.*;

public class ANTLRCalcImpl extends AbstractCalc {

    public ANTLRCalcImpl(String expression) {
        super(expression);
    }

    @Override
    public Double evaluate() {
        CalcLexer lexer = new CalcLexer(CharStreams.fromString(expression));
        CommonTokenStream tokenStream=new CommonTokenStream(lexer);
        CalcParser parser = new CalcParser(tokenStream);
        //parser.addErrorListener(new WasperErrorListener());
        CalcParser.StmtContext stmt = parser.stmt();
        return new EvaluateVisitor().visit(stmt.expr());
    }
}
