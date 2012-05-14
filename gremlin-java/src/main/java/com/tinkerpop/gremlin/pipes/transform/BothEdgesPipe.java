package com.tinkerpop.gremlin.pipes.transform;

import com.tinkerpop.blueprints.Direction;
import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.blueprints.Vertex;
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
                this.nextEnds = new MultiIterator<Edge>(vertex.getEdges(Direction.OUT, this.labels).iterator(), vertex.getEdges(Direction.IN, this.labels).iterator());
            }
        }
    }
}