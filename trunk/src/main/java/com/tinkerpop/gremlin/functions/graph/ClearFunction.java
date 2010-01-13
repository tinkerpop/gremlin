package com.tinkerpop.gremlin.functions.graph;

import com.tinkerpop.gremlin.FunctionHelper;
import com.tinkerpop.gremlin.GremlinFunctions;
import com.tinkerpop.gremlin.model.Graph;
import com.tinkerpop.gremlin.statements.EvaluationException;
import org.apache.commons.jxpath.ExpressionContext;
import org.apache.commons.jxpath.Function;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
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
}
