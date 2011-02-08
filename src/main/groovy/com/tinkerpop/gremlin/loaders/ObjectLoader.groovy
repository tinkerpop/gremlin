package com.tinkerpop.gremlin.loaders

import com.tinkerpop.gremlin.Gremlin
import com.tinkerpop.gremlin.GremlinTokens
import com.tinkerpop.pipes.IdentityPipe

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class ObjectLoader {

  public static void load() {

    Object.metaClass.propertyMissing = {final String name ->
      if (Gremlin.isStep(name)) {
        return delegate."$name"();
      } else {
        throw new MissingPropertyException(name, delegate.getClass());
      }
    }

    Gremlin.addStep(GremlinTokens._);
    Object.metaClass._ = {final Closure closure ->
      return Gremlin.compose(delegate, new IdentityPipe(), closure)
    }

    Object.metaClass.mean = {
      double counter = 0;
      double sum = 0;
      delegate.each {counter++; sum += it}
      return sum / counter;
    }

  }
}
