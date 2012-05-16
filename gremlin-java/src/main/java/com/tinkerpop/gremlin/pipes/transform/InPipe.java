package com.tinkerpop.gremlin.pipes.transform;

import com.tinkerpop.blueprints.Direction;
import com.tinkerpop.pipes.util.PipeHelper;

/**
 * InPipe will emit vertices that are the head/target of the incoming edges to the current vertex.
 *
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class InPipe extends VerticesVerticesPipe {

    public InPipe(final String... labels) {
        super(Direction.IN, labels);
    }

    public String toString() {
        return PipeHelper.makePipeString(this, this.labels);
    }
}
