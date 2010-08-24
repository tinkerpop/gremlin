package com.tinkerpop.gremlin.compiler.functions;

import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.types.Atom;

import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class PlayNumberFunction extends AbstractFunction<Integer> {

    public Atom<Integer> compute(final List<Operation> arguments, final GremlinScriptContext context) throws RuntimeException {
        return new Atom<Integer>(((Number) arguments.get(0).compute().getValue()).intValue());
    }

    public String getFunctionName() {
        return "play-number";
    }
}