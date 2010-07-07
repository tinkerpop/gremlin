package com.tinkerpop.gremlin.compiler.functions.g.util;

import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.functions.AbstractFunction;
import com.tinkerpop.gremlin.compiler.operations.Operation;

import java.util.List;
import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class TypeFunction extends AbstractFunction<String> {

    private static final String FUNCTION_NAME = "type";
    private static final String ITERABLE = "iterable";
    private static final String MAP = "map";

    public Atom<String> compute(final List<Operation> parameters) throws RuntimeException {

        if (parameters.size() == 1) {
            Object object = parameters.get(0).compute().getValue();
            if (object instanceof Iterable)
                return new Atom<String>(ITERABLE);
            else if (object instanceof Map)
                return new Atom<String>(MAP);
            else
                return new Atom<String>(object.getClass().getSimpleName().toLowerCase());
        } else
            throw new RuntimeException(this.createUnsupportedArgumentMessage());
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }


}