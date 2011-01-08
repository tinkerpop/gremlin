package com.tinkerpop.gremlin.loaders

import com.tinkerpop.blueprints.pgm.Graph
import com.tinkerpop.gremlin.Gremlin
import com.tinkerpop.pipes.pgm.GraphElementPipe

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class GraphLoader {

  public static void load() {

    Graph.metaClass.propertyMissing = {final String name ->
      if (Gremlin.getMissingMethods(delegate.getClass()).contains(name)) {
        return delegate."$name"();
      } else {
        throw new MissingPropertyException(name, delegate.getClass());
      }
    }

    Graph.metaClass.V = {final Closure closure ->
      return Gremlin.compose(delegate, new GraphElementPipe(GraphElementPipe.ElementType.VERTEX), closure)
    }

    Graph.metaClass.E = {final Closure closure ->
      return Gremlin.compose(delegate, new GraphElementPipe(GraphElementPipe.ElementType.EDGE), closure)
    }

    Graph.metaClass.v = {final Object id ->
      return ((Graph) delegate).getVertex(id);
    }

    Graph.metaClass.e = {final Object id ->
      return ((Graph) delegate).getEdge(id);
    }
  }
}
