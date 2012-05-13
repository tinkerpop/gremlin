package com.tinkerpop.gremlin.pipes.transform;

import com.tinkerpop.blueprints.Edge;

/**
 * OutEdgesPipe emits the outgoing edges of a vertex.
 *
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class OutEdgesPipe extends AbstractEdgesPipe {

    public OutEdgesPipe(final String... labels) {
        super(labels);
    }

    protected Edge processNextStart() {
        while (true) {
            if (this.nextEnds.hasNext()) {
                return this.nextEnds.next();
            } else {
                this.nextEnds = this.starts.next().getOutEdges(this.labels).iterator();
            }
        }
    }
}