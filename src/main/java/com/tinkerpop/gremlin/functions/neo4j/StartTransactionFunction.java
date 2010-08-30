package com.tinkerpop.gremlin.functions.neo4j;

import com.tinkerpop.blueprints.pgm.impls.neo4j.Neo4jGraph;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.functions.AbstractFunction;
import com.tinkerpop.gremlin.functions.FunctionHelper;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.types.Atom;

import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class StartTransactionFunction extends AbstractFunction<Boolean> {

    private final String FUNCTION_NAME = "start-tx";

    public Atom<Boolean> compute(final List<Operation> arguments, final GremlinScriptContext context) throws RuntimeException {

        if (arguments.size() > 1) {
            Neo4jGraph graph = (Neo4jGraph) FunctionHelper.getGraph(arguments, 0, context);
            graph.startTransaction();
            return new Atom<Boolean>(true);
        } else {
            throw new RuntimeException(createUnsupportedArgumentMessage());
        }
    }

    public String getFunctionName() {
        return this.FUNCTION_NAME;
    }

}