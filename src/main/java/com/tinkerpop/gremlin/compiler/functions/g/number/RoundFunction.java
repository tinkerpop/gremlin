package com.tinkerpop.gremlin.compiler.functions.g.number;

import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.functions.AbstractFunction;
import com.tinkerpop.gremlin.compiler.operations.Operation;

import java.util.List;
import java.util.Random;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class RoundFunction extends AbstractFunction<Double> {

    public static final String FUNCTION_NAME = "round";

    public Atom<Double> compute(final List<Operation> parameters) throws RuntimeException {

        if (parameters.size() == 1) {
            return new Atom<Double>(new Double(Math.round((Double) parameters.get(0).compute().getValue())));
        } else {
            throw new RuntimeException(this.createUnsupportedArgumentMessage());
        }
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }
}