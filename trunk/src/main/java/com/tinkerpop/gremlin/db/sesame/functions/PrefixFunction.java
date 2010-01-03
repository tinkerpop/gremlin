package com.tinkerpop.gremlin.db.sesame.functions;

import com.tinkerpop.gremlin.FunctionHelper;
import com.tinkerpop.gremlin.db.sesame.SesameFunctions;
import com.tinkerpop.gremlin.db.sesame.SesameGraph;
import com.tinkerpop.gremlin.model.Graph;
import com.tinkerpop.gremlin.statements.EvaluationException;
import org.apache.commons.jxpath.ExpressionContext;
import org.apache.commons.jxpath.Function;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class PrefixFunction implements Function {

    public static final String FUNCTION_NAME = "prefix";

    public String invoke(ExpressionContext context, Object[] parameters) {

        if (null != parameters) {
            Object[] objects = FunctionHelper.nodeSetConversion(parameters);
            if (parameters.length == 2) {
                if (objects[0] instanceof SesameGraph && objects[1] instanceof String) {
                    return ((SesameGraph) objects[0]).prefixNamespace((String) objects[1]);
                }
            } else if (parameters.length == 1) {
                Graph graph = FunctionHelper.getGraph(context);
                if (graph instanceof SesameGraph && objects[0] instanceof String) {
                    return ((SesameGraph) graph).prefixNamespace((String) objects[0]);
                }
            }
        }
        throw EvaluationException.createException(FunctionHelper.makeFunctionName(SesameFunctions.NAMESPACE_PREFIX, FUNCTION_NAME), EvaluationException.EvaluationErrorType.UNSUPPORTED_PARAMETERS);

    }
}
