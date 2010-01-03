package com.tinkerpop.gremlin.functions;

import org.apache.commons.jxpath.Function;
import org.apache.commons.jxpath.ExpressionContext;
import com.tinkerpop.gremlin.FunctionHelper;
import com.tinkerpop.gremlin.GremlinFunctions;
import com.tinkerpop.gremlin.model.Graph;
import com.tinkerpop.gremlin.statements.EvaluationException;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class ClearFunction implements Function {

     public static final String FUNCTION_NAME = "clear";

    public Boolean invoke(ExpressionContext context, Object[] parameters) {
        if (null != parameters) {
            Object object = FunctionHelper.nodeSetConversion(parameters[0]);
            if (object instanceof Graph) {
                ((Graph)object).clear();
                return Boolean.TRUE;
            }    
        } else {
            FunctionHelper.getGraph(context).clear();
            return Boolean.TRUE;
        }
        throw EvaluationException.createException(FunctionHelper.makeFunctionName(GremlinFunctions.NAMESPACE_PREFIX,FUNCTION_NAME), EvaluationException.EvaluationErrorType.UNSUPPORTED_PARAMETERS);

    }
}
