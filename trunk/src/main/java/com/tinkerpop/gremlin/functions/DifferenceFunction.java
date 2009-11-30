package com.tinkerpop.gremlin.functions;

import com.tinkerpop.gremlin.FunctionHelper;
import com.tinkerpop.gremlin.GremlinFunctions;
import com.tinkerpop.gremlin.statements.EvaluationErrorException;
import org.apache.commons.jxpath.ExpressionContext;
import org.apache.commons.jxpath.Function;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DifferenceFunction implements Function {

    public static final String FUNCTION_NAME = "difference";

    public Set invoke(ExpressionContext context, Object[] parameters) {

        Object[] objects = FunctionHelper.nodeSetConversion(parameters);

        if (null != objects && objects.length > 1) {
            Set set = new HashSet();

            if (objects[0] instanceof Collection)
                set.addAll((Collection) objects[0]);
            else if (!(objects[0] instanceof Map))
                set.add(objects[0]);

            for (int i = 1; i < objects.length; i++) {
                if (objects[i] instanceof Collection)
                    set.removeAll((Collection) objects[i]);
                else if (!(objects[i] instanceof Map)) {
                    set.remove(objects[i]);
                }
                if (set.size() == 0)
                    return set;
            }
            return set;
        }
        throw new EvaluationErrorException(GremlinFunctions.NAMESPACE_PREFIX + ":" + FUNCTION_NAME + " does not support provided parameters.");
    }
}