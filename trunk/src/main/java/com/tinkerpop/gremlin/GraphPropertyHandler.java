package com.tinkerpop.gremlin;

import com.tinkerpop.gremlin.model.Graph;
import com.tinkerpop.gremlin.statements.Tokens;
import org.apache.commons.jxpath.DynamicPropertyHandler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class GraphPropertyHandler implements DynamicPropertyHandler {

    public String[] getPropertyNames(Object graphObject) {
        List<String> list = new ArrayList<String>();
        list.add(Tokens.VERTICES);
        list.add(Tokens.EDGES);
        return list.toArray(new String[list.size()]);
    }

    public void setProperty(Object graphObject, String key, Object value) {
    }

    public Object getProperty(Object graphObject, String key) {
        Graph graph = (Graph) graphObject;
        if (key.equals(Tokens.VERTICES)) {
            return GraphPropertyHandler.createListFromIterable(graph.getVertices());
        } else if (key.equals(Tokens.EDGES)) {
            return GraphPropertyHandler.createListFromIterable(graph.getEdges());
        } else {
            return null;
        }
    }

    private static Collection createListFromIterable(Iterable itty) {
        if (itty instanceof Collection) {
            // TODO: this is odd, inefficient behavior System.out.println("HERE!");
            return (Collection) itty;
        }
        else {
            List list = new ArrayList();
            for (Object o : itty) {
                list.add(o);
            }
            return list;
        }
    }
}
