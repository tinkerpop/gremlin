package com.tinkerpop.gremlin.db.tg;

import com.tinkerpop.gremlin.db.StringFactory;
import com.tinkerpop.gremlin.model.Edge;
import com.tinkerpop.gremlin.model.Vertex;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
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

    public String toString() {
        return StringFactory.edgeString(this);
    }

    public boolean equals(final Object object) {
        return object instanceof TinkerEdge && ((TinkerEdge) object).getId().equals(this.getId());
    }

}
