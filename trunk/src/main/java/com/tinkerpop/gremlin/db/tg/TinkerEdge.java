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

    public TinkerEdge(String id, Vertex outVertex, Vertex inVertex, String label) {
        super(id);
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

    public Vertex getOutVertex() {
        return this.outVertex;
    }

    public Vertex getInVertex() {
        return this.inVertex;
    }

    public String toString() {
        return "e[" + this.id + "][" + ((TinkerVertex) this.outVertex).getId() + "-" + this.label + "->" + ((TinkerVertex) this.inVertex).getId() + "]";
    }

    public boolean equals(Object object) {
        if(object instanceof TinkerEdge)
            return object.hashCode() == this.hashCode();
        else
            return false;
    }

}
