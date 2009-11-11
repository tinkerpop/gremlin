package com.tinkerpop.gremlin;

import java.util.Set;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public interface Vertex extends Element {

    public static enum Direction {
        IN, OUT, BOTH
    }

    public Set<Edge> getEdges(Direction direction);
}
