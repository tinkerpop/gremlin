package com.tinkerpop.gremlin.loaders

import com.tinkerpop.blueprints.pgm.Graph
import com.tinkerpop.blueprints.pgm.Vertex
import com.tinkerpop.gremlin.Gremlin
import com.tinkerpop.gremlin.GremlinTokens
import com.tinkerpop.pipes.pgm.GraphElementPipe
import java.util.Map.Entry

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class GraphLoader {

    public static void load() {

        Graph.metaClass.propertyMissing = {final String name ->
            if (Gremlin.isStep(name)) {
                return delegate."$name"();
            } else {
                throw new MissingPropertyException(name, delegate.getClass());
            }
        }

        Gremlin.addStep(GremlinTokens.V);
        Graph.metaClass.V = {final Closure closure ->
            return Gremlin.compose(delegate, new GraphElementPipe(GraphElementPipe.ElementType.VERTEX), closure)
        }

        Gremlin.addStep(GremlinTokens.E);
        Graph.metaClass.E = {final Closure closure ->
            return Gremlin.compose(delegate, new GraphElementPipe(GraphElementPipe.ElementType.EDGE), closure)
        }

        Graph.metaClass.v = {final Object id ->
            return ((Graph) delegate).getVertex(id);
        }

        Graph.metaClass.e = {final Object id ->
            return ((Graph) delegate).getEdge(id);
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
    }
}
