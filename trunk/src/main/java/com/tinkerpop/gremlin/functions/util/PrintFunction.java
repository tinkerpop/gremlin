package com.tinkerpop.gremlin.functions.util;

import com.tinkerpop.gremlin.FunctionHelper;
import com.tinkerpop.gremlin.GremlinFunctions;
import com.tinkerpop.gremlin.statements.EvaluationException;
import org.apache.commons.jxpath.ExpressionContext;
import org.apache.commons.jxpath.Function;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class PrintFunction implements Function {

    public static final String FUNCTION_NAME = "print";

    public Boolean invoke(final ExpressionContext context, final Object[] parameters) {

        if (null != parameters && parameters.length > 0) {
            Object[] objects = FunctionHelper.nodeSetConversion(parameters);
            for (Object o : objects) {
                System.out.print(o);
            }
            System.out.println();
            return Boolean.TRUE;
        }

        throw EvaluationException.createException(FunctionHelper.makeFunctionName(GremlinFunctions.NAMESPACE_PREFIX, FUNCTION_NAME), EvaluationException.EvaluationErrorType.UNSUPPORTED_PARAMETERS);

    }
}
