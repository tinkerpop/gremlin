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

        LinkedHashMap.metaClass.getAt = {final Range range ->
            final int size = delegate.size();
            int high = Math.min(size - 1, range.max());
            int low = Math.max(0, range.min());

            final Map tempMap = new LinkedHashMap();
            int c = 0;
            for (final Map.Entry entry: delegate.entrySet()) {
                if (c >= low && c <= high) {
                    tempMap.put(entry.getKey(), entry.getValue());
                }
                c++;
            }
            return tempMap;


        }

    }
}