package com.tinkerpop.gremlin.pipes;

import com.tinkerpop.gremlin.pipes.util.Bundle;
import com.tinkerpop.gremlin.pipes.util.ExpandableBundleIterator;
import com.tinkerpop.pipes.AbstractPipe;
import com.tinkerpop.pipes.MetaPipe;
import com.tinkerpop.pipes.Pipe;
import groovy.lang.Closure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class LoopPipe<S> extends AbstractPipe<S, S> implements MetaPipe {

    private final Closure closure;
    private final Pipe<S, S> pipe;
    private ExpandableBundleIterator<S> expando;

    public LoopPipe(final Pipe<S, S> pipe, final Closure closure) {
        this.pipe = pipe;
        this.closure = closure;
        this.closure.setDelegate(this);
    }

    protected S processNextStart() {
        while (true) {
            final S s = this.pipe.next();
            final Bundle<S> bundle = new Bundle<S>(s, this.getPath(), this.getLoops());
            if ((Boolean) closure.call(bundle)) {
                this.expando.add(bundle);
            } else {
                return s;
            }
        }
    }

    public List<Pipe> getPipes() {
        return (List) Arrays.asList(pipe);
    }

    public void setStarts(final Iterator<S> iterator) {
        this.expando = new ExpandableBundleIterator<S>(iterator);
        this.pipe.setStarts(this.expando);
    }

    public String toString() {
        return super.toString() + "[" + this.pipe + "]";
    }

    public int getLoops() {
        return this.expando.getCurrentLoops() + 1;
    }

    public List getPath() {
        final List path = new ArrayList();
        final List currentPath = this.expando.getCurrentPath();
        if (null != currentPath)
            path.addAll(currentPath);
        path.addAll(this.pipe.getPath());
        return path;
    }

}
