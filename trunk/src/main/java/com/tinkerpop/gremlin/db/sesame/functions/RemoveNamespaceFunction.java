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
public class RemoveNamespaceFunction implements Function {

    public static final String FUNCTION_NAME = "remove-ns";

    public Boolean invoke(ExpressionContext context, Object[] parameters) {
        if (null != parameters) {
            Object[] objects = FunctionHelper.nodeSetConversion(parameters);
            if (objects.length == 2 && FunctionHelper.assertTypes(objects, new Class[]{SesameGraph.class, String.class})) {
                ((SesameGraph) objects[0]).removeNamespace((String) objects[1]);
                return Boolean.TRUE;
            } else if (objects.length == 1) {
                Graph graph = FunctionHelper.getGraph(context);
                if (graph instanceof SesameGraph && objects[0] instanceof String) {
                    ((SesameGraph) graph).removeNamespace((String) objects[0]);
                    return Boolean.TRUE;
                }
            }
        }
        throw EvaluationException.createException(FunctionHelper.makeFunctionName(SesameFunctions.NAMESPACE_PREFIX, FUNCTION_NAME), EvaluationException.EvaluationErrorType.UNSUPPORTED_PARAMETERS);
    }

}