package com.tinkerpop.gremlin.pipes;

import com.tinkerpop.pipes.AbstractPipe;
import com.tinkerpop.pipes.ExpandableIterator;
import com.tinkerpop.pipes.Pipe;
import groovy.lang.Closure;

import java.util.Iterator;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class LoopPipe<S> extends AbstractPipe<S, S> {

    private final Closure doLoopClosure;
    private final Pipe<S, S> toLoopPipe;
    private ExpandableIterator<S> expando;

    public LoopPipe(final Pipe<S, S> toLoopPipe, final Closure doLoopClosure) {
        this.toLoopPipe = toLoopPipe;
        this.doLoopClosure = doLoopClosure;
    }

    protected S processNextStart() {
        while (true) {
            final S e = this.toLoopPipe.next();
            if ((Boolean) doLoopClosure.call(e)) {
                this.expando.add(e);
            } else {
                return e;
            }
        }
    }

    public void setStarts(Iterator iterator) {
        this.expando = new ExpandableIterator<S>(iterator);
        this.toLoopPipe.setStarts(this.expando);
    }
}
