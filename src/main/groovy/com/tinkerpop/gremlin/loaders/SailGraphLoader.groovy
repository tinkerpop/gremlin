package com.tinkerpop.gremlin.loaders

import com.tinkerpop.blueprints.pgm.impls.sail.SailGraph

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class SailGraphLoader {

    public static void load() {

        SailGraph.metaClass.uri {final String prefix ->
            return ((SailGraph) delegate).expandPrefix(prefix)
        }

        SailGraph.metaClass.qn {final String uri ->
            return ((SailGraph) delegate).prefixNamespace(uri)
        }
    }
}
