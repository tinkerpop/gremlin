package com.tinkerpop.gremlin.db.tg;

import com.tinkerpop.gremlin.model.Graph;
import com.tinkerpop.gremlin.model.Element;
import com.tinkerpop.gremlin.model.Edge;
import com.tinkerpop.gremlin.model.Vertex;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class TinkerGraph implements Graph {

    protected Map<String, TinkerVertex> vertices;

    public TinkerGraph() {
        this.vertices = new HashMap<String, TinkerVertex>();
    }

    public void addVertex(TinkerVertex vertex) {
        this.vertices.put(vertex.getId(), vertex);
    }

    public void removeVertex(Object id) {
        Vertex vertex = vertices.get((String)id);
        Set<Edge> edges = vertex.getEdges(Element.Direction.BOTH);
        for(Edge edge : edges) {
            TinkerVertex vIn = (TinkerVertex) edge.getVertex(Element.Direction.IN);
            vIn.removeEdge(edge);
            TinkerVertex vOut = (TinkerVertex) edge.getVertex(Element.Direction.BOTH);
            vOut.removeEdge(edge);
        }
        this.vertices.remove((String)id);
    }

    public TinkerVertex getVertex(Object id) {
        return this.vertices.get((String)id);
    }

    public void shutdown() {
    }
}
