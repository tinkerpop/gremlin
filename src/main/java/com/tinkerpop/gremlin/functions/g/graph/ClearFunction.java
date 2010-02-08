package com.tinkerpop.gremlin.functions.g.graph;

import com.tinkerpop.gremlin.functions.Function;
import com.tinkerpop.gremlin.functions.FunctionHelper;
import com.tinkerpop.gremlin.functions.g.GremlinFunctions;
import com.tinkerpop.gremlin.models.pgm.Graph;
import com.tinkerpop.gremlin.statements.EvaluationException;
import org.apache.commons.jxpath.ExpressionContext;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class ClearFunction implements Function {

    public static final String FUNCTION_NAME = "clear";

    public Boolean invoke(final ExpressionContext context, final Object[] parameters) {
        Graph graph = GraphFunctionHelper.getGraph(context, parameters);
        Object[] objects = FunctionHelper.nodeSetConversion(parameters);
        if (null == objects || (objects.length == 1 && objects[0] instanceof Graph)) {
            graph.clear();
            return Boolean.TRUE;
        }
        throw EvaluationException.createException(FunctionHelper.makeFunctionName(GremlinFunctions.NAMESPACE_PREFIX, FUNCTION_NAME), EvaluationException.EvaluationErrorType.UNSUPPORTED_PARAMETERS);

    }

    public String getName() {
        return FUNCTION_NAME;
    }
}
