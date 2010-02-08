package com.tinkerpop.gremlin.functions.g.lme;

import com.tinkerpop.gremlin.functions.FunctionHelper;
import com.tinkerpop.gremlin.functions.Function;
import com.tinkerpop.gremlin.functions.g.GremlinFunctions;
import com.tinkerpop.gremlin.statements.EvaluationException;
import org.apache.commons.jxpath.ExpressionContext;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class ListFunction implements Function {
    public static final String FUNCTION_NAME = "list";

    public List invoke(final ExpressionContext context, final Object[] parameters) {
        if (null == parameters) {
            return new ArrayList();
        } else if (parameters.length == 1) {
            Object object = FunctionHelper.nodeSetConversion(parameters[0]);

            if (object instanceof List) {
                return new ArrayList((List) object);
            } else {
                List b = new ArrayList();
                b.add(object);
                return b;
            }
        }
        throw EvaluationException.createException(FunctionHelper.makeFunctionName(GremlinFunctions.NAMESPACE_PREFIX, FUNCTION_NAME), EvaluationException.EvaluationErrorType.UNSUPPORTED_PARAMETERS);

    }

        public String getName() {
        return FUNCTION_NAME;
    }
}