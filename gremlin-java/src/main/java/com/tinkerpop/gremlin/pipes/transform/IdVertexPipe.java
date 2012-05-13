package com.tinkerpop.gremlin.pipes.transform;

import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.pipes.AbstractPipe;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class IdVertexPipe<S> extends AbstractPipe<S, Vertex> {

    private final Graph graph;

    public IdVertexPipe(final Graph graph) {
        this.graph = graph;
    }

    protected Vertex processNextStart() {
        return this.graph.getVertex(this.starts.next());
    }
}
