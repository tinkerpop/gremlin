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
import edu.uci.ics.jung.algorithms.scoring.PageRank;
import org.apache.commons.jxpath.ExpressionContext;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class PageRankFunction implements Function {

    public static final String FUNCTION_NAME = "pagerank";

    public Map invoke(final ExpressionContext context, final Object[] parameters) {

        if (parameters != null && parameters.length > 0) {
            Graph graph = GraphFunctionHelper.getGraph(context, parameters);
            Number alpha = null;
            Object[] objects = FunctionHelper.nodeSetConversion(parameters);
            if (objects.length == 2 && FunctionHelper.assertTypes(objects, new Class[]{Graph.class, Number.class})) {
                alpha = (Number) objects[1];
            } else if (objects.length == 1 && objects[0] instanceof Number) {
                alpha = (Number) objects[0];
            }
            if (null != alpha && null != graph) {
                PageRank<Vertex, Edge> pageRank = new PageRank<Vertex, Edge>(new JungGraph(graph), (Double) alpha);
                pageRank.evaluate();
                Map<Vertex, Number> scores = new HashMap<Vertex, Number>();
                for (Vertex vertex : graph.getVertices()) {
                    scores.put(vertex, pageRank.getVertexScore(vertex));
                }
                return scores;
            }
        }
        throw EvaluationException.createException(FunctionHelper.makeFunctionName(GremlinFunctions.NAMESPACE_PREFIX, FUNCTION_NAME), EvaluationException.EvaluationErrorType.UNSUPPORTED_PARAMETERS);

    }

    public String getName() {
        return FUNCTION_NAME;
    }
}
