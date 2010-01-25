package com.tinkerpop.gremlin.functions.number;

import com.tinkerpop.gremlin.FunctionHelper;
import com.tinkerpop.gremlin.GremlinFunctions;
import com.tinkerpop.gremlin.statements.EvaluationException;
import org.apache.commons.jxpath.ExpressionContext;
import org.apache.commons.jxpath.Function;

import java.util.Random;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class RandomNaturalFunction implements Function {

    public static final String FUNCTION_NAME = "rand-nat";
    private static final Random random = new Random();


    public Number invoke(final ExpressionContext context, final Object[] parameters) {

        if (null == parameters) {
            return random.nextInt(context.getContextNodeList().size()) + 1;
        } else if (parameters.length == 1) {
            Object object = FunctionHelper.nodeSetConversion(parameters[0]);
            if (object instanceof Number) {
                return random.nextInt(((Number) object).intValue()) + 1;
            }
        }

        throw EvaluationException.createException(FunctionHelper.makeFunctionName(GremlinFunctions.NAMESPACE_PREFIX, FUNCTION_NAME), EvaluationException.EvaluationErrorType.UNSUPPORTED_PARAMETERS);

    }
}
