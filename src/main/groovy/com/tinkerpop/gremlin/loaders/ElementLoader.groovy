package com.tinkerpop.gremlin.loaders

import com.tinkerpop.blueprints.pgm.Edge
import com.tinkerpop.blueprints.pgm.Element
import com.tinkerpop.blueprints.pgm.Vertex
import com.tinkerpop.gremlin.Gremlin

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class ElementLoader {

  public static void load() {

    Vertex.metaClass.propertyMissing = {final String name ->
      if (Gremlin.getMissingMethods(delegate.getClass()).contains(name)) {
        return delegate."$name"();
      } else {
        if (name.equals(com.tinkerpop.gremlin.GremlinTokens.ID)) {
          return ((Vertex) delegate).getId();
        } else {
          return ((Vertex) delegate).getProperty(name)
        }
      }
    }

    Edge.metaClass.propertyMissing = {final String name ->
      if (Gremlin.getMissingMethods(delegate.getClass()).contains(name)) {
        return delegate."$name"();
      } else {
        if (name.equals(com.tinkerpop.gremlin.GremlinTokens.ID)) {
          return ((Edge) delegate).getId();
        } else if (name.equals(com.tinkerpop.gremlin.GremlinTokens.LABEL)) {
          return ((Edge) delegate).getLabel();
        } else {
          return ((Edge) delegate).getProperty(name)
        }
      }
    }

    Element.metaClass.map = {
      final Map<String, Object> map = new HashMap<String, Object>();
      for (final String key: delegate.getPropertyKeys()) {
        map.put(key, delegate.getProperty(key))
      }
      return map;
    }

    Element.metaClass.keys = {
      return delegate.getPropertyKeys()
    }

    Element.metaClass.values = {
      final List values = new ArrayList();
      for (final String key: delegate.getPropertyKeys()) {
        values.add(delegate.getProperty(key))
      }
      return values;
    }
  }
}
