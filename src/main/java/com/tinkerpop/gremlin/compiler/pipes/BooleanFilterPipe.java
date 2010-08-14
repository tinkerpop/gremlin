package com.tinkerpop.gremlin.compiler.pipes;

import com.tinkerpop.pipes.AbstractPipe;
import com.tinkerpop.pipes.filter.FilterPipe;

/**
 * [true]
 *
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class BooleanFilterPipe<S> extends AbstractPipe<S, S> implements FilterPipe<S> {

    private final boolean filter;

    public BooleanFilterPipe(final boolean filter) {
        this.filter = filter;
    }

    public S processNextStart() {
        while (true) {
            if (this.filter) {
                this.starts.next();
            } else {
                return this.starts.next();
            }
        }
    }
}
