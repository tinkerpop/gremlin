package com.tinkerpop.gremlin;

import com.tinkerpop.gremlin.model.Graph;
import com.tinkerpop.gremlin.model.Vertex;
import com.tinkerpop.gremlin.model.Edge;
import org.apache.commons.jxpath.DynamicPropertyHandler;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class GraphPropertyHandler implements DynamicPropertyHandler {

    public String[] getPropertyNames(Object graphObject) {
        List<String> list = new ArrayList<String>();
        list.add("V");
        list.add("E");
        return list.toArray(new String[list.size()]);
    }

    public void setProperty(Object graphObject, String key, Object value) {
    }

    public Object getProperty(Object graphObject, String key) {
        if(key.equals("V")) {
            return getVertexList((Graph)graphObject);
        } else if(key.equals("E")) {
            return getEdgeList((Graph)graphObject);
        } else {
            return null;
        }
    }

    private List<Vertex> getVertexList(Graph graph) {
        List<Vertex> vertices = new ArrayList<Vertex>();
        Iterator<Vertex> itty = graph.getVertices();
        while (itty.hasNext()) {
            vertices.add(itty.next());
        }
        return vertices;
    }

    private List<Edge> getEdgeList(Graph graph) {
        List<Edge> edges = new ArrayList<Edge>();
        Iterator<Edge> itty = graph.getEdges();
        while (itty.hasNext()) {
            edges.add(itty.next());
        }
        return edges;
    }

}
