package com.tinkerpop.gremlin.models.ggm.impls.sail.functions;

import com.tinkerpop.gremlin.functions.FunctionHelper;
import com.tinkerpop.gremlin.models.ggm.impls.sail.SailFunctions;
import com.tinkerpop.gremlin.models.ggm.impls.sail.SailGraph;
import com.tinkerpop.gremlin.models.ggm.Graph;
import com.tinkerpop.gremlin.statements.EvaluationException;
import org.apache.commons.jxpath.ExpressionContext;
import org.apache.commons.jxpath.Function;

import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class GetNamespacesFunction implements Function {

    public static final String FUNCTION_NAME = "get-ns";

    public Map invoke(final ExpressionContext context, final Object[] parameters) {

        if (null != parameters && parameters.length == 1) {
            Object object = FunctionHelper.nodeSetConversion(parameters[0]);
            if (object instanceof SailGraph) {
                return ((SailGraph) object).getNamespaces();
            }
        } else {
            Graph graph = FunctionHelper.getGraph(context);
            if (graph instanceof SailGraph) {
                return ((SailGraph) graph).getNamespaces();
            }
        }
        throw EvaluationException.createException(FunctionHelper.makeFunctionName(SailFunctions.NAMESPACE_PREFIX, FUNCTION_NAME), EvaluationException.EvaluationErrorType.UNSUPPORTED_PARAMETERS);
    }
}