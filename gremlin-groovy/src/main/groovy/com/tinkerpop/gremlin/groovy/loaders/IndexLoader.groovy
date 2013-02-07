package com.tinkerpop.gremlin.groovy.loaders

import com.tinkerpop.blueprints.Index
import com.tinkerpop.blueprints.IndexableGraph
import com.tinkerpop.gremlin.groovy.GremlinGroovyPipeline

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class IndexLoader {

    public static void load() {

        IndexableGraph.metaClass.idx = { final Object indexName ->
            return ((IndexableGraph) delegate).getIndices().find { it.getIndexName().equals(indexName) }
        }

        Index.metaClass.getAt = { final Map query ->
            final Map.Entry entry = (Map.Entry) query.iterator().next();
            return new GremlinGroovyPipeline().start((((Index) delegate).get((String) entry.getKey(), entry.getValue())));
        }

    }
}
