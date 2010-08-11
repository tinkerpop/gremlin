package com.tinkerpop.gremlin.compiler.functions.g.number;

import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.functions.AbstractFunction;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.types.Atom;

import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class FloatFunction extends AbstractFunction<Float> {

    private static final String FUNCTION_NAME = "float";

    public Atom<Float> compute(final List<Operation> arguments, final GremlinScriptContext context) throws RuntimeException {
        if (arguments.size() == 1) {
            final Object object = arguments.get(0).compute().getValue();
            return new Atom<Float>(Float.valueOf(object.toString()));
        } else {
            throw new RuntimeException(this.createUnsupportedArgumentMessage("One float convertible object required"));
        }
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }
}