package com.tinkerpop.gremlin.functions.flow;

import com.tinkerpop.gremlin.FunctionHelper;
import com.tinkerpop.gremlin.GremlinFunctions;
import com.tinkerpop.gremlin.statements.EvaluationException;
import org.apache.commons.jxpath.ExpressionContext;
import org.apache.commons.jxpath.Function;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class HaltFunction implements Function {

    public static final String FUNCTION_NAME = "halt";

    public Boolean invoke(final ExpressionContext context, final Object[] parameters) {
        if (null != parameters && parameters.length == 1) {
            Object object = FunctionHelper.nodeSetConversion(parameters[0]);
            if (object instanceof Boolean)
                return !((Boolean) object);
        }
        throw EvaluationException.createException(FunctionHelper.makeFunctionName(GremlinFunctions.NAMESPACE_PREFIX,FUNCTION_NAME), EvaluationException.EvaluationErrorType.UNSUPPORTED_PARAMETERS);

    }
}
