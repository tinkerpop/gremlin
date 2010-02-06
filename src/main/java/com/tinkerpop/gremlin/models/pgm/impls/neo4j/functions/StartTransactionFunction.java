package com.tinkerpop.gremlin.models.pgm.impls.neo4j.functions;

import com.tinkerpop.gremlin.functions.FunctionHelper;
import com.tinkerpop.gremlin.functions.graph.GraphFunctionHelper;
import com.tinkerpop.gremlin.models.pgm.Graph;
import com.tinkerpop.gremlin.models.pgm.impls.neo4j.Neo4jFunctions;
import com.tinkerpop.gremlin.models.pgm.impls.neo4j.Neo4jGraph;
import com.tinkerpop.gremlin.statements.EvaluationException;
import org.apache.commons.jxpath.ExpressionContext;
import org.apache.commons.jxpath.Function;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class StartTransactionFunction implements Function {

    public static final String FUNCTION_NAME = "start-tx";

    public Boolean invoke(final ExpressionContext context, final Object[] parameters) {

        Graph graph = GraphFunctionHelper.getGraph(context, parameters);
        if (graph instanceof Neo4jGraph) {
            ((Neo4jGraph) graph).startTransaction();
            return Boolean.TRUE;
        }

        throw EvaluationException.createException(FunctionHelper.makeFunctionName(Neo4jFunctions.NAMESPACE_PREFIX, FUNCTION_NAME), EvaluationException.EvaluationErrorType.UNSUPPORTED_PARAMETERS);

    }
}
