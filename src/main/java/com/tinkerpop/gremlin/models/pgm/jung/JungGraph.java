package com.tinkerpop.gremlin.models.pgm.jung;

import com.tinkerpop.gremlin.models.pgm.Edge;
import com.tinkerpop.gremlin.models.pgm.Graph;
import com.tinkerpop.gremlin.models.pgm.Vertex;
import edu.uci.ics.jung.graph.util.EdgeType;
import edu.uci.ics.jung.graph.util.Pair;

import java.util.*;


/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class JungGraph implements edu.uci.ics.jung.graph.Graph<Vertex, Edge> {

    private final Graph graph;

    public JungGraph(final Graph graph) {
        this.graph = graph;
    }

    public boolean addVertex(final Vertex vertex) {
        if (null != graph.getVertex(vertex.getId()))
            graph.addVertex(vertex.getId());
        return true;
    }

    public boolean removeVertex(final Vertex vertex) {
        this.graph.removeVertex(vertex);
        return true;
    }

    public boolean containsVertex(final Vertex vertex) {
        for (Vertex v : this.graph.getVertices()) {
            if (vertex.equals(v))
                return true;
        }
        return false;
    }

    public int getEdgeCount(final EdgeType edgeType) {
        return this.getEdgeCount();
    }

    public boolean addEdge(final Edge edge, final Collection<? extends Vertex> vertices) {
        if (vertices.size() == 2) {
            Iterator<? extends Vertex> itty = vertices.iterator();
            this.addEdge(edge, itty.next(), itty.next());
        } else {
            throw new IllegalArgumentException();
        }
        return true;
    }

    public boolean addEdge(final Edge edge, final Collection<? extends Vertex> vertices, final EdgeType edgeType) {
        return this.addEdge(edge, vertices);

    }

    public boolean addEdge(final Edge edge, final Vertex outVertex, final Vertex inVertex) {
        this.graph.addEdge(null, outVertex, inVertex, edge.getLabel());
        return true;
    }

    public boolean addEdge(final Edge e, final Vertex v1, final Vertex v2, final EdgeType edgeType) {
        return this.addEdge(e, v1, v2);
    }

    public boolean removeEdge(final Edge edge) {
        this.graph.removeEdge(edge);
        return true;
    }

    public boolean containsEdge(final Edge edge) {
        for (Edge e : this.graph.getEdges()) {
            if (edge.equals(e))
                return true;
        }
        return false;
    }

    public Collection<Edge> getEdges(final EdgeType edgeType) {
        return this.getEdges();
    }

    public Edge findEdge(final Vertex outVertex, final Vertex inVertex) {
        for (Edge edge : outVertex.getOutEdges()) {
            if (edge.getInVertex().equals(inVertex)) {
                return edge;
            }
        }
        return null;
    }

    public Collection<Edge> findEdgeSet(final Vertex outVertex, final Vertex inVertex) {
        Set<Edge> edges = new HashSet<Edge>();
        for (Edge edge : outVertex.getOutEdges()) {
            if (edge.getInVertex().equals(inVertex)) {
                edges.add(edge);
            }
        }
        return edges;
    }

    public boolean isIncident(final Vertex vertex, final Edge edge) {
        return edge.getInVertex().equals(vertex) || edge.getOutVertex().equals(vertex);
    }

    public Collection<Edge> getIncidentEdges(final Vertex vertex) {
        Set<Edge> edges = new HashSet<Edge>();
        for (Edge edge : vertex.getInEdges()) {
            edges.add(edge);
        }
        for (Edge edge : vertex.getOutEdges()) {
            edges.add(edge);
        }
        return edges;
    }

    public EdgeType getDefaultEdgeType() {
        return EdgeType.DIRECTED;
    }

    public EdgeType getEdgeType(final Edge edge) {
        return EdgeType.DIRECTED;
    }

    public int getIncidentCount(final Edge edge) {
        if (edge.getInVertex().equals(edge.getOutVertex()))
            return 1;
        else
            return 2;
    }

    public int getVertexCount() {
        Iterable<Vertex> itty = this.graph.getVertices();
        if (itty instanceof Collection) {
            return ((Collection) itty).size();
        } else {
            int count = 0;
            for (Vertex v : itty) {
                count++;
            }
            return count;
        }
    }

    public int getEdgeCount() {
        int count = 0;
        for (Edge e : this.graph.getEdges()) {
            count++;
        }
        return count;
    }

    public Collection<Edge> getEdges() {
        Iterable<Edge> itty = this.graph.getEdges();
        if (itty instanceof Collection) {
            return (Collection<Edge>) itty;
        } else {
            List<Edge> edges = new ArrayList<Edge>();
            for (Edge e : itty) {
                edges.add(e);
            }
            return edges;
        }
    }

    public Collection<Vertex> getVertices() {
        Iterable<Vertex> itty = this.graph.getVertices();
        if (itty instanceof Collection) {
            return (Collection<Vertex>) itty;
        } else {
            List<Vertex> vertices = new ArrayList<Vertex>();
            for (Vertex v : itty) {
                vertices.add(v);
            }
            return vertices;
        }
    }

    public Collection<Vertex> getIncidentVertices(final Edge edge) {
        List<Vertex> vertices = new ArrayList<Vertex>();
        vertices.add(edge.getInVertex());
        vertices.add(edge.getOutVertex());
        return vertices;
    }

    public Vertex getDest(final Edge edge) {
        return edge.getInVertex();
    }

    public Vertex getSource(final Edge edge) {
        return edge.getOutVertex();
    }

    public Pair<Vertex> getEndpoints(final Edge edge) {
        return new Pair<Vertex>(edge.getOutVertex(), edge.getInVertex());
    }

    public boolean isNeighbor(final Vertex outVertex, final Vertex inVertex) {
        for (Edge edge : outVertex.getOutEdges()) {
            if (edge.getInVertex().equals(inVertex))
                return true;
        }
        for (Edge edge : outVertex.getInEdges()) {
            if (edge.getOutVertex().equals(inVertex))
                return true;
        }
        return false;
    }

    public int getNeighborCount(final Vertex vertex) {
        return this.getNeighbors(vertex).size();
    }

    public Collection<Vertex> getNeighbors(final Vertex vertex) {
        Set<Vertex> vertices = new HashSet<Vertex>();
        for (Edge e : vertex.getOutEdges()) {
            vertices.add(e.getInVertex());
        }
        for (Edge e : vertex.getInEdges()) {
            vertices.add(e.getOutVertex());
        }
        return vertices;
    }

    public Vertex getOpposite(final Vertex vertex, final Edge edge) {
        if (edge.getOutVertex().equals(vertex))
            return edge.getInVertex();
        else
            return edge.getOutVertex();
    }

    public Collection<Edge> getOutEdges(final Vertex vertex) {

        Iterable<Edge> itty = vertex.getOutEdges();
        if (itty instanceof Collection) {
            return (Collection<Edge>) itty;
        } else {
            List<Edge> edges = new ArrayList<Edge>();
            for (Edge edge : itty) {
                edges.add(edge);
            }
            return edges;
        }
    }

    public Collection<Edge> getInEdges(final Vertex vertex) {
        Iterable<Edge> itty = vertex.getInEdges();
        if (itty instanceof Collection) {
            return (Collection<Edge>) itty;
        } else {
            Set<Edge> edges = new HashSet<Edge>();
            for (Edge edge : itty) {
                edges.add(edge);
            }
            return edges;
        }
    }

    public int getPredecessorCount(final Vertex vertex) {
        return this.getPredecessors(vertex).size();
    }

    public Collection<Vertex> getPredecessors(final Vertex vertex) {
        Set<Vertex> vertices = new HashSet<Vertex>();
        for (Edge edge : vertex.getInEdges()) {
            vertices.add(edge.getOutVertex());
        }
        return vertices;
    }

    public int getSuccessorCount(final Vertex vertex) {
        return this.getSuccessors(vertex).size();
    }

    public Collection<Vertex> getSuccessors(final Vertex vertex) {
        Set<Vertex> vertices = new HashSet<Vertex>();
        for (Edge edge : vertex.getOutEdges()) {
            vertices.add(edge.getInVertex());
        }
        return vertices;
    }

    public int inDegree(final Vertex vertex) {
        Iterable<Edge> itty = vertex.getInEdges();
        if (itty instanceof Collection) {
            return ((Collection) itty).size();
        } else {
            int count = 0;
            for (Edge edge : itty) {
                count++;
            }
            return count;
        }
    }

    public int outDegree(final Vertex vertex) {
        Iterable<Edge> itty = vertex.getOutEdges();
        if (itty instanceof Collection) {
            return ((Collection) itty).size();
        } else {
            int count = 0;
            for (Edge edge : itty) {
                count++;
            }
            return count;
        }
    }


    public int degree(final Vertex vertex) {
        return this.outDegree(vertex) + this.inDegree(vertex);
    }

    public boolean isDest(final Vertex vertex, final Edge edge) {
        return edge.getInVertex().equals(vertex);
    }

    public boolean isSource(final Vertex vertex, final Edge edge) {
        return edge.getOutVertex().equals(vertex);
    }

    public boolean isPredecessor(final Vertex outVertex, final Vertex inVertex) {
        for (Edge edge : outVertex.getInEdges()) {
            if (edge.getOutVertex().equals(inVertex))
                return true;
        }
        return false;
    }

    public boolean isSuccessor(final Vertex outVertex, final Vertex inVertex) {
        for (Edge edge : outVertex.getOutEdges()) {
            if (edge.getInVertex().equals(inVertex))
                return true;
        }
        return false;
    }
}
