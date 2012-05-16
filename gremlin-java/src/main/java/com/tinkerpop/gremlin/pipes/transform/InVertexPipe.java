package com.tinkerpop.gremlin.pipes.transform;

import com.tinkerpop.blueprints.Direction;
import com.tinkerpop.pipes.util.PipeHelper;

/**
 * InVertexPipe emits the incoming/target/head vertex of an edge.
 *
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class InVertexPipe extends EdgesVerticesPipe {

    public InVertexPipe() {
        super(Direction.IN);
    }

    public String toString() {
        return PipeHelper.makePipeString(this);
    }
}
