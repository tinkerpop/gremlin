package com.tinkerpop.gremlin.models.ggm.jung;

import com.tinkerpop.gremlin.models.ggm.Edge;
import com.tinkerpop.gremlin.models.ggm.Graph;
import com.tinkerpop.gremlin.models.ggm.Vertex;
import edu.uci.ics.jung.graph.util.EdgeType;
import edu.uci.ics.jung.graph.util.Pair;

import java.util.*;


/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class JungGraph implements edu.uci.ics.jung.graph.Graph<Vertex, Edge> {

    private Graph graph;

    public JungGraph(Graph graph) {
        this.graph = graph;
    }

    public boolean addVertex(Vertex v) {
        if (null != graph.getVertex(v.getId()))
            graph.addVertex(v.getId());

        return true;
    }

    public boolean removeVertex(Vertex v) {
        this.graph.removeVertex(v);
        return true;
    }

    public boolean containsVertex(Vertex v) {
        for (Vertex vertex : this.graph.getVertices()) {
            if (v.equals(vertex))
                return true;
        }
        return false;
    }

    public int getEdgeCount(EdgeType edgeType) {
        return this.getEdgeCount();
    }

    public boolean addEdge(Edge e, Collection<? extends Vertex> vertices) {
        if (vertices.size() == 2) {
            Iterator<? extends Vertex> itty = vertices.iterator();
            this.addEdge(e, itty.next(), itty.next());
        } else {
            throw new IllegalArgumentException();
        }
        return true;
    }

    public boolean addEdge(Edge e, Collection<? extends Vertex> vertices, EdgeType edgeType) {
        return this.addEdge(e, vertices);

    }

    public boolean addEdge(Edge e, Vertex v1, Vertex v2) {
        this.graph.addEdge(null, v1, v2, null);
        return true;
    }

    public boolean addEdge(Edge e, Vertex v1, Vertex v2, EdgeType edgeType) {
        return this.addEdge(e, v1, v2);
    }

    public boolean removeEdge(Edge e) {
        this.graph.removeEdge(e);
        return true;
    }

    public boolean containsEdge(Edge e) {
        Vertex outVertex = e.getOutVertex();
        Vertex inVertex = e.getInVertex();
        for (Edge e1 : outVertex.getOutEdges()) {
            if (e1.getInVertex().equals(inVertex) && e.getLabel().equals(e1.getLabel())) {
                return true;
            }
        }
        return false;
    }

    public Collection<Edge> getEdges(EdgeType edgeType) {
        return this.getEdges();
    }

    public Edge findEdge(Vertex v1, Vertex v2) {
        for (Edge e : v1.getOutEdges()) {
            if (e.getInVertex().equals(v2)) {
                return e;
            }
        }
        return null;
    }

    public Collection<Edge> findEdgeSet(Vertex v1, Vertex v2) {
        Set<Edge> edges = new HashSet<Edge>();
        for (Edge e : v1.getOutEdges()) {
            if (e.getInVertex().equals(v2)) {
                edges.add(e);
            }
        }
        return edges;
    }

    public boolean isIncident(Vertex v, Edge e) {
        return e.getInVertex().equals(v) || e.getOutVertex().equals(v);
    }

    public Collection<Edge> getIncidentEdges(Vertex v) {
        Set<Edge> edges = new HashSet<Edge>();
        for (Edge e : v.getInEdges()) {
            edges.add(e);
        }
        for (Edge e : v.getOutEdges()) {
            edges.add(e);
        }
        return edges;
    }

    public EdgeType getDefaultEdgeType() {
        return EdgeType.DIRECTED;
    }

    public EdgeType getEdgeType(Edge e) {
        return EdgeType.DIRECTED;
    }

    public int getIncidentCount(Edge e) {
        if (e.getInVertex().equals(e.getOutVertex()))
            return 1;
        else
            return 2;
    }

    public int getVertexCount() {
        int count = 0;
        for (Vertex v : this.graph.getVertices()) {
            count++;
        }
        return count;
    }

    public int getEdgeCount() {
        int count = 0;
        for (Edge e : this.graph.getEdges()) {
            count++;
        }
        return count;
    }

    public Collection<Edge> getEdges() {
        List<Edge> edges = new ArrayList<Edge>();
        for (Edge e : this.graph.getEdges()) {
            edges.add(e);
        }
        return edges;
    }

    public Collection<Vertex> getVertices() {
        List<Vertex> vertices = new ArrayList<Vertex>();
        for (Vertex v : this.graph.getVertices()) {
            vertices.add(v);
        }
        return vertices;
    }

    public Collection<Vertex> getIncidentVertices(Edge e) {
        Set<Vertex> vertices = new HashSet<Vertex>();
        vertices.add(e.getInVertex());
        vertices.add(e.getOutVertex());
        return vertices;
    }

    public Vertex getDest(Edge e) {
        return e.getInVertex();
    }

    public Vertex getSource(Edge e) {
        return e.getOutVertex();
    }

    public Pair<Vertex> getEndpoints(Edge e) {
        return new Pair<Vertex>(e.getOutVertex(), e.getInVertex());
    }

    public boolean isNeighbor(Vertex v1, Vertex v2) {
        for (Edge e : v1.getOutEdges()) {
            if (e.getInVertex().equals(v2))
                return true;
        }
        for (Edge e : v1.getInEdges()) {
            if (e.getOutVertex().equals(v2))
                return true;
        }
        return false;
    }

    public int getNeighborCount(Vertex v) {
        return this.getNeighbors(v).size();
    }

    public Collection<Vertex> getNeighbors(Vertex v) {
        Set<Vertex> vertices = new HashSet<Vertex>();
        for (Edge e : v.getOutEdges()) {
            vertices.add(e.getInVertex());
        }
        for (Edge e : v.getInEdges()) {
            vertices.add(e.getOutVertex());
        }
        return vertices;
    }

    public Vertex getOpposite(Vertex v, Edge e) {
        if (e.getOutVertex().equals(v))
            return e.getInVertex();
        else
            return e.getOutVertex();
    }

    public Collection<Edge> getOutEdges(Vertex v) {
        List<Edge> edges = new ArrayList<Edge>();
        for (Edge e : v.getOutEdges()) {
            edges.add(e);
        }
        return edges;
    }

    public int getPredecessorCount(Vertex v) {
        return this.getPredecessors(v).size();
    }

    public Collection<Vertex> getPredecessors(Vertex v) {
        Set<Vertex> vertices = new HashSet<Vertex>();
        for (Edge e : v.getInEdges()) {
            vertices.add(e.getOutVertex());
        }
        return vertices;
    }

    public int getSuccessorCount(Vertex v) {
        return this.getSuccessors(v).size();
    }

    public Collection<Vertex> getSuccessors(Vertex v) {
        Set<Vertex> vertices = new HashSet<Vertex>();
        for (Edge e : v.getOutEdges()) {
            vertices.add(e.getInVertex());
        }
        return vertices;
    }

    public int inDegree(Vertex v) {
        int count = 0;
        for (Edge e : v.getInEdges()) {
            count++;
        }
        return count;
    }

    public int outDegree(Vertex v) {
        int count = 0;
        for (Edge e : v.getOutEdges()) {
            count++;
        }
        return count;
    }

    public Collection<Edge> getInEdges(Vertex v) {
        Set<Edge> edges = new HashSet<Edge>();
        for (Edge e : v.getInEdges()) {
            edges.add(e);
        }
        return edges;
    }

    public int degree(Vertex v) {
        return this.outDegree(v) + this.inDegree(v);
    }

    public boolean isDest(Vertex v, Edge e) {
        return e.getInVertex().equals(v);
    }

    public boolean isSource(Vertex v, Edge e) {
        return e.getOutVertex().equals(v);
    }

    public boolean isPredecessor(Vertex v1, Vertex v2) {
        for (Edge e : v1.getInEdges()) {
            if (e.getOutVertex().equals(v2))
                return true;
        }
        return false;
    }

    public boolean isSuccessor(Vertex v1, Vertex v2) {
        for (Edge e : v1.getOutEdges()) {
            if (e.getInVertex().equals(v2))
                return true;
        }
        return false;
    }
}
