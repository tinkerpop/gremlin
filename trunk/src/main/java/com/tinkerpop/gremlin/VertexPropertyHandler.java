package com.tinkerpop.gremlin;

import com.tinkerpop.gremlin.model.Edge;
import com.tinkerpop.gremlin.model.Vertex;
import com.tinkerpop.gremlin.statements.Tokens;
import org.apache.commons.jxpath.DynamicPropertyHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class VertexPropertyHandler implements DynamicPropertyHandler {

    private static final List<String> staticProperties = new ArrayList<String>();

    static {
        staticProperties.add(Tokens.OUT_EDGES);
        staticProperties.add(Tokens.IN_EDGES);
        staticProperties.add(Tokens.BOTH_EDGES);
        staticProperties.add(Tokens.ID);
    }


    public String[] getPropertyNames(final Object vertexObject) {
        Vertex vertex = (Vertex) vertexObject;
        List<String> list = new ArrayList<String>();
        list.addAll(vertex.getPropertyKeys());
        list.addAll(staticProperties);
        ////
        for(Edge edge : vertex.getOutEdges()) {
            list.add(edge.getLabel() + Tokens.UNDERSCORE);
            list.add(edge.getLabel() + Tokens.UNDERSCORE_2);
        }
        for(Edge edge : vertex.getInEdges()) {
            list.add(Tokens.UNDERSCORE + edge.getLabel());
            list.add(Tokens.UNDERSCORE_2 + edge.getLabel());
        }
        ////
        return list.toArray(new String[list.size()]);
    }

    public void setProperty(final Object vertexObject, final String key, final Object value) {
        if (!key.equals(Tokens.OUT_EDGES) && !key.equals(Tokens.IN_EDGES) && !key.equals(Tokens.BOTH_EDGES) && !key.equals(Tokens.ID)) {
            Vertex vertex = (Vertex) vertexObject;
            vertex.setProperty(key, value);
        }
    }

    public Object getProperty(final Object vertexObject, final String key) {

        Vertex vertex = (Vertex) vertexObject;
        ////
        if (key.startsWith(Tokens.UNDERSCORE_2)) {
            String keyFix = key.substring(2, key.length());
            List<Vertex> results = new ArrayList<Vertex>();
            for (Edge edge : vertex.getInEdges()) {
                if (edge.getLabel().equals(keyFix)) {
                    results.add(edge.getOutVertex());
                }
            }
            return results;
        } else if (key.endsWith(Tokens.UNDERSCORE_2)) {
            String keyFix = key.substring(0, key.length() - 2);
            List<Vertex> results = new ArrayList<Vertex>();
            for (Edge edge : vertex.getOutEdges()) {
                if (edge.getLabel().equals(keyFix)) {
                    results.add(edge.getInVertex());
                }
            }
            return results;
        } else if (key.startsWith(Tokens.UNDERSCORE)) {
            String keyFix = key.substring(1, key.length());
            List<Edge> results = new ArrayList<Edge>();
            for (Edge edge : vertex.getInEdges()) {
                if (edge.getLabel().equals(keyFix)) {
                    results.add(edge);
                }
            }
            return results;
        } else if (key.endsWith(Tokens.UNDERSCORE)) {
            String keyFix = key.substring(0, key.length() - 1);
            List<Edge> results = new ArrayList<Edge>();
            for (Edge edge : vertex.getOutEdges()) {
                if (edge.getLabel().equals(keyFix)) {
                    results.add(edge);
                }
            }
            return results;
        }
        ////

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
