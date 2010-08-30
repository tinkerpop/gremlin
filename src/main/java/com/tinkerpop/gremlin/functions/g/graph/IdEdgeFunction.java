package com.tinkerpop.gremlin.functions.g.graph;

import com.tinkerpop.blueprints.pgm.Edge;
import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.functions.AbstractFunction;
import com.tinkerpop.gremlin.functions.FunctionHelper;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.types.Atom;

import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class IdEdgeFunction extends AbstractFunction<Edge> {

    private final static String FUNCTION_NAME = "id-e";

    public Atom<Edge> compute(final List<Operation> arguments, final GremlinScriptContext context) throws RuntimeException {
        final int size = arguments.size();
        if (size == 0 || size > 2)
            throw new RuntimeException(this.createUnsupportedArgumentMessage());

        final Graph graph = FunctionHelper.getGraph(arguments, 0, context);
        final Object identifer;

        if (size == 2) {
            identifer = arguments.get(1).compute().getValue();
        } else {
            identifer = arguments.get(0).compute().getValue();
        }

        return new Atom<Edge>(graph.getEdge(identifer));
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }
}
