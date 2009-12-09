package com.tinkerpop.gremlin.db.neo.functions;

import com.tinkerpop.gremlin.FunctionHelper;
import com.tinkerpop.gremlin.db.neo.NeoFunctions;
import com.tinkerpop.gremlin.db.neo.NeoGraph;
import com.tinkerpop.gremlin.model.Graph;
import com.tinkerpop.gremlin.statements.EvaluationException;
import org.apache.commons.jxpath.ExpressionContext;
import org.apache.commons.jxpath.Function;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class OpenNeoFunction implements Function {

    public static final String FUNCTION_NAME = "open";

    public Graph invoke(ExpressionContext context, Object[] parameters) {

        if (null != parameters && parameters.length == 1) {
            Object object = FunctionHelper.nodeSetConversion(parameters[0]);
            if (object instanceof String) {
                try {
                    return new NeoGraph((String) object);
                } catch (Exception e) {
                    throw new EvaluationException(NeoFunctions.NAMESPACE_PREFIX + ":" + FUNCTION_NAME + " " + e.getMessage());
                }
            }
        }
        throw EvaluationException.createException(FunctionHelper.makeFunctionName(NeoFunctions.NAMESPACE_PREFIX, FUNCTION_NAME), EvaluationException.EvaluationErrorType.UNSUPPORTED_PARAMETERS);

    }
}
