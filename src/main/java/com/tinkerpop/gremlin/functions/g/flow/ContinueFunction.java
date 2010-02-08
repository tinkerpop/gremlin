package com.tinkerpop.gremlin.functions.g.flow;

import com.tinkerpop.gremlin.functions.Function;
import com.tinkerpop.gremlin.functions.FunctionHelper;
import com.tinkerpop.gremlin.functions.g.GremlinFunctions;
import com.tinkerpop.gremlin.statements.EvaluationException;
import org.apache.commons.jxpath.ExpressionContext;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class ContinueFunction implements Function {

    public static final String FUNCTION_NAME = "cont";

    public Boolean invoke(final ExpressionContext context, final Object[] parameters) {
        if (null != parameters && parameters.length == 1) {
            Object object = FunctionHelper.nodeSetConversion(parameters[0]);
            if (object instanceof Boolean)
                return (Boolean) object;
        }
        throw EvaluationException.createException(FunctionHelper.makeFunctionName(GremlinFunctions.NAMESPACE_PREFIX, FUNCTION_NAME), EvaluationException.EvaluationErrorType.UNSUPPORTED_PARAMETERS);

    }

    public String getName() {
        return FUNCTION_NAME;
    }
}

