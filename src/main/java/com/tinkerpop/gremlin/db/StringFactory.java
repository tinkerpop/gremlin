package com.tinkerpop.gremlin.db;

import com.tinkerpop.gremlin.model.Edge;
import com.tinkerpop.gremlin.model.Vertex;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class StringFactory {

    private static final String V = "v";
    private static final String E = "e";
    private static final String L_BRACKET = "[";
    private static final String R_BRACKET = "]";
    private static final String DASH = "-";
    private static final String ARROW = "->";

    public static String vertexString(final Vertex vertex) {
        return V + L_BRACKET + vertex.getId() + R_BRACKET;
    }

    public static String edgeString(final Edge edge) {
        return E + L_BRACKET + edge.getId() + R_BRACKET + L_BRACKET + edge.getOutVertex().getId() + DASH + edge.getLabel() + ARROW + edge.getInVertex().getId() + R_BRACKET;
    }
}
