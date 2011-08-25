package com.tinkerpop.gremlin.loaders

import com.tinkerpop.gremlin.Gremlin
import com.tinkerpop.gremlin.GremlinTokens
import com.tinkerpop.gremlin.pipes.util.GroovyPipeClosure
import com.tinkerpop.pipes.PipeClosure
import com.tinkerpop.pipes.filter.FilterPipe
import com.tinkerpop.pipes.filter.IdFilterPipe
import com.tinkerpop.pipes.filter.LabelFilterPipe
import com.tinkerpop.pipes.filter.PropertyFilterPipe
import com.tinkerpop.pipes.util.FluentPipeline
import com.tinkerpop.pipes.util.PipeHelper

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class PipeLoader {

    public static void load() {

        FluentPipeline.metaClass.propertyMissing = {final String name ->
            if (Gremlin.isStep(name)) {
                return delegate."$name"();
            } else {
                if (name.equals(com.tinkerpop.gremlin.GremlinTokens.ID)) {
                    return ((FluentPipeline) delegate).id();
                } else if (name.equals(com.tinkerpop.gremlin.GremlinTokens.LABEL)) {
                    return ((FluentPipeline) delegate).label();
                } else {
                    return ((FluentPipeline) delegate).property(name);
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
                    return delegate;
                } else if (count == 1) {
                    return itty.next();
                } else {
                    List objects = new LinkedList();
                    for (int i = 0; i < count; i++) {
                        objects.add(itty.next());
                    }
                    return objects;
                }
            }
        }


        FluentPipeline.metaClass.getAt = {final Integer index ->
            return ((FluentPipeline) delegate).rangeFilter(index, index);
        }


        FluentPipeline.metaClass.getAt = {final Range range ->
            return ((FluentPipeline) delegate).rangeFilter(range.getFrom() as Integer, range.getTo() as Integer);
        }

        FluentPipeline.metaClass.getAt = {final String name ->
            if (name.equals(com.tinkerpop.gremlin.GremlinTokens.ID)) {
                return ((FluentPipeline) delegate).id();
            } else if (name.equals(com.tinkerpop.gremlin.GremlinTokens.LABEL)) {
                return ((FluentPipeline) delegate).label();
            } else {
                return ((FluentPipeline) delegate).property(name);
            }
        }

        FluentPipeline.metaClass.getAt = {final Map map ->
            FluentPipeline pipeline = (FluentPipeline) delegate;
            map.each {key, value ->
                if (key.equals(com.tinkerpop.gremlin.GremlinTokens.LABEL)) {
                    if (value instanceof List) {
                        pipeline.addPipe(new LabelFilterPipe((String) value[1], Gremlin.mapFilter(value[0])))
                    } else {
                        pipeline.addPipe(new LabelFilterPipe((String) value, FilterPipe.Filter.EQUAL));
                    }
                } else if (key.equals(com.tinkerpop.gremlin.GremlinTokens.ID)) {
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
        FluentPipeline.metaClass.step = {final Closure closure ->
            PipeClosure pc = new GroovyPipeClosure(closure);
            ((FluentPipeline) delegate).step(pc);
            //pc.setPipe((FluentPipeline) delegate);
            return delegate;
        }

        TransformPipeLoader.load();
        FilterPipeLoader.load();
        SideEffectPipeLoader.load();
    }
}
