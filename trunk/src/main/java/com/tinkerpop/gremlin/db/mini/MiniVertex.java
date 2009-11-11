package com.tinkerpop.gremlin.db.mini;

import com.tinkerpop.gremlin.Edge;
import com.tinkerpop.gremlin.Vertex;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class MiniVertex extends MiniElement implements Vertex {

    protected Set<Edge> outEdges = new HashSet<Edge>();
    protected Set<Edge> inEdges = new HashSet<Edge>();

    public MiniVertex(String id) {
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

    public MiniEdge createOutEdge(MiniVertex inVertex, String label) {
        MiniEdge edge = new MiniEdge(this, inVertex, label);
        this.outEdges.add(edge);
        inVertex.inEdges.add(edge);
        return edge;
    }

    public MiniEdge createInEdge(MiniVertex outVertex, String label) {
        MiniEdge edge = new MiniEdge(outVertex, this, label);
        this.inEdges.add(edge);
        outVertex.outEdges.add(edge);
        return edge;
    }
}
