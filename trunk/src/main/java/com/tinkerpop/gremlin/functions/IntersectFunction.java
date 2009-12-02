package com.tinkerpop.gremlin.functions;

import com.tinkerpop.gremlin.FunctionHelper;
import com.tinkerpop.gremlin.GremlinFunctions;
import com.tinkerpop.gremlin.statements.EvaluationException;
import org.apache.commons.jxpath.ExpressionContext;
import org.apache.commons.jxpath.Function;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IntersectFunction implements Function {

    public static final String FUNCTION_NAME = "intersect";

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
                    set.retainAll((Collection) objects[i]);
                else if (!(objects[i] instanceof Map)) {
                    Set tempSet = new HashSet();
                    tempSet.add(objects[i]);
                    set.retainAll(tempSet);
                }
                if (set.size() == 0)
                    return set;
            }
            return set;
        }
        throw EvaluationException.createException(FunctionHelper.makeFunctionName(GremlinFunctions.NAMESPACE_PREFIX,FUNCTION_NAME), EvaluationException.EvaluationErrorType.UNSUPPORTED_PARAMETERS);

    }
}