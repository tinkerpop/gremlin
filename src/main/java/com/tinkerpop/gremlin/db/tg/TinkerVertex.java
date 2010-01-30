package com.tinkerpop.gremlin.db.tg;

import com.tinkerpop.gremlin.db.StringFactory;
import com.tinkerpop.gremlin.model.Edge;
import com.tinkerpop.gremlin.model.Vertex;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class TinkerVertex extends TinkerElement implements Vertex {

    protected Set<Edge> outEdges = new HashSet<Edge>();
    protected Set<Edge> inEdges = new HashSet<Edge>();

    protected TinkerVertex(final String id, final TinkerIndex index) {
        super(id, index);
    }

    public Iterable<Edge> getOutEdges() {
        return this.outEdges;
    }

    public Iterable<Edge> getInEdges() {
        return this.inEdges;
    }

    public String toString() {
        return StringFactory.vertexString(this);
    }

    public boolean equals(final Object object) {
        return object instanceof TinkerVertex && ((TinkerVertex) object).getId().equals(this.getId());
    }
}
