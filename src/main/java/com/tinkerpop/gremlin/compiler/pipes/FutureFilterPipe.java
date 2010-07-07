package com.tinkerpop.gremlin.compiler.pipes;

import com.tinkerpop.pipes.AbstractPipe;
import com.tinkerpop.pipes.Pipe;
import com.tinkerpop.pipes.SingleIterator;
import com.tinkerpop.pipes.filter.FilterPipe;

import java.util.NoSuchElementException;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class FutureFilterPipe<S> extends AbstractPipe<S, S> implements FilterPipe<S> {

    private final Pipe<S, ?> pipe;

    public FutureFilterPipe(final Pipe<S, ?> pipe) {
        this.pipe = pipe;
    }

    public S processNextStart() {
        while (this.starts.hasNext()) {
            S s = this.starts.next();
            pipe.setStarts(new SingleIterator<S>(s));
            if (pipe.hasNext()) {
                return s;
            }
        }
        throw new NoSuchElementException();
    }
}
