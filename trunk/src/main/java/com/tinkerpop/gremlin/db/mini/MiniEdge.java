package com.tinkerpop.gremlin.db.mini;

import com.tinkerpop.gremlin.Edge;
import com.tinkerpop.gremlin.Vertex;

import java.util.UUID;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class MiniEdge extends MiniElement implements Edge {

    protected String label;
    protected Vertex inVertex;
    protected Vertex outVertex;

    public MiniEdge(Vertex outVertex, Vertex inVertex, String label) {
        super();
        this.label = label;
        this.outVertex = outVertex;
        this.inVertex = inVertex;
    }

    public String getLabel() {
        return this.label;
    }

    public Vertex getVertex(Vertex.Direction direction) {
        if(direction == Vertex.Direction.OUT)
            return this.outVertex;
        else
            return this.inVertex;
    }

}
