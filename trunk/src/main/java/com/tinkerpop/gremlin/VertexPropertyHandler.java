package com.tinkerpop.gremlin;

import com.tinkerpop.gremlin.model.Element;
import com.tinkerpop.gremlin.model.Vertex;
import org.apache.commons.jxpath.DynamicPropertyHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class VertexPropertyHandler implements DynamicPropertyHandler {

    public static final String OUT_EDGES = "outEdges";
    public static final String IN_EDGES = "inEdges";
    public static final String BOTH_EDGES = "bothEdges";

    public String[] getPropertyNames(Object vertexObject) {
        Vertex vertex = (Vertex) vertexObject;
        List<String> list = new ArrayList<String>();
        list.addAll(vertex.getPropertyKeys());
        list.add(OUT_EDGES);
        list.add(IN_EDGES);
        list.add(BOTH_EDGES);
        return list.toArray(new String[list.size()]);
    }

    public void setProperty(Object vertexObject, String key, Object value) {
        Vertex vertex = (Vertex) vertexObject;
        vertex.setProperty(key, value);
    }

    public Object getProperty(Object vertexObject, String key) {
        Vertex vertex = (Vertex) vertexObject;
        if (key.equals(OUT_EDGES)) {
            return vertex.getEdges(Element.Direction.OUT);
        } else if (key.equals(IN_EDGES)) {
            return vertex.getEdges(Element.Direction.IN);
        } else if (key.equals(BOTH_EDGES)) {
            return vertex.getEdges(Element.Direction.BOTH);
        } else {
            return vertex.getProperty(key);
        }
    }
}
