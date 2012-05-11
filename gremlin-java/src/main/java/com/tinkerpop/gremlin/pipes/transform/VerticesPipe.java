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

    private String key;

    private Object value;

    public VerticesPipe(){
        this.key = null;
        this.value = null;
    }

    public VerticesPipe(final String key, final Object value){
        this.key = key;
        this.value = value;
    }

    protected Vertex processNextStart() {
        while (true) {
            if (null != this.nextEnds && this.nextEnds.hasNext()) {
                return this.nextEnds.next();
            } else {
                if (this.key == null) {
                    this.nextEnds = this.starts.next().getVertices().iterator();
                } else {
                    this.nextEnds = this.starts.next().getVertices(this.key, this.value).iterator();
                }
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
