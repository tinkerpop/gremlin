package com.tinkerpop.gremlin.util

import com.tinkerpop.blueprints.pgm.impls.sail.SailGraph

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class SailSupport {

  public static void load() {

    SailGraph.metaClass.uri {String prefix ->
      return delegate.expandPrefix(prefix)
    }

    SailGraph.metaClass.qn {String uri ->
      return delegate.prefixNamespace(uri)
    }
  }
}
