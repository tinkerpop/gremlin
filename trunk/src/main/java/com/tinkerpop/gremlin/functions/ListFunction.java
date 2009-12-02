package com.tinkerpop.gremlin.functions;

import com.tinkerpop.gremlin.GremlinFunctions;
import com.tinkerpop.gremlin.FunctionHelper;
import com.tinkerpop.gremlin.statements.EvaluationErrorException;
import org.apache.commons.jxpath.ExpressionContext;
import org.apache.commons.jxpath.Function;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class ListFunction implements Function {
    public static final String FUNCTION_NAME = "list";

    public List invoke(ExpressionContext context, Object[] parameters) {
        if (null == parameters) {
            return new ArrayList();
        } else if (parameters.length == 1) {
            Object object = FunctionHelper.nodeSetConversion(parameters[0]);

            if (object instanceof Collection)
                return new ArrayList((Collection) object);
            else if (object instanceof Map) {
                throw new EvaluationErrorException(GremlinFunctions.NAMESPACE_PREFIX + ":" + FUNCTION_NAME + " does not support provided parameters.");
            } else {
                List b = new ArrayList();
                b.add(object);
                return b;
            }
        }
        throw new EvaluationErrorException(GremlinFunctions.NAMESPACE_PREFIX + ":" + FUNCTION_NAME + " does not support provided parameters.");
    }
}