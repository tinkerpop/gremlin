package com.tinkerpop.gremlin.pipes.transform;

import com.tinkerpop.blueprints.Direction;
import com.tinkerpop.pipes.util.PipeHelper;

/**
 * BothVerticesPipe emits both vertices connected the the edge.
 *
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class BothVerticesPipe extends EdgesVerticesPipe {

    public BothVerticesPipe() {
        super(Direction.BOTH);
    }

    public String toString() {
        return PipeHelper.makePipeString(this);
    }
}
