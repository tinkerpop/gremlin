package com.tinkerpop.gremlin;

import com.tinkerpop.gremlin.model.Edge;
import com.tinkerpop.gremlin.model.Vertex;
import com.tinkerpop.gremlin.statements.EvaluationException;
import com.tinkerpop.gremlin.statements.Tokens;

import java.util.*;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class VertexPropertyHandler extends ElementPropertyHandler {

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
        list.addAll(Arrays.asList(super.getPropertyNames(vertexObject)));
        return list.toArray(new String[list.size()]);
    }

    public void setProperty(final Object vertexObject, final String key, final Object value) {
        if (!key.equals(Tokens.OUT_EDGES) && !key.equals(Tokens.IN_EDGES) && !key.equals(Tokens.BOTH_EDGES) && !key.equals(Tokens.ID)) {
            Vertex vertex = (Vertex) vertexObject;
            vertex.setProperty(key, value);
        } else {
            throw new EvaluationException(key + GraphPropertyHandler.CANNOT_BE_SET);
        }
    }

    public Object getProperty(final Object vertexObject, final String key) {

        Vertex vertex = (Vertex) vertexObject;

        if (key.equals(Tokens.OUT_EDGES)) {
            return GraphPropertyHandler.createListFromIterable(vertex.getOutEdges());
        } else if (key.equals(Tokens.IN_EDGES)) {
            return GraphPropertyHandler.createListFromIterable(vertex.getInEdges());
        } else if (key.equals(Tokens.BOTH_EDGES)) {
            Set<Edge> bothEdges = new HashSet<Edge>(GraphPropertyHandler.createListFromIterable(vertex.getInEdges()));
            bothEdges.addAll(GraphPropertyHandler.createListFromIterable(vertex.getOutEdges()));
            return bothEdges;
        } else if (key.equals(Tokens.ID)) {
            return vertex.getId();
        } else if (vertex.getPropertyKeys().contains(key)) {
            return vertex.getProperty(key);
        } else {
            return super.getProperty(vertexObject, key);
        }
    }
}
