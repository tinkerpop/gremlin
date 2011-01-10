package com.tinkerpop.gremlin.pipes;

import com.tinkerpop.pipes.AbstractPipe;
import com.tinkerpop.pipes.filter.FilterPipe;
import groovy.lang.Closure;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class ClosureFilterPipe<S> extends AbstractPipe<S, S> implements FilterPipe<S> {

    private final Closure closure;

    public ClosureFilterPipe(final Closure closure) {
        this.closure = closure;
        this.closure.setDelegate(this);
    }

    public S processNextStart() {
        while (true) {
            final S start = this.starts.next();
            final Object result = closure.call(start);
            if (result instanceof Boolean) {
                if ((Boolean) result)
                    return start;
            } else if (null != result)
                return start;
        }
    }
}
