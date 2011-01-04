package com.tinkerpop.gremlin.pipes;

import com.tinkerpop.pipes.AbstractPipe;
import com.tinkerpop.pipes.Pipe;
import com.tinkerpop.pipes.SingleIterator;
import com.tinkerpop.pipes.filter.FilterPipe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class AndFutureFilterPipe<S> extends AbstractPipe<S, S> implements FilterPipe<S> {

    private final List<Pipe<S, ?>> pipes = new ArrayList<Pipe<S, ?>>();

    public AndFutureFilterPipe(final Pipe<S, ?>... pipes) {
        this.pipes.addAll(Arrays.asList(pipes));
    }

    public S processNextStart() {
        while (true) {
            S s = this.starts.next();
            boolean and = true;
            for (Pipe<S, ?> pipe : this.pipes) {
                pipe.setStarts(new SingleIterator<S>(s));
                if (!pipe.hasNext()) {
                    and = false;
                    break;
                } else {
                    pipe.next();
                }
            }
            if (and)
                return s;
        }
    }

    public void addPipe(final Pipe<S, ?> pipe) {
        this.pipes.add(pipe);
    }

}