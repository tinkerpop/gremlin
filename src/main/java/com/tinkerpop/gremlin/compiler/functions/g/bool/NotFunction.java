package com.tinkerpop.gremlin.compiler.functions.g.bool;

import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.functions.AbstractFunction;
import com.tinkerpop.gremlin.compiler.operations.Operation;

import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class NotFunction extends AbstractFunction<Boolean> {

    private static final String FUNCTION_NAME = "not";


    public Atom<Boolean> compute(final List<Operation> parameters) throws RuntimeException {
        if (parameters.size() == 1) {
            final Boolean bool = (Boolean) parameters.get(0).compute().getValue();
            return new Atom<Boolean>(!bool);
        } else {
            throw new RuntimeException(this.createUnsupportedArgumentMessage());
        }
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }
}
