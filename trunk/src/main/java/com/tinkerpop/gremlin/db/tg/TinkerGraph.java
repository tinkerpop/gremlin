package com.tinkerpop.gremlin.db.tg;

import com.tinkerpop.gremlin.model.Edge;
import com.tinkerpop.gremlin.model.Graph;
import com.tinkerpop.gremlin.model.Index;
import com.tinkerpop.gremlin.model.Vertex;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class TinkerGraph implements Graph {

    private Long currentId = 0l;
    protected Map<String, Vertex> vertices = new HashMap<String, Vertex>();
    private TinkerIndex index = new TinkerIndex();

    public Vertex addVertex(Object id) {
        String idString;
        if (null != id) {
            idString = id.toString();
        } else {
            idString = this.getNextId();
        }

        Vertex vertex = this.vertices.get(idString);

        if (null != vertex) {
            return vertex;
        } else {
            vertex = new TinkerVertex(idString, this.index);
            this.vertices.put(vertex.getId().toString(), vertex);
            return vertex;
        }
    }

    public Vertex getVertex(Object id) {
        if (null == id)
            return null;
        else {
            String idString = id.toString();
            return this.vertices.get(idString);
        }
    }

    public Iterable<Vertex> getVertices() {
        return vertices.values();
    }

    public Iterable<Edge> getEdges() {
        return new TinkerEdgeIterable(this.getVertices());
    }

    public void removeVertex(Vertex vertex) {
        Set<Edge> edges = vertex.getBothEdges();
        for (Edge edge : edges) {
            this.removeEdge(edge);
        }
        for (String key : vertex.getPropertyKeys()) {
            this.index.remove(key, vertex.getProperty(key), vertex);
        }
        this.vertices.remove(vertex.getId().toString());
    }

    public Edge addEdge(Object id, Vertex outVertex, Vertex inVertex, String label) {
        String idString;
        if (null != id) {
            idString = id.toString();
        } else {
            idString = this.getNextId();
        }

        TinkerVertex out = (TinkerVertex) outVertex;
        TinkerVertex in = (TinkerVertex) inVertex;
        TinkerEdge edge = new TinkerEdge(idString, outVertex, inVertex, label, this.index);
        out.outEdges.add(edge);
        in.inEdges.add(edge);
        //this.edges.put(edge.getId(), edge);
        return edge;
    }

    public void removeEdge(Edge edge) {
        // TODO: handle nulls from $g/V[g:remove-ve($g,.)
        TinkerVertex outVertex = (TinkerVertex) edge.getOutVertex();
        TinkerVertex inVertex = (TinkerVertex) edge.getInVertex();
        if (null != outVertex && null != outVertex.outEdges)
            outVertex.outEdges.remove(edge);
        if (null != inVertex && null != inVertex.inEdges)
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

    private String getNextId() {
        String idString;
        while (true) {
            idString = this.currentId.toString();
            this.currentId++;
            if (null == this.vertices.get(idString) || this.currentId == Long.MAX_VALUE)
                break;
        }
        return idString;
    }

    private class TinkerEdgeIterable implements Iterable<Edge> {

        private Iterable<Vertex> vertices;

        public TinkerEdgeIterable(Iterable<Vertex> vertices) {
            this.vertices = vertices;
        }

        public Iterator<Edge> iterator() {
            return new TinkerEdgeIterator(this.vertices.iterator());
        }
    }

    private class TinkerEdgeIterator implements Iterator<Edge> {

        private Iterator<Vertex> vertices;
        private Iterator<Edge> currentEdges;
        private boolean complete = false;

        public TinkerEdgeIterator(Iterator<Vertex> vertices) {
            this.vertices = vertices;
            this.complete = this.goToNextEdge();

        }

        public Edge next() {
            Edge edge = currentEdges.next();
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
            if (this.currentEdges == null || !this.currentEdges.hasNext()) {
                if (vertices.hasNext()) {
                    this.currentEdges = vertices.next().getOutEdges().iterator();
                } else {
                    return true;
                }
            }

            if (this.currentEdges.hasNext()) {
                return false;
            } else {
                return this.goToNextEdge();
            }

        }
    }
}
