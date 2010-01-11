package com.tinkerpop.gremlin.db.sail.functions;

import org.apache.commons.jxpath.Function;
import org.apache.commons.jxpath.ExpressionContext;
import com.tinkerpop.gremlin.FunctionHelper;
import com.tinkerpop.gremlin.model.Graph;
import com.tinkerpop.gremlin.statements.EvaluationException;
import com.tinkerpop.gremlin.db.sail.SailGraph;
import com.tinkerpop.gremlin.db.sail.SailFunctions;

import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class GetNamespacesFunction implements Function {

    public static final String FUNCTION_NAME = "get-ns";

    public Map invoke(ExpressionContext context, Object[] parameters) {

        if (null != parameters && parameters.length == 1) {
            Object object = FunctionHelper.nodeSetConversion(parameters[0]);
            if (object instanceof SailGraph) {
               return ((SailGraph)object).getNamespaces();
            }
        } else {
            Graph graph = FunctionHelper.getGraph(context);
            if(graph instanceof SailGraph) {
                return ((SailGraph)graph).getNamespaces();
            }
        }
        throw EvaluationException.createException(FunctionHelper.makeFunctionName(SailFunctions.NAMESPACE_PREFIX, FUNCTION_NAME), EvaluationException.EvaluationErrorType.UNSUPPORTED_PARAMETERS);
    }
}