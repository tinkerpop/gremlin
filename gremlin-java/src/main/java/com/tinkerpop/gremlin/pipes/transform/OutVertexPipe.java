package com.tinkerpop.gremlin.pipes.transform;

import com.tinkerpop.blueprints.Direction;
import com.tinkerpop.pipes.util.PipeHelper;

/**
 * OutVertexPipe emits the outgoing/source/tail vertex of an edge.
 *
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class OutVertexPipe extends EdgesVerticesPipe {

    public OutVertexPipe() {
        super(Direction.OUT);
    }

    public String toString() {
        return PipeHelper.makePipeString(this);
    }
}
