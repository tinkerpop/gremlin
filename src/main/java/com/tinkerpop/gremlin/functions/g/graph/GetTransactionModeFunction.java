package com.tinkerpop.gremlin.functions.g.graph;

import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.TransactionalGraph;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.types.Atom;
import com.tinkerpop.gremlin.functions.AbstractFunction;
import com.tinkerpop.gremlin.functions.FunctionHelper;

import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class GetTransactionModeFunction extends AbstractFunction<String> {

    private final String FUNCTION_NAME = "get-tx-mode";

    public Atom<String> compute(final List<Operation> arguments, final GremlinScriptContext context) throws RuntimeException {

        final Graph graph = FunctionHelper.getGraph(arguments, 0, context);
        if (graph instanceof TransactionalGraph) {
            return new Atom<String>(((TransactionalGraph) graph).getTransactionMode().toString().toLowerCase());
        } else {
            throw new RuntimeException("Graph does not support transactions");
        }
    }

    public String getFunctionName() {
        return this.FUNCTION_NAME;
    }
}