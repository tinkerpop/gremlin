package com.tinkerpop.gremlin.pipes.transform;

import com.tinkerpop.blueprints.Direction;
import com.tinkerpop.pipes.util.PipeHelper;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class InEdgesPipe extends VerticesEdgesPipe {

    public InEdgesPipe(final String... labels) {
        super(Direction.IN, labels);
    }

    public String toString() {
        return PipeHelper.makePipeString(this, this.labels);
    }
}
