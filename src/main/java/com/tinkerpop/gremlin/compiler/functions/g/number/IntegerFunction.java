package com.tinkerpop.gremlin.compiler.functions.g.number;

import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.functions.AbstractFunction;
import com.tinkerpop.gremlin.compiler.operations.Operation;

import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class IntegerFunction extends AbstractFunction<Integer> {

    private static final String FUNCTION_NAME = "integer";

    public Atom<Integer> compute(final List<Operation> parameters) throws RuntimeException {
        if (parameters.size() == 1) {
            Object object = parameters.get(0).compute().getValue();
            Double temp = Double.valueOf(object.toString());
            return new Atom<Integer>(temp.intValue());
        } else {
            throw new RuntimeException(this.createUnsupportedArgumentMessage());
        }
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }
}