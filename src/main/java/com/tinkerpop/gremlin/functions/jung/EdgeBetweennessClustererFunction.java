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
import edu.uci.ics.jung.algorithms.cluster.EdgeBetweennessClusterer;
import org.apache.commons.jxpath.ExpressionContext;

import java.util.*;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class EdgeBetweennessClustererFunction implements Function {

    public static final String FUNCTION_NAME = "eb-cluster";

    public Map invoke(final ExpressionContext context, final Object[] parameters) {

        if (parameters != null && parameters.length > 0) {
            Graph graph = GraphFunctionHelper.getGraph(context, parameters);
            Number removal = null;
            Object[] objects = FunctionHelper.nodeSetConversion(parameters);
            if (objects.length == 2 && FunctionHelper.assertTypes(objects, new Class[]{Graph.class, Number.class})) {
                removal = (Number) objects[1];
            } else if (objects.length == 1 && objects[0] instanceof Number) {
                removal = (Number) objects[0];
            }
            if (null != removal && null != graph) {
                EdgeBetweennessClusterer<Vertex, Edge> clusterer = new EdgeBetweennessClusterer<Vertex, Edge>(removal.intValue());
                Set<Set<Vertex>> clusters = clusterer.transform(new JungGraph(graph));
                Map<String, List<Vertex>> clustersMap = new HashMap<String, List<Vertex>>();
                int count = 1;
                for (Set<Vertex> cluster : clusters) {
                    clustersMap.put("c" + count, new ArrayList<Vertex>(cluster));
                    count++;
                }
                return clustersMap;

            }
        }
        throw EvaluationException.createException(FunctionHelper.makeFunctionName(GremlinFunctions.NAMESPACE_PREFIX, FUNCTION_NAME), EvaluationException.EvaluationErrorType.UNSUPPORTED_PARAMETERS);
    }

        public String getName() {
        return FUNCTION_NAME;
    }
}