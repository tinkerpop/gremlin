package com.tinkerpop.gremlin.loaders

import com.tinkerpop.gremlin.Gremlin
import com.tinkerpop.gremlin.groovy.GremlinTokens
import com.tinkerpop.gremlin.groovy.GroovyPipeFunction
import com.tinkerpop.gremlin.pipes.GremlinFluentPipeline
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

        GremlinFluentPipeline.metaClass.propertyMissing = {final String name ->
            if (Gremlin.isStep(name)) {
                return delegate."$name"();
            } else {
                if (name.equals(GremlinTokens.ID)) {
                    return ((GremlinFluentPipeline) delegate).id();
                } else if (name.equals(GremlinTokens.LABEL)) {
                    return ((GremlinFluentPipeline) delegate).label();
                } else {
                    return ((GremlinFluentPipeline) delegate).property(name);
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


        GremlinFluentPipeline.metaClass.getAt = {final Integer index ->
            return ((GremlinFluentPipeline) delegate).rangeFilter(index, index);
        }


        GremlinFluentPipeline.metaClass.getAt = {final Range range ->
            return ((GremlinFluentPipeline) delegate).rangeFilter(range.getFrom() as Integer, range.getTo() as Integer);
        }

        GremlinFluentPipeline.metaClass.getAt = {final String name ->
            if (name.equals(GremlinTokens.ID)) {
                return ((GremlinFluentPipeline) delegate).id();
            } else if (name.equals(GremlinTokens.LABEL)) {
                return ((GremlinFluentPipeline) delegate).label();
            } else {
                return ((GremlinFluentPipeline) delegate).property(name);
            }
        }

        GremlinFluentPipeline.metaClass.getAt = {final Map map ->
            GremlinFluentPipeline pipeline = (GremlinFluentPipeline) delegate;
            map.each {key, value ->
                if (key.equals(GremlinTokens.LABEL)) {
                    if (value instanceof List) {
                        pipeline.addPipe(new LabelFilterPipe((String) value[1], Gremlin.mapFilter(value[0])))
                    } else {
                        pipeline.addPipe(new LabelFilterPipe((String) value, FilterPipe.Filter.EQUAL));
                    }
                } else if (key.equals(GremlinTokens.ID)) {
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

        Gremlin.addStep(GremlinTokens.STEP);
        GremlinFluentPipeline.metaClass.step = {final Closure closure ->
            return ((GremlinFluentPipeline) delegate).step(new GroovyPipeFunction(closure));
        }

        TransformPipeLoader.load();
        FilterPipeLoader.load();
        SideEffectPipeLoader.load();
    }
}
