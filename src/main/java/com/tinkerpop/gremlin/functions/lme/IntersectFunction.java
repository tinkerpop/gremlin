package com.tinkerpop.gremlin.functions.lme;

import com.tinkerpop.gremlin.FunctionHelper;
import com.tinkerpop.gremlin.functions.GremlinFunctions;
import com.tinkerpop.gremlin.statements.EvaluationException;
import org.apache.commons.jxpath.ExpressionContext;
import org.apache.commons.jxpath.Function;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class IntersectFunction implements Function {

    public static final String FUNCTION_NAME = "intersect";

    public List invoke(final ExpressionContext context, final Object[] parameters) {

        Object[] objects = FunctionHelper.nodeSetConversion(parameters);
        if (null != objects && objects.length > 1) {
            Set set = new HashSet();
            if (objects[0] instanceof List)
                set.addAll((List) objects[0]);
            else
                set.add(objects[0]);

            for (int i = 1; i < objects.length; i++) {
                if (objects[i] instanceof List)
                    set.retainAll((List) objects[i]);
                else {
                    Set tempSet = new HashSet();
                    tempSet.add(objects[i]);
                    set.retainAll(tempSet);
                }
                if (set.size() == 0)
                    return new ArrayList(set);
            }
            return new ArrayList(set);
        }
        throw EvaluationException.createException(FunctionHelper.makeFunctionName(GremlinFunctions.NAMESPACE_PREFIX, FUNCTION_NAME), EvaluationException.EvaluationErrorType.UNSUPPORTED_PARAMETERS);

    }
}