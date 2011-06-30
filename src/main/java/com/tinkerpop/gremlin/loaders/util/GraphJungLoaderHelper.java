package com.tinkerpop.gremlin.loaders.util;

import com.tinkerpop.blueprints.pgm.Edge;
import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.Vertex;
import com.tinkerpop.blueprints.pgm.oupls.jung.GraphJung;
import com.tinkerpop.gremlin.GremlinTokens;
import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.graph.util.Context;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import org.apache.commons.collections15.Predicate;
import org.apache.commons.collections15.Transformer;

import javax.swing.*;
import java.awt.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class GraphJungLoaderHelper {

    public static void visualizeGraph(final Graph graph, final String vertexPropertyLabel, final String edgePropertyLabel, final Iterable<Vertex> vertices, final Collection<String> edgeLabels) {
        final Set<Vertex> legalVertices;
        if (vertices != null) {
            legalVertices = new HashSet<Vertex>();
            for (final Vertex vertex : vertices) {
                legalVertices.add(vertex);
            }
        } else {
            legalVertices = null;
        }
        final GraphJung graphJung = new GraphJung(graph);
        final Layout<Vertex, Edge> layout = new CircleLayout<Vertex, Edge>(graphJung);
        layout.setSize(new Dimension(300, 300));
        final BasicVisualizationServer<Vertex, Edge> viz = new BasicVisualizationServer<Vertex, Edge>(layout);
        viz.setPreferredSize(new Dimension(350, 350));

        final Transformer<Vertex, String> vertexLabelTransformer = new Transformer<Vertex, String>() {
            public String transform(final Vertex vertex) {
                if (null == vertexPropertyLabel) {
                    return "";
                } else if (vertexPropertyLabel.equals(GremlinTokens.ID)) {
                    return vertex.getId().toString();
                } else {
                    final Object temp = vertex.getProperty(vertexPropertyLabel);
                    if (null == temp) {
                        return "null";
                    } else {
                        return temp.toString();
                    }
                }
            }
        };

        final Transformer<Edge, String> edgeLabelTransformer = new Transformer<Edge, String>() {
            public String transform(final Edge edge) {
                if (null == edgePropertyLabel) {
                    return "";
                } else if (edgePropertyLabel.equals(GremlinTokens.ID)) {
                    return edge.getId().toString();
                } else if (edgePropertyLabel.equals(GremlinTokens.LABEL)) {
                    return edge.getLabel();
                } else {
                    final Object temp = edge.getProperty(edgePropertyLabel);
                    if (null == temp) {
                        return "null";
                    } else {
                        return temp.toString();
                    }
                }
            }
        };

        final Predicate<Context<GraphJung, Edge>> edgeIncludePredicate = new Predicate<Context<GraphJung, Edge>>() {
            public boolean evaluate(final Context<GraphJung, Edge> context) {
                return null == edgeLabels || edgeLabels.contains(context.element.getLabel());
            }
        };

        final Predicate<Context<GraphJung, Vertex>> vertexIncludePredicate = new Predicate<Context<GraphJung, Vertex>>() {
            public boolean evaluate(final Context<GraphJung, Vertex> context) {
                return null == legalVertices || legalVertices.contains(context.element);
            }
        };

        viz.getRenderContext().setEdgeLabelTransformer(edgeLabelTransformer);
        viz.getRenderContext().setVertexLabelTransformer(vertexLabelTransformer);
        viz.getRenderContext().setEdgeIncludePredicate((Predicate) edgeIncludePredicate);
        viz.getRenderContext().setVertexIncludePredicate((Predicate) vertexIncludePredicate);

        JFrame frame = new JFrame("Gremlin Graph Visualization");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(viz);
        frame.pack();
        frame.setVisible(true);
    }
}
