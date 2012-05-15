package com.tinkerpop.gremlin.pipes.transform;

import com.tinkerpop.blueprints.Direction;
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
                this.nextEnds = this.starts.next().getEdges(Direction.IN, this.labels).iterator();
            } else {
                if (this.nextEnds.hasNext()) {
                    return this.nextEnds.next().getVertex(Direction.OUT);
                } else {
                    this.nextEnds = null;
                }
            }
        }
    }
}
