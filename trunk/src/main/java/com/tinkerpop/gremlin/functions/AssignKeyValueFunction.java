package com.tinkerpop.gremlin.functions;

import org.apache.commons.jxpath.Function;
import org.apache.commons.jxpath.ExpressionContext;
import com.tinkerpop.gremlin.FunctionHelper;
import com.tinkerpop.gremlin.GremlinFunctions;
import com.tinkerpop.gremlin.statements.EvaluationException;
import com.tinkerpop.gremlin.model.Element;

import java.util.List;
import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class AssignKeyValueFunction implements Function {

      public static final String FUNCTION_NAME = "assign-key-value";

    public Object invoke(ExpressionContext context, Object[] parameters) {

        Object[] objects = FunctionHelper.nodeSetConversion(parameters);

        if (null != objects) {
            if (objects.length == 2) {
                if (objects[0] instanceof String && context.getContextNodePointer().getValue() instanceof Element) {
                    // ./.[g:assign-key-value(key, value)]
                    setElementKey((Element)context.getContextNodePointer().getValue(), (String)objects[0], objects[1]);
                    return Boolean.TRUE;
                }
            } else if (objects.length == 3) {
               if (objects[0] instanceof Map && !(objects[1] instanceof List || objects[1] instanceof Map) && !(objects[2] instanceof List || objects[2] instanceof Map)) {
                    // g:assign-key-value(map,key,value)
                    return setMapKey((Map) objects[0], objects[1], objects[2]);
                } else if (objects[0] instanceof Element && objects[1] instanceof String) {
                    // g:assign-key-value(element,key,value)
                    return setElementKey((Element) objects[0], (String)objects[1], objects[2]);

                }
            }
        }

        throw EvaluationException.createException(FunctionHelper.makeFunctionName(GremlinFunctions.NAMESPACE_PREFIX, FUNCTION_NAME), EvaluationException.EvaluationErrorType.UNSUPPORTED_PARAMETERS);
    }

    private static Object setMapKey(Map map, Object key, Object value) {
        if (value instanceof List || value instanceof Map)
            throw EvaluationException.createException(FunctionHelper.makeFunctionName(GremlinFunctions.NAMESPACE_PREFIX, FUNCTION_NAME), EvaluationException.EvaluationErrorType.EMBEDDED_COLLECTIONS);

        map.put(key, value);
        return value;
    }

    private static Object setElementKey(Element element, String key, Object value) {
        if (value instanceof List || value instanceof Map)
            throw EvaluationException.createException(FunctionHelper.makeFunctionName(GremlinFunctions.NAMESPACE_PREFIX, FUNCTION_NAME), EvaluationException.EvaluationErrorType.EMBEDDED_COLLECTIONS);

        element.setProperty(key, value);
        return value;
    }
}
