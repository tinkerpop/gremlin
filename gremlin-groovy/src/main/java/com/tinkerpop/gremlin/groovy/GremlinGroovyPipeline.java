package com.tinkerpop.gremlin.groovy;

import com.tinkerpop.gremlin.java.GremlinPipeline;
import com.tinkerpop.pipes.branch.LoopPipe;
import com.tinkerpop.pipes.util.structures.Pair;
import com.tinkerpop.pipes.util.structures.Row;
import com.tinkerpop.pipes.util.structures.Table;
import com.tinkerpop.pipes.util.structures.Tree;
import groovy.lang.Closure;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class GremlinGroovyPipeline<S, E> extends GremlinPipeline<S, E> {

    public GremlinGroovyPipeline() {
        super();
    }

    public GremlinGroovyPipeline(final Object starts) {
        super(starts);
    }

    public GremlinGroovyPipeline<S, E> aggregate(final Closure closure) {
        return (GremlinGroovyPipeline<S, E>) super.aggregate(new GroovyPipeFunction(this.asMap, closure));
    }

    public GremlinGroovyPipeline<S, E> aggregate(final Collection aggregate, final Closure closure) {
        return (GremlinGroovyPipeline<S, E>) super.aggregate(aggregate, new GroovyPipeFunction(this.asMap, closure));
    }

    public GremlinGroovyPipeline<S, E> dedup(final Closure closure) {
        return (GremlinGroovyPipeline<S, E>) super.dedup(new GroovyPipeFunction(this.asMap, closure));
    }

    public GremlinGroovyPipeline<S, E> filter(final Closure closure) {
        return (GremlinGroovyPipeline<S, E>) super.filter(new GroovyPipeFunction(this.asMap, closure));
    }

    public GremlinGroovyPipeline<S, ?> gather(final Closure closure) {
        return (GremlinGroovyPipeline<S, ?>) super.gather(new GroovyPipeFunction(this.asMap, closure));
    }

    public GremlinGroovyPipeline<S, E> groupBy(final Map<?, List<?>> map, final Closure keyClosure, final Closure valueClosure) {
        return (GremlinGroovyPipeline<S, E>) super.groupBy(map, new GroovyPipeFunction(this.asMap, keyClosure), new GroovyPipeFunction(this.asMap, valueClosure));
    }

    public GremlinGroovyPipeline<S, E> groupBy(final Closure keyClosure, final Closure valueClosure) {
        return (GremlinGroovyPipeline<S, E>) super.groupBy(new GroovyPipeFunction(this.asMap, keyClosure), new GroovyPipeFunction(this.asMap, valueClosure));
    }

    public GremlinGroovyPipeline<S, E> groupBy(final Closure keyClosure, final Closure valueClosure, Closure reduceClosure) {
        return (GremlinGroovyPipeline<S, E>) super.groupBy(new GroovyPipeFunction(this.asMap, keyClosure), new GroovyPipeFunction(this.asMap, valueClosure), new GroovyPipeFunction(this.asMap, reduceClosure));
    }

    public GremlinGroovyPipeline<S, E> groupBy(final Map reduceMap, final Closure keyClosure, final Closure valueClosure, Closure reduceClosure) {
        return (GremlinGroovyPipeline<S, E>) super.groupBy(reduceMap, new GroovyPipeFunction(this.asMap, keyClosure), new GroovyPipeFunction(this.asMap, valueClosure), new GroovyPipeFunction(this.asMap, reduceClosure));
    }


    public GremlinGroovyPipeline<S, E> groupCount(final Closure keyClosure, Closure valueClosure) {
        return (GremlinGroovyPipeline<S, E>) super.groupCount(new GroovyPipeFunction(this.asMap, keyClosure), new GroovyPipeFunction<Pair<?, Number>, Number>(this.asMap, valueClosure));
    }

    public GremlinGroovyPipeline<S, E> groupCount(final Closure keyClosure) {
        return (GremlinGroovyPipeline<S, E>) super.groupCount(new GroovyPipeFunction(this.asMap, keyClosure));
    }

    public GremlinGroovyPipeline<S, E> groupCount(final Map<Object, Number> map, final Closure keyClosure, final Closure valueClosure) {
        return (GremlinGroovyPipeline<S, E>) super.groupCount(map, new GroovyPipeFunction(this.asMap, keyClosure), new GroovyPipeFunction<Pair<?, Number>, Number>(this.asMap, valueClosure));
    }

    public GremlinGroovyPipeline<S, E> groupCount(final Map<Object, Number> map, final Closure keyClosure) {
        return (GremlinGroovyPipeline<S, E>) super.groupCount(map, new GroovyPipeFunction(this.asMap, keyClosure));
    }

    public GremlinGroovyPipeline<S, ?> ifThenElse(final Closure ifClosure, final Closure thenClosure, final Closure elseClosure) {
        return (GremlinGroovyPipeline<S, ?>) super.ifThenElse(new GroovyPipeFunction<E, Boolean>(this.asMap, ifClosure), new GroovyPipeFunction<E, Object>(this.asMap, thenClosure), new GroovyPipeFunction<E, Object>(this.asMap, elseClosure));
    }

    public GremlinGroovyPipeline<S, E> loop(final Integer numberedStep, final Closure whileClosure) {
        return (GremlinGroovyPipeline<S, E>) super.loop(numberedStep, new GroovyPipeFunction<LoopPipe.LoopBundle<E>, Boolean>(this.asMap, whileClosure));
    }

    public GremlinGroovyPipeline<S, E> loop(final String namedStep, final Closure whileClosure) {
        return (GremlinGroovyPipeline<S, E>) super.loop(namedStep, new GroovyPipeFunction<LoopPipe.LoopBundle<E>, Boolean>(this.asMap, whileClosure));
    }

    public GremlinGroovyPipeline<S, E> loop(final Integer numberedStep, final Closure whileClosure, final Closure emitClosure) {
        return (GremlinGroovyPipeline<S, E>) super.loop(numberedStep, new GroovyPipeFunction<LoopPipe.LoopBundle<E>, Boolean>(this.asMap, whileClosure), new GroovyPipeFunction<LoopPipe.LoopBundle<E>, Boolean>(this.asMap, emitClosure));
    }

    public GremlinGroovyPipeline<S, E> loop(final String namedStep, final Closure whileClosure, final Closure emitClosure) {
        return (GremlinGroovyPipeline<S, E>) super.loop(namedStep, new GroovyPipeFunction<LoopPipe.LoopBundle<E>, Boolean>(this.asMap, whileClosure), new GroovyPipeFunction<LoopPipe.LoopBundle<E>, Boolean>(this.asMap, emitClosure));
    }

    public GremlinGroovyPipeline<S, E> order(final Closure compareClosure) {
        return (GremlinGroovyPipeline<S, E>) super.order(new GroovyPipeFunction<Pair<E, E>, Integer>(this.asMap, compareClosure));
    }

    public GremlinGroovyPipeline<S, E> path(final Closure... closures) {
        return (GremlinGroovyPipeline<S, E>) super.path(GroovyPipeFunction.generate(this.asMap, closures));
    }

    public GremlinGroovyPipeline<S, E> orderMap(final Closure closure) {
        return (GremlinGroovyPipeline<S, E>) super.orderMap(new GroovyPipeFunction(this.asMap, closure));
    }

    public GremlinGroovyPipeline<S, E> sideEffect(final Closure closure) {
        return (GremlinGroovyPipeline<S, E>) super.sideEffect(new GroovyPipeFunction<E, Object>(this.asMap, closure));
    }

    public GremlinGroovyPipeline<S, ?> step(final Closure closure) {
        return (GremlinGroovyPipeline<S, ?>) super.step(new GroovyPipeFunction(this.asMap, closure));
    }

    public GremlinGroovyPipeline<S, E> store(final Closure closure) {
        return (GremlinGroovyPipeline<S, E>) super.store(new GroovyPipeFunction<E, Object>(this.asMap, closure));
    }

    public GremlinGroovyPipeline<S, E> store(final Collection storage, final Closure closure) {
        return (GremlinGroovyPipeline<S, E>) super.store(storage, new GroovyPipeFunction<E, Object>(this.asMap, closure));
    }

    public GremlinGroovyPipeline<S, E> table(final Closure... closures) {
        return (GremlinGroovyPipeline<S, E>) super.table(GroovyPipeFunction.generate(this.asMap, closures));
    }

    public GremlinGroovyPipeline<S, E> table(final Table table, final Closure... closures) {
        return (GremlinGroovyPipeline<S, E>) super.table(table, GroovyPipeFunction.generate(this.asMap, closures));
    }

    public GremlinGroovyPipeline<S, E> table(final Table table, final List<String> columnNames, final Closure... closures) {
        return (GremlinGroovyPipeline<S, E>) super.table(table, columnNames, GroovyPipeFunction.generate(this.asMap, closures));
    }

    public GremlinGroovyPipeline<S, E> tree(final Tree tree) {
        return (GremlinGroovyPipeline<S, E>) super.tree(tree);
    }

    public GremlinGroovyPipeline<S, E> tree(final Tree tree, final Closure... closures) {
        return (GremlinGroovyPipeline<S, E>) super.tree(tree, GroovyPipeFunction.generate(this.asMap, closures));
    }

    public GremlinGroovyPipeline<S, E> tree(final Closure... closures) {
        return (GremlinGroovyPipeline<S, E>) super.tree(GroovyPipeFunction.generate(this.asMap, closures));
    }

    public GremlinGroovyPipeline<S, Row> select(final Closure... closures) {
        return (GremlinGroovyPipeline<S, Row>) this.select(GroovyPipeFunction.generate(this.asMap, closures));
    }

    public GremlinGroovyPipeline<S, Row> select(final Collection<String> columnNames, final Closure... closures) {
        return (GremlinGroovyPipeline<S, Row>) super.select(columnNames, GroovyPipeFunction.generate(this.asMap, closures));
    }

    public GremlinGroovyPipeline<S, Row> select(final Collection<String> columnNames) {
        return (GremlinGroovyPipeline<S, Row>) super.select(columnNames);
    }

    public GremlinGroovyPipeline<S, ?> transform(final Closure closure) {
        return (GremlinGroovyPipeline<S, ?>) super.transform(new GroovyPipeFunction(this.asMap, closure));
    }
}