package org.jetbrains.calculator.antlr;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class EvaluateVisitor extends org.jetbrains.calculator.antlr.CalcBaseVisitor<Double> {

    @Override
    public Double visitNumber(org.jetbrains.calculator.antlr.CalcParser.NumberContext ctx) {
        return Double.valueOf(ctx.getText());
    }

    @Override
    public Double visitMulDiv(org.jetbrains.calculator.antlr.CalcParser.MulDivContext ctx) {
        double left = visit(ctx.expr(0));
        double right = visit(ctx.expr(1));
        if (nonNull(ctx.MULT())) return left * right;
        return left / right;
    }

    @Override
    public Double visitPlusMinus(org.jetbrains.calculator.antlr.CalcParser.PlusMinusContext ctx) {
        double left = visit(ctx.expr(0));
        double right = visit(ctx.expr(1));
        if (nonNull(ctx.PLUS())) return left + right;
        return left - right;
    }

    @Override
    public Double visitParen(org.jetbrains.calculator.antlr.CalcParser.ParenContext ctx) {
        Double result = visit(ctx.expr());
        return isNull(ctx.MINUS()) ? result : result * -1d;
    }

}
