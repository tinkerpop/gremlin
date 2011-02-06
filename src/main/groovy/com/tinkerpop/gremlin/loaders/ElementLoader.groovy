package com.tinkerpop.gremlin.loaders

import com.tinkerpop.blueprints.pgm.Edge
import com.tinkerpop.blueprints.pgm.Element
import com.tinkerpop.blueprints.pgm.Vertex
import com.tinkerpop.gremlin.Gremlin
import com.tinkerpop.gremlin.GremlinTokens

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class ElementLoader {

  public static void load() {

    Element.metaClass.propertyMissing = {final String name, final def value ->
      ((Element) delegate).setProperty(name, value)
    }

    Vertex.metaClass.propertyMissing = {final String name ->
      if (Gremlin.isExistingMethod(delegate.getClass(), name)) {
        return delegate."$name"()
      } else {
        if (name.equals(com.tinkerpop.gremlin.GremlinTokens.ID)) {
          return ((Vertex) delegate).getId()
        } else {
          return ((Vertex) delegate).getProperty(name)
        }
      }
    }

    Edge.metaClass.propertyMissing = {final String name ->
      if (Gremlin.getExistingMethods(delegate.getClass()).contains(name)) {
        return delegate."$name"()
      } else {
        if (name.equals(com.tinkerpop.gremlin.GremlinTokens.ID)) {
          return ((Edge) delegate).getId()
        } else if (name.equals(com.tinkerpop.gremlin.GremlinTokens.LABEL)) {
          return ((Edge) delegate).getLabel()
        } else {
          return ((Edge) delegate).getProperty(name)
        }
      }
    }

    Vertex.metaClass.getAt = {final String key ->
      if (key.equals(GremlinTokens.ID)) {
        return ((Vertex) delegate).getId()
      } else {
        return ((Vertex) delegate).getProperty(key)
      }
    }

    Edge.metaClass.getAt = {final String key ->
      if (key.equals(GremlinTokens.ID)) {
        return ((Edge) delegate).getId()
      } else if (key.equals(GremlinTokens.LABEL)) {
        return ((Edge) delegate).getLabel();
      } else {
        return ((Edge) delegate).getProperty(key)
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
  }
}
