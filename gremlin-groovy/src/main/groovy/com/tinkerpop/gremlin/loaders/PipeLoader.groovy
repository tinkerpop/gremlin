package com.tinkerpop.gremlin.loaders

import com.tinkerpop.gremlin.Gremlin
import com.tinkerpop.gremlin.groovy.GremlinGroovyPipeline
import com.tinkerpop.pipes.util.PipeHelper

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class PipeLoader {

    public static void load() {

        GremlinGroovyPipeline.metaClass.propertyMissing = {final String name ->
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
                delegate.each {counter++; sum += it;}
                return sum / counter;
            }
        }

        [Iterable, Iterator].each {
            it.metaClass.rightShift = {final Collection collection ->
                PipeHelper.fillCollection(delegate.iterator(), collection);
                return collection;
            }
        }

        [Iterable, Iterator].each {
            it.metaClass.rightShift = {final Integer count ->
                if (count == -1) {
                    PipeHelper.iterate(delegate.iterator());
                    return null;
                } else if (count == 1) {
                    return delegate.iterator().next();
                } else {
                    final List list = new LinkedList();
                    PipeHelper.fillCollection(delegate.iterator(), list, count);
                    return list;
                }
            }
        }


        GremlinGroovyPipeline.metaClass.getAt = {final Integer index ->
            return ((GremlinGroovyPipeline) delegate).range(index, index);
        }


        GremlinGroovyPipeline.metaClass.getAt = {final Range range ->
            return ((GremlinGroovyPipeline) delegate).range(range.getFrom() as Integer, range.getTo() as Integer);
        }
    }
}
