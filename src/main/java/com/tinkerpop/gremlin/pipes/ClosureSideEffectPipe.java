package com.tinkerpop.gremlin.pipes;

import com.tinkerpop.pipes.AbstractPipe;
import groovy.lang.Closure;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class ClosureSideEffectPipe<S> extends AbstractPipe<S, S> {

    private final Closure closure;

    public ClosureSideEffectPipe(final Closure closure) {
        this.closure = closure;
        this.closure.setDelegate(this);
    }

    public S processNextStart() {
        final S s = this.starts.next();
        this.closure.call(s);
        return s;
    }
}
