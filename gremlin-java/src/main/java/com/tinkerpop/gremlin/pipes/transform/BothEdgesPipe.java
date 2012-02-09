package com.tinkerpop.gremlin.pipes.transform;

import com.tinkerpop.blueprints.pgm.Edge;
import com.tinkerpop.blueprints.pgm.Vertex;
import com.tinkerpop.pipes.util.iterators.MultiIterator;

/**
 * BothEdgesPipe emits the incoming and outgoing edges of a vertex.
 *
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class BothEdgesPipe extends AbstractEdgesPipe {

    public BothEdgesPipe(final String... labels) {
        super(labels);
    }

    protected Edge processNextStart() {
        while (true) {
            if (this.nextEnds.hasNext()) {
                return this.nextEnds.next();
            } else {
                final Vertex vertex = this.starts.next();
                this.nextEnds = new MultiIterator<Edge>(vertex.getInEdges(this.labels).iterator(), vertex.getOutEdges(this.labels).iterator());
            }
        }
    }
}