package com.tinkerpop.gremlin.groovy.loaders

import com.tinkerpop.blueprints.Edge
import com.tinkerpop.blueprints.Graph
import com.tinkerpop.blueprints.TransactionalGraph
import com.tinkerpop.blueprints.Vertex
import com.tinkerpop.blueprints.util.TransactionRetryHelper
import com.tinkerpop.blueprints.util.TransactionWork
import com.tinkerpop.blueprints.util.io.gml.GMLReader
import com.tinkerpop.blueprints.util.io.gml.GMLWriter
import com.tinkerpop.blueprints.util.io.graphml.GraphMLReader
import com.tinkerpop.blueprints.util.io.graphml.GraphMLWriter
import com.tinkerpop.blueprints.util.io.graphson.GraphSONMode
import com.tinkerpop.blueprints.util.io.graphson.GraphSONReader
import com.tinkerpop.blueprints.util.io.graphson.GraphSONWriter
import com.tinkerpop.gremlin.groovy.Gremlin
import com.tinkerpop.gremlin.groovy.GremlinGroovyPipeline

import java.util.Map.Entry

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class GraphLoader {

    public static void load() {

        Graph.metaClass.propertyMissing = { final String name ->
            if (Gremlin.isStep(name)) {
                return new GremlinGroovyPipeline(delegate)."$name"();
            } else {
                throw new MissingPropertyException(name, delegate.getClass());
            }
        }

        Graph.metaClass.methodMissing = { final String name, final def args ->
            if (Gremlin.isStep(name)) {
                return new GremlinGroovyPipeline(delegate)."$name"(* args);
            } else {
                throw new MissingMethodException(name, delegate.getClass());
            }
        }

        Graph.metaClass.v = { final Object... ids ->
            if (ids.length == 1)
                return ((Graph) delegate).getVertex(ids[0]);
            else {
                final Graph g = (Graph) delegate;
                return new GremlinGroovyPipeline(ids.collect { g.getVertex(it) });
            }
        }

        Graph.metaClass.e = { final Object... ids ->
            if (ids.length == 1)
                return ((Graph) delegate).getEdge(ids[0]);
            else {
                final Graph g = (Graph) delegate;
                return new GremlinGroovyPipeline(ids.collect { g.getEdge(it) });
            }
        }

        Graph.metaClass.addVertex = {->
            return ((Graph) delegate).addVertex(null);
        }

        Graph.metaClass.addVertex = { final Object id, final Map<String, Object> properties ->
            final Vertex vertex = ((Graph) delegate).addVertex(id);
            for (final Entry<String, Object> entry : properties.entrySet()) {
                vertex.setProperty(entry.getKey(), entry.getValue());
            }
            return vertex;
        }

        Graph.metaClass.addVertex = { final Map<String, Object> properties ->
            return ((Graph) delegate).addVertex(null, properties);
        }

        Graph.metaClass.addEdge = { final Object id, final Vertex outVertex, final Vertex inVertex, final String label, final Map<String, Object> properties ->
            final Edge edge = ((Graph) delegate).addEdge(id, outVertex, inVertex, label);
            for (final Entry<String, Object> entry : properties.entrySet()) {
                edge.setProperty(entry.getKey(), entry.getValue());
            }
            return edge;
        }

        Graph.metaClass.addEdge = { final Vertex outVertex, final Vertex inVertex, final String label, final Map<String, Object> properties ->
            return ((Graph) delegate).addEdge(null, outVertex, inVertex, label, properties);
        }

        Graph.metaClass.addEdge = { final Vertex outVertex, final Vertex inVertex, final String label ->
            return ((Graph) delegate).addEdge(null, outVertex, inVertex, label);
        }

        // Transaction Retry
        Graph.metaClass.tryTx = { final Closure work ->
            final def g = (Graph) delegate
            if (!(g instanceof TransactionalGraph)) throw new UnsupportedOperationException("Graph must be a TransactionalGraph instance.")
            return new TransactionRetryHelper.Builder<Object>(g as TransactionalGraph).perform(new TransactionWork<Object>() {
                @Override
                public Object execute(final TransactionalGraph graph) throws Exception {
                    return work(graph)
                }
            }).build()
        }

        // GRAPHML

        Graph.metaClass.loadGraphML = { final def fileObject ->
            try {
                GraphMLReader.inputGraph((Graph) delegate, new URL(fileObject).openStream());
            } catch (MalformedURLException e) {
                GraphMLReader.inputGraph((Graph) delegate, new FileInputStream(fileObject))
            }
        }

        Graph.metaClass.saveGraphML = { final def fileObject ->
            GraphMLWriter.outputGraph((Graph) delegate, new FileOutputStream(fileObject))
        }

        // GRAPHSON

        Graph.metaClass.loadGraphSON = { final def fileObject ->
            try {
                GraphSONReader.inputGraph((Graph) delegate, new URL(fileObject).openStream());
            } catch (MalformedURLException e) {
                GraphSONReader.inputGraph((Graph) delegate, new FileInputStream(fileObject))
            }
        }

        Graph.metaClass.saveGraphSON = { final def fileObject ->
            GraphSONWriter.outputGraph((Graph) delegate, new FileOutputStream(fileObject), GraphSONMode.NORMAL)
        }

        Graph.metaClass.saveGraphSON = { final def fileObject, final GraphSONMode mode ->
            GraphSONWriter.outputGraph((Graph) delegate, new FileOutputStream(fileObject), mode)
        }

        Graph.metaClass.saveGraphSON = { final def fileObject, final GraphSONMode mode,
                                         final List<String> vertexPropertyKeys, final List<String> edgePropertyKeys ->
            GraphSONWriter.outputGraph((Graph) delegate, new FileOutputStream(fileObject),
                    vertexPropertyKeys as Set, edgePropertyKeys as Set, mode)
        }

        // GML

        Graph.metaClass.loadGML = { final def fileObject ->
            try {
                GMLReader.inputGraph((Graph) delegate, new URL(fileObject).openStream());
            } catch (MalformedURLException e) {
                GMLReader.inputGraph((Graph) delegate, new FileInputStream(fileObject))
            }
        }

        Graph.metaClass.saveGML = { final def fileObject ->
            GMLWriter.outputGraph((Graph) delegate, new FileOutputStream(fileObject));
        }

    }
}
