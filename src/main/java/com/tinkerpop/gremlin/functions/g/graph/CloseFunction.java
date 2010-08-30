package com.tinkerpop.gremlin.functions.g.graph;

import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.functions.AbstractFunction;
import com.tinkerpop.gremlin.functions.FunctionHelper;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.types.Atom;

import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class CloseFunction extends AbstractFunction<Boolean> {

    private final static String FUNCTION_NAME = "close";

    public Atom<Boolean> compute(final List<Operation> arguments, final GremlinScriptContext context) throws RuntimeException {
        if (arguments.size() > 1)
            throw new RuntimeException(this.createUnsupportedArgumentMessage());

        FunctionHelper.getGraph(arguments, 0, context).shutdown();
        return new Atom<Boolean>(true);
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }
}
