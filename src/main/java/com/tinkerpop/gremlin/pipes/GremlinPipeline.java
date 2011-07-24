package com.tinkerpop.gremlin.pipes;

import com.tinkerpop.gremlin.pipes.util.GroovyPipeClosure;
import com.tinkerpop.pipes.Pipe;
import com.tinkerpop.pipes.branch.LoopPipe;
import com.tinkerpop.pipes.filter.BackFilterPipe;
import com.tinkerpop.pipes.sideeffect.OptionalPipe;
import com.tinkerpop.pipes.sideeffect.SideEffectPipe;
import com.tinkerpop.pipes.transform.SideEffectCapPipe;
import com.tinkerpop.pipes.util.AsPipe;
import com.tinkerpop.pipes.util.MetaPipe;
import com.tinkerpop.pipes.util.Pipeline;
import groovy.lang.Closure;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class GremlinPipeline<S, E> implements Pipe<S, E>, MetaPipe {

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

    public void loopPipe(final int stepsAgo, final Closure closure) {
        this.addPipe(new LoopPipe(new Pipeline(this.getPipesStepsAgo(stepsAgo)), new GroovyPipeClosure(closure)));
        if (this.pipes.size() == 1)
            this.setStarts(this.starts);
    }

    public void loopPipe(final String name, final Closure closure) {
        this.addPipe(new LoopPipe(new Pipeline(this.getPipesAsAgo(name)), new GroovyPipeClosure(closure)));
        if (this.pipes.size() == 1)
            this.setStarts(this.starts);
    }


    public void backPipe(final int stepsAgo) {
        this.addPipe(new BackFilterPipe(new Pipeline(this.getPipesStepsAgo(stepsAgo))));
        if (this.pipes.size() == 1)
            this.setStarts(this.starts);
    }

    public void backPipe(final String name) {
        this.addPipe(new BackFilterPipe(new Pipeline(this.getPipesAsAgo(name))));
        if (this.pipes.size() == 1)
            this.setStarts(this.starts);
    }

    public void optionalPipe(final int stepsAgo) {
        this.addPipe(new OptionalPipe(new Pipeline(this.getPipesStepsAgo(stepsAgo))));
        if (this.pipes.size() == 1)
            this.setStarts(this.starts);
    }

    public void optionalPipe(final String name) {
        this.addPipe(new OptionalPipe(new Pipeline(this.getPipesAsAgo(name))));
        if (this.pipes.size() == 1)
            this.setStarts(this.starts);
    }

    public void asPipe(final String name) {
        this.addPipe(new AsPipe(name, this.getPipesStepsAgo(1).get(0)));
        if (this.pipes.size() == 1)
            this.setStarts(this.starts);
    }

    public List<AsPipe> getAsPipes() {
        return this.getAsPipes(this);
    }

    private List<AsPipe> getAsPipes(final MetaPipe metaPipe) {
        List<AsPipe> asPipes = new ArrayList<AsPipe>();
        for (final Pipe subPipe : metaPipe.getPipes()) {
            if (subPipe instanceof AsPipe) {
                asPipes.add((AsPipe) subPipe);
            }
            if (subPipe instanceof MetaPipe) {
                asPipes.addAll(this.getAsPipes((MetaPipe) subPipe));
            }
        }
        return asPipes;
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

    private List<Pipe> getPipesAsAgo(final String name) {
        final List<Pipe> backPipes = new ArrayList<Pipe>();
        for (int i = this.pipes.size() - 1; i >= 0; i--) {
            Pipe pipe = this.pipes.get(i);
            if (pipe instanceof AsPipe && ((AsPipe) pipe).getName().equals(name)) {
                break;
            } else {
                backPipes.add(0, pipe);
            }
        }
        for (int i = 0; i < backPipes.size(); i++) {
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

    public void reset() {
        this.endPipe.reset();
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
