package com.tinkerpop.gremlin.functions.graph;

import com.tinkerpop.gremlin.functions.FunctionHelper;
import com.tinkerpop.gremlin.functions.GremlinFunctions;
import com.tinkerpop.gremlin.models.pgm.Graph;
import com.tinkerpop.gremlin.models.pgm.Vertex;
import com.tinkerpop.gremlin.statements.EvaluationException;
import org.apache.commons.jxpath.ExpressionContext;
import org.apache.commons.jxpath.Function;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class AddVertexFunction implements Function {

    public static final String FUNCTION_NAME = "add-v";

    public Vertex invoke(final ExpressionContext context, final Object[] parameters) {


        Graph graph = GraphFunctionHelper.getGraph(context, parameters);
        Object[] objects = FunctionHelper.nodeSetConversion(parameters);

        if (null == objects || (objects.length == 1 && objects[0] instanceof Graph)) {
            return graph.addVertex(null);
        } else if (objects.length == 2 && FunctionHelper.assertTypes(objects, new Class[]{Graph.class, Vertex.class})) {
            Vertex v = (Vertex) objects[1];
            Vertex u = graph.addVertex(v.getId());
            for (String key : v.getPropertyKeys()) {
                u.setProperty(key, v.getProperty(key));
            }
            return u;
        } else if (objects.length == 2 && objects[0] instanceof Graph) {
            return graph.addVertex(objects[1]);
        } else if (objects.length == 1 && objects[0] instanceof Vertex) {
            Vertex v = (Vertex) objects[0];
            Vertex u = graph.addVertex(v.getId());
            for (String key : v.getPropertyKeys()) {
                u.setProperty(key, v.getProperty(key));
            }
            return u;

        } else if (objects.length == 1) {
            return graph.addVertex(objects[0]);
        }

        throw EvaluationException.createException(FunctionHelper.makeFunctionName(GremlinFunctions.NAMESPACE_PREFIX, FUNCTION_NAME), EvaluationException.EvaluationErrorType.UNSUPPORTED_PARAMETERS);

    }
}
