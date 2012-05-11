package com.tinkerpop.gremlin.pipes.transform;

import com.tinkerpop.blueprints.pgm.Edge;
import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.pipes.AbstractPipe;
import com.tinkerpop.pipes.util.PipeHelper;

import java.util.Iterator;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class EdgesPipe extends AbstractPipe<Graph, Edge> {

    protected Iterator<Edge> nextEnds = PipeHelper.emptyIterator();
    
    private String key;
    
    private Object value;
    
    public EdgesPipe(){
        this.key = null;
        this.value = null;
    }
    
    public EdgesPipe(final String key, final Object value){
        this.key = key;
        this.value = value;
    }

    protected Edge processNextStart() {
        while (true) {
            if (null != this.nextEnds && this.nextEnds.hasNext()) {
                return this.nextEnds.next();
            } else {
                if (this.key == null) {
                    this.nextEnds = this.starts.next().getEdges().iterator();
                } else {
                    this.nextEnds = this.starts.next().getEdges(this.key, this.value).iterator();
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
