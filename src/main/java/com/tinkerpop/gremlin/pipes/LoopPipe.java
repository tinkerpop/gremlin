package com.tinkerpop.gremlin.pipes;

import com.tinkerpop.gremlin.pipes.util.Bundle;
import com.tinkerpop.gremlin.pipes.util.ExpandableBundleIterator;
import com.tinkerpop.pipes.AbstractPipe;
import com.tinkerpop.pipes.Pipe;
import groovy.lang.Closure;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class LoopPipe<S> extends AbstractPipe<S, S> {

    private final Closure doLoopClosure;
    private final Pipe<S, S> toLoopPipe;
    private ExpandableBundleIterator<S> expando;

    public LoopPipe(final Pipe<S, S> toLoopPipe, final Closure doLoopClosure) {
        this.toLoopPipe = toLoopPipe;
        this.doLoopClosure = doLoopClosure;
        this.doLoopClosure.setDelegate(this);
    }

    protected S processNextStart() {
        while (true) {
            final S s = this.toLoopPipe.next();
            final Bundle<S> bundle = new Bundle<S>(s, this.getPath(), this.getLoops());
            if ((Boolean) doLoopClosure.call(bundle)) {
                this.expando.add(bundle);
            } else {
                return s;
            }
        }
    }

    public void setStarts(final Iterator<S> iterator) {
        this.expando = new ExpandableBundleIterator<S>(iterator);
        this.toLoopPipe.setStarts(this.expando);
    }

    public String toString() {
        return super.toString() + "<" + this.toLoopPipe + ">";
    }

    public int getLoops() {
        return this.expando.getCurrentLoops() + 1;
    }

    public List getPath() {
        final List path = new ArrayList();
        final List currentPath = this.expando.getCurrentPath();
        if (null != currentPath)
            path.addAll(currentPath);
        path.addAll(this.toLoopPipe.getPath());
        return path;
    }


}
