package com.tinkerpop.gremlin.db.tg;

import com.tinkerpop.gremlin.model.Edge;
import com.tinkerpop.gremlin.model.Graph;
import com.tinkerpop.gremlin.model.Vertex;
import com.tinkerpop.gremlin.model.Index;

import java.util.*;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class TinkerGraph implements Graph {

    protected Map<String, Vertex> vertices = new HashMap<String, Vertex>();
    //protected Map<String, Edge> edges = new HashMap<String, Edge>();
    private TinkerIndex index = new TinkerIndex();

    public Vertex addVertex(Object id) {

        Vertex vertex = this.vertices.get(id);
        if (null != vertex)
            return vertex;
        else {
            vertex = new TinkerVertex((String)id, this.index);
            this.vertices.put((String)vertex.getId(), vertex);
            return vertex;
        }
    }

    public Vertex getVertex(Object id) {
        return this.vertices.get(id);
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
            this.removeEdge(edge);
        }
        for (String key : vertex.getPropertyKeys()) {
                this.index.remove(key, vertex.getProperty(key), vertex);
        }
        this.vertices.remove(vertex.getId());
    }

    public Edge addEdge(Object id, Vertex outVertex, Vertex inVertex, String label) {
        TinkerVertex out = (TinkerVertex) outVertex;
        TinkerVertex in = (TinkerVertex) inVertex;
        TinkerEdge edge = new TinkerEdge((String)id, outVertex, inVertex, label, this.index);
        out.outEdges.add(edge);
        in.inEdges.add(edge);
        //this.edges.put(edge.getId(), edge);
        return edge;
    }

    public void removeEdge(Edge edge) {
        TinkerVertex outVertex = (TinkerVertex) edge.getOutVertex();
        TinkerVertex inVertex = (TinkerVertex) edge.getInVertex();
        outVertex.outEdges.remove(edge);
        inVertex.inEdges.remove(edge);
        //this.edges.remove(edge.getId());
    }

    public Index getIndex() {
        return this.index;
    }

    public String toString() {
        return "tinkergraph[vertices:" + this.vertices.size() + "]";
    }

    public void shutdown() {

    }

    private class TinkerEdgeIterator implements Iterator<Edge> {

        private Iterator<Vertex> vertices;
        private List<Edge> currentEdges;
        private int currentIndex = -1;
        private boolean complete = false;

        public TinkerEdgeIterator(Iterator<Vertex> vertices) {
            this.vertices = vertices;
            this.complete = this.goToNextEdge();

        }

        public Edge next() {
            Edge edge = currentEdges.get(currentIndex);
            this.complete = this.goToNextEdge();
            return edge;
        }

        public boolean hasNext() {
            return !complete;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        private boolean goToNextEdge() {
            if (this.currentIndex == -1) {
                if (vertices.hasNext()) {
                    this.currentEdges = new ArrayList<Edge>(vertices.next().getOutEdges());
                    if (this.currentEdges.size() > 0) {
                        this.currentIndex = 0;
                        return false;
                    } else {
                        return this.goToNextEdge();
                    }
                } else {
                    return true;
                }
            } else {
                if (this.currentIndex < this.currentEdges.size() - 1) {
                    this.currentIndex++;
                    return false;
                } else {
                    this.currentIndex = -1;
                    return this.goToNextEdge();
                }
            }

        }
    }
}
