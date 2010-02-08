package com.tinkerpop.gremlin.functions.sail;

import com.tinkerpop.gremlin.functions.FunctionHelper;
import com.tinkerpop.gremlin.functions.Function;
import com.tinkerpop.gremlin.models.pgm.Graph;
import com.tinkerpop.gremlin.models.pgm.impls.sail.SailGraph;
import com.tinkerpop.gremlin.statements.EvaluationException;
import org.apache.commons.jxpath.ExpressionContext;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class PrefixFunction implements Function {

    public static final String FUNCTION_NAME = "prefix";

    public String invoke(final ExpressionContext context, final Object[] parameters) {

        if (null != parameters) {
            Object[] objects = FunctionHelper.nodeSetConversion(parameters);
            if (objects.length == 2 && FunctionHelper.assertTypes(objects, new Class[]{SailGraph.class, String.class})) {
                return ((SailGraph) objects[0]).prefixNamespace((String) objects[1]);
            } else if (objects.length == 1) {
                Graph graph = FunctionHelper.getGraph(context);
                if (graph instanceof SailGraph && objects[0] instanceof String) {
                    return ((SailGraph) graph).prefixNamespace((String) objects[0]);
                }
            }
        }
        throw EvaluationException.createException(FunctionHelper.makeFunctionName(SailFunctions.NAMESPACE_PREFIX, FUNCTION_NAME), EvaluationException.EvaluationErrorType.UNSUPPORTED_PARAMETERS);

    }

        public String getName() {
        return FUNCTION_NAME;
    }
}
