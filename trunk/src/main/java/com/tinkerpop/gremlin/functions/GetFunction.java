package com.tinkerpop.gremlin.functions;

import com.tinkerpop.gremlin.FunctionHelper;
import com.tinkerpop.gremlin.GremlinFunctions;
import com.tinkerpop.gremlin.statements.EvaluationErrorException;
import org.apache.commons.jxpath.ExpressionContext;
import org.apache.commons.jxpath.Function;

import java.util.List;
import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class GetFunction implements Function {

    public static final String FUNCTION_NAME = "get";

    public Object invoke(ExpressionContext context, Object[] parameters) {

        if (null != parameters && parameters.length == 2) {
            Object[] objects = FunctionHelper.nodeSetConversion(parameters);
            if (objects[0] instanceof Map) {
                return ((Map) objects[0]).get(objects[1]);
            } else if (objects[0] instanceof List && objects[1] instanceof Number) {
                return ((List) objects[0]).get(((Number) objects[1]).intValue()-1);
            }
        }

        throw new EvaluationErrorException(GremlinFunctions.NAMESPACE_PREFIX + ":" + FUNCTION_NAME + " does not support provided parameters.");
    }


}
