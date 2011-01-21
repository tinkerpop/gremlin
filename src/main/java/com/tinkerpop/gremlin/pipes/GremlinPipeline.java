package com.tinkerpop.gremlin.pipes;

import com.tinkerpop.pipes.Pipe;
import com.tinkerpop.pipes.Pipeline;
import com.tinkerpop.pipes.filter.FutureFilterPipe;
import com.tinkerpop.pipes.sideeffect.SideEffectCapPipe;
import com.tinkerpop.pipes.sideeffect.SideEffectPipe;
import groovy.lang.Closure;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class GremlinPipeline<S, E> implements Pipe<S, E> {

    private Pipe<S, ?> startPipe;
    private Pipe<?, E> endPipe;
    private final List<Pipe> pipes = new ArrayList<Pipe>();
    private Iterator<S> starts;


    public List<Pipe> getPipes() {
        return this.pipes;
    }

    public void capPipe(final int indexOfPipe) {
        final SideEffectPipe pipe = (SideEffectPipe) this.pipes.get(indexOfPipe);
        this.pipes.remove(indexOfPipe);
        final Pipe cap = new SideEffectCapPipe(pipe);
        this.pipes.add(indexOfPipe, cap);
        this.setPipes(this.pipes);
    }

    public void loopPipe(final Closure closure) {
        this.loopPipe(this.pipes.size(), closure);
    }

    public void loopPipe(final int stepsAgo, final Closure closure) {
        this.addPipe(new LoopPipe(new Pipeline(this.getPipesStepsAgo(stepsAgo)), closure));
        if (this.pipes.size() == 1)
            this.setStarts(this.starts);
    }

    public void backPipe(final int stepsAgo) {
        this.addPipe(new FutureFilterPipe(new Pipeline(this.getPipesStepsAgo(stepsAgo))));
        if (this.pipes.size() == 1)
            this.setStarts(this.starts);
    }

    private List<Pipe> getPipesStepsAgo(final int stepsAgo) {
        final List<Pipe> backPipes = new ArrayList<Pipe>();
        for (int i = this.pipes.size() - 1; i > ((this.pipes.size() - 1) - stepsAgo); i--) {
            backPipes.add(0, this.pipes.get(i));
        }
        for (int i = 0; i < stepsAgo; i++) {
            this.pipes.remove(this.pipes.size() - 1);
        }
        return backPipes;
    }

    public int size() {
        return this.pipes.size();
    }

    public void addPipe(final Pipe pipe) {
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
        this.starts = starts;
        this.startPipe.setStarts(starts);
    }

    public void setStarts(final Iterable<S> starts) {
        this.setStarts(starts.iterator());
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }


    public boolean hasNext() {
        return this.endPipe.hasNext();
    }


    public E next() {
        return this.endPipe.next();
    }

    public List getPath() {
        return this.endPipe.getPath();
    }

    public Iterator<E> iterator() {
        return this;
    }

    public String toString() {
        return this.pipes.toString();
    }

    public boolean equals(final Object object) {
        if (!(object instanceof GremlinPipeline))
            return false;
        else {
            final GremlinPipeline pipe = (GremlinPipeline) object;
            if (pipe.hasNext() != this.hasNext())
                return false;

            while (this.hasNext()) {
                if (!pipe.hasNext())
                    return false;

                if (pipe.next() != this.next())
                    return false;
            }
            return true;
        }
    }
}
