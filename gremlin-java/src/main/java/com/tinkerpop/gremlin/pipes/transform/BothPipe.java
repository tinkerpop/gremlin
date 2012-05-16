package com.tinkerpop.gremlin.pipes.transform;

import com.tinkerpop.blueprints.Direction;
import com.tinkerpop.pipes.util.PipeHelper;

/**
 * BothPipe will emit those vertices adjacent to the incoming and outgoing edges of the incoming vertex.
 *
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class BothPipe extends VerticesVerticesPipe {

    public BothPipe(final String... labels) {
        super(Direction.BOTH, labels);
    }

    public String toString() {
        return PipeHelper.makePipeString(this, this.labels);
    }
}
