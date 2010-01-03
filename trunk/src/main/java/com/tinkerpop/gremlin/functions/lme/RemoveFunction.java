package com.tinkerpop.gremlin.functions.lme;

import com.tinkerpop.gremlin.FunctionHelper;
import com.tinkerpop.gremlin.GremlinFunctions;
import com.tinkerpop.gremlin.statements.EvaluationException;
import org.apache.commons.jxpath.ExpressionContext;
import org.apache.commons.jxpath.Function;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class RemoveFunction implements Function {
    public static final String FUNCTION_NAME = "remove";

    public List invoke(ExpressionContext context, Object[] parameters) {

        Object[] objects = FunctionHelper.nodeSetConversion(parameters);
        
        if (null != objects && objects.length > 1) {
            List list = new ArrayList();
            if (objects[0] instanceof List)
                list.addAll((List) objects[0]);
            else if (!(objects[0] instanceof Map))
                list.add(objects[0]);

            for (int i = 1; i < objects.length; i++) {
                if (objects[i] instanceof List)
                    list.removeAll((List) objects[i]);
                else if (!(objects[i] instanceof Map))
                    list.remove(objects[i]);
                if (list.size() == 0)
                    return list;
            }
            return list;
        }
        throw EvaluationException.createException(FunctionHelper.makeFunctionName(GremlinFunctions.NAMESPACE_PREFIX,FUNCTION_NAME), EvaluationException.EvaluationErrorType.UNSUPPORTED_PARAMETERS);
       
    }
}