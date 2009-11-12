package com.tinkerpop.gremlin.db.tg;

import com.tinkerpop.gremlin.Edge;
import com.tinkerpop.gremlin.Vertex;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class TinkerEdge extends TinkerElement implements Edge {

    protected String label;
    protected Vertex inVertex;
    protected Vertex outVertex;

    public TinkerEdge(Vertex outVertex, Vertex inVertex, String label) {
        super();
        this.label = label;
        this.outVertex = outVertex;
        this.inVertex = inVertex;
    }

    public String getLabel() {
        return this.label;
    }

    public Vertex getVertex(Vertex.Direction direction) {
        if (direction == Vertex.Direction.OUT)
            return this.outVertex;
        else
            return this.inVertex;
    }

}
