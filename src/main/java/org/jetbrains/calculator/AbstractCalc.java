package org.jetbrains.calculator;

import org.jetbrains.calculator.utils.SyntaxValidator;

public abstract class AbstractCalc implements ICalculator {

  protected void validateSyntax(String expression) {
      SyntaxValidator.isSyntaxValid(expression);
  }
}
