package com.tinkerpop.gremlin.compiler.functions.g.util;

import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.functions.AbstractFunction;
import com.tinkerpop.gremlin.compiler.operations.Operation;

import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class TypeFunction extends AbstractFunction<String> {

    private static final String FUNCTION_NAME = "type";

    public Atom<String> compute(final List<Operation> parameters) throws RuntimeException {

        //todo do instanceof map, list, etc.
        if (parameters.size() == 1) {
            return new Atom<String>(parameters.get(0).compute().getValue().getClass().getSimpleName().toLowerCase());
        } else
            throw new RuntimeException(this.createUnsupportedArgumentMessage());
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }


}