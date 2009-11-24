package com.tinkerpop.gremlin;

import com.tinkerpop.gremlin.lang.Tokens;
import com.tinkerpop.gremlin.model.Edge;
import com.tinkerpop.gremlin.model.Element;
import org.apache.commons.jxpath.DynamicPropertyHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class EdgePropertyHandler implements DynamicPropertyHandler {


    public String[] getPropertyNames(Object edgeObject) {
        Edge edge = (Edge) edgeObject;
        List<String> list = new ArrayList<String>();
        list.addAll(edge.getPropertyKeys());
        list.add(Tokens.OUT_VERTEX);
        list.add(Tokens.IN_VERTEX);
        list.add(Tokens.LABEL);
        return list.toArray(new String[list.size()]);
    }

    public void setProperty(Object edgeObject, String key, Object value) {
        Edge edge = (Edge) edgeObject;
        edge.setProperty(key, value);
    }

    public Object getProperty(Object edgeObject, String key) {
        Edge edge = (Edge) edgeObject;
        if (key.equals(Tokens.OUT_VERTEX)) {
            return edge.getOutVertex();
        } else if (key.equals(Tokens.IN_VERTEX)) {
            return edge.getInVertex();
        } else if (key.equals(Tokens.LABEL)) {
            return edge.getLabel();
        } else {
            return edge.getProperty(key);
        }
    }
}