package com.tinkerpop.gremlin.groovy;

import com.tinkerpop.pipes.AbstractPipe;
import groovy.lang.Closure;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class ClosurePipe<S, E> extends AbstractPipe<S, E> {

    private final Closure closure;

    public ClosurePipe(final Closure closure) {
        this.closure = closure;
        this.closure.setDelegate(this);
    }

    public E processNextStart() {
        return (E) this.closure.call();
    }
}
