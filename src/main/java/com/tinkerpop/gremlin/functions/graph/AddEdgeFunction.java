package com.tinkerpop.gremlin.functions.graph;

import com.tinkerpop.gremlin.functions.FunctionHelper;
import com.tinkerpop.gremlin.functions.GremlinFunctions;
import com.tinkerpop.gremlin.models.ggm.Edge;
import com.tinkerpop.gremlin.models.ggm.Graph;
import com.tinkerpop.gremlin.models.ggm.Vertex;
import com.tinkerpop.gremlin.statements.EvaluationException;
import org.apache.commons.jxpath.ExpressionContext;
import org.apache.commons.jxpath.Function;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class AddEdgeFunction implements Function {

    public static final String FUNCTION_NAME = "add-e";

    public Edge invoke(final ExpressionContext context, final Object[] parameters) {

        if (parameters != null && parameters.length > 2) {

            Object[] objects = FunctionHelper.nodeSetConversion(parameters);
            Graph graph = GraphFunctionHelper.getGraph(context, parameters);

            if (objects.length == 4 && FunctionHelper.assertTypes(objects, new Class[]{Graph.class, Vertex.class, String.class, Vertex.class})) {
                Vertex vertexOut = (Vertex) objects[1];
                String label = (String) objects[2];
                Vertex vertexIn = (Vertex) objects[3];
                return graph.addEdge(null, vertexOut, vertexIn, label);
            } else if (objects.length == 5 && FunctionHelper.assertTypes(objects, new Class[]{Graph.class, Object.class, Vertex.class, String.class, Vertex.class})) {
                Vertex vertexOut = (Vertex) objects[2];
                String label = (String) objects[3];
                Vertex vertexIn = (Vertex) objects[4];
                return graph.addEdge(objects[1], vertexOut, vertexIn, label);
            } else if (objects.length == 3 && FunctionHelper.assertTypes(objects, new Class[]{Vertex.class, String.class, Vertex.class})) {
                Vertex vertexOut = (Vertex) objects[0];
                String label = (String) objects[1];
                Vertex vertexIn = (Vertex) objects[2];
                return graph.addEdge(null, vertexOut, vertexIn, label);
            } else if (objects.length == 4 && FunctionHelper.assertTypes(objects, new Class[]{Object.class, Vertex.class, String.class, Vertex.class})) {
                Vertex vertexOut = (Vertex) objects[1];
                String label = (String) objects[2];
                Vertex vertexIn = (Vertex) objects[3];
                return graph.addEdge(objects[0], vertexOut, vertexIn, label);
            }
        }
        throw EvaluationException.createException(FunctionHelper.makeFunctionName(GremlinFunctions.NAMESPACE_PREFIX, FUNCTION_NAME), EvaluationException.EvaluationErrorType.UNSUPPORTED_PARAMETERS);

    }
}