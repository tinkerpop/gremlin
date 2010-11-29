package com.tinkerpop.gremlin.functions.g.bool;

import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.types.Atom;
import com.tinkerpop.gremlin.functions.AbstractFunction;

import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class BooleanFunction extends AbstractFunction<Boolean> {

    private static final String FUNCTION_NAME = "boolean";

    public Atom<Boolean> compute(final List<Operation> arguments, final GremlinScriptContext context) throws RuntimeException {
        if (arguments.size() == 1) {
            Object object = arguments.get(0).compute().getValue();
            if (object instanceof Number) {
                if (((Number) object).doubleValue() > 0)
                    return new Atom<Boolean>(true);
                else
                    return new Atom<Boolean>(false);
            } else
                return new Atom<Boolean>(Boolean.parseBoolean(object.toString()));
        } else {
            throw new RuntimeException(this.createUnsupportedArgumentMessage("One boolean interpretable argument required"));
        }
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }
}