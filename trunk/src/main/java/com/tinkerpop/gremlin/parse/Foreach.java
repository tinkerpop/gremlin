package com.tinkerpop.gremlin.parse;

import com.tinkerpop.gremlin.Evaluator;

import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class Foreach {

    protected String variable;
    protected GPath forSet;
    protected GPath loopBody;
    protected Evaluator evaluator;

    public Foreach(String variable, GPath forSet, GPath loopBody, Evaluator evaluator) {
        this.variable = variable;
        this.forSet = forSet;
        this.loopBody = loopBody;
        this.evaluator = evaluator;
    }

    public void evaluate() {
        List set = evaluator.evaluate(forSet.toString());
        for(Object item : set) {
            evaluator.setVariable(variable, item);
            evaluator.evaluate(loopBody.toString());
        }
    }

}
