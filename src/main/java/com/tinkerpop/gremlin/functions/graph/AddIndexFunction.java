package com.tinkerpop.gremlin.functions.graph;

import com.tinkerpop.gremlin.FunctionHelper;
import com.tinkerpop.gremlin.GremlinFunctions;
import com.tinkerpop.gremlin.model.Graph;
import com.tinkerpop.gremlin.model.Index;
import com.tinkerpop.gremlin.statements.EvaluationException;
import org.apache.commons.jxpath.ExpressionContext;
import org.apache.commons.jxpath.Function;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class AddIndexFunction implements Function {

    public static final String FUNCTION_NAME = "add-idx";

    public Boolean invoke(final ExpressionContext context, final Object[] parameters) {

        if (parameters != null) {
            Graph graph = GraphFunctionHelper.getGraph(context, parameters);
            Index index = graph.getIndex();
            Object[] objects = FunctionHelper.nodeSetConversion(parameters);
            if (objects.length == 2 && FunctionHelper.assertTypes(objects, new Class[]{Graph.class, String.class})) {
                index.addIndexKey((String) objects[1]);
                return Boolean.TRUE;
            } else if (objects.length == 1 && objects[0] instanceof String) {
                index.addIndexKey((String) objects[0]);
                return Boolean.TRUE;
            }
        }
        throw EvaluationException.createException(FunctionHelper.makeFunctionName(GremlinFunctions.NAMESPACE_PREFIX, FUNCTION_NAME), EvaluationException.EvaluationErrorType.UNSUPPORTED_PARAMETERS);

    }
}
