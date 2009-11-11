package com.tinkerpop.gremlin;

import org.apache.commons.jxpath.DynamicPropertyHandler;

import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class EdgePropertyHandler implements DynamicPropertyHandler {

    public String[] getPropertyNames(Object edgeObject) {
        Edge edge = (Edge) edgeObject;
        List<String> list = new LinkedList<String>();
        list.addAll(edge.getPropertyKeys());
        list.add("outVertex");
        list.add("inVertex");
        list.add("label");
        return list.toArray(new String[list.size()]);
    }

    public void setProperty(Object edgeObject, String key, Object value) {
        Edge edge = (Edge) edgeObject;
        edge.setProperty(key, value);
    }

    public Object getProperty(Object edgeObject, String key) {
        Edge edge = (Edge) edgeObject;
        if (key.equals("outVertex")) {
            return edge.getVertex(Vertex.Direction.OUT);
        } else if (key.equals("inVertex")) {
            return edge.getVertex(Vertex.Direction.IN);
        } else if (key.equals("label")) {
            return edge.getLabel();
        } else {
            return edge.getProperty(key);
        }
    }
}