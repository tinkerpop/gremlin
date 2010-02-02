package com.tinkerpop.gremlin.functions.lme;

import com.tinkerpop.gremlin.FunctionHelper;
import com.tinkerpop.gremlin.functions.GremlinFunctions;
import com.tinkerpop.gremlin.model.Element;
import com.tinkerpop.gremlin.statements.EvaluationException;
import org.apache.commons.jxpath.ExpressionContext;
import org.apache.commons.jxpath.Function;

import java.util.List;
import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class OperateValueFunction implements Function {

    public static final String FUNCTION_NAME = "op-value";

    public Object invoke(final ExpressionContext context, final Object[] parameters) {
        if (parameters != null && parameters.length == 4) {
            Object[] objects = FunctionHelper.nodeSetConversion(parameters);
            if (objects[0] instanceof String) {
                String operation = (String) objects[0];
                if (operation.equals("+") || operation.equals("-") || operation.equals("*") || operation.equals("div") || operation.equals("mod")) {

                    if (objects[1] instanceof Map && objects[3] instanceof Number) {
                        Map map = (Map) objects[1];
                        opValue(operation, map, objects[2], (Number) objects[3]);
                        return map.get(objects[2]);
                    } else if (objects[1] instanceof List && objects[2] instanceof Number && objects[3] instanceof Number) {
                        Integer index = ((Number) objects[2]).intValue() - 1;
                        List list = (List) objects[1];
                        opValue(operation, list, index, (Number) objects[3]);
                        return list.get(index);
                    } else if (objects[1] instanceof Element && objects[3] instanceof Number) {
                        Element element = (Element) objects[1];
                        opValue(operation, element, objects[2].toString(), (Number) objects[3]);
                        return element.getProperty(objects[2].toString());
                    }
                }
            }
        }
        throw EvaluationException.createException(FunctionHelper.makeFunctionName(GremlinFunctions.NAMESPACE_PREFIX, FUNCTION_NAME), EvaluationException.EvaluationErrorType.UNSUPPORTED_PARAMETERS);

    }

    private static void opValue(final String operation, final Map map, final Object key, final Number amount) {
        Object object = map.get(key);
        Number value;
        if (object == null || !(object instanceof Number))
            value = 0.0d;
        else
            value = (Number) object;

        if (operation.equals("+")) {
            map.put(key, value.doubleValue() + amount.doubleValue());
        } else if (operation.equals("-")) {
            map.put(key, value.doubleValue() - amount.doubleValue());
        } else if (operation.equals("*")) {
            map.put(key, value.doubleValue() * amount.doubleValue());
        } else if (operation.equals("div")) {
            map.put(key, value.doubleValue() / amount.doubleValue());
        } else if (operation.equals("mod")) {
            map.put(key, value.doubleValue() % amount.doubleValue());
        }

    }

    private static void opValue(final String operation, final Element element, final String key, final Number amount) {
        Object object = element.getProperty(key);
        Number value;
        if (object == null || !(object instanceof Number))
            value = 0.0d;
        else
            value = (Number) object;

        if (operation.equals("+")) {
            element.setProperty(key, value.doubleValue() + amount.doubleValue());
        } else if (operation.equals("-")) {
            element.setProperty(key, value.doubleValue() - amount.doubleValue());
        } else if (operation.equals("*")) {
            element.setProperty(key, value.doubleValue() * amount.doubleValue());
        } else if (operation.equals("div")) {
            element.setProperty(key, value.doubleValue() / amount.doubleValue());
        } else if (operation.equals("mod")) {
            element.setProperty(key, value.doubleValue() % amount.doubleValue());
        }
    }

    private static void opValue(final String operation, final List list, final Integer index, final Number amount) {
        if (list.size() < index + 1)
            throw EvaluationException.createException(FunctionHelper.makeFunctionName(GremlinFunctions.NAMESPACE_PREFIX, FUNCTION_NAME), EvaluationException.EvaluationErrorType.INDEX_BOUNDS);

        Object object = list.get(index);
        Number value;
        if (object == null || !(object instanceof Number))
            value = 0.0d;
        else
            value = (Number) object;

        if (operation.equals("+")) {
            list.set(index, value.doubleValue() + amount.doubleValue());
        } else if (operation.equals("-")) {
            list.set(index, value.doubleValue() - amount.doubleValue());
        } else if (operation.equals("*")) {
            list.set(index, value.doubleValue() * amount.doubleValue());
        } else if (operation.equals("div")) {
            list.set(index, value.doubleValue() / amount.doubleValue());
        } else if (operation.equals("mod")) {
            list.set(index, value.doubleValue() % amount.doubleValue());
        }
    }
}
