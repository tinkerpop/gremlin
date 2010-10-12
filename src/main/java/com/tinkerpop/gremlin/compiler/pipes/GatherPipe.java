package com.tinkerpop.gremlin.compiler.pipes;

import com.tinkerpop.pipes.AbstractPipe;
import com.tinkerpop.pipes.Pipe;
import com.tinkerpop.pipes.sideeffect.AggregatorPipe;
import com.tinkerpop.pipes.sideeffect.SideEffectCapPipe;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class GatherPipe extends AbstractPipe<Object, Object> {

    private final Pipe pipe = new SideEffectCapPipe(new AggregatorPipe(new LinkedList()));

    public void setStarts(Iterable starts) {
        this.pipe.setStarts(starts);
    }

    public void setStarts(Iterator starts) {
        this.pipe.setStarts(starts);
    }

    public Object processNextStart() {
        return this.pipe.next();
    }
}
