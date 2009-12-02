package com.tinkerpop.gremlin.functions;

import com.tinkerpop.gremlin.GremlinFunctions;
import com.tinkerpop.gremlin.FunctionHelper;
import com.tinkerpop.gremlin.statements.EvaluationException;
import org.apache.commons.jxpath.ExpressionContext;
import org.apache.commons.jxpath.Function;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SetFunction implements Function {

    public static final String FUNCTION_NAME = "set";

    public Set invoke(ExpressionContext context, Object[] parameters) {
        if (null == parameters) {
            return new HashSet();
        } else if (parameters.length == 1) {
            Object object = FunctionHelper.nodeSetConversion(parameters[0]);

            if (object instanceof Collection)
                return new HashSet((Collection) object);
            else if (object instanceof Map) {
                throw EvaluationException.createException(FunctionHelper.makeFunctionName(GremlinFunctions.NAMESPACE_PREFIX,FUNCTION_NAME), EvaluationException.EvaluationErrorType.UNSUPPORTED_PARAMETERS);

            } else {
                Set b = new HashSet();
                b.add(object);
                return b;
            }
        }
        throw EvaluationException.createException(FunctionHelper.makeFunctionName(GremlinFunctions.NAMESPACE_PREFIX,FUNCTION_NAME), EvaluationException.EvaluationErrorType.UNSUPPORTED_PARAMETERS);
        
    }
}