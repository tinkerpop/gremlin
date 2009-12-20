package com.tinkerpop.gremlin.functions;

import com.tinkerpop.gremlin.FunctionHelper;
import com.tinkerpop.gremlin.GremlinFunctions;
import com.tinkerpop.gremlin.statements.EvaluationException;
import org.apache.commons.jxpath.ExpressionContext;
import org.apache.commons.jxpath.Function;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class PrintFunction implements Function {

    public static final String FUNCTION_NAME = "print";

    public Boolean invoke(ExpressionContext context, Object[] parameters) {

        if (null != parameters && parameters.length > 0) {
            Object[] objects = FunctionHelper.nodeSetConversion(parameters);
            for (Object o : objects) {
                System.out.println(o);
            }
            return Boolean.TRUE;
        }

        throw EvaluationException.createException(FunctionHelper.makeFunctionName(GremlinFunctions.NAMESPACE_PREFIX,FUNCTION_NAME), EvaluationException.EvaluationErrorType.UNSUPPORTED_PARAMETERS);
        
    }
}
