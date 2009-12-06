package com.tinkerpop.gremlin.functions;

import com.tinkerpop.gremlin.FunctionHelper;
import com.tinkerpop.gremlin.GremlinFunctions;
import com.tinkerpop.gremlin.statements.EvaluationException;
import org.apache.commons.jxpath.ExpressionContext;
import org.apache.commons.jxpath.Function;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class AssignValueFunction implements Function {

    public static final String FUNCTION_NAME = "assign-value";

    public Object invoke(ExpressionContext context, Object[] parameters) {

        Object[] objects = FunctionHelper.nodeSetConversion(parameters);

        if (null != objects && objects.length == 2) {
            if (objects[0] instanceof Map) {
                setMapKey((Map) objects[0], context.getContextNodePointer().getValue(), objects[1]);
                return Boolean.TRUE;
            }
            if (objects[0] instanceof List) {
                Object index = context.getContextNodePointer().getValue();
                if (index instanceof Number) {
                    setListIndex((List) objects[0], ((Number) index).intValue() - 1, objects[1]);
                    return Boolean.TRUE;
                }
            }
        }

        throw EvaluationException.createException(FunctionHelper.makeFunctionName(GremlinFunctions.NAMESPACE_PREFIX, FUNCTION_NAME), EvaluationException.EvaluationErrorType.UNSUPPORTED_PARAMETERS);
    }

    private static Object setMapKey(Map map, Object key, Object value) {
        if (key instanceof Collection || key instanceof Map || value instanceof Collection || value instanceof Map)
            throw EvaluationException.createException(FunctionHelper.makeFunctionName(GremlinFunctions.NAMESPACE_PREFIX, FUNCTION_NAME), EvaluationException.EvaluationErrorType.EMBEDDED_COLLECTIONS);
        map.put(key, value);
        return value;
    }

    private static Object setListIndex(List list, Integer index, Object value) {
        if (list.size() < index + 1)
            throw EvaluationException.createException(FunctionHelper.makeFunctionName(GremlinFunctions.NAMESPACE_PREFIX, FUNCTION_NAME), EvaluationException.EvaluationErrorType.INDEX_BOUNDS);

        if (value instanceof Collection || value instanceof Map)
            throw EvaluationException.createException(FunctionHelper.makeFunctionName(GremlinFunctions.NAMESPACE_PREFIX, FUNCTION_NAME), EvaluationException.EvaluationErrorType.EMBEDDED_COLLECTIONS);

        list.set(index, value);
        return value;
    }
}

