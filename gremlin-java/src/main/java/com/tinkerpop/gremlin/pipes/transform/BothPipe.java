package com.tinkerpop.gremlin.pipes.transform;

import com.tinkerpop.blueprints.pgm.Edge;
import com.tinkerpop.blueprints.pgm.Vertex;
import com.tinkerpop.pipes.util.MultiIterator;

/**
 * BothPipe will emit those vertices adjacent to the incoming and outgoing edges of the incoming vertex.
 *
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class BothPipe extends AbstractEdgesVerticesPipe {

    private Vertex startVertex = null;

    public BothPipe(final String... labels) {
        super(labels);
    }

    public Vertex processNextStart() {
        while (true) {
            if (null != this.nextEnds && this.nextEnds.hasNext()) {
                final Edge edge = this.nextEnds.next();
                final Vertex tempOut = edge.getOutVertex();
                final Vertex tempIn = edge.getInVertex();
                if (tempOut.equals(tempIn)) {
                    return tempIn;
                } else if (tempOut.equals(this.startVertex)) {
                    return tempIn;
                } else {
                    return tempOut;
                }
            } else {
                this.startVertex = this.starts.next();
                this.nextEnds = new MultiIterator<Edge>(this.startVertex.getInEdges(this.labels).iterator(), this.startVertex.getOutEdges(this.labels).iterator());
            }
        }
    }

    public void reset() {
        this.startVertex = null;
        super.reset();
    }
}
