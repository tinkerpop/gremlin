package com.tinkerpop.gremlin.pipes;

import com.tinkerpop.blueprints.pgm.Edge;
import com.tinkerpop.blueprints.pgm.Element;
import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.Index;
import com.tinkerpop.blueprints.pgm.Vertex;
import com.tinkerpop.gremlin.GremlinFluentPipeline;
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

    /**
     * Construct a new GremlinPipeline with a StartPipe as the first pipe given provide start object.
     *
     * @param starts start object (if iterable/iterator, it is unfolded)
     */
    public GremlinPipeline(final Object starts) {
        super(new StartPipe(starts));
        FluentUtility.setStarts(this, starts);
    }

    /*public <T extends Element> GremlinPipeline(final Index<T> index, final String key, final Object value) {
        super(new IndexElementsPipe<T>(index, key, value));
    }*/

    /**
     * Add an arbitrary Pipe to the end of the pipeline.
     *
     * @param pipe the pipe to concatenate to the end of the pipeline
     * @return the extended Pipeline
     */
    public GremlinPipeline add(final Pipe pipe) {
        this.addPipe(pipe);
        return this;
    }

    /**
     * Add an IdFilterPipe to the end of the Pipeline.
     *
     * @param id     the id to filter on
     * @param filter the filter of the pipe
     * @return the extended Pipeline
     */
    public GremlinPipeline idFilter(final Object id, final FilterPipe.Filter filter) {
        return this.add(new IdFilterPipe(id, filter));
    }

    /**
     * Add a LabelFilterPipe to the end of the Pipeline.
     *
     * @param label  the label to filter on
     * @param filter the filter of the pipe
     * @return the extended Pipeline
     */
    public GremlinPipeline labelFilter(final String label, final FilterPipe.Filter filter) {
        return this.add(new LabelFilterPipe(label, filter));
    }

    /**
     * Add a PropertyFilterPipe to the end of the Pipeline.
     *
     * @param key    the property key to check
     * @param filter the filter of the pipe
     * @param value  the object to filter on
     * @return the extended Pipeline
     */
    public GremlinPipeline propertyFilter(final String key, final FilterPipe.Filter filter, final Object value) {
        return this.add(new PropertyFilterPipe(key, value, filter));
    }

    public GremlinPipeline propertyFilter(final String key, final Tokens.T t, final Object value) {
        return this.add(new PropertyFilterPipe(key, value, Tokens.mapFilter(t)));
    }

    /**
     * Add a BothEdgesPipe to the end of the Pipeline.
     *
     * @param labels the edge labels to traverse
     * @return the extended Pipeline
     */
    public GremlinPipeline<S, Edge> bothE(final String... labels) {
        return this.add(new BothEdgesPipe(labels));
    }

    /**
     * Add a BothPipe to the end of the Pipeline.
     *
     * @param labels the edge labels to traverse
     * @return the extended Pipeline
     */
    public GremlinPipeline<S, Vertex> both(final String... labels) {
        return this.add(new BothPipe(labels));
    }

    /**
     * Add a BothVerticesPipe to the end of the Pipeline.
     *
     * @return the extended Pipeline
     */
    public GremlinPipeline<S, Vertex> bothV() {
        return this.add(new BothVerticesPipe());
    }

    /**
     * Add an EdgesPipe to the end of the Pipeline.
     *
     * @return the extended Pipeline
     */
    public GremlinPipeline<S, Edge> E() {
        return this.add(new EdgesPipe());
    }

    /**
     * Add an IdEdgePipe to the end of the Pipeline.
     *
     * @param graph the graph of the pipe
     * @return the extended Pipeline
     */
    public GremlinPipeline<S, Edge> idEdge(final Graph graph) {
        return this.add(new IdEdgePipe(graph));
    }

    /**
     * Add an IdPipe to the end of the Pipeline.
     *
     * @return the extended Pipeline
     */
    public GremlinPipeline id() {
        return this.add(new IdPipe());
    }

    /**
     * Add an IdVertexPipe to the end of the Pipeline.
     *
     * @param graph the graph of the pipe
     * @return the extended Pipeline
     */
    public GremlinPipeline<S, Vertex> idVertex(final Graph graph) {
        return this.add(new IdVertexPipe(graph));
    }

    /**
     * Add an InEdgesPipe to the end of the Pipeline.
     *
     * @param labels the edge labels to traverse
     * @return the extended Pipeline
     */
    public GremlinPipeline<S, Edge> inE(final String... labels) {
        return this.add(new InEdgesPipe(labels));
    }

    /**
     * Add a InPipe to the end of the Pipeline.
     *
     * @param labels the edge labels to traverse
     * @return the extended Pipeline
     */
    public GremlinPipeline<S, Vertex> in(final String... labels) {
        return this.add(new InPipe(labels));
    }

    /**
     * Add an InVertexPipe to the end of the Pipeline.
     *
     * @return the extended Pipeline
     */
    public GremlinPipeline<S, Vertex> inV() {
        return this.add(new InVertexPipe());
    }

    /**
     * Add an LabelPipe to the end of the Pipeline
     *
     * @return the extended Pipeline
     */
    public GremlinPipeline<S, String> label() {
        return this.add(new LabelPipe());
    }

    /**
     * Add an OutEdgesPipe to the end of the Pipeline.
     *
     * @param labels the edge labels to traverse
     * @return the extended Pipeline
     */
    public GremlinPipeline<S, Edge> outE(final String... labels) {
        return this.add(new OutEdgesPipe(labels));
    }

    /**
     * Add an OutPipe to the end of the Pipeline.
     *
     * @param labels the edge labels to traverse
     * @return the extended Pipeline
     */
    public GremlinPipeline<S, Vertex> out(final String... labels) {
        return this.add(new OutPipe(labels));
    }

    /**
     * Add an OutVertexPipe to the end of the Pipeline.
     *
     * @return the extended Pipeline
     */
    public GremlinPipeline<S, Vertex> outV() {
        return this.add(new OutVertexPipe());
    }

    /**
     * Add a PropertyMapPipe to the end of the Pipeline.
     *
     * @return the extended Pipeline
     */
    public GremlinPipeline<S, Map<String, Object>> map() {
        return this.add(new PropertyMapPipe());
    }

    /**
     * Add a PropertyPipe to the end of the Pipeline.
     *
     * @param key the property key
     * @return the extended Pipeline
     */
    public GremlinPipeline property(final String key) {
        return this.add(new PropertyPipe(key));
    }

    /**
     * Add a VerticesPipe to the end of the Pipeline
     *
     * @return the extended Pipeline
     */
    public GremlinPipeline<S, Vertex> V() {
        return this.add(new VerticesPipe());
    }

    // utility

    public <Q extends Element> GremlinPipeline index(final Index<Q> index, final String key, final Object value) {
        return this.add(new IndexElementsPipe<Q>(index, key, value));
    }

    /********************************************/
    /********************************************/
    /********************************************/

    /**
     * Add a FunctionPipe to the end of the pipeline.
     *
     * @param function the function of the FunctionPipe
     * @return the extended Pipeline
     */
    public GremlinPipeline step(final PipeFunction function) {
        return this.add(new FunctionPipe(function));
    }

    public GremlinPipeline step(final Pipe pipe) {
        return this.add(pipe);
    }

    ////////////////////
    /// BRANCH PIPES ///
    ////////////////////

    /**
     * Add a CopySplitPipe to the end of the pipeline.
     *
     * @param pipes the internal pipes of the CopySplitPipe
     * @return the extended Pipeline
     */
    public GremlinPipeline copySplit(final Pipe... pipes) {
        return this.add(new CopySplitPipe(pipes));
    }

    /**
     * Add an ExhaustMergePipe to the end of the pipeline.
     *
     * @param pipes the internal pipes ExhaustMergePipe
     * @return the extended Pipeline
     */
    public GremlinPipeline exhaustMerge(final Pipe... pipes) {
        return this.add(new ExhaustMergePipe(pipes));
    }

    /**
     * Add an ExhaustMergePipe to the end of the pipeline.
     * The one-step previous MetaPipe in the pipeline's pipes are used as the internal pipes.
     *
     * @return the extended Pipeline
     */
    public GremlinPipeline exhaustMerge() {
        return this.add(new ExhaustMergePipe((((MetaPipe) FluentUtility.removePreviousPipes(this, 1).get(0)).getPipes())));
    }

    /**
     * Add a FairMergePipe to the end of the pipeline.
     *
     * @param pipes the internal pipes of the FairMergePipe
     * @return the extended Pipeline
     */
    public GremlinPipeline fairMerge(final Pipe... pipes) {
        return this.add(new FairMergePipe(pipes));
    }

    /**
     * Add a FairMergePipe to the end of the Pipeline.
     * The one-step previous MetaPipe in the pipeline's pipes are used as the internal pipes.
     *
     * @return the extended Pipeline
     */
    public GremlinPipeline fairMerge() {
        return this.add(new FairMergePipe((((MetaPipe) FluentUtility.removePreviousPipes(this, 1).get(0)).getPipes())));
    }

    /**
     * Add an IfThenElsePipe to the end of the Pipeline.
     *
     * @param ifFunction   the function denoting the "if" part of the pipe
     * @param thenFunction the function denoting the "then" part of the pipe
     * @param elseFunction the function denoting the "else" part of the pipe
     * @return the extended Pipeline
     */
    public GremlinPipeline ifThenElse(final PipeFunction<?, Boolean> ifFunction, final PipeFunction thenFunction, final PipeFunction elseFunction) {
        return this.add(new IfThenElsePipe(ifFunction, thenFunction, elseFunction));
    }

    /**
     * Add a LoopPipe to the end of the Pipeline.
     *
     * @param numberedStep  the number of steps previous to loop back to
     * @param whileFunction the "while()" whileFunction of the LoopPipe
     * @return the extended Pipeline
     */
    public GremlinPipeline loop(final int numberedStep, final PipeFunction<?, Boolean> whileFunction) {
        return this.add(new LoopPipe(new Pipeline(FluentUtility.removePreviousPipes(this, numberedStep)), whileFunction));
    }

    /**
     * Add a LoopPipe ot the end of the Pipeline.
     *
     * @param namedStep     the name of the step previous to loop back to
     * @param whileFunction the "while()" function of the LoopPipe
     * @return the extended Pipeline
     */
    public GremlinPipeline loop(final String namedStep, final PipeFunction<?, Boolean> whileFunction) {
        return this.add(new LoopPipe(new Pipeline(FluentUtility.removePreviousPipes(this, namedStep)), whileFunction));
    }

    /**
     * Add a LoopPipe ot the end of the Pipeline.
     *
     * @param pipe          the internal pipe of the LoopPipe
     * @param whileFunction the "while()" function of the LoopPipe
     * @return the extended Pipeline
     */
    public GremlinPipeline loop(final Pipe pipe, final PipeFunction<?, Boolean> whileFunction) {
        return this.add(new LoopPipe(pipe, whileFunction));
    }

    ////////////////////
    /// FILTER PIPES ///
    ////////////////////

    /**
     * Add an AndFilterPipe to the end the Pipeline.
     *
     * @param pipes the internal pipes of the AndFilterPipe
     * @return the extended Pipeline
     */
    public GremlinPipeline and(final Pipe<?, Boolean>... pipes) {
        return this.add(new AndFilterPipe(pipes));
    }

    /**
     * Add a BackFilterPipe to the end of the Pipeline.
     *
     * @param numberedStep the number of steps previous to back up to
     * @return the extended Pipeline
     */
    public GremlinPipeline back(final int numberedStep) {
        return this.add(new BackFilterPipe(new Pipeline(FluentUtility.removePreviousPipes(this, numberedStep))));
    }

    /**
     * Add a BackFilterPipe to the end of the Pipeline.
     *
     * @param namedStep the name of the step previous to back up to
     * @return the extended Pipeline
     */
    public GremlinPipeline back(final String namedStep) {
        return this.add(new BackFilterPipe(new Pipeline(FluentUtility.removePreviousPipes(this, namedStep))));
    }

    /**
     * Add a BackFilterPipe to the end of the Pipeline.
     *
     * @param pipe the internal pipe of the BackFilterPipe
     * @return the extended Pipeline
     */
    public GremlinPipeline back(final Pipe pipe) {
        return this.add(new BackFilterPipe(pipe));
    }

    /**
     * Add a DuplicateFilterPipe to the end of the Pipeline.
     *
     * @return the extended Pipeline
     */
    public GremlinPipeline dedup() {
        return this.add(new DuplicateFilterPipe());
    }

    /**
     * Add an ExceptFilterPipe to the end of the Pipeline.
     *
     * @param collection the collection except from the stream
     * @return the extended Pipeline
     */
    public GremlinPipeline except(final Collection collection) {
        return this.add(new ExceptFilterPipe(collection));
    }

    /**
     * Add an FilterFunctionPipe to the end of the Pipeline.
     *
     * @param filterFunction the filter function of the pipe
     * @return the extended Pipeline
     */
    public GremlinPipeline filter(final PipeFunction<?, Boolean> filterFunction) {
        return this.add(new FilterFunctionPipe(filterFunction));
    }

    /**
     * Add an ObjectFilterPipe to the end of the Pipeline.
     *
     * @param object the object to filter on
     * @param filter the filter of the pipe
     * @return the extended Pipeline
     */
    public GremlinPipeline objectFilter(final Object object, final FilterPipe.Filter filter) {
        return this.add(new ObjectFilterPipe(object, filter));
    }

    /**
     * Add an OrFilterPipe to the end the Pipeline.
     *
     * @param pipes the internal pipes of the OrFilterPipe
     * @return the extended Pipeline
     */
    public GremlinPipeline or(final Pipe<S, Boolean>... pipes) {
        return this.add(new OrFilterPipe(pipes));
    }

    /**
     * Add a RandomFilterPipe to the end of the Pipeline.
     *
     * @param bias the bias of the random coin
     * @return the extended Pipeline
     */
    public GremlinPipeline random(final Double bias) {
        return this.add(new RandomFilterPipe(bias));
    }

    /**
     * Add a RageFilterPipe to the end of the Pipeline.
     *
     * @param low  the low end of the range
     * @param high the high end of the range
     * @return the extended Pipeline
     */
    public GremlinPipeline range(final int low, final int high) {
        return this.add(new RangeFilterPipe(low, high));
    }

    /**
     * Add a RetainFilterPipe to the end of the Pipeline.
     *
     * @param collection the collection to retain
     * @return the extended Pipeline
     */
    public GremlinPipeline retain(final Collection collection) {
        return this.add(new RetainFilterPipe(collection));
    }

    /**
     * Add a CyclicPathFilterPipe to the end of the Pipeline.
     *
     * @return the extended Pipeline
     */
    public GremlinPipeline simplePath() {
        return this.add(new CyclicPathFilterPipe());
    }

    /////////////////////////
    /// SIDE-EFFECT PIPES ///
    /////////////////////////

    /**
     * Add an AggregatePipe to the end of the Pipeline.
     *
     * @param aggregate the collection to aggregate results into
     * @return the extended Pipeline
     */
    public GremlinPipeline aggregate(final Collection aggregate) {
        return this.add(new AggregatePipe(aggregate));
    }

    /**
     * Add an AggregatePipe to the end of the Pipeline.
     *
     * @param aggregate         the collection to aggregate results into
     * @param aggregateFunction the function to run over each object prior to insertion into the aggregate
     * @return the extended Pipeline
     */
    public GremlinPipeline aggregate(final Collection aggregate, final PipeFunction aggregateFunction) {
        return this.add(new AggregatePipe(aggregate, aggregateFunction));
    }

    /**
     * Add an AggregatePipe to the end of the Pipeline.
     * An ArrayList aggregate is provided.
     *
     * @return the extended Pipeline
     */
    public GremlinPipeline aggregate() {
        return this.aggregate(new ArrayList());
    }

    /**
     * Add an AggregatePipe to the end of the Pipeline.
     * An ArrayList aggregate is provided.
     *
     * @param aggregateFunction the function to run over each object prior to insertion into the aggregate
     * @return the extended Pipeline
     */
    public GremlinPipeline aggregate(final PipeFunction aggregateFunction) {
        return this.aggregate(new ArrayList(), aggregateFunction);
    }

    // todo do count pipe? (or remove it)

    /**
     * Add an OptionalPipe to the end of the Pipeline.
     *
     * @param numberedStep the number of steps previous to optional back to
     * @return the extended Pipeline
     */
    public GremlinPipeline optional(final int numberedStep) {
        return this.add(new OptionalPipe(new Pipeline(FluentUtility.removePreviousPipes(this, numberedStep))));
    }

    /**
     * Add an OptionalPipe to the end of the Pipeline.
     *
     * @param namedStep the name of the step previous to optional back to
     * @return the extended Pipeline
     */
    public GremlinPipeline optional(final String namedStep) {
        return this.add(new OptionalPipe(new Pipeline(FluentUtility.removePreviousPipes(this, namedStep))));
    }

    /**
     * Add an OptionalPipe to the end of the Pipeline.
     *
     * @param pipe the internal pipe of the OptionalPipe
     * @return the extended Pipeline
     */
    public GremlinPipeline optional(final Pipe pipe) {
        return this.add(new OptionalPipe(pipe));
    }

    /**
     * Add a GroupCountPipe or GroupCountFunctionPipe to the end of the Pipeline.
     *
     * @param map           a provided count map
     * @param keyFunction   the key function to determine map key
     * @param valueFunction the value function to determine map value
     * @return the extended Pipeline
     */
    public GremlinPipeline groupCount(final Map<?, Number> map, final PipeFunction keyFunction, final PipeFunction<Number, Number> valueFunction) {
        return this.add(new GroupCountFunctionPipe(map, keyFunction, valueFunction));
    }

    /**
     * Add a GroupCountPipe or GroupCountFunctionPipe to the end of the Pipeline.
     *
     * @param keyFunction   the key function to determine map key
     * @param valueFunction the value function to determine map value
     * @return the extended Pipeline
     */
    public GremlinPipeline groupCount(final PipeFunction keyFunction, final PipeFunction<Number, Number> valueFunction) {
        return this.add(new GroupCountFunctionPipe(keyFunction, valueFunction));
    }


    /**
     * Add a GroupCountPipe or GroupCountFunctionPipe to the end of the Pipeline.
     *
     * @param map         a provided count map
     * @param keyFunction the key function to determine map key
     * @return the extended Pipeline
     */
    public GremlinPipeline groupCount(final Map<?, Number> map, final PipeFunction keyFunction) {
        return this.add(new GroupCountFunctionPipe(map, keyFunction, null));
    }

    /**
     * Add a GroupCountPipe or GroupCountFunctionPipe to the end of the Pipeline.
     *
     * @param keyFunction the key function to determine map key
     * @return the extended Pipeline
     */
    public GremlinPipeline groupCount(final PipeFunction keyFunction) {
        return this.add(new GroupCountFunctionPipe(keyFunction, null));
    }


    /**
     * Add a GroupCountPipe to the end of the Pipeline.
     *
     * @param map a provided count map
     * @return the extended Pipeline
     */
    public GremlinPipeline groupCount(final Map<?, Number> map) {
        return this.add(new GroupCountPipe(map));
    }

    /**
     * Add a GroupCountPipe to the end of the Pipeline.
     *
     * @return the extended Pipeline
     */
    public GremlinPipeline groupCount() {
        return this.add(new GroupCountPipe());
    }


    /**
     * Add a SideEffectFunctionPipe to the end of the Pipeline.
     *
     * @param sideEffectFunction the function of the pipe
     * @return the extended Pipeline
     */
    public GremlinPipeline sideEffect(final PipeFunction sideEffectFunction) {
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
    public GremlinPipeline table(final Table table, final Collection<String> stepNames, final PipeFunction... columnFunctions) {
        return this.add(new TablePipe(table, stepNames, FluentUtility.getAsPipes(this), columnFunctions));
    }

    /**
     * Add a TablePipe to the end of the Pipeline.
     *
     * @param table           the table to fill
     * @param columnFunctions the post-processing function for each column
     * @return the extended Pipeline
     */
    public GremlinPipeline table(final Table table, final PipeFunction... columnFunctions) {
        return this.add(new TablePipe(table, null, FluentUtility.getAsPipes(this), columnFunctions));
    }

    /**
     * Add a TablePipe to the end of the Pipeline.
     *
     * @param table the table to fill
     * @return the extended Pipeline
     */
    public GremlinPipeline table(final Table table) {
        return this.add(new TablePipe(table, null, FluentUtility.getAsPipes(this)));
    }

    /**
     * Add a TablePipe to the end of the Pipeline.
     *
     * @return the extended Pipeline
     */
    public GremlinPipeline table() {
        return this.add(new TablePipe(new Table(), null, FluentUtility.getAsPipes(this)));
    }

    ///////////////////////
    /// TRANSFORM PIPES ///
    ///////////////////////


    /**
     * Add a GatherPipe to the end of the Pipeline.
     *
     * @return the extended Pipeline
     */
    public GremlinPipeline gather() {
        return this.add(new GatherPipe());
    }

    public GremlinPipeline gather(PipeFunction<List, ?> function) {
        this.addPipe(new GatherPipe());
        return this.add(new TransformFunctionPipe(function));
    }

    /**
     * Add an IdentityPipe to the end of the Pipeline.
     *
     * @return the extended Pipeline
     */
    public GremlinPipeline identity() {
        return this.add(new IdentityPipe());
    }

    /**
     * Add an IdentityPipe to the end of the Pipeline.
     *
     * @return the extended Pipeline
     */
    public GremlinPipeline _() {
        return this.identity();
    }

    /**
     * Add a MemoizePipe to the end of the Pipeline.
     *
     * @param namedStep the name of the step previous to memoize to
     * @return the extended Pipeline
     */
    public GremlinPipeline memoize(final String namedStep) {
        return this.add(new MemoizePipe(new Pipeline(FluentUtility.removePreviousPipes(this, namedStep))));
    }

    /**
     * Add a MemoizePipe to the end of the Pipeline.
     *
     * @param numberedStep the number of the step previous to memoize to
     * @return the extended Pipeline
     */
    public GremlinPipeline memoize(final int numberedStep) {
        return this.add(new MemoizePipe(new Pipeline(FluentUtility.removePreviousPipes(this, numberedStep))));
    }

    /**
     * Add a MemoizePipe to the end of the Pipeline.
     *
     * @param namedStep the name of the step previous to memoize to
     * @param map       the memoization map
     * @return the extended Pipeline
     */
    public GremlinPipeline memoize(final String namedStep, final Map map) {
        return this.add(new MemoizePipe(new Pipeline(FluentUtility.removePreviousPipes(this, namedStep)), map));
    }

    /**
     * Add a MemoizePipe to the end of the Pipeline.
     *
     * @param numberedStep the number of the step previous to memoize to
     * @param map          the memoization map
     * @return the extended Pipeline
     */
    public GremlinPipeline memoize(final int numberedStep, final Map map) {
        return this.add(new MemoizePipe(new Pipeline(FluentUtility.removePreviousPipes(this, numberedStep)), map));
    }

    /**
     * Add a PathPipe or PathFunctionPipe to the end of the Pipeline.
     *
     * @param pathFunctions the path function of the PathFunctionPipe
     * @return the extended Pipeline
     */
    public GremlinPipeline path(final PipeFunction... pathFunctions) {
        if (pathFunctions.length == 0)
            this.addPipe(new PathPipe());
        else
            this.addPipe(new PathFunctionPipe(pathFunctions));
        return this;
    }

    /**
     * Add a PathPipe to the end of the Pipeline.
     *
     * @return the extended Pipeline
     */
    public GremlinPipeline path() {
        return this.add(new PathPipe());
    }

    /**
     * Add a ScatterPipe to the end of the Pipeline.
     *
     * @return the extended Pipeline
     */
    public GremlinPipeline scatter() {
        return this.add(new ScatterPipe());
    }

    /**
     * Add a SideEffectCapPipe to the end of the Pipeline.
     *
     * @return the extended Pipeline
     */
    public GremlinPipeline sideEffectCap() {
        return this.add(new SideEffectCapPipe((SideEffectPipe) FluentUtility.removePreviousPipes(this, 1).get(0)));
    }

    /**
     * Add a SideEffectCapPipe to the end of the Pipeline.
     *
     * @return the extended Pipeline
     */
    public GremlinPipeline cap() {
        return this.sideEffectCap();
    }

    /**
     * Add a TransformFunctionPipe to the end of the Pipeline.
     *
     * @param function the transformation function of the pipe
     * @return the extended Pipeline
     */
    public GremlinPipeline transform(final PipeFunction function) {
        return this.add(new TransformFunctionPipe(function));
    }

    //////////////////////
    /// UTILITY PIPES ///
    //////////////////////

    /**
     * Wrap the previous step in an AsPipe
     *
     * @param name the name of the AsPipe
     * @return the extended Pipeline
     */
    public GremlinPipeline as(final String name) {
        return this.add(new AsPipe(name, FluentUtility.removePreviousPipes(this, 1).get(0)));
    }

    /**
     * Add a StartPipe to the end of the pipeline.
     * Though, in practice, a StartPipe is usually the beginning.
     *
     * @param starts the object that serves as the start of the pipeline (iterator/iterable are unfolded)
     * @return the extended Pipeline
     */
    public GremlinPipeline start(final Object starts) {
        this.add(new StartPipe(starts));
        FluentUtility.setStarts(this, starts);
        return this;
    }

    ///////////////////////
    /// UTILITY METHODS ///
    ///////////////////////

    /**
     * Return the number of objects iterated through the pipeline.
     *
     * @return the number of objects iterated
     */
    public long count() {
        return PipeHelper.counter(this);
    }

    /**
     * Completely drain the pipeline of its objects.
     * Useful when a sideEffect of the pipeline is desired.
     */
    public void iterate() {
        PipeHelper.iterate(this);
    }

    /**
     * Return the next X objects in the pipeline as a list.
     *
     * @param number the number of objects to return
     * @return a list of X objects (if X objects occur)
     */
    public List<E> next(final int number) {
        final List<E> list = new ArrayList<E>(number);
        PipeHelper.fillCollection(this, list, number);
        return list;
    }

    /**
     * Return a list of all the objects in the pipeline.
     *
     * @return a list of all the objects
     */
    public List<E> toList() {
        final List<E> list = new ArrayList<E>();
        PipeHelper.fillCollection(this, list);
        return list;
    }
}
