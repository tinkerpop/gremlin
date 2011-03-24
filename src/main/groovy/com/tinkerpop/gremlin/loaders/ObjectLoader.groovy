package com.tinkerpop.gremlin.loaders

import com.tinkerpop.gremlin.Gremlin
import com.tinkerpop.gremlin.GremlinTokens
import com.tinkerpop.pipes.IdentityPipe

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class ObjectLoader {

    public static void load() {

        Gremlin.addStep(GremlinTokens._);
        Object.metaClass._ = {final Closure closure ->
            return Gremlin.compose(delegate, new IdentityPipe(), closure)
        }

    }
}