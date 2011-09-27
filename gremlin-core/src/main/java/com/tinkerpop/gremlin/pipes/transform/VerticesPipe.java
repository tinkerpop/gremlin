package com.tinkerpop.gremlin.pipes.transform;

import com.tinkerpop.blueprints.pgm.Vertex;
import com.tinkerpop.pipes.util.PipeHelper;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class VerticesPipe extends GraphElementPipe<Vertex> {

    public VerticesPipe() {
        super(ElementType.VERTEX);
    }

    public String toString() {
        return PipeHelper.makePipeString(this);
    }
}
