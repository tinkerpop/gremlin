package com.tinkerpop.gremlin.pipes.transform;

import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.pipes.AbstractPipe;
import com.tinkerpop.pipes.util.PipeHelper;

import java.util.Iterator;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public abstract class AbstractEdgesVerticesPipe extends AbstractPipe<Vertex, Vertex> {

    protected Iterator<Edge> nextEnds;
    protected final String[] labels;

    public AbstractEdgesVerticesPipe(final String... labels) {
        this.labels = labels;
    }

    public String toString() {
        return PipeHelper.makePipeString(this, this.labels);
    }

    public void reset() {
        this.nextEnds = null;
        super.reset();
    }
}
