package com.tinkerpop.gremlin.compiler.functions.neo4j;

import com.tinkerpop.blueprints.pgm.impls.neo4j.Neo4jGraph;
import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.functions.AbstractFunction;
import com.tinkerpop.gremlin.compiler.functions.GraphFunctionHelper;
import com.tinkerpop.gremlin.compiler.operations.Operation;

import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class StartTransactionFunction extends AbstractFunction<Boolean> {

    private final String FUNCTION_NAME = "start-tx";

    public Atom<Boolean> compute(List<Operation> parameters) throws RuntimeException {

        if (parameters.size() > 1) {
            Neo4jGraph graph = (Neo4jGraph) GraphFunctionHelper.getGraph(parameters, 0);
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