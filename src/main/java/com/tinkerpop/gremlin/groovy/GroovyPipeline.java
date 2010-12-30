package com.tinkerpop.gremlin.groovy;

import com.tinkerpop.pipes.IdentityPipe;
import com.tinkerpop.pipes.Pipe;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class GroovyPipeline<S, E> implements Pipe<S, E> {

    private Pipe<S, ?> startPipe;
    private Pipe<?, E> endPipe;
    private List<Pipe> pipes = new ArrayList<Pipe>();


    public List<Pipe> getPipes() {
        return this.pipes;
    }

    public void addPipe(Pipe pipe) {
        this.pipes.add(pipe);
        this.setPipes(this.pipes);

    }
    private void setPipes(final List<Pipe> pipes) {
        this.startPipe = (Pipe<S, ?>) pipes.get(0);
        this.endPipe = (Pipe<?, E>) pipes.get(pipes.size() - 1);
        for (int i = 1; i < pipes.size(); i++) {
            pipes.get(i).setStarts((Iterator) pipes.get(i - 1));
        }
    }

    public void setStarts(final Iterator<S> starts) {
        this.startPipe.setStarts(starts);
    }

    public void setStarts(final Iterable<S> starts) {
        this.setStarts(starts.iterator());
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }


    public boolean hasNext() {
        return endPipe.hasNext();
    }


    public E next() {
        return endPipe.next();
    }

    public void enablePath() {
        endPipe.enablePath();
    }

    public List getPath() {
        return endPipe.getPath();
    }

    public Iterator<E> iterator() {
        return this;
    }
}
