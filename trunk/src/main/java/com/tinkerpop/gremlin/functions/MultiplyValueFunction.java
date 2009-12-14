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
public class MultiplyValueFunction implements Function {

    public static final String FUNCTION_NAME = "mult-value";

    //TODO allow it to take a set of indices or keys
    public Object invoke(ExpressionContext context, Object[] parameters) {
        Object[] objects = FunctionHelper.nodeSetConversion(parameters);
        if (null != objects) {
            if (objects.length == 2) {
                if (objects[0] instanceof Map && objects[1] instanceof Number) {
                    multValue((Map) objects[0], context.getContextNodePointer().getValue(), (Number) objects[1]);
                    return Boolean.TRUE;
                } else if (objects[0] instanceof List && objects[1] instanceof Number) {
                    Object index = context.getContextNodePointer().getValue();
                    if (index instanceof Number) {
                        multValue((List) objects[0], ((Number) index).intValue() - 1, (Number) objects[1]);
                        return Boolean.TRUE;
                    }
                }
            } else if (objects.length == 3) {
                if (objects[0] instanceof Map && objects[2] instanceof Number) {
                    Map map = (Map) objects[0];
                    multValue(map, objects[1], (Number) objects[2]);
                    return map.get(objects[1]);
                } else if (objects[0] instanceof List && objects[1] instanceof Number && objects[2] instanceof Number) {
                    Integer index = ((Number) objects[1]).intValue() - 1;
                    List list = (List) objects[0];
                    multValue(list, index, (Number) objects[2]);
                    return list.get(index);
                }
            }

        }
        throw EvaluationException.createException(FunctionHelper.makeFunctionName(GremlinFunctions.NAMESPACE_PREFIX, FUNCTION_NAME), EvaluationException.EvaluationErrorType.UNSUPPORTED_PARAMETERS);

    }

    private static void multValue(Map map, Object key, Number amount) {
        Object value = map.get(key);
        if (value != null && value instanceof Number) {
            map.put(key, ((Number) value).doubleValue() * amount.doubleValue());
        } else {
            map.put(key, amount.doubleValue());
        }
    }

    private static void multValue(List list, Integer index, Number amount) {
        if (list.size() < index + 1)
            throw EvaluationException.createException(FunctionHelper.makeFunctionName(GremlinFunctions.NAMESPACE_PREFIX, FUNCTION_NAME), EvaluationException.EvaluationErrorType.INDEX_BOUNDS);


        Object value = list.get(index);
        if (value != null && value instanceof Number) {
            list.set(index, ((Number) value).doubleValue() * amount.doubleValue());
        }
    }
}
