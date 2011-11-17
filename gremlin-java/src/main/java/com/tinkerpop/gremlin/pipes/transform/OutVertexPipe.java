package com.tinkerpop.gremlin.pipes.transform;

import com.tinkerpop.blueprints.pgm.Edge;
import com.tinkerpop.blueprints.pgm.Vertex;
import com.tinkerpop.pipes.AbstractPipe;

/**
 * OutVertexPipe emits the tail/source vertex of an edge.
 *
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class OutVertexPipe extends AbstractPipe<Edge, Vertex> {
    protected Vertex processNextStart() {
        return this.starts.next().getOutVertex();
    }
}
