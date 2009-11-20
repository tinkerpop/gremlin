package com.tinkerpop.gremlin.db.tg;

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

    public void removeEdge(Edge edge) {
        this.outEdges.remove(edge);
        this.inEdges.remove(edge);
    }

    public void removeOutEdge(TinkerVertex inVertex, String label) {
        Set<Edge> toRemove = new HashSet<Edge>();
        for (Edge edge : this.outEdges) {
            if (edge.getVertex(Direction.IN).equals(inVertex) && (edge.getLabel().equals(label) || label == null)) {
                toRemove.add(edge);
                inVertex.removeEdge(edge);
            }
        }
        this.outEdges.removeAll(toRemove);
    }

    public void removeInEdge(TinkerVertex outVertex, String label) {
        Set<Edge> toRemove = new HashSet<Edge>();
        for (Edge edge : this.outEdges) {
            if (edge.getVertex(Direction.OUT).equals(outVertex) && (edge.getLabel().equals(label) || label == null)) {
                toRemove.add(edge);
                outVertex.removeEdge(edge);
            }
        }
        this.inEdges.removeAll(toRemove);
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

    public String toString() {
        //return "vertex[id:" + id + "][outEdges:" + outEdges.size() + "][inEdges:" + inEdges.size() + "]";
        return "vertex[id:" + id + "]";
    }

    public boolean equals(Object object) {
        if (object instanceof TinkerEdge)
            return object.hashCode() == this.hashCode();
        else
            return false;
    }
}
