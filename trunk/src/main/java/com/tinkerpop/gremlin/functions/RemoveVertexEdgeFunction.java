package com.tinkerpop.gremlin.functions;

import com.tinkerpop.gremlin.FunctionHelper;
import com.tinkerpop.gremlin.GremlinFunctions;
import com.tinkerpop.gremlin.model.Edge;
import com.tinkerpop.gremlin.model.Graph;
import com.tinkerpop.gremlin.model.Vertex;
import com.tinkerpop.gremlin.statements.EvaluationException;
import org.apache.commons.jxpath.ExpressionContext;
import org.apache.commons.jxpath.Function;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class RemoveVertexEdgeFunction implements Function {

    public static final String FUNCTION_NAME = "remove-ve";

    public Boolean invoke(ExpressionContext context, Object[] parameters) {

        if (parameters != null && parameters.length > 0) {
            Object[] objects = FunctionHelper.nodeSetConversion(parameters);
            if (objects[0] instanceof Graph) {
                Graph graph = (Graph) objects[0];
                if (objects.length == 1) {
                    if (FunctionHelper.isLastInContext(context)) {
                        for (Object o : FunctionHelper.asObject(context.getContextNodeList())) {
                            if (o instanceof Vertex) {
                                graph.removeVertex((Vertex) o);
                            } else if (o instanceof Edge) {
                                graph.removeEdge((Edge) o);
                            }
                        }
                    }
                    return Boolean.TRUE;

                } else if (objects.length == 2) {
                    Set<Vertex> vertices = new HashSet<Vertex>();
                    Set<Edge> edges = new HashSet<Edge>();
                    for (int i = 1; i < objects.length; i++) {
                        if (objects[i] instanceof Vertex) {
                            vertices.add((Vertex) objects[i]);
                        } else if (objects[i] instanceof Edge) {
                            edges.add((Edge) objects[i]);
                        } else if (objects[i] instanceof Collection) {
                            for (Object o : ((Collection) objects[i])) {
                                if (o instanceof Vertex) {
                                    vertices.add((Vertex) o);
                                } else if (o instanceof Edge) {
                                    edges.add((Edge) o);
                                }
                            }
                        }
                    }
                    for (Edge e : edges) {
                        graph.removeEdge(e);
                    }
                    for (Vertex v : vertices) {
                        graph.removeVertex(v);
                    }
                    return Boolean.TRUE;
                }
            }
        }
        throw EvaluationException.createException(FunctionHelper.makeFunctionName(GremlinFunctions.NAMESPACE_PREFIX, FUNCTION_NAME), EvaluationException.EvaluationErrorType.UNSUPPORTED_PARAMETERS);

    }

}
