package com.tinkerpop.gremlin.pipes.transform;

import com.tinkerpop.blueprints.Edge;

/**
 * InEdgesPipe emits the incoming edges to a vertex.
 *
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class InEdgesPipe extends AbstractEdgesPipe {

    public InEdgesPipe(final String... labels) {
        super(labels);
    }

    protected Edge processNextStart() {
        while (true) {
            if (this.nextEnds.hasNext()) {
                return this.nextEnds.next();
            } else {
                this.nextEnds = this.starts.next().getInEdges(this.labels).iterator();
            }
        }
    }
}