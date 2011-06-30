package com.tinkerpop.gremlin.loaders

import com.tinkerpop.blueprints.pgm.Graph
import com.tinkerpop.blueprints.pgm.Vertex
import com.tinkerpop.gremlin.GremlinTokens
import com.tinkerpop.gremlin.loaders.util.GraphJungLoaderHelper

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class GraphJungLoader {

    public static void load() {

        Graph.metaClass.visualize = { final String vertexPropertyLabel, final String edgePropertyLabel, final Iterable<Vertex> vertices, final Collection<String> edgeLabels ->
            GraphJungLoaderHelper.visualizeGraph((Graph) delegate, GremlinTokens.ID, GremlinTokens.LABEL, vertices, edgeLabels);
        }

        Graph.metaClass.visualize = { final String vertexPropertyLabel, final String edgePropertyLabel ->
            GraphJungLoaderHelper.visualizeGraph((Graph) delegate, vertexPropertyLabel, edgePropertyLabel, null, null);
        }

        Graph.metaClass.visualize = { final Iterable<Vertex> vertices, final Set<String> edgeLabels ->
            GraphJungLoaderHelper.visualizeGraph((Graph) delegate, GremlinTokens.ID, GremlinTokens.LABEL, vertices, edgeLabels);
        }

        Graph.metaClass.visualize = { final Iterable<Vertex> vertices ->
            GraphJungLoaderHelper.visualizeGraph((Graph) delegate, GremlinTokens.ID, GremlinTokens.LABEL, vertices, null);
        }

        Graph.metaClass.visualize = {
            GraphJungLoaderHelper.visualizeGraph((Graph) delegate, GremlinTokens.ID, GremlinTokens.LABEL, null, null);
        }
    }
}
