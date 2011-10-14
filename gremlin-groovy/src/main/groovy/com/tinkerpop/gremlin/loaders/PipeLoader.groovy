package com.tinkerpop.gremlin.loaders

import com.tinkerpop.gremlin.Gremlin
import com.tinkerpop.gremlin.Tokens
import com.tinkerpop.gremlin.groovy.GremlinGroovyPipeline
import com.tinkerpop.gremlin.groovy.GroovyPipeFunction
import com.tinkerpop.gremlin.pipes.filter.IdFilterPipe
import com.tinkerpop.gremlin.pipes.filter.LabelFilterPipe
import com.tinkerpop.gremlin.pipes.filter.PropertyFilterPipe
import com.tinkerpop.pipes.filter.FilterPipe
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
                if (name.equals(Tokens.ID)) {
                    return ((GremlinGroovyPipeline) delegate).id();
                } else if (name.equals(Tokens.LABEL)) {
                    return ((GremlinGroovyPipeline) delegate).label();
                } else {
                    return ((GremlinGroovyPipeline) delegate).property(name);
                }
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
                final Iterator itty;
                if (delegate instanceof Iterable) {
                    itty = delegate.iterator();
                } else {
                    itty = (Iterator) delegate;
                }
                PipeHelper.fillCollection(itty, collection);
                return collection;
            }
        }

        [Iterable, Iterator].each {
            it.metaClass.rightShift = {final Integer count ->
                final Iterator itty;
                if (delegate instanceof Iterable) {
                    itty = delegate.iterator();
                } else {
                    itty = (Iterator) delegate;
                }

                if (count == -1) {
                    PipeHelper.iterate(itty);
                    return null;
                } else if (count == 1) {
                    return itty.next();
                } else {
                    final List list = new LinkedList();
                    PipeHelper.fillCollection(itty, list, count);
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

        GremlinGroovyPipeline.metaClass.getAt = {final String name ->
            if (name.equals(Tokens.ID)) {
                return ((GremlinGroovyPipeline) delegate).id();
            } else if (name.equals(Tokens.LABEL)) {
                return ((GremlinGroovyPipeline) delegate).label();
            } else {
                return ((GremlinGroovyPipeline) delegate).property(name);
            }
        }

        GremlinGroovyPipeline.metaClass.getAt = {final Map map ->
            GremlinGroovyPipeline pipeline = (GremlinGroovyPipeline) delegate;
            map.each {key, value ->
                if (key.equals(Tokens.LABEL)) {
                    if (value instanceof List) {
                        pipeline.addPipe(new LabelFilterPipe((String) value[1], Gremlin.mapFilter(value[0])))
                    } else {
                        pipeline.addPipe(new LabelFilterPipe((String) value, FilterPipe.Filter.EQUAL));
                    }
                } else if (key.equals(Tokens.ID)) {
                    if (value instanceof List) {
                        pipeline.addPipe(new IdFilterPipe(value[1], Gremlin.mapFilter(value[0])))
                    } else {
                        pipeline.addPipe(new IdFilterPipe(value, FilterPipe.Filter.EQUAL));
                    }
                } else {
                    if (value instanceof List) {
                        pipeline.addPipe(new PropertyFilterPipe((String) key, value[1], Gremlin.mapFilter(value[0])))
                    } else {
                        pipeline.addPipe(new PropertyFilterPipe((String) key, value, FilterPipe.Filter.EQUAL))
                    }
                }

            }
            return pipeline;
        }

        Gremlin.addStep(Tokens.STEP);
        GremlinGroovyPipeline.metaClass.step = {final Closure closure ->
            return ((GremlinGroovyPipeline) delegate).step(new GroovyPipeFunction(closure));
        }

        TransformPipeLoader.load();
        FilterPipeLoader.load();
        SideEffectPipeLoader.load();
    }
}
