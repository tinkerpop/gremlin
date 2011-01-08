package com.tinkerpop.gremlin.loaders

import com.tinkerpop.gremlin.Gremlin
import com.tinkerpop.pipes.IdentityPipe
import com.tinkerpop.pipes.Pipe

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class ObjectLoader {

  public static void load() {

    Object.metaClass.propertyMissing = {final String name ->
      if (Gremlin.getMissingMethods(delegate.getClass()).contains(name)) {
        return delegate."$name"();
      } else {
        throw new MissingPropertyException(name, delegate.getClass());
      }
    }

    //todo: decide to keep or not
    Object.metaClass.rightShift = {final Pipe pipe ->
      Gremlin.compose(delegate, pipe);
    }

    // PIPES

    Object.metaClass._ = {final Closure closure ->
      return Gremlin.compose(delegate, new IdentityPipe(), closure)
    }
  }
}
