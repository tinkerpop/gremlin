package com.tinkerpop.gremlin.pipes;

import com.tinkerpop.pipes.Pipe;
import com.tinkerpop.pipes.sideeffect.SideEffectCapPipe;
import com.tinkerpop.pipes.sideeffect.SideEffectPipe;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class GremlinPipeline<S, E> implements Pipe<S, E> {

    private static final String GREMLIN_PIPELINE = "GremlinPipeline";
    private Pipe<S, ?> startPipe;
    private Pipe<?, E> endPipe;
    private final List<Pipe> pipes = new ArrayList<Pipe>();


    public List<Pipe> getPipes() {
        return this.pipes;
    }

    public void capPipe(int indexOfPipe) {
        SideEffectPipe pipe = (SideEffectPipe) this.pipes.get(indexOfPipe);
        this.pipes.remove(indexOfPipe);
        Pipe cap = new SideEffectCapPipe(pipe);
        this.pipes.add(indexOfPipe, cap);
        this.setPipes(this.pipes);
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

    public String toString() {
        return GREMLIN_PIPELINE + this.getShortPipelineNotation();
    }

    public boolean equals(final Object object) {
        if (!(object instanceof GremlinPipeline))
            return false;
        else {
            GremlinPipeline pipe = (GremlinPipeline) object;
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

    private String getShortPipelineNotation() {
        StringBuilder sb = new StringBuilder("[");
        for (Pipe pipe : this.pipes) {
            String pipeString = pipe.toString();
            pipeString = pipeString.substring(0, pipeString.indexOf("@"));
            pipeString = pipeString.substring(pipeString.lastIndexOf(".") + 1);
            sb.append(pipeString).append(",");
        }
        return sb.toString().substring(0, sb.length() - 1) + "]";

    }
}
