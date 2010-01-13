package com.tinkerpop.gremlin.db.tg;

import com.tinkerpop.gremlin.model.Edge;
import com.tinkerpop.gremlin.model.Vertex;
import com.tinkerpop.gremlin.db.StringFactory;

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

    protected TinkerEdge(final String id, final Vertex outVertex, final Vertex inVertex, final String label, final TinkerIndex index) {
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
        return StringFactory.edgeString(this);
    }

    public boolean equals(final Object object) {
        if(object instanceof TinkerEdge)
            return object.hashCode() == this.hashCode();
        else
            return false;
    }

}
