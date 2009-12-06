package com.tinkerpop.gremlin.functions;

import com.tinkerpop.gremlin.FunctionHelper;
import com.tinkerpop.gremlin.GremlinFunctions;
import com.tinkerpop.gremlin.statements.EvaluationException;
import org.apache.commons.jxpath.ExpressionContext;
import org.apache.commons.jxpath.Function;

import java.util.List;
import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class IncrementValueFunction implements Function {

    public static final String FUNCTION_NAME = "incr-value";

    public Boolean invoke(ExpressionContext context, Object[] parameters) {
        Object[] objects = FunctionHelper.nodeSetConversion(parameters);
        if (null != objects && objects.length == 2) {
            if (objects[0] instanceof Map && objects[1] instanceof Number) {
                incrValue((Map) objects[0], context.getContextNodePointer().getValue(), (Number) objects[1]);
                return Boolean.TRUE;
            } else if (objects[0] instanceof List && objects[1] instanceof Number) {
                Object index = context.getContextNodePointer().getValue();
                if (index instanceof Number) {
                    incrValue((List) objects[0], ((Number) index).intValue() - 1, (Number) objects[1]);
                    return Boolean.TRUE;
                }
            }

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

    private static void incrValue(List list, Integer index, Number amount) {
        if (list.size() < index + 1)
            throw EvaluationException.createException(FunctionHelper.makeFunctionName(GremlinFunctions.NAMESPACE_PREFIX, FUNCTION_NAME), EvaluationException.EvaluationErrorType.INDEX_BOUNDS);


        Object value = list.get(index);
        if (value != null && value instanceof Number) {
            list.set(index, ((Number) value).doubleValue() + amount.doubleValue());
        }
    }
}
