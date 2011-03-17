package com.tinkerpop.gremlin.loaders

import com.tinkerpop.blueprints.pgm.Edge
import com.tinkerpop.blueprints.pgm.Vertex
import com.tinkerpop.gremlin.Gremlin
import com.tinkerpop.gremlin.GremlinTokens
import com.tinkerpop.gremlin.GremlinTokens.T
import com.tinkerpop.pipes.Pipe
import com.tinkerpop.pipes.PipeHelper
import com.tinkerpop.pipes.filter.ComparisonFilterPipe.Filter
import com.tinkerpop.pipes.sideeffect.AggregatorPipe
import com.tinkerpop.pipes.util.GatherPipe
import com.tinkerpop.pipes.util.HasNextPipe
import com.tinkerpop.pipes.util.PathPipe
import com.tinkerpop.pipes.util.ScatterPipe
import com.tinkerpop.gremlin.pipes.*
import com.tinkerpop.pipes.filter.*
import com.tinkerpop.pipes.pgm.*

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

        [Iterator, Iterable].each {
            it.metaClass.count = {
                return PipeHelper.counter(delegate);
            }
        }

        [Iterator, Iterable].each {
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

        [Iterator, Iterable].each {
            it.metaClass.rightShift = {final Integer count ->
                final Iterator itty;
                if (delegate instanceof Iterable) {
                    itty = delegate.iterator();
                } else {
                    itty = (Iterator) delegate;
                }

                if (count == -1) {
                    while (itty.hasNext()) {
                        itty.next();
                    }
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

        [Iterator, Iterable].each {
            it.metaClass.getAt = {final Integer index ->
                return Gremlin.compose(delegate, new RangeFilterPipe(index as Integer, index + 1 as Integer));
            }
        }

        [Iterator, Iterable].each {
            it.metaClass.getAt = {final Range range ->
                return Gremlin.compose(delegate, new RangeFilterPipe(range.getFrom() as Integer, range.getTo() as Integer));
            }
        }

        [Iterator, Iterable].each {
            it.metaClass.getAt = {final String name ->
                if (name.equals(com.tinkerpop.gremlin.GremlinTokens.ID)) {
                    return Gremlin.compose(delegate, new IdPipe());
                } else if (name.equals(com.tinkerpop.gremlin.GremlinTokens.LABEL)) {
                    return Gremlin.compose(delegate, new LabelPipe());
                } else {
                    return Gremlin.compose(delegate, new PropertyPipe(name));
                }
            }
        }

        [Iterator, Iterable].each {
            it.metaClass.getAt = {final Map map ->
                GremlinPipeline pipeline = Gremlin.compose(delegate);
                map.each {key, value ->
                    if (key.equals(com.tinkerpop.gremlin.GremlinTokens.LABEL)) {
                        if (value instanceof List) {
                            pipeline.addPipe(new LabelFilterPipe((String) value[1], Gremlin.mapFilter(value[0])))
                        } else {
                            pipeline.addPipe(new LabelFilterPipe((String) value, Filter.NOT_EQUAL));
                        }
                    } else if (key.equals(com.tinkerpop.gremlin.GremlinTokens.ID)) {
                        if (value instanceof List) {
                            pipeline.addPipe(new IdFilterPipe(value[1], Gremlin.mapFilter(value[0])))
                        } else {
                            pipeline.addPipe(new IdFilterPipe(value, Filter.NOT_EQUAL));
                        }
                    } else {
                        if (value instanceof List) {
                            pipeline.addPipe(new PropertyFilterPipe((String) key, value[1], Gremlin.mapFilter(value[0])))
                        } else {
                            pipeline.addPipe(new PropertyFilterPipe((String) key, value, Filter.NOT_EQUAL))
                        }
                    }

                }
                return pipeline;
            }
        }

        ///////////////////////////
        ////////// PIPES //////////
        ///////////////////////////

        Gremlin.addStep(GremlinTokens.FOREACH);
        [Iterator, Iterable].each {
            it.metaClass.foreach = {final Closure closure ->
                return Gremlin.compose(delegate, new ForeachPipe(closure));
            }
        }

        Gremlin.addStep(GremlinTokens.EMIT);
        [Iterator, Iterable].each {
            it.metaClass.emit = {final Closure closure ->
                return Gremlin.compose(delegate, new EmitPipe(closure));
            }
        }

        Gremlin.addStep(GremlinTokens.FILTER);
        [Iterator, Iterable].each {
            it.metaClass.filter = {final Closure closure ->
                return Gremlin.compose(delegate, new ClosureFilterPipe(closure));
            }
        }

        Gremlin.addStep(GremlinTokens.UNIQUEPATH);
        [Iterator, Iterable].each {
            it.metaClass.uniquePath = {final Closure closure ->
                return Gremlin.compose(delegate, new UniquePathFilterPipe(), closure);
            }
        }

        Gremlin.addStep(GremlinTokens.IFELSE);
        [Iterator, Iterable].each {
            it.metaClass.ifelse = {final Closure ifClosure, final Closure thenClosure, final Closure elseClosure ->
                return Gremlin.compose(delegate, new IfPipe(ifClosure, thenClosure, elseClosure));
            }
        }

        [Iterator, Iterable].each {
            it.metaClass.ifelse = {final Closure ifClosure, final Closure thenClosure ->
                return Gremlin.compose(delegate, new IfPipe(ifClosure, thenClosure));
            }
        }

        Gremlin.addStep(GremlinTokens.CAP);
        GremlinPipeline.metaClass.cap = {final Closure closure ->
            final GremlinPipeline pipeline = ((GremlinPipeline) delegate);
            pipeline.capPipe(pipeline.size() - 1);
            if (closure) {
                pipeline.addPipe(new ClosureFilterPipe(closure));
            }
            return pipeline;
        }

        Gremlin.addStep(GremlinTokens.LOOP);
        GremlinPipeline.metaClass.loop = {final Integer stepsAgo, final Closure closure ->
            final GremlinPipeline pipeline = ((GremlinPipeline) delegate);
            pipeline.loopPipe(stepsAgo, closure)
            return pipeline;
        }

        Gremlin.addStep(GremlinTokens.AGGREGATE);
        [Iterator, Iterable].each {
            it.metaClass.aggregate = {final Object... params ->
                if (params) {
                    if (params.length == 2) {
                        return Gremlin.compose(delegate, new AggregatorPipe((Collection) params[0]), (Closure) params[1])
                    } else {
                        if (params[0] instanceof Collection) {
                            return Gremlin.compose(delegate, new AggregatorPipe((Collection) params[0]))
                        } else {
                            return Gremlin.compose(delegate, new AggregatorPipe(new LinkedList()), (Closure) params[0])

                        }
                    }
                } else {
                    return Gremlin.compose(delegate, new AggregatorPipe(new LinkedList()));
                }
            }
        }

        Gremlin.addStep(GremlinTokens.EXCEPT);
        [Iterator, Iterable].each {
            it.metaClass.except = {final Collection collection ->
                return Gremlin.compose(delegate, new CollectionFilterPipe(collection, Filter.EQUAL));
            }
        }

        [Iterator, Iterable].each {
            it.metaClass.except = {final Collection collection, final Closure closure ->
                return Gremlin.compose(delegate, new CollectionFilterPipe(collection, Filter.EQUAL), closure);
            }
        }

        Gremlin.addStep(GremlinTokens.RETAIN);
        [Iterator, Iterable].each {
            it.metaClass.retain = {final Collection collection ->
                return Gremlin.compose(delegate, new CollectionFilterPipe(collection, Filter.NOT_EQUAL));
            }
        }

        [Iterator, Iterable].each {
            it.metaClass.retain = {final Collection collection, final Closure closure ->
                return Gremlin.compose(delegate, new CollectionFilterPipe(collection, Filter.NOT_EQUAL), closure);
            }
        }

        Gremlin.addStep(GremlinTokens.GROUPCOUNT);
        [Iterator, Iterable].each {
            it.metaClass.groupCount = {final Object... params ->
                if (params) {
                    if (params.length == 2) {
                        Gremlin.compose(delegate, new GroupCountClosurePipe((Map) params[0], (Closure) params[1]));
                    } else {
                        if (params[0] instanceof Map) {
                            Gremlin.compose(delegate, new GroupCountClosurePipe((Map) params[0], {it + 1l}));

                        } else {
                            Gremlin.compose(delegate, new GroupCountClosurePipe(new HashMap(), (Closure) params[0]));
                        }
                    }
                } else {
                    return Gremlin.compose(delegate, new GroupCountClosurePipe(new HashMap(), {it + 1l}));
                }
            }
        }

        Gremlin.addStep(GremlinTokens.UNIQUE);
        [Iterator, Iterable].each {
            it.metaClass.unique = {final Closure closure ->
                return Gremlin.compose(delegate, new DuplicateFilterPipe(), closure)
            }
        }

        Gremlin.addStep(GremlinTokens.ANDF);
        [Iterator, Iterable].each {
            it.metaClass.andf = {final Pipe... pipes ->
                return Gremlin.compose(delegate, new AndFilterPipe(pipes.collect {new HasNextPipe((Pipe) it)} as List))
            }
        }

        Gremlin.addStep(GremlinTokens.ORF);
        [Iterator, Iterable].each {
            it.metaClass.orf = {final Pipe... pipes ->
                return Gremlin.compose(delegate, new OrFilterPipe(pipes.collect {new HasNextPipe((Pipe) it)} as List))
            }
        }

        Gremlin.addStep(GremlinTokens.BACK);
        GremlinPipeline.metaClass.back = {final Integer steps ->
            ((GremlinPipeline) delegate).backPipe(steps);
            return delegate;
        }

        Gremlin.addStep(GremlinTokens.GATHER);
        [Iterator, Iterable].each {
            it.metaClass.gather = {final Closure closure ->
                GremlinPipeline pipeline;
                pipeline = Gremlin.compose(delegate, new GatherPipe())
                if (closure)
                    pipeline = Gremlin.compose(pipeline, new ClosurePipe(closure))
                return pipeline;

            }
        }

        Gremlin.addStep(GremlinTokens.SCATTER);
        [Iterator, Iterable].each {
            it.metaClass.scatter = {final Closure closure ->
                return Gremlin.compose(delegate, new ScatterPipe(), closure)
            }
        }

        Gremlin.addStep(GremlinTokens.PATHS);
        [Iterator, Iterable].each {
            it.metaClass.paths = {final Closure closure ->
                return Gremlin.compose(delegate, new PathPipe(), closure)
            }
        }

        Gremlin.addStep(GremlinTokens.STEP);
        [Iterator, Iterable].each {
            it.metaClass.step = {final Closure closure ->
                return Gremlin.compose(delegate, new ClosurePipe(closure))
            }
        }

        Gremlin.addStep(GremlinTokens.PROPF);
        [Iterator, Iterable, Vertex, Edge].each {
            it.metaClass.propf = {final String key, final T t, final Object value ->
                if (key.equals(com.tinkerpop.gremlin.GremlinTokens.ID)) {
                    return Gremlin.compose(delegate, new IdFilterPipe(value, Gremlin.mapFilter(t)));
                } else if (key.equals(com.tinkerpop.gremlin.GremlinTokens.LABEL)) {
                    return Gremlin.compose(delegate, new LabelFilterPipe((String) value, Gremlin.mapFilter(t)))
                } else {
                    return Gremlin.compose(delegate, new PropertyFilterPipe(key, value, Gremlin.mapFilter(t)));
                }
            }
        }

        Gremlin.addStep(GremlinTokens.OUTE);
        [Iterator, Iterable, Vertex].each {
            it.metaClass.outE = {final Closure closure ->
                return Gremlin.compose(delegate, new OutEdgesPipe(), closure)
            }
            it.metaClass.outE = {
                return Gremlin.compose(delegate, new OutEdgesPipe())
            }
        }

        [Iterator, Iterable, Vertex].each {
            it.metaClass.outE = {final String label, final Closure closure ->
                return Gremlin.compose(delegate, new OutEdgesPipe(label), closure)
            }

            it.metaClass.outE = {final String label ->
                return Gremlin.compose(delegate, new OutEdgesPipe(label))
            }
        }

        Gremlin.addStep(GremlinTokens.INE);
        [Iterator, Iterable, Vertex].each {
            it.metaClass.inE = {final Closure closure ->
                return Gremlin.compose(delegate, new InEdgesPipe(), closure)
            }

            it.metaClass.inE = {
                return Gremlin.compose(delegate, new InEdgesPipe())
            }
        }

        [Iterator, Iterable, Vertex].each {
            it.metaClass.inE = {final String label, final Closure closure ->
                return Gremlin.compose(delegate, new InEdgesPipe(label), closure)
            }

            it.metaClass.inE = {final String label ->
                return Gremlin.compose(delegate, new InEdgesPipe(label))
            }
        }

        Gremlin.addStep(GremlinTokens.BOTHE);
        [Iterator, Iterable, Vertex].each {
            it.metaClass.bothE = {final Closure closure ->
                return Gremlin.compose(delegate, new BothEdgesPipe(), closure)
            }

            it.metaClass.bothE = {
                return Gremlin.compose(delegate, new BothEdgesPipe())
            }
        }

        [Iterator, Iterable, Vertex].each {
            it.metaClass.bothE = {final String label, final Closure closure ->
                return Gremlin.compose(delegate, new BothEdgesPipe(label), closure)
            }

            it.metaClass.bothE = {final String label ->
                return Gremlin.compose(delegate, new BothEdgesPipe(label))
            }
        }

        Gremlin.addStep(GremlinTokens.INV);
        [Iterator, Iterable, Edge].each {
            it.metaClass.inV = {final Closure closure ->
                return Gremlin.compose(delegate, new InVertexPipe(), closure)
            }
        }

        Gremlin.addStep(GremlinTokens.OUTV);
        [Iterator, Iterable, Edge].each {
            it.metaClass.outV = {final Closure closure ->
                return Gremlin.compose(delegate, new OutVertexPipe(), closure)
            }
        }

        Gremlin.addStep(GremlinTokens.BOTHV);
        [Iterator, Iterable, Edge].each {
            it.metaClass.bothV = {final Closure closure ->
                return Gremlin.compose(delegate, new BothVerticesPipe(), closure)
            }
        }
    }
}
