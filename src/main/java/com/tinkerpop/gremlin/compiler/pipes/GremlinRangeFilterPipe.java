package com.tinkerpop.gremlin.compiler.pipes;

import com.tinkerpop.pipes.AbstractPipe;
import com.tinkerpop.pipes.filter.FilterPipe;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class GremlinRangeFilterPipe<S> extends AbstractPipe<S, S> implements FilterPipe<S> {

    private final int low;
    private final int high;
    private int counter = -1;
    Iterator tempInterator = null;

    public GremlinRangeFilterPipe(final int low, final int high) {
        this.low = low;
        this.high = high;
        if (this.low != -1 && this.high != -1 && this.low > this.high) {
            throw new IllegalArgumentException("Not a legal range: [" + low + ", " + high + "]");
        }
    }

    public void reset() {
        this.counter = -1;
    }

    protected S processNextStart() {
        if (null != this.tempInterator) {
            if (this.tempInterator.hasNext()) {
                return (S) this.tempInterator.next();
            } else {
                this.tempInterator = null;
            }
        }

        while (this.starts.hasNext()) {
            S s = this.starts.next();
            this.counter++;
            if ((this.low == -1 || this.counter >= this.low) && (this.high == -1 || this.counter < this.high)) {
                if (s instanceof Iterable) {
                    this.tempInterator = ((Iterable) s).iterator();
                    return this.processNextStart();
                } else {
                    return s;
                }
            }
        }
        throw new NoSuchElementException();
    }
}
