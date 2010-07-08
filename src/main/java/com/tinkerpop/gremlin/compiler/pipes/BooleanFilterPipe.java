package com.tinkerpop.gremlin.compiler.pipes;

import com.tinkerpop.pipes.AbstractPipe;
import com.tinkerpop.pipes.filter.FilterPipe;

import java.util.NoSuchElementException;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class BooleanFilterPipe<S> extends AbstractPipe<S, S> implements FilterPipe<S> {

    private final boolean filter;

    public BooleanFilterPipe(final boolean filter) {
        this.filter = filter;
    }

    public S processNextStart() {
        if (this.filter) {
            throw new NoSuchElementException();
        } else {
            return this.starts.next();
        }
    }
}
