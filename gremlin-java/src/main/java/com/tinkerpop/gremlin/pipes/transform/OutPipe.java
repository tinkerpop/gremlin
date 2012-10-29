package com.tinkerpop.gremlin.pipes.transform;

import com.tinkerpop.blueprints.Direction;
import com.tinkerpop.pipes.util.PipeHelper;

/**
 * OutPipe will emit vertices that are the tail/source of the outgoing edges to the current vertex.
 *
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class OutPipe extends VerticesVerticesPipe {

    public OutPipe(final String... labels) {
        super(Direction.OUT, labels);
    }

    public String toString() {
        return PipeHelper.makePipeString(this, this.labels);
    }
}
