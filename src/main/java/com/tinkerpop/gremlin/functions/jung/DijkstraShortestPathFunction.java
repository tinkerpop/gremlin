package com.tinkerpop.gremlin.functions.jung;

import com.tinkerpop.blueprints.pgm.Edge;
import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.Vertex;
import com.tinkerpop.blueprints.pgm.jung.JungGraph;
import com.tinkerpop.gremlin.functions.Function;
import com.tinkerpop.gremlin.functions.FunctionHelper;
import com.tinkerpop.gremlin.functions.g.GremlinFunctions;
import com.tinkerpop.gremlin.functions.g.graph.GraphFunctionHelper;
import com.tinkerpop.gremlin.statements.EvaluationException;
import edu.uci.ics.jung.algorithms.shortestpath.DijkstraShortestPath;
import org.apache.commons.collections15.Transformer;
import org.apache.commons.jxpath.ExpressionContext;

import java.util.List;
import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class DijkstraShortestPathFunction implements Function {

    public static final String FUNCTION_NAME = "dijkstra";

    /*
        labels = g:list()
        filter = true()
        weight_key = 'weight'
        invert = true()
     */

    public List invoke(final ExpressionContext context, final Object[] parameters) {

        Graph graph = GraphFunctionHelper.getGraph(context, parameters);
        if (null != graph) {
            Object[] objects = FunctionHelper.nodeSetConversion(parameters);
            Vertex sourceVertex;
            Vertex targetVertex;
            Map parameterMap;
            if (objects.length == 2 && FunctionHelper.assertTypes(objects, new Class[]{Vertex.class, Vertex.class})) {
                sourceVertex = (Vertex) objects[0];
                targetVertex = (Vertex) objects[1];
                parameterMap = null;
            } else if (objects.length == 3 && FunctionHelper.assertTypes(objects, new Class[]{Vertex.class, Vertex.class, Map.class})) {
                sourceVertex = (Vertex) objects[0];
                targetVertex = (Vertex) objects[1];
                parameterMap = (Map) objects[2];
            } else if (objects.length == 4 && FunctionHelper.assertTypes(objects, new Class[]{Graph.class, Vertex.class, Vertex.class, Map.class})) {
                sourceVertex = (Vertex) objects[1];
                targetVertex = (Vertex) objects[2];
                parameterMap = (Map) objects[3];
            } else {
                throw EvaluationException.createException(FunctionHelper.makeFunctionName(GremlinFunctions.NAMESPACE_PREFIX, FUNCTION_NAME), EvaluationException.EvaluationErrorType.UNSUPPORTED_PARAMETERS);
            }

            List labels = null;
            Boolean filter = null;
            String weightKey = null;
            Boolean invert = null;

            if (parameterMap != null) {
                Object temp = parameterMap.get("labels");
                if (null != temp && temp instanceof List)
                    labels = (List) temp;
                temp = parameterMap.get("filter");
                if (null != temp && temp instanceof Boolean)
                    filter = (Boolean) temp;
                temp = parameterMap.get("weight-key");
                if (null != temp && temp instanceof String)
                    weightKey = (String) temp;
                temp = parameterMap.get("invert");
                if (null != temp && temp instanceof Boolean)
                    invert = (Boolean) temp;
            }


            DijkstraShortestPath<Vertex, Edge> dsp;
            Transformer<Edge, Number> transformer = JungFunctionHelper.makeTransformer(JungFunctionHelper.makeSetList(labels), filter, Double.MAX_VALUE, false, weightKey, null, invert);
            if (null == transformer) {
                dsp = new DijkstraShortestPath<Vertex, Edge>(new JungGraph(graph), true);
            } else {
                dsp = new DijkstraShortestPath<Vertex, Edge>(new JungGraph(graph), transformer, true);

            }
            return dsp.getPath(sourceVertex, targetVertex);
        }

        throw EvaluationException.createException(FunctionHelper.makeFunctionName(GremlinFunctions.NAMESPACE_PREFIX, FUNCTION_NAME), EvaluationException.EvaluationErrorType.UNSUPPORTED_PARAMETERS);

    }

    public String getName() {
        return FUNCTION_NAME;
    }
}