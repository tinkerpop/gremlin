package com.tinkerpop.gremlin.functions.neo4j;

import com.tinkerpop.gremlin.functions.FunctionHelper;
import com.tinkerpop.gremlin.functions.Function;
import com.tinkerpop.gremlin.functions.g.graph.GraphFunctionHelper;
import com.tinkerpop.gremlin.models.pgm.Graph;
import com.tinkerpop.gremlin.models.pgm.impls.neo4j.Neo4jGraph;
import com.tinkerpop.gremlin.statements.EvaluationException;
import org.apache.commons.jxpath.ExpressionContext;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class AutomaticTransactionsFunction implements Function {

    public static final String FUNCTION_NAME = "auto-tx";

    public Boolean invoke(final ExpressionContext context, final Object[] parameters) {

        Graph graph = GraphFunctionHelper.getGraph(context, parameters);
        if (parameters != null && graph instanceof Neo4jGraph) {
            Object[] objects = FunctionHelper.nodeSetConversion(parameters);
            if (objects.length == 1 && objects[0] instanceof Boolean) {
                ((Neo4jGraph) graph).setAutoTransactions((Boolean) objects[0]);
                return Boolean.TRUE;
            } else if (objects.length == 2 && objects[0] instanceof Graph && objects[1] instanceof Boolean) {
                ((Neo4jGraph) graph).setAutoTransactions((Boolean) objects[1]);
                return Boolean.TRUE;
            }
        }

        throw EvaluationException.createException(FunctionHelper.makeFunctionName(Neo4jFunctions.NAMESPACE_PREFIX, FUNCTION_NAME), EvaluationException.EvaluationErrorType.UNSUPPORTED_PARAMETERS);

    }

        public String getName() {
        return FUNCTION_NAME;
    }
}