package com.tinkerpop.gremlin.pipes.transform;

import com.tinkerpop.blueprints.Direction;
import com.tinkerpop.pipes.util.PipeHelper;

/**
 * OutEdgesPipe emits the outgoing edges of a vertex.
 *
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class OutEdgesPipe extends VerticesEdgesPipe {

    public OutEdgesPipe(final String... labels) {
        super(Direction.OUT, labels);
    }

    public String toString() {
        return PipeHelper.makePipeString(this, this.labels);
    }
}
