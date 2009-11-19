package com.tinkerpop.gremlin;

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

    public static final String OUT_VERTEX = "outVertex";
    public static final String IN_VERTEX = "inVertex";
    public static final String LABEL = "label";


    public String[] getPropertyNames(Object edgeObject) {
        Edge edge = (Edge) edgeObject;
        List<String> list = new ArrayList<String>();
        list.addAll(edge.getPropertyKeys());
        list.add(OUT_VERTEX);
        list.add(IN_VERTEX);
        list.add(LABEL);
        return list.toArray(new String[list.size()]);
    }

    public void setProperty(Object edgeObject, String key, Object value) {
        Edge edge = (Edge) edgeObject;
        edge.setProperty(key, value);
    }

    public Object getProperty(Object edgeObject, String key) {
        Edge edge = (Edge) edgeObject;
        if (key.equals(OUT_VERTEX)) {
            return edge.getVertex(Element.Direction.OUT);
        } else if (key.equals(IN_VERTEX)) {
            return edge.getVertex(Element.Direction.IN);
        } else if (key.equals(LABEL)) {
            return edge.getLabel();
        } else {
            return edge.getProperty(key);
        }
    }
}