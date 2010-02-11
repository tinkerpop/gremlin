package com.tinkerpop.gremlin.functions.g.graph;

import com.tinkerpop.blueprints.pgm.Edge;
import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.gremlin.functions.FunctionHelper;
import org.apache.commons.jxpath.ExpressionContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class GraphFunctionHelper {

    public static Graph getGraph(final ExpressionContext context, final Object[] parameters) {
        if (null != parameters && parameters.length > 0) {
            Object object = FunctionHelper.nodeSetConversion(parameters[0]);
            if (object instanceof Graph) {
                return (Graph) object;
            }
        }
        return FunctionHelper.getGraph(context);
    }

    public static List<Edge> filterEdgeLabels(Iterable<Edge> edges, Set<String> labels, boolean filter) {
        List<Edge> returnEdges = new ArrayList<Edge>();
        for (Edge edge : edges) {
            if (labels.contains(edge.getLabel())) {
                if (!filter) {
                    returnEdges.add(edge);
                }
            } else {
                if (filter) {
                    returnEdges.add(edge);
                }
            }
        }
        return returnEdges;
    }

    public static Double totalWeight(Iterable<Edge> edges, String weightKey) {
        double total = 0.0d;
        for (Edge edge : edges) {
            Object weight = edge.getProperty(weightKey);
            if (null != weight && weight instanceof Number) {
                total = total + ((Number) weight).doubleValue();
            }
        }
        return total;
    }
}
