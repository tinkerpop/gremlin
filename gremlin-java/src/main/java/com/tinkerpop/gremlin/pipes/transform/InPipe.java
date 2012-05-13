package com.tinkerpop.gremlin.pipes.transform;

import com.tinkerpop.blueprints.Vertex;

/**
 * InPipe will emit vertices that are the head/target of the incoming edges to the current vertex.
 *
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class InPipe extends AbstractEdgesVerticesPipe {

    public InPipe(final String... labels) {
        super(labels);
    }

    public Vertex processNextStart() {
        while (true) {
            if (null == this.nextEnds) {
                this.nextEnds = this.starts.next().getInEdges(this.labels).iterator();
            } else {
                if (this.nextEnds.hasNext()) {
                    return this.nextEnds.next().getOutVertex();
                } else {
                    this.nextEnds = null;
                }
            }
        }
    }
}
