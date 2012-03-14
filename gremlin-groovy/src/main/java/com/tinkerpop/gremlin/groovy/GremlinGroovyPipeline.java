package com.tinkerpop.gremlin.groovy;

import com.tinkerpop.gremlin.java.GremlinFluentPipeline;
import com.tinkerpop.gremlin.java.GremlinPipeline;
import com.tinkerpop.pipes.branch.LoopPipe;
import com.tinkerpop.pipes.sideeffect.GroupByPipe;
import com.tinkerpop.pipes.sideeffect.GroupByReducePipe;
import com.tinkerpop.pipes.util.structures.Pair;
import com.tinkerpop.pipes.util.structures.Row;
import com.tinkerpop.pipes.util.structures.Table;
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

    public GremlinGroovyPipeline<S, E> dedup(final Closure closure) {
        return (GremlinGroovyPipeline<S, E>) this.dedup(new GroovyPipeFunction<E, Object>(closure));
    }

    public GremlinGroovyPipeline<S, E> filter(final Closure closure) {
        return (GremlinGroovyPipeline<S, E>) this.filter(new GroovyPipeFunction<E, Boolean>(closure));
    }

    public GremlinGroovyPipeline<S, List> gather(final Closure closure) {
        return (GremlinGroovyPipeline<S, List>) this.gather(new GroovyPipeFunction<List, List>(closure));
    }

    public GremlinGroovyPipeline<S, E> groupBy(final Map<?, List<?>> map, final Closure keyClosure, final Closure valueClosure) {
        return (GremlinGroovyPipeline<S, E>) this.add(new GroupByPipe(map, new GroovyPipeFunction(keyClosure), new GroovyPipeFunction(valueClosure)));
    }

    public GremlinGroovyPipeline<S, E> groupBy(final Closure keyClosure, final Closure valueClosure) {
        return (GremlinGroovyPipeline<S, E>) this.add(new GroupByPipe(new GroovyPipeFunction(keyClosure), new GroovyPipeFunction(valueClosure)));
    }

    public GremlinGroovyPipeline<S, E> groupBy(final Closure keyClosure, final Closure valueClosure, Closure reduceClosure) {
        return (GremlinGroovyPipeline<S, E>) this.add(new GroupByReducePipe(new GroovyPipeFunction(keyClosure), new GroovyPipeFunction(valueClosure), new GroovyPipeFunction(reduceClosure)));
    }

    public GremlinGroovyPipeline<S, E> groupBy(final Map reduceMap, final Closure keyClosure, final Closure valueClosure, Closure reduceClosure) {
        return (GremlinGroovyPipeline<S, E>) this.add(new GroupByReducePipe(reduceMap, new GroovyPipeFunction(keyClosure), new GroovyPipeFunction(valueClosure), new GroovyPipeFunction(reduceClosure)));
    }


    public GremlinGroovyPipeline<S, E> groupCount(final Closure keyClosure, Closure valueClosure) {
        return (GremlinGroovyPipeline<S, E>) this.groupCount(new GroovyPipeFunction(keyClosure), new GroovyPipeFunction<Pair<?, Number>, Number>(valueClosure));
    }

    public GremlinGroovyPipeline<S, E> groupCount(final Closure keyClosure) {
        return (GremlinGroovyPipeline<S, E>) this.groupCount(new GroovyPipeFunction(keyClosure));
    }

    public GremlinGroovyPipeline<S, E> groupCount(final Map<Object, Number> map, final Closure keyClosure, final Closure valueClosure) {
        return (GremlinGroovyPipeline<S, E>) this.groupCount(map, new GroovyPipeFunction(keyClosure), new GroovyPipeFunction<Pair<?, Number>, Number>(valueClosure));
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

    public GremlinGroovyPipeline<S, E> path(final Closure... closures) {
        return (GremlinGroovyPipeline<S, E>) this.path(GroovyPipeFunction.generate(closures));
    }

    public GremlinGroovyPipeline<S, E> sideEffect(final Closure closure) {
        return (GremlinGroovyPipeline<S, E>) this.sideEffect(new GroovyPipeFunction<E, Object>(closure));
    }

    public GremlinGroovyPipeline<S, ?> step(final Closure closure) {
        return (GremlinGroovyPipeline<S, ?>) this.step(new GroovyPipeFunction(closure));
    }

    public GremlinGroovyPipeline<S, E> store(final Closure closure) {
        return (GremlinGroovyPipeline<S, E>) this.store(new GroovyPipeFunction<E, Object>(closure));
    }

    public GremlinGroovyPipeline<S, E> store(final Collection storage, final Closure closure) {
        return (GremlinGroovyPipeline<S, E>) this.store(storage, new GroovyPipeFunction<E, Object>(closure));
    }

    public GremlinGroovyPipeline<S, E> table(final Closure... closures) {
        return (GremlinGroovyPipeline<S, E>) this.table(GroovyPipeFunction.generate(closures));
    }

    public GremlinGroovyPipeline<S, E> table(final Table table, final Closure... closures) {
        return (GremlinGroovyPipeline<S, E>) this.table(table, GroovyPipeFunction.generate(closures));
    }

    public GremlinGroovyPipeline<S, E> table(final Table table, final List<String> columnNames, final Closure... closures) {
        return (GremlinGroovyPipeline<S, E>) this.table(table, columnNames, GroovyPipeFunction.generate(closures));
    }

    public GremlinGroovyPipeline<S, E> tree(final Map tree) {
        return (GremlinGroovyPipeline<S, E>) super.tree(tree);
    }

    public GremlinGroovyPipeline<S, E> tree(final Map tree, final Closure... closures) {
        return (GremlinGroovyPipeline<S, E>) this.tree(tree, GroovyPipeFunction.generate(closures));
    }

    public GremlinGroovyPipeline<S, E> tree(final Closure... closures) {
        return (GremlinGroovyPipeline<S, E>) this.tree(GroovyPipeFunction.generate(closures));
    }

    public GremlinGroovyPipeline<S, Row> select(final Closure... closures) {
        return (GremlinGroovyPipeline<S, Row>) this.select(GroovyPipeFunction.generate(closures));
    }

    public GremlinGroovyPipeline<S, Row> select(final Collection<String> columnNames, final Closure... closures) {
        return (GremlinGroovyPipeline<S, Row>) this.select(columnNames, GroovyPipeFunction.generate(closures));
    }

    public GremlinGroovyPipeline<S, Row> select(final Collection<String> columnNames) {
        return (GremlinGroovyPipeline<S, Row>) super.select(columnNames);
    }

    public GremlinGroovyPipeline<S, ?> transform(final Closure closure) {
        return (GremlinGroovyPipeline<S, ?>) this.transform(new GroovyPipeFunction(closure));
    }


}