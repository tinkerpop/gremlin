package com.tinkerpop.gremlin.functions.lme;

import com.tinkerpop.gremlin.FunctionHelper;
import com.tinkerpop.gremlin.GremlinFunctions;
import com.tinkerpop.gremlin.statements.EvaluationException;
import org.apache.commons.jxpath.ExpressionContext;
import org.apache.commons.jxpath.Function;

import java.util.*;

public class DifferenceFunction implements Function {

    public static final String FUNCTION_NAME = "difference";

    public List invoke(ExpressionContext context, Object[] parameters) {

        Object[] objects = FunctionHelper.nodeSetConversion(parameters);

        if (null != objects && objects.length > 1) {
            Set set = new HashSet();

            if (objects[0] instanceof List)
                set.addAll((List) objects[0]);
            else if (!(objects[0] instanceof Map))
                set.add(objects[0]);

            for (int i = 1; i < objects.length; i++) {
                if (objects[i] instanceof List)
                    set.removeAll((List) objects[i]);
                else if (!(objects[i] instanceof Map)) {
                    set.remove(objects[i]);
                }
                if (set.size() == 0)
                    return new ArrayList();
            }
            return new ArrayList(set);
        }
        throw EvaluationException.createException(FunctionHelper.makeFunctionName(GremlinFunctions.NAMESPACE_PREFIX,FUNCTION_NAME), EvaluationException.EvaluationErrorType.UNSUPPORTED_PARAMETERS);

    }
}