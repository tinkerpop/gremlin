package com.tinkerpop.gremlin.functions.g.util;

import com.tinkerpop.gremlin.functions.Function;
import com.tinkerpop.gremlin.functions.FunctionHelper;
import com.tinkerpop.gremlin.functions.g.GremlinFunctionLibrary;
import com.tinkerpop.gremlin.statements.EvaluationException;
import org.apache.commons.jxpath.ExpressionContext;

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

        throw EvaluationException.createException(FunctionHelper.makeFunctionName(GremlinFunctionLibrary.NAMESPACE_PREFIX, FUNCTION_NAME), EvaluationException.EvaluationErrorType.UNSUPPORTED_PARAMETERS);

    }

    public String getName() {
        return FUNCTION_NAME;
    }
}
