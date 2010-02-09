package com.tinkerpop.gremlin.functions.sail;

import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.impls.sail.SailGraph;
import com.tinkerpop.gremlin.functions.Function;
import com.tinkerpop.gremlin.functions.FunctionHelper;
import com.tinkerpop.gremlin.statements.EvaluationException;
import org.apache.commons.jxpath.ExpressionContext;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class AddNamespaceFunction implements Function {

    public static final String FUNCTION_NAME = "add-ns";

    public Boolean invoke(final ExpressionContext context, final Object[] parameters) {

        if (null != parameters) {
            Object[] objects = FunctionHelper.nodeSetConversion(parameters);
            if (objects.length == 3 && FunctionHelper.assertTypes(objects, new Class[]{SailGraph.class, String.class, String.class})) {
                ((SailGraph) objects[0]).addNamespace((String) objects[1], (String) objects[2]);
                return Boolean.TRUE;

            } else if (parameters.length == 2 && FunctionHelper.assertTypes(objects, new Class[]{String.class, String.class})) {
                Graph graph = FunctionHelper.getGraph(context);
                if (graph instanceof SailGraph) {
                    ((SailGraph) graph).addNamespace((String) objects[0], (String) objects[1]);
                    return Boolean.TRUE;
                }
            }
        }
        throw EvaluationException.createException(FunctionHelper.makeFunctionName(SailFunctions.NAMESPACE_PREFIX, FUNCTION_NAME), EvaluationException.EvaluationErrorType.UNSUPPORTED_PARAMETERS);
    }

    public String getName() {
        return FUNCTION_NAME;
    }

}
