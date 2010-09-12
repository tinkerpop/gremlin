package com.tinkerpop.gremlin.compiler.pipes;

import com.tinkerpop.pipes.AbstractPipe;
import com.tinkerpop.pipes.PipeHelper;
import com.tinkerpop.pipes.filter.FilterPipe;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class GremlinRangeFilterPipe<S> extends AbstractPipe<S, S> implements FilterPipe<S> {

    private final Collection range;
    private int counter = -1;
    Iterator tempIterator = null;

    public GremlinRangeFilterPipe(Iterable range) {
        if (range instanceof Collection)
            this.range = (Collection) range;
        else {
            this.range = new HashSet();
            PipeHelper.fillCollection(range.iterator(), this.range);
        }
    }

    public void reset() {
        this.counter = -1;
    }

    protected S processNextStart() {
        if (null != this.tempIterator) {
            if (this.tempIterator.hasNext()) {
                return (S) this.tempIterator.next();
            } else {
                this.tempIterator = null;
            }
        }

        while (true) {
            S s = this.starts.next();
            this.counter++;
            if (this.range.contains(this.counter)) {
                if (s instanceof Iterable) {
                    this.tempIterator = ((Iterable) s).iterator();
                    return this.processNextStart();
                } else {
                    return s;
                }
            }
        }
    }


}
