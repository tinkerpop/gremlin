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
public class AddNamespaceFunction implements Function {

    public static final String FUNCTION_NAME = "add-ns";

    public Boolean invoke(ExpressionContext context, Object[] parameters) {

        if (null != parameters) {
            Object[] objects = FunctionHelper.nodeSetConversion(parameters);
            if (objects.length == 3 && FunctionHelper.assertTypes(objects, new Class[]{SesameGraph.class, String.class, String.class})) {
                ((SesameGraph) objects[0]).addNamespace((String) objects[1], (String) objects[2]);
                return Boolean.TRUE;

            } else if (parameters.length == 2 && FunctionHelper.assertTypes(objects, new Class[]{String.class, String.class})) {
                Graph graph = FunctionHelper.getGraph(context);
                if (graph instanceof SesameGraph) {
                    ((SesameGraph) graph).addNamespace((String) objects[0], (String) objects[1]);
                    return Boolean.TRUE;
                }
            }
        }
        throw EvaluationException.createException(FunctionHelper.makeFunctionName(SesameFunctions.NAMESPACE_PREFIX, FUNCTION_NAME), EvaluationException.EvaluationErrorType.UNSUPPORTED_PARAMETERS);
    }

}
