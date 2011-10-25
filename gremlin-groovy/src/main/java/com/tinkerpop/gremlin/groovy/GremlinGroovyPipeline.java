package com.tinkerpop.gremlin.groovy;

import com.tinkerpop.blueprints.pgm.Element;
import com.tinkerpop.blueprints.pgm.Index;
import com.tinkerpop.gremlin.pipes.GremlinFluentPipeline;
import com.tinkerpop.gremlin.pipes.GremlinPipeline;
import com.tinkerpop.gremlin.pipes.transform.IndexElementsPipe;
import com.tinkerpop.pipes.util.Table;
import groovy.lang.Closure;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class GremlinGroovyPipeline<S, E> extends GremlinPipeline<S, E> implements GremlinFluentPipeline<S, E> {

    public GremlinGroovyPipeline() {
        super();
    }

    /**
     * Construct a new GremlinPipeline with a StartPipe as the first pipe given provide start object.
     *
     * @param starts start object (if iterable/iterator, it is unfolded)
     */
    public GremlinGroovyPipeline(final Object starts) {
        super(starts);
    }

    public <T extends Element> GremlinGroovyPipeline(final Index<T> index, final String key, final Object value) {
        super(new IndexElementsPipe<T>(index, key, value));
    }

    public GremlinGroovyPipeline aggregate(final Closure closure) {
        return (GremlinGroovyPipeline) this.aggregate(new GroovyPipeFunction(closure));
    }

    public GremlinGroovyPipeline aggregate(final Collection aggregate, final Closure closure) {
        return (GremlinGroovyPipeline) this.aggregate(aggregate, new GroovyPipeFunction(closure));
    }

    public GremlinGroovyPipeline filter(final Closure closure) {
        return (GremlinGroovyPipeline) this.filter(new GroovyPipeFunction<Object, Boolean>(closure));
    }

    public GremlinGroovyPipeline gather(final Closure closure) {
        return (GremlinGroovyPipeline) this.gather(new GroovyPipeFunction<List, Object>(closure));
    }

    public GremlinGroovyPipeline groupCount(final Closure keyClosure, Closure valueClosure) {
        return (GremlinGroovyPipeline) this.groupCount(new GroovyPipeFunction(keyClosure), new GroovyPipeFunction<Number, Number>(valueClosure));
    }

    public GremlinGroovyPipeline groupCount(final Closure keyClosure) {
        return (GremlinGroovyPipeline) this.groupCount(new GroovyPipeFunction(keyClosure));
    }

    public GremlinGroovyPipeline groupCount(final Map<Object, Number> map, final Closure keyClosure, final Closure valueClosure) {
        return (GremlinGroovyPipeline) this.groupCount(map, new GroovyPipeFunction(keyClosure), new GroovyPipeFunction<Number, Number>(valueClosure));
    }

    public GremlinGroovyPipeline groupCount(final Map<Object, Number> map, final Closure keyClosure) {
        return (GremlinGroovyPipeline) this.groupCount(map, new GroovyPipeFunction(keyClosure));
    }

    public GremlinGroovyPipeline ifThenElse(final Closure ifClosure, final Closure thenClosure, final Closure elseClosure) {
        return (GremlinGroovyPipeline) this.ifThenElse(new GroovyPipeFunction<Object, Boolean>(ifClosure), new GroovyPipeFunction(thenClosure), new GroovyPipeFunction(elseClosure));
    }

    public GremlinGroovyPipeline loop(final Integer numberedStep, final Closure closure) {
        return (GremlinGroovyPipeline) this.loop(numberedStep, new GroovyPipeFunction<Object, Boolean>(closure));
    }

    public GremlinGroovyPipeline loop(final String namedStep, final Closure closure) {
        return (GremlinGroovyPipeline) this.loop(namedStep, new GroovyPipeFunction<Object, Boolean>(closure));
    }

    public GremlinGroovyPipeline paths(final Closure... closures) {
        return (GremlinGroovyPipeline) this.path(GroovyPipeFunction.generate(closures));
    }

    public GremlinGroovyPipeline sideEffect(final Closure closure) {
        return (GremlinGroovyPipeline) this.sideEffect(new GroovyPipeFunction(closure));
    }

    public GremlinGroovyPipeline step(final Closure closure) {
        return (GremlinGroovyPipeline) this.step(new GroovyPipeFunction(closure));
    }

    public GremlinGroovyPipeline table(final Closure... closures) {
        return (GremlinGroovyPipeline) this.table(new Table(), GroovyPipeFunction.generate(closures));
    }

    public GremlinGroovyPipeline table(final Table table, final Closure... closures) {
        return (GremlinGroovyPipeline) this.table(table, GroovyPipeFunction.generate(closures));
    }

    public GremlinGroovyPipeline table(final Table table, final List<String> columnNames, final Closure... closures) {
        return (GremlinGroovyPipeline) this.table(table, columnNames, GroovyPipeFunction.generate(closures));
    }

    public GremlinGroovyPipeline transform(final Closure closure) {
        return (GremlinGroovyPipeline) this.transform(new GroovyPipeFunction(closure));
    }


}
