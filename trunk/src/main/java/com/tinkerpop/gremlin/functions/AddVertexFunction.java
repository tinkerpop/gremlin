package com.tinkerpop.gremlin.functions;

import com.tinkerpop.gremlin.FunctionHelper;
import com.tinkerpop.gremlin.GremlinFunctions;
import com.tinkerpop.gremlin.model.Graph;
import com.tinkerpop.gremlin.model.Vertex;
import com.tinkerpop.gremlin.statements.EvaluationException;
import org.apache.commons.jxpath.ExpressionContext;
import org.apache.commons.jxpath.Function;

import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class AddVertexFunction implements Function {

    public static final String FUNCTION_NAME = "add-v";

    public Vertex invoke(ExpressionContext context, Object[] parameters) {

        if (parameters != null) {
            Object[] objects = FunctionHelper.nodeSetConversion(parameters);
            if (objects[0] instanceof Graph) {
                if (objects.length == 1) {
                    return ((Graph) objects[0]).addVertex(null);
                } else if (objects.length == 2) {
                    if (objects[1] instanceof Vertex) {
                        Graph graph = (Graph) objects[0];
                        Vertex v = (Vertex) objects[1];
                        Vertex u = graph.addVertex(v.getId());
                        for (String key : v.getPropertyKeys()) {
                            u.setProperty(key, v.getProperty(key));
                        }
                        return u;
                    } else if (objects[1] instanceof List) {
                      // TODO : add a list of numbers or vertices?
                    } else {
                        return ((Graph) objects[0]).addVertex(objects[1]);
                    }
                }
            }
        }
        throw EvaluationException.createException(FunctionHelper.makeFunctionName(GremlinFunctions.NAMESPACE_PREFIX, FUNCTION_NAME), EvaluationException.EvaluationErrorType.UNSUPPORTED_PARAMETERS);

    }
}
