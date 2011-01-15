package com.tinkerpop.gremlin.pipes.util;

import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class Bundle<T> {

    private final List path;
    private final T t;

    public Bundle(final T t, final List path) {
        this.t = t;
        this.path = path;
        // remove the join object
        this.path.remove(this.path.size() - 1);
    }

    public List getPath() {
        return this.path;
    }

    public T getObject() {
        return this.t;
    }
}