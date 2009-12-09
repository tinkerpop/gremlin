package com.tinkerpop.gremlin.db.tg;

import com.tinkerpop.gremlin.model.Edge;
import com.tinkerpop.gremlin.model.Vertex;

import java.util.List;
import java.util.ArrayList;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class TinkerEdge extends TinkerElement implements Edge {

    private final String label;
    private final Vertex inVertex;
    private final Vertex outVertex;

    protected TinkerEdge(String id, Vertex outVertex, Vertex inVertex, String label, TinkerIndex index) {
        super(id, index);
        this.label = label;
        this.outVertex = outVertex;
        this.inVertex = inVertex;
    }

    public String getLabel() {
        return this.label;
    }

    public Vertex getOutVertex() {
        return this.outVertex;
    }

    public Vertex getInVertex() {
        return this.inVertex;
    }

    public List<Vertex> getBothVertices() {
        List<Vertex> bothVertices = new ArrayList<Vertex>();
        bothVertices.add(this.outVertex);
        bothVertices.add(this.inVertex);
        return bothVertices;
    }

    public String toString() {
        return "e[" + this.id + "][" + this.outVertex.getId() + "-" + this.label + "->" + this.inVertex.getId() + "]";
    }

    public boolean equals(Object object) {
        if(object instanceof TinkerEdge)
            return object.hashCode() == this.hashCode();
        else
            return false;
    }

}
