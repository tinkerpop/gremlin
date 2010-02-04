package com.tinkerpop.gremlin.models.ggm.impls.neo4j.functions;

import com.tinkerpop.gremlin.functions.FunctionHelper;
import com.tinkerpop.gremlin.models.ggm.impls.neo4j.Neo4jFunctions;
import com.tinkerpop.gremlin.models.ggm.impls.neo4j.Neo4jGraph;
import com.tinkerpop.gremlin.models.ggm.Graph;
import com.tinkerpop.gremlin.statements.EvaluationException;
import org.apache.commons.jxpath.ExpressionContext;
import org.apache.commons.jxpath.Function;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class OpenFunction implements Function {

    public static final String FUNCTION_NAME = "open";

    public Graph invoke(final ExpressionContext context, final Object[] parameters) {

        if (null != parameters && parameters.length == 1) {
            Object object = FunctionHelper.nodeSetConversion(parameters[0]);
            if (object instanceof String) {
                return new Neo4jGraph((String) object);
            }
        }
        throw EvaluationException.createException(FunctionHelper.makeFunctionName(Neo4jFunctions.NAMESPACE_PREFIX, FUNCTION_NAME), EvaluationException.EvaluationErrorType.UNSUPPORTED_PARAMETERS);

    }
}
