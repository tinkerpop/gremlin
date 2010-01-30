package com.tinkerpop.gremlin.db.neo4j.functions;

import org.apache.commons.jxpath.Function;
import org.apache.commons.jxpath.ExpressionContext;
import com.tinkerpop.gremlin.model.Graph;
import com.tinkerpop.gremlin.FunctionHelper;
import com.tinkerpop.gremlin.functions.graph.GraphFunctionHelper;
import com.tinkerpop.gremlin.statements.EvaluationException;
import com.tinkerpop.gremlin.db.neo4j.Neo4jGraph;
import com.tinkerpop.gremlin.db.neo4j.Neo4jFunctions;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class StartTransactionFunction implements Function {

    public static final String FUNCTION_NAME = "start-tx";

    public Boolean invoke(final ExpressionContext context, final Object[] parameters) {

        Graph graph  = GraphFunctionHelper.getGraph(context, parameters);
        if(graph instanceof Neo4jGraph) {
            ((Neo4jGraph)graph).startTransaction();
            return Boolean.TRUE;
        }

        throw EvaluationException.createException(FunctionHelper.makeFunctionName(Neo4jFunctions.NAMESPACE_PREFIX, FUNCTION_NAME), EvaluationException.EvaluationErrorType.UNSUPPORTED_PARAMETERS);

    }
}
