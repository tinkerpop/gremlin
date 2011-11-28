package com.tinkerpop.gremlin.groovy;

import com.tinkerpop.gremlin.java.GremlinFluentPipeline;
import com.tinkerpop.gremlin.java.GremlinPipeline;
import com.tinkerpop.pipes.branch.LoopPipe;
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

    public GremlinGroovyPipeline(final Object starts) {
        super(starts);
    }

    public GremlinGroovyPipeline<S, E> aggregate(final Closure closure) {
        return (GremlinGroovyPipeline<S, E>) this.aggregate(new GroovyPipeFunction(closure));
    }

    public GremlinGroovyPipeline<S, E> aggregate(final Collection aggregate, final Closure closure) {
        return (GremlinGroovyPipeline<S, E>) this.aggregate(aggregate, new GroovyPipeFunction(closure));
    }

    public GremlinGroovyPipeline<S, E> filter(final Closure closure) {
        return (GremlinGroovyPipeline<S, E>) this.filter(new GroovyPipeFunction<E, Boolean>(closure));
    }

    public GremlinGroovyPipeline<S, ?> gather(final Closure closure) {
        return (GremlinGroovyPipeline<S, ?>) this.gather(new GroovyPipeFunction<List, Object>(closure));
    }

    public GremlinGroovyPipeline<S, E> groupCount(final Closure keyClosure, Closure valueClosure) {
        return (GremlinGroovyPipeline<S, E>) this.groupCount(new GroovyPipeFunction(keyClosure), new GroovyPipeFunction<Number, Number>(valueClosure));
    }

    public GremlinGroovyPipeline<S, E> groupCount(final Closure keyClosure) {
        return (GremlinGroovyPipeline<S, E>) this.groupCount(new GroovyPipeFunction(keyClosure));
    }

    public GremlinGroovyPipeline<S, E> groupCount(final Map<Object, Number> map, final Closure keyClosure, final Closure valueClosure) {
        return (GremlinGroovyPipeline<S, E>) this.groupCount(map, new GroovyPipeFunction(keyClosure), new GroovyPipeFunction<Number, Number>(valueClosure));
    }

    public GremlinGroovyPipeline<S, E> groupCount(final Map<Object, Number> map, final Closure keyClosure) {
        return (GremlinGroovyPipeline<S, E>) this.groupCount(map, new GroovyPipeFunction(keyClosure));
    }

    public GremlinGroovyPipeline<S, ?> ifThenElse(final Closure ifClosure, final Closure thenClosure, final Closure elseClosure) {
        return (GremlinGroovyPipeline<S, ?>) this.ifThenElse(new GroovyPipeFunction<E, Boolean>(ifClosure), new GroovyPipeFunction<E, Object>(thenClosure), new GroovyPipeFunction<E, Object>(elseClosure));
    }

    public GremlinGroovyPipeline<S, E> loop(final Integer numberedStep, final Closure whileClosure) {
        return (GremlinGroovyPipeline<S, E>) this.loop(numberedStep, new GroovyPipeFunction<LoopPipe.LoopBundle<E>, Boolean>(whileClosure));
    }

    public GremlinGroovyPipeline<S, E> loop(final String namedStep, final Closure whileClosure) {
        return (GremlinGroovyPipeline<S, E>) this.loop(namedStep, new GroovyPipeFunction<LoopPipe.LoopBundle<E>, Boolean>(whileClosure));
    }

    public GremlinGroovyPipeline<S, E> loop(final Integer numberedStep, final Closure whileClosure, final Closure emitClosure) {
        return (GremlinGroovyPipeline<S, E>) this.loop(numberedStep, new GroovyPipeFunction<LoopPipe.LoopBundle<E>, Boolean>(whileClosure), new GroovyPipeFunction<LoopPipe.LoopBundle<E>, Boolean>(emitClosure));
    }

    public GremlinGroovyPipeline<S, E> loop(final String namedStep, final Closure whileClosure, final Closure emitClosure) {
        return (GremlinGroovyPipeline<S, E>) this.loop(namedStep, new GroovyPipeFunction<LoopPipe.LoopBundle<E>, Boolean>(whileClosure), new GroovyPipeFunction<LoopPipe.LoopBundle<E>, Boolean>(emitClosure));
    }

    public GremlinGroovyPipeline<S, E> paths(final Closure... closures) {
        return (GremlinGroovyPipeline<S, E>) this.path(GroovyPipeFunction.generate(closures));
    }

    public GremlinGroovyPipeline<S, E> sideEffect(final Closure closure) {
        return (GremlinGroovyPipeline<S, E>) this.sideEffect(new GroovyPipeFunction<E, Object>(closure));
    }

    public GremlinGroovyPipeline<S, ?> step(final Closure closure) {
        return (GremlinGroovyPipeline<S, ?>) this.step(new GroovyPipeFunction(closure));
    }

    public GremlinGroovyPipeline<S, E> store(final Closure closure) {
        return (GremlinGroovyPipeline<S, E>) this.store(new GroovyPipeFunction(closure));
    }

    public GremlinGroovyPipeline<S, E> store(final Collection storage, final Closure closure) {
        return (GremlinGroovyPipeline<S, E>) this.aggregate(storage, new GroovyPipeFunction(closure));
    }

    public GremlinGroovyPipeline<S, E> table(final Closure... closures) {
        return (GremlinGroovyPipeline<S, E>) this.table(new Table(), GroovyPipeFunction.generate(closures));
    }

    public GremlinGroovyPipeline<S, E> table(final Table table, final Closure... closures) {
        return (GremlinGroovyPipeline<S, E>) this.table(table, GroovyPipeFunction.generate(closures));
    }

    public GremlinGroovyPipeline<S, E> table(final Table table, final List<String> columnNames, final Closure... closures) {
        return (GremlinGroovyPipeline<S, E>) this.table(table, columnNames, GroovyPipeFunction.generate(closures));
    }

    public GremlinGroovyPipeline<S, ?> transform(final Closure closure) {
        return (GremlinGroovyPipeline<S, ?>) this.transform(new GroovyPipeFunction(closure));
    }


}