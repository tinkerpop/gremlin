package com.tinkerpop.gremlin.functions.jung;

import com.tinkerpop.gremlin.functions.FunctionHelper;
import com.tinkerpop.gremlin.functions.Function;
import com.tinkerpop.gremlin.functions.g.GremlinFunctions;
import com.tinkerpop.gremlin.functions.g.graph.GraphFunctionHelper;
import com.tinkerpop.gremlin.models.pgm.Edge;
import com.tinkerpop.gremlin.models.pgm.Graph;
import com.tinkerpop.gremlin.models.pgm.Vertex;
import com.tinkerpop.gremlin.models.pgm.jung.JungGraph;
import com.tinkerpop.gremlin.statements.EvaluationException;
import edu.uci.ics.jung.algorithms.shortestpath.DijkstraShortestPath;
import org.apache.commons.jxpath.ExpressionContext;

import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class DijkstraShortestPathFunction implements Function {

    public static final String FUNCTION_NAME = "dijkstra";

    public List invoke(final ExpressionContext context, final Object[] parameters) {

        if (parameters != null && parameters.length > 0) {
            Graph graph = GraphFunctionHelper.getGraph(context, parameters);
            Boolean cache = null;
            Vertex source = null;
            Vertex destination = null;
            Object[] objects = FunctionHelper.nodeSetConversion(parameters);
            if (objects.length == 4 && FunctionHelper.assertTypes(objects, new Class[]{Graph.class, Vertex.class, Vertex.class, Boolean.class})) {
                source = (Vertex) objects[1];
                destination = (Vertex) objects[2];
                cache = (Boolean) objects[3];
            } else if (objects.length == 3 && FunctionHelper.assertTypes(objects, new Class[]{Vertex.class, Vertex.class, Boolean.class})) {
                source = (Vertex) objects[0];
                destination = (Vertex) objects[1];
                cache = (Boolean) objects[2];
            }
            if (null != source && null != destination && null != cache && null != graph) {
                DijkstraShortestPath<Vertex, Edge> dsp = new DijkstraShortestPath<Vertex, Edge>(new JungGraph(graph), cache);
                return dsp.getPath(source, destination);
            }
        }
        throw EvaluationException.createException(FunctionHelper.makeFunctionName(GremlinFunctions.NAMESPACE_PREFIX, FUNCTION_NAME), EvaluationException.EvaluationErrorType.UNSUPPORTED_PARAMETERS);

    }

        public String getName() {
        return FUNCTION_NAME;
    }
}