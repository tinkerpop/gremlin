package com.tinkerpop.gremlin.functions.var;

import com.tinkerpop.gremlin.functions.FunctionHelper;
import com.tinkerpop.gremlin.functions.GremlinFunctions;
import com.tinkerpop.gremlin.models.ggm.Element;
import com.tinkerpop.gremlin.statements.EvaluationException;
import org.apache.commons.jxpath.ExpressionContext;
import org.apache.commons.jxpath.Function;

import java.util.List;
import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class UnassignFunction implements Function {
    public static final String FUNCTION_NAME = "unassign";

    public Object invoke(final ExpressionContext context, final Object[] parameters) {
        Object[] objects = FunctionHelper.nodeSetConversion(parameters);

        if (null != objects) {
            if (objects.length == 1 && objects[0] instanceof String) {
                // g:unassign('variable')
                Object value = FunctionHelper.getGremlin(context).getVariables().getVariable(objects[0].toString());
                FunctionHelper.getGremlin(context).getVariables().undeclareVariable(objects[0].toString());
                return value;
            } else if (objects.length == 2) {
                if (objects[0] instanceof List && objects[1] instanceof Number) {
                    // g:unassign(list,index)
                    return removeListIndex((List) objects[0], ((Number) objects[1]).intValue() - 1);
                } else if (objects[0] instanceof Map) {
                    // g:unassign(map,key)
                    return removeMapKey((Map) objects[0], objects[1]);
                } else if (objects[0] instanceof Element && objects[1] instanceof String) {
                    // g:unassign(element,key)
                    return removeElementKey((Element) objects[0], (String) objects[1]);
                }
            }
        }

        throw EvaluationException.createException(FunctionHelper.makeFunctionName(GremlinFunctions.NAMESPACE_PREFIX, FUNCTION_NAME), EvaluationException.EvaluationErrorType.UNSUPPORTED_PARAMETERS);

    }

    private static Object removeListIndex(final List list, final Integer index) {
        if (list.size() < index + 1)
            throw EvaluationException.createException(FunctionHelper.makeFunctionName(GremlinFunctions.NAMESPACE_PREFIX, FUNCTION_NAME), EvaluationException.EvaluationErrorType.INDEX_BOUNDS);

        return list.remove(index.intValue());
    }

    private static Object removeMapKey(final Map map, final Object key) {
        return map.remove(key);
    }

    private static Object removeElementKey(final Element element, final String key) {
        return element.removeProperty(key);
    }
}