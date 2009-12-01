package com.tinkerpop.gremlin.functions;

import com.tinkerpop.gremlin.FunctionHelper;
import com.tinkerpop.gremlin.GremlinFunctions;
import com.tinkerpop.gremlin.model.Graph;
import com.tinkerpop.gremlin.statements.EvaluationErrorException;
import org.apache.commons.jxpath.ExpressionContext;
import org.apache.commons.jxpath.Function;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class IdFunction implements Function {

    public static final String FUNCTION_NAME = "id";

    public Object invoke(ExpressionContext context, Object[] parameters) {

        Object[] objects = FunctionHelper.nodeSetConversion(parameters);
        if (null != objects && objects.length == 2) {
            if (objects[0] instanceof Graph) {
                return ((Graph) objects[0]).getVertex(objects[1]);
            }
        }

        throw new EvaluationErrorException(GremlinFunctions.NAMESPACE_PREFIX + ":" + FUNCTION_NAME + " does not support provided parameters.");
    }
}
