package org.jetbrains.calculator.nashorn;

import org.jetbrains.calculator.AbstractCalc;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class NashornCalcImpl extends AbstractCalc {

    public NashornCalcImpl(String expression) {
        super(expression);
    }

    @Override
    public Double evaluate() {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        try {
            Object result = engine.eval(expression);
            if(result instanceof Integer) return Double.valueOf((Integer)result);
            if(result instanceof Double) return (Double) result;
            throw new RuntimeException("Unknown type " + result.getClass().getName());
        } catch (ScriptException e) {
            e.printStackTrace();
        }
       return null;
    }
}