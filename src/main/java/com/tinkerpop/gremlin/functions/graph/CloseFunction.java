package com.tinkerpop.gremlin.functions.graph;

import com.tinkerpop.gremlin.functions.FunctionHelper;
import com.tinkerpop.gremlin.functions.GremlinFunctions;
import com.tinkerpop.gremlin.models.pgm.Graph;
import com.tinkerpop.gremlin.statements.EvaluationException;
import org.apache.commons.jxpath.ExpressionContext;
import org.apache.commons.jxpath.Function;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class CloseFunction implements Function {

    public static final String FUNCTION_NAME = "close";

    public Boolean invoke(final ExpressionContext context, final Object[] parameters) {

        Graph graph = GraphFunctionHelper.getGraph(context, parameters);
        Object[] objects = FunctionHelper.nodeSetConversion(parameters);
        if (null == objects || (objects.length == 1 && objects[0] instanceof Graph)) {
            graph.shutdown();
            return Boolean.TRUE;
        }

        throw EvaluationException.createException(FunctionHelper.makeFunctionName(GremlinFunctions.NAMESPACE_PREFIX, FUNCTION_NAME), EvaluationException.EvaluationErrorType.UNSUPPORTED_PARAMETERS);

    }
}