package com.tinkerpop.gremlin.loaders

import com.tinkerpop.blueprints.pgm.Index
import com.tinkerpop.blueprints.pgm.IndexableGraph
import com.tinkerpop.gremlin.GremlinTokens.T
import com.tinkerpop.pipes.util.FluentPipeline

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class IndexLoader {

    public static void load() {

        IndexableGraph.metaClass.idx = {final Object indexName ->
            final String name;
            if (indexName.equals(T.v)) {
                name = Index.VERTICES
            } else if (indexName.equals(T.e)) {
                name = Index.EDGES
            } else {
                name = indexName.toString()
            }
            return ((IndexableGraph) delegate).getIndices().find {it.getIndexName().equals(name)}
        }

        Index.metaClass.getAt = {final Map query ->
            final Map.Entry entry = (Map.Entry) query.iterator().next();
            return new FluentPipeline().start((((Index) delegate).get((String) entry.getKey(), entry.getValue())));
        }

    }
}
