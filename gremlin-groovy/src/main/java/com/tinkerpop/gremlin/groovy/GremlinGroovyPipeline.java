package com.tinkerpop.gremlin.groovy;

import com.tinkerpop.gremlin.pipes.GremlinPipeline;
import com.tinkerpop.pipes.util.Table;
import groovy.lang.Closure;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class GremlinGroovyPipeline<S, E> extends GremlinPipeline<S, E, GremlinGroovyPipeline> {

    public GremlinGroovyPipeline(final Object starts) {
        super(starts);
    }

    public GremlinGroovyPipeline() {
        super();
    }

    public GremlinGroovyPipeline aggregate(final Closure closure) {
        super.aggregate(new GroovyPipeFunction(closure));
        return this;
    }

    public GremlinGroovyPipeline aggregate(final Collection aggregate, final Closure closure) {
        super.aggregate(aggregate, new GroovyPipeFunction(closure));
        return this;
    }

    public GremlinGroovyPipeline filter(final Closure closure) {
        super.filter(new GroovyPipeFunction<Object, Boolean>(closure));
        return this;
    }

    public GremlinGroovyPipeline gather(final Closure closure) {
        super.gather(new GroovyPipeFunction<List, Object>(closure));
        return this;
    }

    public GremlinGroovyPipeline groupCount(final Closure keyClosure, Closure valueClosure) {
        super.groupCount(new GroovyPipeFunction(keyClosure), new GroovyPipeFunction<Number, Number>(valueClosure));
        return this;
    }

    public GremlinGroovyPipeline groupCount(final Closure keyClosure) {
        super.groupCount(new GroovyPipeFunction(keyClosure));
        return this;
    }

    public GremlinGroovyPipeline groupCount(final Map<Object, Number> map, final Closure keyClosure, final Closure valueClosure) {
        super.groupCount(map, new GroovyPipeFunction(keyClosure), new GroovyPipeFunction<Number, Number>(valueClosure));
        return this;
    }

    public GremlinGroovyPipeline groupCount(final Map<Object, Number> map, final Closure keyClosure) {
        super.groupCount(map, new GroovyPipeFunction(keyClosure));
        return this;
    }

    public GremlinGroovyPipeline ifThenElse(final Closure ifClosure, final Closure thenClosure, final Closure elseClosure) {
        super.ifThenElse(new GroovyPipeFunction<Object, Boolean>(ifClosure), new GroovyPipeFunction(thenClosure), new GroovyPipeFunction(elseClosure));
        return this;
    }

    public GremlinGroovyPipeline loop(final Integer numberedStep, final Closure closure) {
        super.loop(numberedStep, new GroovyPipeFunction<Object, Boolean>(closure));
        return this;
    }

    public GremlinGroovyPipeline loop(final String namedStep, final Closure closure) {
        super.loop(namedStep, new GroovyPipeFunction<Object, Boolean>(closure));
        return this;
    }

    public GremlinGroovyPipeline paths(final Closure... closures) {
        super.path(GroovyPipeFunction.generate(closures));
        return this;
    }

    public GremlinGroovyPipeline sideEffect(final Closure closure) {
        super.sideEffect(new GroovyPipeFunction(closure));
        return this;
    }

    public GremlinGroovyPipeline step(final Closure closure) {
        super.step(new GroovyPipeFunction(closure));
        return this;
    }

    public GremlinGroovyPipeline table(final Closure... closures) {
        super.table(new Table(), GroovyPipeFunction.generate(closures));
        return this;
    }


    public GremlinGroovyPipeline table(final Table table, final Closure... closures) {
        super.table(table, GroovyPipeFunction.generate(closures));
        return this;
    }

    public GremlinGroovyPipeline table(final Table table, final List<String> columnNames, final Closure... closures) {
        super.table(table, columnNames, GroovyPipeFunction.generate(closures));
        return this;
    }

    public GremlinGroovyPipeline transform(final Closure closure) {
        super.transform(new GroovyPipeFunction(closure));
        return this;
    }
}
