package org.jetbrains.calculator.antlr;

import static java.util.Objects.nonNull;

public class EvaluateVisitor extends CalcBaseVisitor<Double> {

    @Override
    public Double visitNumber(CalcParser.NumberContext ctx) {
        return Double.valueOf(ctx.getText());
    }

    @Override
    public Double visitMulDiv(CalcParser.MulDivContext ctx) {
        double left = visit(ctx.expr(0));
        double right = visit(ctx.expr(1));
        if(nonNull(ctx.MULT())) return left*right;
        return left/right;
    }

    @Override
    public Double visitPlusMinus(CalcParser.PlusMinusContext ctx) {
        double left = visit(ctx.expr(0));
        double right = visit(ctx.expr(1));
        if(nonNull(ctx.PLUS())) return left+right;
        return left-right;
    }

    @Override
    public Double visitParen(CalcParser.ParenContext ctx) {
        return visit(ctx.expr());
    }
}
