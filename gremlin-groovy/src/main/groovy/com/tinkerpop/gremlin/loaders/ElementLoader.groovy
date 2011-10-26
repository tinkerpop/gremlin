package com.tinkerpop.gremlin.loaders

import com.tinkerpop.blueprints.pgm.Edge
import com.tinkerpop.blueprints.pgm.Element
import com.tinkerpop.blueprints.pgm.Vertex
import com.tinkerpop.gremlin.Gremlin
import com.tinkerpop.gremlin.groovy.GremlinGroovyPipeline

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class ElementLoader {

    public static void load() {

        Element.metaClass.propertyMissing = {final String name, final def value ->
            ((Element) delegate).setProperty(name, value)
        }

        Element.metaClass.methodMissing = {final String name, final def args ->
            if (Gremlin.isStep(name)) {
                return delegate._()."$name"(* args)
            } else {
                throw new MissingMethodException(name, delegate.getClass());
            }
        }

        Element.metaClass.propertyMissing = {final String name ->
            if (Gremlin.isStep(name)) {
                return delegate._()."$name"()
            } else {
                return ((Element) delegate).getProperty(name)
            }
        }

        Element.metaClass.map = {
            final Map<String, Object> map = new HashMap<String, Object>();
            for (final String key: ((Element) delegate).getPropertyKeys()) {
                map.put(key, ((Element) delegate).getProperty(key))
            }
            return map;
        }

        Element.metaClass.keys = {
            return ((Element) delegate).getPropertyKeys()
        }

        Element.metaClass.values = {
            final List values = new ArrayList();
            for (final String key: ((Element) delegate).getPropertyKeys()) {
                values.add(((Element) delegate).getProperty(key))
            }
            return values;
        }

        Vertex.metaClass.out = {final String... labels ->
            return new GremlinGroovyPipeline(delegate).out(labels);
        }

        Vertex.metaClass.outE = {final String... labels ->
            return new GremlinGroovyPipeline(delegate).outE(labels);
        }

        Vertex.metaClass.in = {final String... labels ->
            return new GremlinGroovyPipeline(delegate).in(labels);
        }

        Vertex.metaClass.inE = {final String... labels ->
            return new GremlinGroovyPipeline(delegate).inE(labels);
        }

        Vertex.metaClass.both = {final String... labels ->
            return new GremlinGroovyPipeline(delegate).both(labels);
        }

        Vertex.metaClass.bothE = {final String... labels ->
            return new GremlinGroovyPipeline(delegate).bothE(labels);
        }

        Edge.metaClass.inV = {->
            return new GremlinGroovyPipeline(delegate).inV();
        }

        Edge.metaClass.outV = {->
            return new GremlinGroovyPipeline(delegate).outV();
        }

        Edge.metaClass.bothV = {->
            return new GremlinGroovyPipeline(delegate).bothV();
        }
    }
}
