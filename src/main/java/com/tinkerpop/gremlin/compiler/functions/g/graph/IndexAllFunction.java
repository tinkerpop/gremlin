package com.tinkerpop.gremlin.compiler.functions.g.graph;

import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.functions.AbstractFunction;
import com.tinkerpop.gremlin.compiler.functions.FunctionHelper;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.types.Atom;

import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class IndexAllFunction extends AbstractFunction<Boolean> {

    private final static String FUNCTION_NAME = "idx-all";

    public Atom<Boolean> compute(final List<Operation> parameters, final GremlinScriptContext context) throws RuntimeException {
        final int size = parameters.size();
        if (size == 0 || size > 2)
            throw new RuntimeException(this.createUnsupportedArgumentMessage());

        final Graph graph = FunctionHelper.getGraph(parameters, 0, context);
        final Boolean indexAll;

        if (size == 2) {
            indexAll = (Boolean) parameters.get(1).compute().getValue();
        } else {
            indexAll = (Boolean) parameters.get(0).compute().getValue();
        }

        graph.getIndex().indexAll(indexAll);
        return new Atom<Boolean>(true);
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }
}
