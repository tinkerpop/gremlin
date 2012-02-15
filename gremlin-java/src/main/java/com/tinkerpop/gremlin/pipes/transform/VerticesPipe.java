package com.tinkerpop.gremlin.pipes.transform;

import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.Vertex;
import com.tinkerpop.pipes.AbstractPipe;
import com.tinkerpop.pipes.util.PipeHelper;

import java.util.Iterator;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class VerticesPipe extends AbstractPipe<Graph, Vertex> {

    protected Iterator<Vertex> nextEnds = PipeHelper.emptyIterator();

    protected Vertex processNextStart() {
        while (true) {
            if (null != this.nextEnds && this.nextEnds.hasNext()) {
                return this.nextEnds.next();
            } else {
                this.nextEnds = this.starts.next().getVertices().iterator();
            }
        }
    }

    public void reset() {
        super.reset();
        this.nextEnds = PipeHelper.emptyIterator();
    }

    public String toString() {
        return PipeHelper.makePipeString(this);
    }
}
