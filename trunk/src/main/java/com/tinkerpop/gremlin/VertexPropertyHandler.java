package com.tinkerpop.gremlin;

import org.apache.commons.jxpath.DynamicPropertyHandler;

import java.util.Set;
import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class VertexPropertyHandler implements DynamicPropertyHandler {

    public String[] getPropertyNames(Object vertexObject) {
        Vertex vertex = (Vertex) vertexObject;
        List<String> list = new LinkedList<String>();
        list.addAll(vertex.getPropertyKeys());
        list.add("outEdges");
        list.add("inEdges");
        list.add("bothEdges");
        return list.toArray(new String[list.size()]);
    }

    public void setProperty(Object vertexObject, String key, Object value) {
        Vertex vertex = (Vertex) vertexObject;
        vertex.setProperty(key, value);
    }

    public Object getProperty(Object vertexObject, String key) {
        Vertex vertex = (Vertex) vertexObject;
        if (key.equals("outEdges")) {
            return vertex.getEdges(Vertex.Direction.OUT);
        } else if (key.equals("inEdges")) {
            return vertex.getEdges(Vertex.Direction.IN);
        } else if (key.equals("bothEdges")) {
            return vertex.getEdges(Vertex.Direction.BOTH);
        } else {
            return vertex.getProperty(key);
        }
    }
}
