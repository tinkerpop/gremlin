package com.tinkerpop.gremlin.functions.g.number;

import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.types.Atom;
import com.tinkerpop.gremlin.functions.AbstractFunction;

import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class DoubleFunction extends AbstractFunction<Double> {

    private static final String FUNCTION_NAME = "double";

    public Atom<Double> compute(final List<Operation> arguments, final GremlinScriptContext context) throws RuntimeException {
        if (arguments.size() == 1) {
            final Object object = arguments.get(0).compute().getValue();
            return new Atom<Double>(Double.valueOf(object.toString()));
        } else {
            throw new RuntimeException(this.createUnsupportedArgumentMessage("One double convertible object required"));
        }
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }
}