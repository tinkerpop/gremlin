package com.tinkerpop.gremlin.core;

import com.tinkerpop.gremlin.Edge;
import com.tinkerpop.gremlin.Vertex;
import com.tinkerpop.gremlin.Function;

import java.util.Set;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class BothEdgesFunction implements Function<Vertex, Set<Edge>> {

    public final String NAME = "<->";

    public Set<Edge> evaluate(final Vertex input) {
        return input.getEdges(Vertex.Direction.BOTH);
    }

    public String getName() {
        return NAME;
    }
}
