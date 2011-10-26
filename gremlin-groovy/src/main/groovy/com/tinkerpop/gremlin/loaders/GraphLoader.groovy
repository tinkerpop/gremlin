package com.tinkerpop.gremlin.loaders

import com.tinkerpop.blueprints.pgm.Edge
import com.tinkerpop.blueprints.pgm.Graph
import com.tinkerpop.blueprints.pgm.Vertex
import com.tinkerpop.blueprints.pgm.util.graphml.GraphMLReader
import com.tinkerpop.blueprints.pgm.util.graphml.GraphMLWriter
import com.tinkerpop.blueprints.pgm.util.json.GraphJSONReader
import com.tinkerpop.blueprints.pgm.util.json.GraphJSONWriter
import com.tinkerpop.gremlin.Gremlin
import com.tinkerpop.gremlin.groovy.GremlinGroovyPipeline
import java.util.Map.Entry

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class GraphLoader {

    public static void load() {

        Graph.metaClass.propertyMissing = {final String name ->
            if (Gremlin.isStep(name)) {
                return new GremlinGroovyPipeline(delegate)."$name"();
            } else {
                throw new MissingPropertyException(name, delegate.getClass());
            }
        }

        Graph.metaClass.methodMissing = {final String name, final def args ->
            if (Gremlin.isStep(name)) {
                return new GremlinGroovyPipeline(delegate)."$name"(* args);
            } else {
                throw new MissingMethodException(name, delegate.getClass());
            }
        }

        Graph.metaClass.v = {final Object... ids ->
            if (ids.length == 1)
                return ((Graph) delegate).getVertex(ids[0]);
            else {
                final Graph g = (Graph) delegate;
                final List vertices = new LinkedList();
                ids.each {vertices.add(g.getVertex(it))};
                return vertices;
            }
        }

        Graph.metaClass.e = {final Object... ids ->
            if (ids.length == 1)
                return ((Graph) delegate).getEdge(ids[0]);
            else {
                final Graph g = (Graph) delegate;
                final List edges = new LinkedList();
                ids.each {edges.add(g.getEdge(it))};
                return edges;
            }
        }

        Graph.metaClass.addVertex = {->
            return ((Graph) delegate).addVertex(null);
        }

        Graph.metaClass.addVertex = {final Object id, final Map<String, Object> properties ->
            final Vertex vertex = ((Graph) delegate).addVertex(id);
            for (final Entry<String, Object> entry: properties.entrySet()) {
                vertex.setProperty(entry.getKey(), entry.getValue());
            }
            return vertex;
        }

        Graph.metaClass.addVertex = {final Map<String, Object> properties ->
            return ((Graph) delegate).addVertex(null, properties);
        }

        Graph.metaClass.addEdge = {final Object id, final Vertex outVertex, final Vertex inVertex, final String label, final Map<String, Object> properties ->
            final Edge edge = ((Graph) delegate).addEdge(id, outVertex, inVertex, label);
            for (final Entry<String, Object> entry: properties.entrySet()) {
                edge.setProperty(entry.getKey(), entry.getValue());
            }
            return edge;
        }

        Graph.metaClass.addEdge = {final Vertex outVertex, final Vertex inVertex, final String label, final Map<String, Object> properties ->
            return ((Graph) delegate).addEdge(null, outVertex, inVertex, label, properties);
        }

        Graph.metaClass.addEdge = {final Vertex outVertex, final Vertex inVertex, final String label ->
            return ((Graph) delegate).addEdge(null, outVertex, inVertex, label);
        }

        Graph.metaClass.loadGraphML = {final def fileObject ->
            try {
                GraphMLReader.inputGraph((Graph) delegate, new URL(fileObject).openStream());
            } catch (MalformedURLException e) {
                GraphMLReader.inputGraph((Graph) delegate, new FileInputStream(fileObject))
            }
        }

        Graph.metaClass.saveGraphML = {final def fileObject ->
            GraphMLWriter.outputGraph((Graph) delegate, new FileOutputStream(fileObject))
        }

        Graph.metaClass.loadGraphJSON = {final def fileObject ->
            try {
                GraphJSONReader.inputGraph((Graph) delegate, new URL(fileObject).openStream());
            } catch (MalformedURLException e) {
                GraphJSONReader.inputGraph((Graph) delegate, new FileInputStream(fileObject))
            }
        }

        Graph.metaClass.saveGraphJSON = {final def fileObject ->
            GraphJSONWriter.outputGraph((Graph) delegate, new FileOutputStream(fileObject), true)
        }

        Graph.metaClass.saveGraphJSON = {final def fileObject, final boolean showTypes ->
            GraphJSONWriter.outputGraph((Graph) delegate, new FileOutputStream(fileObject), showTypes)
        }

    }
}
