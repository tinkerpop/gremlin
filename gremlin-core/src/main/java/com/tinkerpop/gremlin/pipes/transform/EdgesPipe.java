package com.tinkerpop.gremlin.pipes.transform;

import com.tinkerpop.blueprints.pgm.Edge;
import com.tinkerpop.pipes.util.PipeHelper;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class EdgesPipe extends GraphElementPipe<Edge> {

    public EdgesPipe() {
        super(ElementType.EDGE);
    }

    public String toString() {
        return PipeHelper.makePipeString(this);
    }
}
