package com.tinkerpop.gremlin.groovy.loaders

import com.tinkerpop.blueprints.Edge
import com.tinkerpop.blueprints.Element
import com.tinkerpop.blueprints.Vertex
import com.tinkerpop.gremlin.groovy.Gremlin
import com.tinkerpop.gremlin.groovy.GremlinGroovyPipeline

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class ElementLoader {

    public static void load() {

        Element.metaClass.propertyMissing = { final String name, final def value ->
            ((Element) delegate).setProperty(name, value)
        }

        Element.metaClass.methodMissing = { final String name, final def args ->
            if (Gremlin.isStep(name)) {
                return new GremlinGroovyPipeline(delegate)."$name"(* args)
            } else {
                throw new MissingMethodException(name, delegate.getClass());
            }
        }

        Element.metaClass.propertyMissing = { final String name ->
            if (Gremlin.isStep(name)) {
                return new GremlinGroovyPipeline(delegate)."$name"()
            } else {
                return ((Element) delegate).getProperty(name)
            }
        }

        Element.metaClass.map = {
            final Map<String, Object> map = new HashMap<String, Object>();
            for (final String key : ((Element) delegate).getPropertyKeys()) {
                map.put(key, ((Element) delegate).getProperty(key))
            }
            return map;
        }

        Element.metaClass.keys = {
            return ((Element) delegate).getPropertyKeys()
        }

        Element.metaClass.values = {
            final List values = new ArrayList();
            for (final String key : ((Element) delegate).getPropertyKeys()) {
                values.add(((Element) delegate).getProperty(key))
            }
            return values;
        }

        // for Vertex only

        Vertex.metaClass.addEdge = { final String label, final Vertex inVertex, final Map<String, Object> properties ->
            final Edge edge = ((Vertex) delegate).addEdge(label, inVertex);
            for (final Map.Entry<String, Object> entry : properties.entrySet()) {
                edge.setProperty(entry.getKey(), entry.getValue());
            }
            return edge;
        }
    }
}
