package com.tinkerpop.gremlin.functions;

import org.apache.commons.jxpath.Function;
import org.apache.commons.jxpath.ExpressionContext;
import com.tinkerpop.gremlin.FunctionHelper;
import com.tinkerpop.gremlin.GremlinFunctions;
import com.tinkerpop.gremlin.statements.EvaluationException;
import com.tinkerpop.gremlin.model.Graph;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class KeyFunction implements Function {

    public static final String FUNCTION_NAME = "key";

    public Object invoke(ExpressionContext context, Object[] parameters) {

        Object[] objects = FunctionHelper.nodeSetConversion(parameters);
        if (null != objects && objects.length == 3) {
            if (objects[0] instanceof Graph && objects[1] instanceof String) {
                return ((Graph) objects[0]).getIndex().get((String)objects[1], objects[2]);
            }
        }

        throw EvaluationException.createException(FunctionHelper.makeFunctionName(GremlinFunctions.NAMESPACE_PREFIX,FUNCTION_NAME), EvaluationException.EvaluationErrorType.UNSUPPORTED_PARAMETERS);

    }
}
