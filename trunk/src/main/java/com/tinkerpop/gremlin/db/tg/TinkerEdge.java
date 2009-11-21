package com.tinkerpop.gremlin.db.tg;

import com.tinkerpop.gremlin.model.Edge;
import com.tinkerpop.gremlin.model.Vertex;

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

    public void setLabel(String label) {
        this.label = label;
    }

    public Vertex getVertex(Vertex.Direction direction) {
        if (direction == Direction.OUT)
            return this.outVertex;
        else
            return this.inVertex;
    }

    public String toString() {
        return ((TinkerVertex) this.outVertex).getId() + "--" + this.label + "-->" + ((TinkerVertex) this.inVertex).getId();
    }

    public boolean equals(Object object) {
        if(object instanceof TinkerEdge)
            return object.hashCode() == this.hashCode();
        else
            return false;
    }

}
