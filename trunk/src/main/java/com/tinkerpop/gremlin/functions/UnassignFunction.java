package com.tinkerpop.gremlin.functions;

import com.tinkerpop.gremlin.FunctionHelper;
import com.tinkerpop.gremlin.GremlinFunctions;
import com.tinkerpop.gremlin.statements.EvaluationException;
import org.apache.commons.jxpath.ExpressionContext;
import org.apache.commons.jxpath.Function;

import java.util.List;
import java.util.Map;

public class UnassignFunction implements Function {
    public static final String FUNCTION_NAME = "unassign";

    public Object invoke(ExpressionContext context, Object[] parameters) {
        Object[] objects = FunctionHelper.nodeSetConversion(parameters);

        if (null != objects) {
            if (objects.length == 1 && objects[0] instanceof String) {
                // g:unassign('variable')
                Object value = FunctionHelper.getGremlin(context).getVariable(objects[0].toString());
                FunctionHelper.getGremlin(context).removeVariable(objects[0].toString());
                return value;
            } else if (objects.length == 1 && (objects[0] instanceof Map || objects[0] instanceof List)) {
                if (objects[0] instanceof Map) {
                    // key[g:unassign(map)]
                    removeMapKey((Map) objects[0], context.getContextNodePointer().getValue());
                    return Boolean.TRUE;
                } else if (objects[0] instanceof List) {
                    // index[g:unassign(list)]
                    Object index = context.getContextNodePointer().getValue();
                    if (index instanceof Number) {
                        removeListIndex((List) objects[0], ((Number) index).intValue() - 1);
                        return Boolean.TRUE;
                    }
                }
            } else if (objects.length == 2) {
                if (objects[0] instanceof List && objects[1] instanceof Number) {
                    // $i[index]
                    // g:unassign(list,index)
                    return removeListIndex((List) objects[0], ((Number) objects[1]).intValue() - 1);
                } else if (objects[0] instanceof Map) {
                    // $i/@key
                    // g:unassign(map,key)
                    return removeMapKey((Map) objects[0], objects[1]);
                }
            }
        }

        throw EvaluationException.createException(FunctionHelper.makeFunctionName(GremlinFunctions.NAMESPACE_PREFIX, FUNCTION_NAME), EvaluationException.EvaluationErrorType.UNSUPPORTED_PARAMETERS);

    }

    private static Object removeListIndex(List list, Integer index) {
        if (list.size() < index + 1)
            throw EvaluationException.createException(FunctionHelper.makeFunctionName(GremlinFunctions.NAMESPACE_PREFIX, FUNCTION_NAME), EvaluationException.EvaluationErrorType.INDEX_BOUNDS);

        return list.remove(index.intValue());
    }

    private static Object removeMapKey(Map map, Object key) {
        return map.remove(key);
    }
}