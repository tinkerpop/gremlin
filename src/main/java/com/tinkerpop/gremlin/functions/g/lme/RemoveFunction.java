package com.tinkerpop.gremlin.functions.g.lme;

import com.tinkerpop.gremlin.functions.Function;
import com.tinkerpop.gremlin.functions.FunctionHelper;
import com.tinkerpop.gremlin.functions.g.GremlinFunctionLibrary;
import com.tinkerpop.gremlin.statements.EvaluationException;
import org.apache.commons.jxpath.ExpressionContext;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class RemoveFunction implements Function {
    public static final String FUNCTION_NAME = "remove";

    public List invoke(final ExpressionContext context, final Object[] parameters) {

        Object[] objects = FunctionHelper.nodeSetConversion(parameters);

        if (null != objects && objects.length > 1) {
            List list = new ArrayList();
            if (objects[0] instanceof List)
                list.addAll((List) objects[0]);
            else
                list.add(objects[0]);

            for (int i = 1; i < objects.length; i++) {
                if (objects[i] instanceof List)
                    list.removeAll((List) objects[i]);
                else
                    list.remove(objects[i]);

                if (list.size() == 0)
                    return list;
            }
            return list;
        }
        throw EvaluationException.createException(FunctionHelper.makeFunctionName(GremlinFunctionLibrary.NAMESPACE_PREFIX, FUNCTION_NAME), EvaluationException.EvaluationErrorType.UNSUPPORTED_PARAMETERS);

    }

    public String getName() {
        return FUNCTION_NAME;
    }
}