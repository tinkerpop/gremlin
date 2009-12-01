package com.tinkerpop.gremlin.functions;

import com.tinkerpop.gremlin.GremlinFunctions;
import com.tinkerpop.gremlin.statements.EvaluationErrorException;
import org.apache.commons.jxpath.ExpressionContext;
import org.apache.commons.jxpath.Function;

import java.util.Random;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class RandomRealFunction implements Function {

    public static final String FUNCTION_NAME = "rand_real";
    private static final Random random = new Random();


    public Number invoke(ExpressionContext context, Object[] parameters) {

        if (null == parameters) {
            return random.nextDouble();
        }

        throw new EvaluationErrorException(GremlinFunctions.NAMESPACE_PREFIX + ":" + FUNCTION_NAME + " does not support provided parameters.");
    }
}
