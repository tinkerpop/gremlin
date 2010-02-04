package com.tinkerpop.gremlin.models.ggm.paths;

import com.tinkerpop.gremlin.models.ggm.Edge;
import com.tinkerpop.gremlin.models.ggm.Vertex;
import com.tinkerpop.gremlin.statements.EvaluationException;
import com.tinkerpop.gremlin.statements.Tokens;
import com.tinkerpop.gremlin.paths.ObjectPropertyHandler;
import com.tinkerpop.gremlin.models.ggm.paths.GraphPropertyHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class EdgePropertyHandler extends ObjectPropertyHandler {

    private static final List<String> staticProperties = new ArrayList<String>();

    static {
        staticProperties.add(Tokens.OUT_VERTEX);
        staticProperties.add(Tokens.IN_VERTEX);
        staticProperties.add(Tokens.BOTH_VERTICES);
        staticProperties.add(Tokens.LABEL);
        staticProperties.add(Tokens.ID);
    }

    public String[] getPropertyNames(final Object edgeObject) {
        Edge edge = (Edge) edgeObject;
        List<String> list = new ArrayList<String>();
        Set<String> keys = edge.getPropertyKeys();
        if (null != keys)
            list.addAll(edge.getPropertyKeys());
        list.addAll(staticProperties);
        list.addAll(Arrays.asList(super.getPropertyNames(edgeObject)));
        return list.toArray(new String[list.size()]);
    }

    public void setProperty(final Object edgeObject, final String key, final Object value) {
        if (!key.equals(Tokens.OUT_VERTEX) && !key.equals(Tokens.IN_VERTEX) && !key.equals(Tokens.LABEL) && !key.equals(Tokens.ID)) {
            Edge edge = (Edge) edgeObject;
            edge.setProperty(key, value);
        } else {
            throw new EvaluationException(key + GraphPropertyHandler.CANNOT_BE_SET);
        }
    }

    public Object getProperty(final Object edgeObject, final String key) {
        Edge edge = (Edge) edgeObject;

        if (super.containsProperty(key)) {
            return super.getProperty(edgeObject, key);
        } else if (key.equals(Tokens.OUT_VERTEX)) {
            return edge.getOutVertex();
        } else if (key.equals(Tokens.IN_VERTEX)) {
            return edge.getInVertex();
        } else if (key.equals(Tokens.BOTH_VERTICES)) {
            List<Vertex> bothVertices = new ArrayList<Vertex>();
            bothVertices.add(edge.getOutVertex());
            bothVertices.add(edge.getInVertex());
            return bothVertices;
        } else if (key.equals(Tokens.LABEL)) {
            return edge.getLabel();
        } else if (key.equals(Tokens.ID)) {
            return edge.getId();
        } else {
            return edge.getProperty(key);
        }
    }
}