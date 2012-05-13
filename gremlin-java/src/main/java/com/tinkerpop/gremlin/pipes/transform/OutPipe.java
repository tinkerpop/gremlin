package com.tinkerpop.gremlin.pipes.transform;

import com.tinkerpop.blueprints.Vertex;

/**
 * OutPipe emits those vertices on the head of the outgoing edges of a vertex.
 *
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class OutPipe extends AbstractEdgesVerticesPipe {

    public OutPipe(final String... labels) {
        super(labels);
    }

    public Vertex processNextStart() {
        while (true) {
            if (null == this.nextEnds) {
                this.nextEnds = this.starts.next().getOutEdges(this.labels).iterator();
            } else {
                if (this.nextEnds.hasNext()) {
                    return this.nextEnds.next().getInVertex();
                } else {
                    this.nextEnds = null;
                }
            }
        }
    }
}
