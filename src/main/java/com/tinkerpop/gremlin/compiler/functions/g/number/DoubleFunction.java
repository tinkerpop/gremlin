package com.tinkerpop.gremlin.compiler.functions.g.number;

import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.functions.AbstractFunction;
import com.tinkerpop.gremlin.compiler.operations.Operation;

import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class DoubleFunction extends AbstractFunction<Double> {

    private static final String FUNCTION_NAME = "double";

    public Atom<Double> compute(final List<Operation> parameters) throws RuntimeException {
        if (parameters.size() == 1) {
            final Object object = parameters.get(0).compute().getValue();
            return new Atom<Double>(Double.valueOf(object.toString()));
        } else {
            throw new RuntimeException(this.createUnsupportedArgumentMessage());
        }
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }
}