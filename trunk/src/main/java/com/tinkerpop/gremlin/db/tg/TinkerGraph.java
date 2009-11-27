package com.tinkerpop.gremlin.db.tg;

import com.tinkerpop.gremlin.model.Edge;
import com.tinkerpop.gremlin.model.Graph;
import com.tinkerpop.gremlin.model.Vertex;

import java.util.*;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class TinkerGraph implements Graph {

    protected Map<String, Vertex> vertices;

    public TinkerGraph() {
        this.vertices = new HashMap<String, Vertex>();
    }

    public Vertex addVertex(Object id) {
        TinkerVertex vertex = new TinkerVertex((String) id);
        this.vertices.put(vertex.getId(), vertex);
        return vertex;
    }

    public Vertex getVertex(Object id) {
        return this.vertices.get((String) id);
    }

    public Iterator<Vertex> getVertices() {
        return vertices.values().iterator();
    }

    public Iterator<Edge> getEdges() {
        return new TinkerEdgeIterator(this.getVertices());
    }

    public void removeVertex(Vertex vertex) {
        Set<Edge> edges = vertex.getBothEdges();
        for (Edge edge : edges) {
            TinkerVertex vIn = (TinkerVertex) edge.getInVertex();
            vIn.inEdges.remove(edge);
            TinkerVertex vOut = (TinkerVertex) edge.getOutVertex();
            vOut.outEdges.remove(edge);
        }
        this.vertices.remove((String)vertex.getId());
    }

    public Edge addEdge(Object id, Vertex outVertex, Vertex inVertex, String label) {
        TinkerVertex out = (TinkerVertex)outVertex;
        TinkerVertex in = (TinkerVertex)inVertex;
        TinkerEdge edge = new TinkerEdge((String)id, outVertex, inVertex, label);
        out.outEdges.add(edge);
        in.inEdges.add(edge);
        return edge;
    }

    public void removeEdge(Edge edge) {
        TinkerVertex outVertex = (TinkerVertex)edge.getOutVertex();
        TinkerVertex inVertex = (TinkerVertex)edge.getInVertex();
        outVertex.outEdges.remove(edge);
        inVertex.inEdges.remove(edge);
    }

    public String toString() {
        return "tinkergraph[vertices:" + this.vertices.size() + "]";
    }

    public void shutdown() {
    }

    private class TinkerEdgeIterator implements Iterator<Edge> {

        private Iterator<Vertex> vertices;
        private Edge[] currentEdges;
        private int currentIndex;

        public TinkerEdgeIterator(Iterator<Vertex> vertices) {
            this.vertices = vertices;
            this.currentIndex = -1;
        }

        public Edge next() {
            if(currentIndex != -1) {
                if(currentIndex >= currentEdges.length - 1) {
                    currentIndex = -1;
                }
                return currentEdges[currentIndex];
            } else {
                if(vertices.hasNext()) {
                    currentEdges = (Edge[]) vertices.next().getOutEdges().toArray();
                    currentIndex = 0;
                    return next();
                } else {
                    return null;
                }
            }
        }

        public boolean hasNext() {
            return !(this.currentIndex == -1);
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

    }

}
