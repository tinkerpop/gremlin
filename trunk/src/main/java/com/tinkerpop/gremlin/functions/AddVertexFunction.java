package com.tinkerpop.gremlin.functions;

import com.tinkerpop.gremlin.FunctionHelper;
import com.tinkerpop.gremlin.GremlinFunctions;
import com.tinkerpop.gremlin.model.Graph;
import com.tinkerpop.gremlin.model.Vertex;
import com.tinkerpop.gremlin.statements.EvaluationException;
import org.apache.commons.jxpath.ExpressionContext;
import org.apache.commons.jxpath.Function;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class AddVertexFunction implements Function {

    public static final String FUNCTION_NAME = "add-v";

    public Vertex invoke(ExpressionContext context, Object[] parameters) {

        if (parameters != null) {
            Object[] objects = FunctionHelper.nodeSetConversion(parameters);
            if (objects[0] instanceof Graph) {
                if (objects.length == 1) {
                    return ((Graph) objects[0]).addVertex(null);
                } else if (objects.length == 2) {
                    return ((Graph) objects[0]).addVertex(objects[1]);
                }
            }
        }
        throw EvaluationException.createException(FunctionHelper.makeFunctionName(GremlinFunctions.NAMESPACE_PREFIX, FUNCTION_NAME), EvaluationException.EvaluationErrorType.UNSUPPORTED_PARAMETERS);

    }
}
