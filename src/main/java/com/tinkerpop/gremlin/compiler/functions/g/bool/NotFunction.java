package com.tinkerpop.gremlin.compiler.functions.g.bool;

import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.functions.AbstractFunction;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.types.Atom;

import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class NotFunction extends AbstractFunction<Boolean> {

    private static final String FUNCTION_NAME = "not";


    public Atom<Boolean> compute(final List<Operation> arguments, final GremlinScriptContext context) throws RuntimeException {
        if (arguments.size() == 1) {
            return new Atom<Boolean>(!((Boolean) arguments.get(0).compute().getValue()));
        } else {
            throw new RuntimeException(this.createUnsupportedArgumentMessage("One boolean argument required"));
        }
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }
}
