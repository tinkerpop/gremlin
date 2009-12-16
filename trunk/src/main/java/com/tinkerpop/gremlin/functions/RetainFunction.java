package com.tinkerpop.gremlin.functions;

import com.tinkerpop.gremlin.FunctionHelper;
import com.tinkerpop.gremlin.GremlinFunctions;
import com.tinkerpop.gremlin.statements.EvaluationException;
import org.apache.commons.jxpath.ExpressionContext;
import org.apache.commons.jxpath.Function;

import java.util.*;

public class RetainFunction implements Function {
    public static final String FUNCTION_NAME = "retain";

    public Boolean invoke(ExpressionContext context, Object[] parameters) {

        if (null != parameters) {
            Object[] objects = FunctionHelper.nodeSetConversion(parameters);
            Set setA = new HashSet();
            for (Object object : objects) {
                if (object instanceof List)
                    setA.addAll((List) object);
                else if (!(object instanceof Map))
                    setA.add(object);

            }
            Set setB = new HashSet();
            setB.add(context.getContextNodePointer().getValue());
            setA.retainAll(setB);
            return setA.size() > 0;
        }
        throw EvaluationException.createException(FunctionHelper.makeFunctionName(GremlinFunctions.NAMESPACE_PREFIX,FUNCTION_NAME), EvaluationException.EvaluationErrorType.UNSUPPORTED_PARAMETERS);
        
    }

}