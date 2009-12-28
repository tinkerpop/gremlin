package com.tinkerpop.gremlin.db.tg;

import com.tinkerpop.gremlin.model.Edge;
import com.tinkerpop.gremlin.model.Vertex;
import com.tinkerpop.gremlin.db.StringFactory;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class TinkerVertex extends TinkerElement implements Vertex {

    protected Set<Edge> outEdges = new HashSet<Edge>();
    protected Set<Edge> inEdges = new HashSet<Edge>();

    protected TinkerVertex(String id, TinkerIndex index) {
        super(id, index);
    }

    public Set<Edge> getOutEdges() {
        return this.outEdges;
    }

    public Set<Edge> getInEdges() {
        return this.inEdges;
    }

    public Set<Edge> getBothEdges() {
        Set<Edge> bothEdges = new HashSet<Edge>();
        bothEdges.addAll(outEdges);
        bothEdges.addAll(inEdges);
        return bothEdges;
    }

    public String toString() {
        return StringFactory.vertexString(this);
    }  

    public boolean equals(Object object) {
        if (object instanceof TinkerVertex)
            return object.hashCode() == this.hashCode();
        else
            return false;
    }
}
