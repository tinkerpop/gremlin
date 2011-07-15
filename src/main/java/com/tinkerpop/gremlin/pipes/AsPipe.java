package com.tinkerpop.gremlin.pipes;

import com.tinkerpop.pipes.AbstractPipe;
import com.tinkerpop.pipes.MetaPipe;
import com.tinkerpop.pipes.Pipe;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * An AsPipe wraps a Pipe and provides it a name and 'peak back' access to the last emitted end.
 *
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class AsPipe<S, E> extends AbstractPipe<S, E> implements MetaPipe {

    private final String name;
    private final Pipe<S, E> pipe;

    public AsPipe(final String name, final Pipe<S, E> pipe) {
        this.pipe = pipe;
        this.name = name;
    }

    public void setStarts(final Iterator<S> starts) {
        this.pipe.setStarts((Iterator) starts);
        this.starts = starts;
    }

    protected List getPathToHere() {
        return this.pipe.getPath();
    }

    public E getCurrentEnd() {
        return this.currentEnd;
    }

    public String getName() {
        return this.name;
    }

    public E processNextStart() {
        return this.pipe.next();
    }

    public List<Pipe> getPipes() {
        return (List) Arrays.asList(this.pipe);
    }


    public String toString() {
        return super.toString() + "(" + this.name + ")[" + this.pipe + "]";
    }

    public void reset() {
        this.pipe.reset();
        super.reset();
    }

}
