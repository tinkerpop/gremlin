package com.tinkerpop.gremlin.models.ggm.paths;

import com.tinkerpop.gremlin.models.ggm.Graph;
import com.tinkerpop.gremlin.paths.ObjectPropertyHandler;
import com.tinkerpop.gremlin.statements.Tokens;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class GraphPropertyHandler extends ObjectPropertyHandler {

    private static final String[] properties = new String[]{Tokens.VERTICES, Tokens.EDGES};
    public static final String CANNOT_BE_SET = " cannot be set as a property.";

    public String[] getPropertyNames(final Object graphObject) {
        return properties;
    }

    public void setProperty(final Object graphObject, final String key, final Object value) {
    }

    public Object getProperty(final Object graphObject, final String key) {
        Graph graph = (Graph) graphObject;
        if (key.equals(Tokens.VERTICES)) {
            return GraphPropertyHandler.createListFromIterable(graph.getVertices());
        } else if (key.equals(Tokens.EDGES)) {
            return GraphPropertyHandler.createListFromIterable(graph.getEdges());
        } else {
            return null;
        }
    }

    public static Collection createListFromIterable(final Iterable iterable) {
        if (iterable instanceof Collection) {
            // TODO: this is odd, inefficient behavior System.out.println("HERE!");
            return (Collection) iterable;
        } else {
            List list = new ArrayList();
            for (Object o : iterable) {
                list.add(o);
            }
            return list;
        }
    }
}
