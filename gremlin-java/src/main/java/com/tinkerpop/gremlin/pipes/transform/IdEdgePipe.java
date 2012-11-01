package com.tinkerpop.gremlin.pipes.transform;

import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.pipes.AbstractPipe;
import com.tinkerpop.pipes.transform.TransformPipe;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class IdEdgePipe<S> extends AbstractPipe<S, Edge> implements TransformPipe {

    private final Graph graph;

    public IdEdgePipe(final Graph graph) {
        this.graph = graph;
    }

    protected Edge processNextStart() {
        return this.graph.getEdge(this.starts.next());
    }
}