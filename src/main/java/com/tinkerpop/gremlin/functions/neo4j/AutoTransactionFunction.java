package com.tinkerpop.gremlin.functions.neo4j;

import com.tinkerpop.blueprints.pgm.impls.neo4j.Neo4jGraph;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.types.Atom;
import com.tinkerpop.gremlin.functions.AbstractFunction;
import com.tinkerpop.gremlin.functions.FunctionHelper;

import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class AutoTransactionFunction extends AbstractFunction<Object> {

    private final String FUNCTION_NAME = "auto-tx";

    public Atom<Object> compute(final List<Operation> arguments, final GremlinScriptContext context) throws RuntimeException {

        final Neo4jGraph graph = (Neo4jGraph) FunctionHelper.getGraph(arguments, 0, context);
        if (arguments.size() == 1) {
            graph.setAutoTransactions((Boolean) arguments.get(0).compute().getValue());
        } else if (arguments.size() == 2) {
            graph.setAutoTransactions((Boolean) arguments.get(1).compute().getValue());
        } else {
            throw new RuntimeException(createUnsupportedArgumentMessage());
        }
        return new Atom<Object>(null);
    }

    public String getFunctionName() {
        return this.FUNCTION_NAME;
    }

}
