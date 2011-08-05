package com.tinkerpop.gremlin.loaders

import com.tinkerpop.blueprints.pgm.Edge
import com.tinkerpop.blueprints.pgm.Graph
import com.tinkerpop.blueprints.pgm.Vertex
import com.tinkerpop.gremlin.Gremlin
import com.tinkerpop.gremlin.GremlinTokens
import com.tinkerpop.gremlin.pipes.GremlinPipeline
import com.tinkerpop.gremlin.pipes.util.GroovyPipeClosure
import com.tinkerpop.pipes.ClosurePipe
import com.tinkerpop.pipes.Pipe
import com.tinkerpop.pipes.filter.FilterPipe
import com.tinkerpop.pipes.filter.IdFilterPipe
import com.tinkerpop.pipes.filter.LabelFilterPipe
import com.tinkerpop.pipes.filter.PropertyFilterPipe
import com.tinkerpop.pipes.filter.RangeFilterPipe
import com.tinkerpop.pipes.transform.IdPipe
import com.tinkerpop.pipes.transform.LabelPipe
import com.tinkerpop.pipes.transform.PropertyPipe
import com.tinkerpop.pipes.util.PipeHelper

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class PipeLoader {

    public static void load() {

        Pipe.metaClass.propertyMissing = {final String name ->
            if (Gremlin.isStep(name)) {
                return delegate."$name"();
            } else {
                if (name.equals(com.tinkerpop.gremlin.GremlinTokens.ID)) {
                    return Gremlin.compose(delegate, new IdPipe());
                } else if (name.equals(com.tinkerpop.gremlin.GremlinTokens.LABEL)) {
                    return Gremlin.compose(delegate, new LabelPipe());
                } else {
                    return Gremlin.compose(delegate, new PropertyPipe(name));
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


        Pipe.metaClass.getAt = {final Integer index ->
            return Gremlin.compose(delegate, new RangeFilterPipe(index, index));
        }


        Pipe.metaClass.getAt = {final Range range ->
            return Gremlin.compose(delegate, new RangeFilterPipe(range.getFrom() as Integer, range.getTo() as Integer));
        }

        Pipe.metaClass.getAt = {final String name ->
            if (name.equals(com.tinkerpop.gremlin.GremlinTokens.ID)) {
                return Gremlin.compose(delegate, new IdPipe());
            } else if (name.equals(com.tinkerpop.gremlin.GremlinTokens.LABEL)) {
                return Gremlin.compose(delegate, new LabelPipe());
            } else {
                return Gremlin.compose(delegate, new PropertyPipe(name));
            }
        }

        Pipe.metaClass.getAt = {final Map map ->
            GremlinPipeline pipeline = Gremlin.compose(delegate);
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
        [Pipe, Vertex, Edge, Graph].each {
            it.metaClass.step = {final Closure closure ->
                return Gremlin.compose(delegate, new ClosurePipe(new GroovyPipeClosure(closure)));
            }
        }

        TransformPipeLoader.load();
        FilterPipeLoader.load();
        SideEffectPipeLoader.load();
    }
}
