package com.tinkerpop.gremlin;

import com.tinkerpop.gremlin.model.Vertex;
import com.tinkerpop.gremlin.statements.Tokens;
import org.apache.commons.jxpath.DynamicPropertyHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class VertexPropertyHandler implements DynamicPropertyHandler {

    private static final List<String> staticProperties = new ArrayList<String>();

    static {
        staticProperties.add(Tokens.OUT_EDGES);
        staticProperties.add(Tokens.IN_EDGES);
        staticProperties.add(Tokens.BOTH_EDGES);
        staticProperties.add(Tokens.ID);
    }


    public String[] getPropertyNames(Object vertexObject) {
        Vertex vertex = (Vertex) vertexObject;
        List<String> list = new ArrayList<String>();
        list.addAll(vertex.getPropertyKeys());
        list.addAll(staticProperties);
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
