package com.tinkerpop.gremlin.pipes.transform;

import com.tinkerpop.blueprints.pgm.Edge;
import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.pipes.AbstractPipe;
import com.tinkerpop.pipes.util.EmptyIterator;
import com.tinkerpop.pipes.util.PipeHelper;

import java.util.Iterator;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class EdgesPipe extends AbstractPipe<Graph, Edge> {

    protected Iterator<Edge> nextEnds = new EmptyIterator<Edge>();

    protected Edge processNextStart() {
        while (true) {
            if (null != this.nextEnds && this.nextEnds.hasNext()) {
                return this.nextEnds.next();
            } else {
                this.nextEnds = this.starts.next().getEdges().iterator();
            }
        }
    }

    public void reset() {
        super.reset();
        this.nextEnds = new EmptyIterator<Edge>();
    }

    public String toString() {
        return PipeHelper.makePipeString(this);
    }
}
