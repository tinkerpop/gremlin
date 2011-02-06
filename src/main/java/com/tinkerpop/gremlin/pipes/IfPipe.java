package com.tinkerpop.gremlin.pipes;

import com.tinkerpop.pipes.AbstractPipe;
import groovy.lang.Closure;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class IfPipe<S, E> extends AbstractPipe<S, E> {

    private final Closure ifClosure;
    private final Closure thenClosure;
    private final Closure elseClosure;

    public IfPipe(final Closure ifClosure, final Closure thenClosure, final Closure elseClosure) {
        this.ifClosure = ifClosure;
        this.thenClosure = thenClosure;
        this.elseClosure = elseClosure;

        this.ifClosure.setDelegate(this);
        this.thenClosure.setDelegate(this);
        if (null != this.elseClosure)
            this.elseClosure.setDelegate(this);
    }

    public IfPipe(final Closure ifClosure, final Closure thenClosure) {
        this(ifClosure, thenClosure, null);
    }

    public E processNextStart() {
        while (true) {
            final S s = this.starts.next();
            if ((Boolean) this.ifClosure.call(s)) {
                return (E) this.thenClosure.call(s);
            } else if (null != this.elseClosure) {
                return (E) this.elseClosure.call(s);
            }
        }
    }
}