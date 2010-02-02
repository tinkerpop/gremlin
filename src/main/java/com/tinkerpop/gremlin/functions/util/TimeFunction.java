package com.tinkerpop.gremlin.functions.util;

import com.tinkerpop.gremlin.FunctionHelper;
import com.tinkerpop.gremlin.functions.GremlinFunctions;
import com.tinkerpop.gremlin.statements.EvaluationException;
import org.apache.commons.jxpath.ExpressionContext;
import org.apache.commons.jxpath.Function;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class TimeFunction implements Function {

    public static final String FUNCTION_NAME = "time";

    public Double invoke(final ExpressionContext context, final Object[] parameters) {

        if (null == parameters) {
            return new Long(System.currentTimeMillis()).doubleValue();
        } else if (parameters.length == 1) {
            Object object = FunctionHelper.nodeSetConversion(parameters[0]);
            if (object instanceof Number) {
                return System.currentTimeMillis() - (Double) object;
            }
        }

        throw EvaluationException.createException(FunctionHelper.makeFunctionName(GremlinFunctions.NAMESPACE_PREFIX, FUNCTION_NAME), EvaluationException.EvaluationErrorType.UNSUPPORTED_PARAMETERS);

    }

}
