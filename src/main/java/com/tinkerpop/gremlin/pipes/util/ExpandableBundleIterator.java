package com.tinkerpop.gremlin.pipes.util;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class ExpandableBundleIterator<T> implements Iterator<T> {

    private final Queue<Bundle<T>> queue = new LinkedList<Bundle<T>>();
    private final Iterator<T> iterator;
    private Bundle<T> current;

    public ExpandableBundleIterator(final Iterator<T> iterator) {
        this.iterator = iterator;
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }

    public T next() {
        if (this.queue.isEmpty()) {
            this.current = null;
            return iterator.next();
        } else {
            this.current = this.queue.remove();
            return this.current.getObject();
        }
    }

    public boolean hasNext() {
        return !this.queue.isEmpty() || this.iterator.hasNext();
    }

    public void add(final T t, final List path, final int loops) {
        Bundle<T> bundle = new Bundle<T>(t, path, loops);
        this.queue.add(bundle);
    }

    public List getCurrentPath() {
        if (null == this.current)
            return null;
        else
            return this.current.getPath();

    }

    public int getCurrentLoops() {
        if (null == this.current)
            return 1;
        else
            return this.current.getLoops();
    }
}
