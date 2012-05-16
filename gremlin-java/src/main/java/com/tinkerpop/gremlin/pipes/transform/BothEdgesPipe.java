package com.tinkerpop.gremlin.pipes.transform;

import com.tinkerpop.blueprints.Direction;
import com.tinkerpop.pipes.util.PipeHelper;

/**
 * BothEdgesPipe emits both the outgoing and incoming edges of a vertex.
 *
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class BothEdgesPipe extends VerticesEdgesPipe {

    public BothEdgesPipe(final String... labels) {
        super(Direction.BOTH, labels);
    }

    public String toString() {
        return PipeHelper.makePipeString(this, this.labels);
    }
}
