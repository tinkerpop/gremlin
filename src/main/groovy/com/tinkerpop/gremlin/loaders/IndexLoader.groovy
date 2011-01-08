package com.tinkerpop.gremlin.loaders

import com.tinkerpop.blueprints.pgm.Index
import com.tinkerpop.blueprints.pgm.IndexableGraph
import com.tinkerpop.gremlin.GremlinTokens.T

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class IndexLoader {

  public static void load() {

    IndexableGraph.metaClass.idx = {final Object idx ->
      final String name;
      if (idx.equals(T.v)) {
        name = Index.VERTICES
      } else if (idx.equals(T.e)) {
        name = Index.EDGES
      } else {
        name = idx.toString()
      }

      return ((IndexableGraph) delegate).getIndices().find {it.getIndexName().equals(name)}
    }

    Index.metaClass.getAt = {final Map query ->
      Map.Entry entry = (Map.Entry) query.iterator().next();
      return ((Index) delegate).get((String) entry.getKey(), entry.getValue());
    }

  }
}
