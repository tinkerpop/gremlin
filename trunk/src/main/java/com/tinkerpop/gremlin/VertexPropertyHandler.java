package com.tinkerpop.gremlin;

import com.tinkerpop.gremlin.lang.Tokens;
import com.tinkerpop.gremlin.model.Vertex;
import org.apache.commons.jxpath.DynamicPropertyHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class VertexPropertyHandler implements DynamicPropertyHandler {


    public String[] getPropertyNames(Object vertexObject) {
        Vertex vertex = (Vertex) vertexObject;
        List<String> list = new ArrayList<String>();
        list.addAll(vertex.getPropertyKeys());
        list.add(Tokens.OUT_EDGES);
        list.add(Tokens.IN_EDGES);
        list.add(Tokens.BOTH_EDGES);
        list.add(Tokens.ID);
        return list.toArray(new String[list.size()]);
    }

    public void setProperty(Object vertexObject, String key, Object value) {
        if (!key.equals(Tokens.OUT_EDGES) && !key.equals(Tokens.IN_EDGES) && !key.equals(Tokens.BOTH_EDGES) && !key.equals(Tokens.ID)) {
            Vertex vertex = (Vertex) vertexObject;
            vertex.setProperty(key, value);
        }
    }

    public Object getProperty(Object vertexObject, String key) {
        Vertex vertex = (Vertex) vertexObject;
        if (key.equals(Tokens.OUT_EDGES)) {
            return vertex.getOutEdges();
        } else if (key.equals(Tokens.IN_EDGES)) {
            return vertex.getInEdges();
        } else if (key.equals(Tokens.BOTH_EDGES)) {
            return vertex.getBothEdges();
        } else if (key.equals(Tokens.ID)) {
            return vertex.getId();
        } else {
            return vertex.getProperty(key);
        }
    }
}
