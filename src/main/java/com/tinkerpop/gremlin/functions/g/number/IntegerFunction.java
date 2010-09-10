package com.tinkerpop.gremlin.functions.g.number;

import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.types.Atom;
import com.tinkerpop.gremlin.functions.AbstractFunction;

import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class IntegerFunction extends AbstractFunction<Integer> {

    private static final String FUNCTION_NAME = "integer";

    public Atom<Integer> compute(final List<Operation> arguments, final GremlinScriptContext context) throws RuntimeException {
        if (arguments.size() == 1) {
            final Object object = arguments.get(0).compute().getValue();
            final Double temp = Double.valueOf(object.toString());
            return new Atom<Integer>(temp.intValue());
        } else {
            throw new RuntimeException(this.createUnsupportedArgumentMessage("One integer convertible object required"));
        }
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }
}