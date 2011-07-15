package com.tinkerpop.gremlin.pipes;

import com.tinkerpop.pipes.AbstractPipe;
import groovy.lang.Closure;

import java.util.Iterator;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class IfThenElsePipe<S, E> extends AbstractPipe<S, E> {

    private final Closure ifClosure;
    private final Closure thenClosure;
    private final Closure elseClosure;
    private Iterator<E> itty = null;

    public IfThenElsePipe(final Closure ifClosure, final Closure thenClosure, final Closure elseClosure) {
        this.ifClosure = ifClosure;
        this.thenClosure = thenClosure;
        this.elseClosure = elseClosure;

        this.ifClosure.setDelegate(this);
        this.thenClosure.setDelegate(this);
        if (null != this.elseClosure)
            this.elseClosure.setDelegate(this);
    }

    public IfThenElsePipe(final Closure ifClosure, final Closure thenClosure) {
        this(ifClosure, thenClosure, null);
    }

    public E processNextStart() {
        while (true) {
            if (null != itty && itty.hasNext()) {
                return itty.next();
            } else {
                final S s = this.starts.next();
                if ((Boolean) this.ifClosure.call(s)) {
                    Object e = this.thenClosure.call(s);
                    if (e instanceof Iterable) {
                        itty = ((Iterable<E>) e).iterator();
                    } else if (e instanceof Iterator) {
                        itty = (Iterator<E>) e;
                    } else {
                        return (E) e;
                    }
                } else if (null != this.elseClosure) {
                    Object e = this.elseClosure.call(s);
                    if (e instanceof Iterable) {
                        itty = ((Iterable<E>) e).iterator();
                    } else if (e instanceof Iterator) {
                        itty = (Iterator<E>) e;
                    } else {
                        return (E) e;
                    }
                }
            }
        }
    }

    public void reset() {
        this.itty = null;
        super.reset();
    }
}