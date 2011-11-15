package com.tinkerpop.gremlin.pipes;

import com.tinkerpop.blueprints.pgm.Edge;
import com.tinkerpop.blueprints.pgm.Element;
import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.Index;
import com.tinkerpop.blueprints.pgm.Vertex;
import com.tinkerpop.gremlin.Tokens;
import com.tinkerpop.gremlin.pipes.filter.IdFilterPipe;
import com.tinkerpop.gremlin.pipes.filter.LabelFilterPipe;
import com.tinkerpop.gremlin.pipes.filter.PropertyFilterPipe;
import com.tinkerpop.gremlin.pipes.transform.BothEdgesPipe;
import com.tinkerpop.gremlin.pipes.transform.BothPipe;
import com.tinkerpop.gremlin.pipes.transform.BothVerticesPipe;
import com.tinkerpop.gremlin.pipes.transform.EdgesPipe;
import com.tinkerpop.gremlin.pipes.transform.IdEdgePipe;
import com.tinkerpop.gremlin.pipes.transform.IdPipe;
import com.tinkerpop.gremlin.pipes.transform.IdVertexPipe;
import com.tinkerpop.gremlin.pipes.transform.InEdgesPipe;
import com.tinkerpop.gremlin.pipes.transform.InPipe;
import com.tinkerpop.gremlin.pipes.transform.InVertexPipe;
import com.tinkerpop.gremlin.pipes.transform.IndexElementsPipe;
import com.tinkerpop.gremlin.pipes.transform.LabelPipe;
import com.tinkerpop.gremlin.pipes.transform.OutEdgesPipe;
import com.tinkerpop.gremlin.pipes.transform.OutPipe;
import com.tinkerpop.gremlin.pipes.transform.OutVertexPipe;
import com.tinkerpop.gremlin.pipes.transform.PropertyMapPipe;
import com.tinkerpop.gremlin.pipes.transform.PropertyPipe;
import com.tinkerpop.gremlin.pipes.transform.VerticesPipe;
import com.tinkerpop.pipes.FunctionPipe;
import com.tinkerpop.pipes.Pipe;
import com.tinkerpop.pipes.PipeFunction;
import com.tinkerpop.pipes.branch.CopySplitPipe;
import com.tinkerpop.pipes.branch.ExhaustMergePipe;
import com.tinkerpop.pipes.branch.FairMergePipe;
import com.tinkerpop.pipes.branch.IfThenElsePipe;
import com.tinkerpop.pipes.branch.LoopPipe;
import com.tinkerpop.pipes.filter.AndFilterPipe;
import com.tinkerpop.pipes.filter.BackFilterPipe;
import com.tinkerpop.pipes.filter.CyclicPathFilterPipe;
import com.tinkerpop.pipes.filter.DuplicateFilterPipe;
import com.tinkerpop.pipes.filter.ExceptFilterPipe;
import com.tinkerpop.pipes.filter.FilterFunctionPipe;
import com.tinkerpop.pipes.filter.FilterPipe;
import com.tinkerpop.pipes.filter.ObjectFilterPipe;
import com.tinkerpop.pipes.filter.OrFilterPipe;
import com.tinkerpop.pipes.filter.RandomFilterPipe;
import com.tinkerpop.pipes.filter.RangeFilterPipe;
import com.tinkerpop.pipes.filter.RetainFilterPipe;
import com.tinkerpop.pipes.sideeffect.AggregatePipe;
import com.tinkerpop.pipes.sideeffect.GroupCountFunctionPipe;
import com.tinkerpop.pipes.sideeffect.GroupCountPipe;
import com.tinkerpop.pipes.sideeffect.OptionalPipe;
import com.tinkerpop.pipes.sideeffect.SideEffectFunctionPipe;
import com.tinkerpop.pipes.sideeffect.SideEffectPipe;
import com.tinkerpop.pipes.sideeffect.TablePipe;
import com.tinkerpop.pipes.transform.GatherPipe;
import com.tinkerpop.pipes.transform.IdentityPipe;
import com.tinkerpop.pipes.transform.MemoizePipe;
import com.tinkerpop.pipes.transform.PathFunctionPipe;
import com.tinkerpop.pipes.transform.PathPipe;
import com.tinkerpop.pipes.transform.ScatterPipe;
import com.tinkerpop.pipes.transform.SideEffectCapPipe;
import com.tinkerpop.pipes.transform.TransformFunctionPipe;
import com.tinkerpop.pipes.util.AsPipe;
import com.tinkerpop.pipes.util.FluentUtility;
import com.tinkerpop.pipes.util.MetaPipe;
import com.tinkerpop.pipes.util.PipeHelper;
import com.tinkerpop.pipes.util.Pipeline;
import com.tinkerpop.pipes.util.StartPipe;
import com.tinkerpop.pipes.util.Table;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class GremlinPipeline<S, E> extends Pipeline<S, E> implements GremlinFluentPipeline<S, E> {

    public GremlinPipeline() {
        super();
    }

    public GremlinPipeline(final Object starts) {
        super(new StartPipe(starts));
        FluentUtility.setStarts(this, starts);
    }

    /*public <T extends Element> GremlinPipeline(final Index<T> index, final String key, final Object value) {
        super(new IndexElementsPipe<T>(index, key, value));
    }*/

    public <T> GremlinPipeline<S, T> add(final Pipe<?, T> pipe) {
        this.addPipe(pipe);
        return (GremlinPipeline<S, T>) this;
    }

    public GremlinPipeline<S, ? extends Element> idFilter(final Object id, final FilterPipe.Filter filter) {
        return this.add(new IdFilterPipe(id, filter));
    }

    public GremlinPipeline<S, Edge> labelFilter(final String label, final FilterPipe.Filter filter) {
        return this.add(new LabelFilterPipe(label, filter));
    }

    public GremlinPipeline<S, ? extends Element> propertyFilter(final String key, final FilterPipe.Filter filter, final Object value) {
        return this.add(new PropertyFilterPipe(key, value, filter));
    }

    public GremlinPipeline<S, ? extends Element> propertyFilter(final String key, final Tokens.T t, final Object value) {
        return this.add(new PropertyFilterPipe(key, value, Tokens.mapFilter(t)));
    }

    public GremlinPipeline<S, Edge> bothE(final String... labels) {
        return this.add(new BothEdgesPipe(labels));
    }

    public GremlinPipeline<S, Vertex> both(final String... labels) {
        return this.add(new BothPipe(labels));
    }

    public GremlinPipeline<S, Vertex> bothV() {
        return this.add(new BothVerticesPipe());
    }

    public GremlinPipeline<S, Edge> E() {
        return this.add(new EdgesPipe());
    }

    public GremlinPipeline<S, Edge> idEdge(final Graph graph) {
        return this.add(new IdEdgePipe(graph));
    }

    public GremlinPipeline<S, Object> id() {
        return this.add(new IdPipe());
    }

    public GremlinPipeline<S, Vertex> idVertex(final Graph graph) {
        return this.add(new IdVertexPipe(graph));
    }

    public GremlinPipeline<S, Edge> inE(final String... labels) {
        return this.add(new InEdgesPipe(labels));
    }

    public GremlinPipeline<S, Vertex> in(final String... labels) {
        return this.add(new InPipe(labels));
    }

    public GremlinPipeline<S, Vertex> inV() {
        return this.add(new InVertexPipe());
    }

    public GremlinPipeline<S, String> label() {
        return this.add(new LabelPipe());
    }

    public GremlinPipeline<S, Edge> outE(final String... labels) {
        return this.add(new OutEdgesPipe(labels));
    }

    public GremlinPipeline<S, Vertex> out(final String... labels) {
        return this.add(new OutPipe(labels));
    }

    public GremlinPipeline<S, Vertex> outV() {
        return this.add(new OutVertexPipe());
    }

    public GremlinPipeline<S, Map<String, Object>> map() {
        return this.add(new PropertyMapPipe());
    }

    public GremlinPipeline<S, Object> property(final String key) {
        return this.add(new PropertyPipe(key));
    }

    public GremlinPipeline<S, Vertex> V() {
        return this.add(new VerticesPipe());
    }

    public <Q extends Element> GremlinPipeline index(final Index<Q> index, final String key, final Object value) {
        return this.add(new IndexElementsPipe<Q>(index, key, value));
    }

    /********************************************/
    /********************************************/
    /**
     * ****************************************
     */

    public GremlinPipeline<S, ?> step(final PipeFunction function) {
        return this.add(new FunctionPipe(function));
    }

    public <T> GremlinPipeline<S, T> step(final Pipe<?, T> pipe) {
        return this.add(pipe);
    }

    ////////////////////
    /// BRANCH PIPES ///
    ////////////////////

    public GremlinPipeline<S, ?> copySplit(final Pipe... pipes) {
        return this.add(new CopySplitPipe(pipes));
    }

    public GremlinPipeline<S, ?> exhaustMerge(final Pipe... pipes) {
        return this.add(new ExhaustMergePipe(pipes));
    }

    public GremlinPipeline<S, ?> exhaustMerge() {
        return this.add(new ExhaustMergePipe((((MetaPipe) FluentUtility.removePreviousPipes(this, 1).get(0)).getPipes())));
    }

    public GremlinPipeline<S, ?> fairMerge(final Pipe... pipes) {
        return this.add(new FairMergePipe(pipes));
    }

    public GremlinPipeline<S, ?> fairMerge() {
        return this.add(new FairMergePipe((((MetaPipe) FluentUtility.removePreviousPipes(this, 1).get(0)).getPipes())));
    }

    public GremlinPipeline<S, ?> ifThenElse(final PipeFunction<?, Boolean> ifFunction, final PipeFunction thenFunction, final PipeFunction elseFunction) {
        return this.add(new IfThenElsePipe(ifFunction, thenFunction, elseFunction));
    }

    public GremlinPipeline<S, S> loop(final int numberedStep, final PipeFunction<LoopPipe.LoopBundle<S>, Boolean> whileFunction) {
        return this.add(new LoopPipe(new Pipeline(FluentUtility.removePreviousPipes(this, numberedStep)), whileFunction));
    }

    public GremlinPipeline<S, S> loop(final String namedStep, final PipeFunction<LoopPipe.LoopBundle<S>, Boolean> whileFunction) {
        return this.add(new LoopPipe(new Pipeline(FluentUtility.removePreviousPipes(this, namedStep)), whileFunction));
    }

    public GremlinPipeline<S, S> loop(final Pipe pipe, final PipeFunction<LoopPipe.LoopBundle<S>, Boolean> whileFunction) {
        return this.add(new LoopPipe(pipe, whileFunction));
    }

    public GremlinPipeline<S, S> loop(final int numberedStep, final PipeFunction<LoopPipe.LoopBundle<S>, Boolean> whileFunction, final PipeFunction<LoopPipe.LoopBundle<S>, Boolean> emitFunction) {
        return this.add(new LoopPipe(new Pipeline(FluentUtility.removePreviousPipes(this, numberedStep)), whileFunction, emitFunction));
    }

    public GremlinPipeline<S, S> loop(final String namedStep, final PipeFunction<LoopPipe.LoopBundle<S>, Boolean> whileFunction, final PipeFunction<LoopPipe.LoopBundle<S>, Boolean> emitFunction) {
        return this.add(new LoopPipe(new Pipeline(FluentUtility.removePreviousPipes(this, namedStep)), whileFunction, emitFunction));
    }

    public GremlinPipeline<S, S> loop(final Pipe pipe, final PipeFunction<LoopPipe.LoopBundle<S>, Boolean> whileFunction, final PipeFunction<LoopPipe.LoopBundle<S>, Boolean> emitFunction) {
        return this.add(new LoopPipe(pipe, whileFunction, emitFunction));
    }

    ////////////////////
    /// FILTER PIPES ///
    ////////////////////

    public GremlinPipeline<S, E> and(final Pipe<?, Boolean>... pipes) {
        return this.add(new AndFilterPipe(pipes));
    }

    public GremlinPipeline<S, ?> back(final int numberedStep) {
        return this.add(new BackFilterPipe(new Pipeline(FluentUtility.removePreviousPipes(this, numberedStep))));
    }

    public GremlinPipeline<S, ?> back(final String namedStep) {
        return this.add(new BackFilterPipe(new Pipeline(FluentUtility.removePreviousPipes(this, namedStep))));
    }

    public GremlinPipeline<S, ?> back(final Pipe pipe) {
        return this.add(new BackFilterPipe(pipe));
    }

    public GremlinPipeline<S, E> dedup() {
        return this.add(new DuplicateFilterPipe());
    }

    public GremlinPipeline<S, E> except(final Collection collection) {
        return this.add(new ExceptFilterPipe(collection));
    }

    public GremlinPipeline<S, E> filter(final PipeFunction<?, Boolean> filterFunction) {
        return this.add(new FilterFunctionPipe(filterFunction));
    }

    public GremlinPipeline<S, E> objectFilter(final Object object, final FilterPipe.Filter filter) {
        return this.add(new ObjectFilterPipe(object, filter));
    }

    public GremlinPipeline<S, E> or(final Pipe<S, Boolean>... pipes) {
        return this.add(new OrFilterPipe(pipes));
    }

    public GremlinPipeline<S, E> random(final Double bias) {
        return this.add(new RandomFilterPipe(bias));
    }

    public GremlinPipeline<S, E> range(final int low, final int high) {
        return this.add(new RangeFilterPipe(low, high));
    }

    public GremlinPipeline<S, E> retain(final Collection collection) {
        return this.add(new RetainFilterPipe(collection));
    }

    public GremlinPipeline<S, E> simplePath() {
        return this.add(new CyclicPathFilterPipe());
    }

    /////////////////////////
    /// SIDE-EFFECT PIPES ///
    /////////////////////////

    public GremlinPipeline<S, E> aggregate(final Collection aggregate) {
        return this.add(new AggregatePipe(aggregate));
    }

    public GremlinPipeline<S, E> aggregate(final Collection aggregate, final PipeFunction aggregateFunction) {
        return this.add(new AggregatePipe(aggregate, aggregateFunction));
    }

    public GremlinPipeline<S, E> aggregate() {
        return this.aggregate(new ArrayList());
    }

    public GremlinPipeline<S, E> aggregate(final PipeFunction aggregateFunction) {
        return this.aggregate(new ArrayList(), aggregateFunction);
    }

    public GremlinPipeline<S, ?> optional(final int numberedStep) {
        return this.add(new OptionalPipe(new Pipeline(FluentUtility.removePreviousPipes(this, numberedStep))));
    }

    public GremlinPipeline<S, ?> optional(final String namedStep) {
        return this.add(new OptionalPipe(new Pipeline(FluentUtility.removePreviousPipes(this, namedStep))));
    }

    public GremlinPipeline<S, ?> optional(final Pipe pipe) {
        return this.add(new OptionalPipe(pipe));
    }

    public GremlinPipeline<S, E> groupCount(final Map<?, Number> map, final PipeFunction keyFunction, final PipeFunction<Number, Number> valueFunction) {
        return this.add(new GroupCountFunctionPipe(map, keyFunction, valueFunction));
    }

    public GremlinPipeline<S, E> groupCount(final PipeFunction keyFunction, final PipeFunction<Number, Number> valueFunction) {
        return this.add(new GroupCountFunctionPipe(keyFunction, valueFunction));
    }


    /**
     * Add a GroupCountPipe or GroupCountFunctionPipe to the end of the Pipeline.
     *
     * @param map         a provided count map
     * @param keyFunction the key function to determine map key
     * @return the extended Pipeline
     */
    public GremlinPipeline<S, E> groupCount(final Map<?, Number> map, final PipeFunction keyFunction) {
        return this.add(new GroupCountFunctionPipe(map, keyFunction, null));
    }

    /**
     * Add a GroupCountPipe or GroupCountFunctionPipe to the end of the Pipeline.
     *
     * @param keyFunction the key function to determine map key
     * @return the extended Pipeline
     */
    public GremlinPipeline<S, E> groupCount(final PipeFunction keyFunction) {
        return this.add(new GroupCountFunctionPipe(keyFunction, null));
    }


    /**
     * Add a GroupCountPipe to the end of the Pipeline.
     *
     * @param map a provided count map
     * @return the extended Pipeline
     */
    public GremlinPipeline<S, E> groupCount(final Map<?, Number> map) {
        return this.add(new GroupCountPipe(map));
    }

    /**
     * Add a GroupCountPipe to the end of the Pipeline.
     *
     * @return the extended Pipeline
     */
    public GremlinPipeline<S, E> groupCount() {
        return this.add(new GroupCountPipe());
    }


    /**
     * Add a SideEffectFunctionPipe to the end of the Pipeline.
     *
     * @param sideEffectFunction the function of the pipe
     * @return the extended Pipeline
     */
    public GremlinPipeline<S, E> sideEffect(final PipeFunction sideEffectFunction) {
        return this.add(new SideEffectFunctionPipe(sideEffectFunction));
    }

    /**
     * Add a TablePipe to the end of the Pipeline.
     *
     * @param table           the table to fill
     * @param stepNames       the named steps to include in the filling
     * @param columnFunctions the post-processing function for each column
     * @return the extended Pipeline
     */
    public GremlinPipeline<S, E> table(final Table table, final Collection<String> stepNames, final PipeFunction... columnFunctions) {
        return this.add(new TablePipe(table, stepNames, FluentUtility.getAsPipes(this), columnFunctions));
    }

    /**
     * Add a TablePipe to the end of the Pipeline.
     *
     * @param table           the table to fill
     * @param columnFunctions the post-processing function for each column
     * @return the extended Pipeline
     */
    public GremlinPipeline<S, E> table(final Table table, final PipeFunction... columnFunctions) {
        return this.add(new TablePipe(table, null, FluentUtility.getAsPipes(this), columnFunctions));
    }

    /**
     * Add a TablePipe to the end of the Pipeline.
     *
     * @param table the table to fill
     * @return the extended Pipeline
     */
    public GremlinPipeline<S, E> table(final Table table) {
        return this.add(new TablePipe(table, null, FluentUtility.getAsPipes(this)));
    }

    /**
     * Add a TablePipe to the end of the Pipeline.
     *
     * @return the extended Pipeline
     */
    public GremlinPipeline<S, E> table() {
        return this.add(new TablePipe(new Table(), null, FluentUtility.getAsPipes(this)));
    }

    ///////////////////////
    /// TRANSFORM PIPES ///
    ///////////////////////

    public GremlinPipeline<S, List<?>> gather() {
        return this.add(new GatherPipe());
    }

    public GremlinPipeline<S, ?> gather(PipeFunction<List, ?> function) {
        this.addPipe(new GatherPipe());
        return this.add(new TransformFunctionPipe(function));
    }

    public GremlinPipeline<S, E> _() {
        return this.add(new IdentityPipe());
    }

    /**
     * Add a MemoizePipe to the end of the Pipeline.
     *
     * @param namedStep the name of the step previous to memoize to
     * @return the extended Pipeline
     */
    public GremlinPipeline<S, E> memoize(final String namedStep) {
        return this.add(new MemoizePipe(new Pipeline(FluentUtility.removePreviousPipes(this, namedStep))));
    }

    /**
     * Add a MemoizePipe to the end of the Pipeline.
     *
     * @param numberedStep the number of the step previous to memoize to
     * @return the extended Pipeline
     */
    public GremlinPipeline<S, E> memoize(final int numberedStep) {
        return this.add(new MemoizePipe(new Pipeline(FluentUtility.removePreviousPipes(this, numberedStep))));
    }

    /**
     * Add a MemoizePipe to the end of the Pipeline.
     *
     * @param namedStep the name of the step previous to memoize to
     * @param map       the memoization map
     * @return the extended Pipeline
     */
    public GremlinPipeline<S, E> memoize(final String namedStep, final Map map) {
        return this.add(new MemoizePipe(new Pipeline(FluentUtility.removePreviousPipes(this, namedStep)), map));
    }

    /**
     * Add a MemoizePipe to the end of the Pipeline.
     *
     * @param numberedStep the number of the step previous to memoize to
     * @param map          the memoization map
     * @return the extended Pipeline
     */
    public GremlinPipeline<S, E> memoize(final int numberedStep, final Map map) {
        return this.add(new MemoizePipe(new Pipeline(FluentUtility.removePreviousPipes(this, numberedStep)), map));
    }

    public GremlinPipeline<S, List<?>> path(final PipeFunction... pathFunctions) {
        if (pathFunctions.length == 0)
            this.addPipe(new PathPipe());
        else
            this.addPipe(new PathFunctionPipe(pathFunctions));
        return (GremlinPipeline<S, List<?>>) this;
    }

    public GremlinPipeline<S, ?> scatter() {
        return this.add(new ScatterPipe());
    }

    public GremlinPipeline<S, ?> cap() {
        return this.add(new SideEffectCapPipe((SideEffectPipe) FluentUtility.removePreviousPipes(this, 1).get(0)));

    }

    public GremlinPipeline<S, ?> transform(final PipeFunction function) {
        return this.add(new TransformFunctionPipe(function));
    }

    //////////////////////
    /// UTILITY PIPES ///
    //////////////////////


    public GremlinPipeline<S, E> as(final String name) {
        return this.add(new AsPipe(name, FluentUtility.removePreviousPipes(this, 1).get(0)));
    }

    public GremlinPipeline<S, E> start(final Object starts) {
        this.add(new StartPipe(starts));
        FluentUtility.setStarts(this, starts);
        return this;
    }

    ///////////////////////
    /// UTILITY METHODS ///
    ///////////////////////

    public long count() {
        return PipeHelper.counter(this);
    }

    public void iterate() {
        PipeHelper.iterate(this);
    }

    public List<E> next(final int number) {
        final List<E> list = new ArrayList<E>(number);
        PipeHelper.fillCollection(this, list, number);
        return list;
    }

    public List<E> toList() {
        final List<E> list = new ArrayList<E>();
        PipeHelper.fillCollection(this, list);
        return list;
    }

    public Collection<E> fill(final Collection<E> collection) {
        PipeHelper.fillCollection(this, collection);
        return collection;
    }
}