package com.tinkerpop.gremlin.pipes;

import com.tinkerpop.pipes.AbstractPipe;
import com.tinkerpop.pipes.MetaPipe;
import com.tinkerpop.pipes.Pipe;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class AsPipe<S> extends AbstractPipe<S, S> implements MetaPipe {

    private final String name;
    private final Pipe<?, S> pipe;

    public AsPipe(String name, Pipe<?, S> pipe) {
        this.pipe = pipe;
        this.name = name;
    }

    public void setStarts(final Iterator<S> starts) {
        this.pipe.setStarts((Iterator) starts);
        this.starts = starts;
    }

    public void setStarts(final Iterable<S> starts) {
        this.setStarts(starts.iterator());
    }

    protected List getPathToHere() {
        return this.pipe.getPath();
    }

    public S getCurrentEnd() {
        return this.currentEnd;
    }

    public String getName() {
        return this.name;
    }

    public S processNextStart() {
        return this.pipe.next();
    }

    public List<Pipe> getPipes() {
        return (List) Arrays.asList(this.pipe);
    }


    public String toString() {
        return super.toString() + "(" + this.name + ")[" + this.pipe + "]";
    }

}
