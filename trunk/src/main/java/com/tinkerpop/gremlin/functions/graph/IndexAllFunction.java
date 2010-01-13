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
public class IndexAllFunction implements Function {

    public static final String FUNCTION_NAME = "idx-all";

    public Boolean invoke(final ExpressionContext context, final Object[] parameters) {

        if (parameters != null) {
            Graph graph = GraphFunctionHelper.getGraph(context, parameters);
            Object[] objects = FunctionHelper.nodeSetConversion(parameters);
            if (objects.length == 1 && objects[0] instanceof Boolean) {
                graph.getIndex().indexAll((Boolean) objects[0]);
                return Boolean.TRUE;
            } else if (objects.length == 2 && FunctionHelper.assertTypes(objects, new Class[]{Graph.class, Boolean.class})) {
                graph.getIndex().indexAll((Boolean) objects[1]);
                return Boolean.TRUE;
            }

        }
        throw EvaluationException.createException(FunctionHelper.makeFunctionName(GremlinFunctions.NAMESPACE_PREFIX, FUNCTION_NAME), EvaluationException.EvaluationErrorType.UNSUPPORTED_PARAMETERS);
    }
}
