package org.jetbrains.calculator.nashorn;

import org.jetbrains.calculator.AbstractCalc;
import org.jetbrains.exceptions.NashornEvalException;
import org.jetbrains.exceptions.UnknownReturnTypeException;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NashornCalcImpl extends AbstractCalc {

    public NashornCalcImpl(String expression) {
        super(expression);
    }

    @Override
    public Double evaluate() {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        try {
            Object result = engine.eval(expression);
            if (result instanceof Integer) return Double.valueOf((Integer) result);
            if (result instanceof Double) return (Double) result;
            throw new UnknownReturnTypeException(result.getClass());
        } catch (ScriptException e) {
        throw new NashornEvalException(e);
        }
    }
}
