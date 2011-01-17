package com.tinkerpop.gremlin.pipes;

import com.tinkerpop.pipes.AbstractPipe;
import groovy.lang.Closure;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class ForeachPipe<S> extends AbstractPipe<S, S> {

    private final Closure closure;

    public ForeachPipe(final Closure closure) {
        this.closure = closure;
    }

    public S processNextStart() {
        final S s = this.starts.next();
        this.closure.call(s);
        return s;
    }
}
