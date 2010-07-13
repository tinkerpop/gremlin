package com.tinkerpop.gremlin.compiler.functions.neo4j;

import com.tinkerpop.blueprints.pgm.impls.neo4j.Neo4jGraph;
import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.functions.AbstractFunction;
import com.tinkerpop.gremlin.compiler.functions.FunctionHelper;
import com.tinkerpop.gremlin.compiler.operations.Operation;

import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class StopTransactionFunction extends AbstractFunction<Boolean> {

    private final String FUNCTION_NAME = "stop-tx";

    public Atom<Boolean> compute(final List<Operation> parameters) throws RuntimeException {

        final Neo4jGraph graph = (Neo4jGraph) FunctionHelper.getGraph(parameters, 0);
        if (parameters.size() == 1) {
            graph.stopTransaction((Boolean) parameters.get(0).compute().getValue());
        } else if (parameters.size() == 2) {
            graph.stopTransaction((Boolean) parameters.get(1).compute().getValue());
        } else {
            throw new RuntimeException(createUnsupportedArgumentMessage());
        }
        return new Atom<Boolean>(true);
    }

    public String getFunctionName() {
        return this.FUNCTION_NAME;
    }

}