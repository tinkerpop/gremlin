package com.tinkerpop.gremlin.groovy;

import com.tinkerpop.pipes.AbstractPipe;
import com.tinkerpop.pipes.filter.FilterPipe;
import groovy.lang.Closure;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class ClosureFilterPipe<S> extends AbstractPipe<S, S> implements FilterPipe<S> {

    private final Closure closure;

    public ClosureFilterPipe(Closure closure) {
        this.closure = closure;
    }

    public S processNextStart() {
        while (true) {
            S start = this.starts.next();
            if ((Boolean) closure.call(start))
                return start;
        }
    }
}
