package com.tinkerpop.gremlin.pipes;

import com.tinkerpop.pipes.AbstractPipe;
import groovy.lang.Closure;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class EmitPipe<S, E> extends AbstractPipe<S, E> {

    private final Closure closure;

    public EmitPipe(final Closure closure) {
        this.closure = closure;
        this.closure.setDelegate(this);
    }

    public E processNextStart() {
        final S s = this.starts.next();
        return (E) this.closure.call(s);
    }
}