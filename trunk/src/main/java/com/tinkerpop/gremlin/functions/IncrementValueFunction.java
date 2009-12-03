package com.tinkerpop.gremlin.functions;

import com.tinkerpop.gremlin.FunctionHelper;
import com.tinkerpop.gremlin.GremlinFunctions;
import com.tinkerpop.gremlin.statements.EvaluationException;
import org.apache.commons.jxpath.ExpressionContext;
import org.apache.commons.jxpath.Function;

import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class IncrementValueFunction implements Function {

    public static final String FUNCTION_NAME = "incr-value";

    public Boolean invoke(ExpressionContext context, Object[] parameters) {
        Object[] objects = FunctionHelper.nodeSetConversion(parameters);
        if (null != objects && objects.length == 2 && objects[0] instanceof Map && objects[1] instanceof Number) {
            System.out.println(context.getContextNodePointer().getValue());
            incrValue((Map) objects[0], context.getContextNodePointer().getValue(), (Number) objects[1]);
            return Boolean.TRUE;

        }
        throw EvaluationException.createException(FunctionHelper.makeFunctionName(GremlinFunctions.NAMESPACE_PREFIX, FUNCTION_NAME), EvaluationException.EvaluationErrorType.UNSUPPORTED_PARAMETERS);

    }

    private static void incrValue(Map map, Object key, Number amount) {
        Object value = map.get(key);
        if (value != null && value instanceof Number) {
            map.put(key, ((Number) value).doubleValue() + amount.doubleValue());
        } else {
            map.put(key, amount.doubleValue());
        }
    }
}
