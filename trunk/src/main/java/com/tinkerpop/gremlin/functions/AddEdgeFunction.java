package com.tinkerpop.gremlin.functions;

import com.tinkerpop.gremlin.FunctionHelper;
import com.tinkerpop.gremlin.GremlinFunctions;
import com.tinkerpop.gremlin.model.Edge;
import com.tinkerpop.gremlin.model.Graph;
import com.tinkerpop.gremlin.model.Vertex;
import com.tinkerpop.gremlin.statements.EvaluationException;
import org.apache.commons.jxpath.ExpressionContext;
import org.apache.commons.jxpath.Function;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class AddEdgeFunction implements Function {

    public static final String FUNCTION_NAME = "add-e";

    public Edge invoke(ExpressionContext context, Object[] parameters) {

        if (parameters != null && parameters.length > 2) {
            Object[] objects = FunctionHelper.nodeSetConversion(parameters);
            if (objects[0] instanceof Graph) {
                if (objects.length == 4) {
                    if (objects[1] instanceof Vertex && objects[2] instanceof String && objects[3] instanceof Vertex) {
                        Graph graph = (Graph) objects[0];
                        Vertex vertexOut = (Vertex) objects[1];
                        String label = (String) objects[2];
                        Vertex vertexIn = (Vertex) objects[3];
                        return graph.addEdge(null, vertexOut, vertexIn, label);
                    }
                } else if (objects.length == 5) {
                    if (objects[2] instanceof Vertex && objects[3] instanceof String && objects[4] instanceof Vertex) {
                        Graph graph = (Graph) objects[0];
                        Vertex vertexOut = (Vertex) objects[2];
                        String label = (String) objects[3];
                        Vertex vertexIn = (Vertex) objects[4];
                        return graph.addEdge(objects[1], vertexOut, vertexIn, label);
                    }
                }
            } else {
                Graph graph = FunctionHelper.getGraph(context);
                if (objects.length == 3) {
                    if (objects[0] instanceof Vertex && objects[1] instanceof String && objects[2] instanceof Vertex) {
                        Vertex vertexOut = (Vertex) objects[0];
                        String label = (String) objects[1];
                        Vertex vertexIn = (Vertex) objects[2];
                        return graph.addEdge(null, vertexOut, vertexIn, label);
                    }
                } else if (objects.length == 4) {
                    if (objects[1] instanceof Vertex && objects[2] instanceof String && objects[3] instanceof Vertex) {
                        Vertex vertexOut = (Vertex) objects[1];
                        String label = (String) objects[2];
                        Vertex vertexIn = (Vertex) objects[3];
                        return graph.addEdge(objects[0], vertexOut, vertexIn, label);
                    }
                }
            }
        }
        throw EvaluationException.createException(FunctionHelper.makeFunctionName(GremlinFunctions.NAMESPACE_PREFIX, FUNCTION_NAME), EvaluationException.EvaluationErrorType.UNSUPPORTED_PARAMETERS);

    }
}