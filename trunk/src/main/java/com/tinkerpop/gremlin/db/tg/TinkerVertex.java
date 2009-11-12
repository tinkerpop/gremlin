package com.tinkerpop.gremlin.db.tg;

import com.tinkerpop.gremlin.Edge;
import com.tinkerpop.gremlin.Vertex;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class TinkerVertex extends TinkerElement implements Vertex {

    protected Set<Edge> outEdges = new HashSet<Edge>();
    protected Set<Edge> inEdges = new HashSet<Edge>();

    public TinkerVertex(String id) {
        super(id);
    }

    public Set<Edge> getEdges(Direction direction) {
        if (direction == Direction.OUT)
            return outEdges;
        else if (direction == Direction.IN) {
            return inEdges;
        } else {
            Set<Edge> bothEdges = new HashSet<Edge>();
            bothEdges.addAll(outEdges);
            bothEdges.addAll(inEdges);
            return bothEdges;
        }
    }

    public TinkerEdge createOutEdge(TinkerVertex inVertex, String label) {
        TinkerEdge edge = new TinkerEdge(this, inVertex, label);
        this.outEdges.add(edge);
        inVertex.inEdges.add(edge);
        return edge;
    }

    public TinkerEdge createInEdge(TinkerVertex outVertex, String label) {
        TinkerEdge edge = new TinkerEdge(outVertex, this, label);
        this.inEdges.add(edge);
        outVertex.outEdges.add(edge);
        return edge;
    }
}
