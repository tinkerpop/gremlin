package com.tinkerpop.gremlin.functions.g.number;

import com.tinkerpop.gremlin.functions.FunctionHelper;
import com.tinkerpop.gremlin.functions.Function;
import com.tinkerpop.gremlin.functions.g.GremlinFunctions;
import com.tinkerpop.gremlin.statements.EvaluationException;
import org.apache.commons.jxpath.ExpressionContext;

import java.util.Random;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class RandomRealFunction implements Function {

    public static final String FUNCTION_NAME = "rand-real";
    private static final Random random = new Random();


    public Number invoke(final ExpressionContext context, final Object[] parameters) {

        if (null == parameters) {
            return random.nextDouble();
        }

        throw EvaluationException.createException(FunctionHelper.makeFunctionName(GremlinFunctions.NAMESPACE_PREFIX, FUNCTION_NAME), EvaluationException.EvaluationErrorType.UNSUPPORTED_PARAMETERS);

    }

        public String getName() {
        return FUNCTION_NAME;
    }
}
