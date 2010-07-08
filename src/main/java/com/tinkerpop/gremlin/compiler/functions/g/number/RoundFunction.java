package com.tinkerpop.gremlin.compiler.functions.g.number;

import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.functions.AbstractFunction;
import com.tinkerpop.gremlin.compiler.operations.Operation;

import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class RoundFunction extends AbstractFunction<Long> {

    public static final String FUNCTION_NAME = "round";

    public Atom<Long> compute(final List<Operation> parameters) throws RuntimeException {

        if (parameters.size() == 1) {
            return new Atom<Long>(Math.round(((Number) parameters.get(0).compute().getValue()).doubleValue()));
        } else {
            throw new RuntimeException(this.createUnsupportedArgumentMessage());
        }
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }
}