package com.tinkerpop.gremlin.groovy.loaders

import com.tinkerpop.gremlin.groovy.Gremlin
import com.tinkerpop.gremlin.groovy.GremlinGroovyPipeline
import com.tinkerpop.pipes.util.PipeHelper

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class PipeLoader {

    public static void load() {

        GremlinGroovyPipeline.metaClass.propertyMissing = { final String name ->
            if (Gremlin.isStep(name)) {
                return delegate."$name"();
            } else {
                return ((GremlinGroovyPipeline) delegate).property(name);
            }
        }

        [Iterable, Iterator].each {
            it.metaClass.count = {
                return PipeHelper.counter(delegate.iterator());
            }
        }

        [Iterable, Iterator].each {
            it.metaClass.mean = {
                double counter = 0;
                double sum = 0;
                delegate.each { counter++; sum += it; }
                return sum / counter;
            }
        }

        GremlinGroovyPipeline.metaClass.getAt = { final Integer index ->
            return ((GremlinGroovyPipeline) delegate).range(index, index);
        }


        GremlinGroovyPipeline.metaClass.getAt = { final Range range ->
            return ((GremlinGroovyPipeline) delegate).range(range.getFrom() as Integer, range.getTo() as Integer);
        }
    }
}
