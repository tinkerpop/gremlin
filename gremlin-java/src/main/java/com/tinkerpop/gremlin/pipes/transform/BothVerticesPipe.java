package com.tinkerpop.gremlin.pipes.transform;

import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.pipes.AbstractPipe;

/**
 * BothVertexPipe emits the tail/source and head/target vertices of an edge.
 *
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class BothVerticesPipe extends AbstractPipe<Edge, Vertex> {

    private Vertex next = null;

    protected Vertex processNextStart() {
        if (null == this.next) {
            final Edge edge = this.starts.next();
            this.next = edge.getOutVertex();
            return edge.getInVertex();
        } else {
            final Vertex temp = this.next;
            this.next = null;
            return temp;
        }
    }
}
