package com.tinkerpop.gremlin.functions;

import com.tinkerpop.gremlin.FunctionHelper;
import com.tinkerpop.gremlin.GremlinFunctions;
import com.tinkerpop.gremlin.statements.EvaluationException;
import org.apache.commons.jxpath.ExpressionContext;
import org.apache.commons.jxpath.Function;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class AssignFunction implements Function {

    public static final String FUNCTION_NAME = "assign";

    public Object invoke(ExpressionContext context, Object[] parameters) {

        Object[] objects = FunctionHelper.nodeSetConversion(parameters);

        if (null != objects) {
            if (objects.length == 1 && objects[0] instanceof String) {
                // ../..[g:assign('$i')]
                if (FunctionHelper.isLastInContext(context))
                    FunctionHelper.getGremlin(context).setVariable((String) objects[0], FunctionHelper.asObject(context.getContextNodeList()));
                return Boolean.TRUE;
            } else if (objects.length == 2) {
                if (objects[0] instanceof String) {
                    // g:assign('$i', value)
                    FunctionHelper.getGremlin(context).setVariable((String) objects[0], objects[1]);
                    return objects[1];
                } else if (objects[0] instanceof List && objects[1] instanceof Number) {
                    // ../..[g:assign(list,index)]
                    setListIndex((List) objects[0], ((Number) objects[1]).intValue() - 1, context.getContextNodePointer().getValue());
                    return Boolean.TRUE;
                } else if (objects[0] instanceof Map && !(objects[1] instanceof Collection && objects[1] instanceof Map)) {
                    // ../..[g:assign(map,key)]
                    setMapKey((Map) objects[0], objects[1], context.getContextNodePointer().getValue());
                    return Boolean.TRUE;
                }
            } else if (objects.length == 3) {
                if (objects[0] instanceof List && !(objects[2] instanceof Collection || objects[2] instanceof Map)) {
                    // g:assign(list,index,value)
                    return setListIndex((List) objects[0], ((Number) objects[1]).intValue() - 1, objects[2]);
                } else if (objects[0] instanceof Map && !(objects[2] instanceof Collection || objects[2] instanceof Map)) {
                    // g:assign(map,key,value)
                    return setMapKey((Map) objects[0], objects[1], objects[2]);
                }
            }
        }

        throw EvaluationException.createException(FunctionHelper.makeFunctionName(GremlinFunctions.NAMESPACE_PREFIX,FUNCTION_NAME), EvaluationException.EvaluationErrorType.UNSUPPORTED_PARAMETERS);
    }

    private static Object setListIndex(List list, Integer index, Object value) {
        if (list.size() < index + 1)
            throw EvaluationException.createException(FunctionHelper.makeFunctionName(GremlinFunctions.NAMESPACE_PREFIX,FUNCTION_NAME), EvaluationException.EvaluationErrorType.INDEX_BOUNDS);

        if (value instanceof Collection || value instanceof Map)
            throw EvaluationException.createException(FunctionHelper.makeFunctionName(GremlinFunctions.NAMESPACE_PREFIX,FUNCTION_NAME), EvaluationException.EvaluationErrorType.EMBEDDED_COLLECTIONS);

        list.set(index, value);
        return value;
    }

    private static Object setMapKey(Map map, Object key, Object value) {
        if (value instanceof Collection || value instanceof Map)
            throw EvaluationException.createException(FunctionHelper.makeFunctionName(GremlinFunctions.NAMESPACE_PREFIX,FUNCTION_NAME), EvaluationException.EvaluationErrorType.EMBEDDED_COLLECTIONS);


        map.put(key, value);
        return value;
    }
}