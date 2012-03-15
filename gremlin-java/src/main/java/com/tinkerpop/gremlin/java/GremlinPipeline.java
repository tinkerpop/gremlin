package com.tinkerpop.gremlin.java;

import com.tinkerpop.blueprints.pgm.Edge;
import com.tinkerpop.blueprints.pgm.Element;
import com.tinkerpop.blueprints.pgm.Graph;
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
import com.tinkerpop.pipes.filter.OrFilterPipe;
import com.tinkerpop.pipes.filter.RandomFilterPipe;
import com.tinkerpop.pipes.filter.RangeFilterPipe;
import com.tinkerpop.pipes.filter.RetainFilterPipe;
import com.tinkerpop.pipes.sideeffect.AggregatePipe;
import com.tinkerpop.pipes.sideeffect.GroupByPipe;
import com.tinkerpop.pipes.sideeffect.GroupByReducePipe;
import com.tinkerpop.pipes.sideeffect.GroupCountFunctionPipe;
import com.tinkerpop.pipes.sideeffect.GroupCountPipe;
import com.tinkerpop.pipes.sideeffect.OptionalPipe;
import com.tinkerpop.pipes.sideeffect.SideEffectFunctionPipe;
import com.tinkerpop.pipes.sideeffect.SideEffectPipe;
import com.tinkerpop.pipes.sideeffect.StorePipe;
import com.tinkerpop.pipes.sideeffect.TablePipe;
import com.tinkerpop.pipes.sideeffect.TreePipe;
import com.tinkerpop.pipes.transform.GatherPipe;
import com.tinkerpop.pipes.transform.IdentityPipe;
import com.tinkerpop.pipes.transform.MemoizePipe;
import com.tinkerpop.pipes.transform.PathPipe;
import com.tinkerpop.pipes.transform.ScatterPipe;
import com.tinkerpop.pipes.transform.SelectPipe;
import com.tinkerpop.pipes.transform.SideEffectCapPipe;
import com.tinkerpop.pipes.transform.TransformFunctionPipe;
import com.tinkerpop.pipes.util.AsPipe;
import com.tinkerpop.pipes.util.FluentUtility;
import com.tinkerpop.pipes.util.MetaPipe;
import com.tinkerpop.pipes.util.PipeHelper;
import com.tinkerpop.pipes.util.Pipeline;
import com.tinkerpop.pipes.util.StartPipe;
import com.tinkerpop.pipes.util.structures.Pair;
import com.tinkerpop.pipes.util.structures.Row;
import com.tinkerpop.pipes.util.structures.Table;
import com.tinkerpop.pipes.util.structures.Tree;

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

    public <T> GremlinPipeline<S, T> add(final Pipe<?, T> pipe) {
        this.addPipe(pipe);
        return (GremlinPipeline<S, T>) this;
    }

    public GremlinPipeline<S, ? extends Element> has(final String key, final Object value) {
        if (key.equals(Tokens.ID)) {
            return this.add(new IdFilterPipe(value, FilterPipe.Filter.EQUAL));
        } else if (key.equals(Tokens.LABEL)) {
            return this.add(new LabelFilterPipe((String) value, FilterPipe.Filter.EQUAL));
        } else {
            return this.add(new PropertyFilterPipe(key, value, FilterPipe.Filter.EQUAL));
        }
    }

    public GremlinPipeline<S, ? extends Element> has(final String key, final Tokens.T comparison, final Object value) {
        FilterPipe.Filter filter = Tokens.mapFilter(comparison);
        if (key.equals(Tokens.ID)) {
            return this.add(new IdFilterPipe(value, filter));
        } else if (key.equals(Tokens.LABEL)) {
            return this.add(new LabelFilterPipe((String) value, filter));
        } else {
            return this.add(new PropertyFilterPipe(key, value, filter));
        }
    }

    public GremlinPipeline<S, ? extends Element> hasNot(final String key, final Object value) {
        if (key.equals(Tokens.ID)) {
            return this.add(new IdFilterPipe(value, FilterPipe.Filter.NOT_EQUAL));
        } else if (key.equals(Tokens.LABEL)) {
            return this.add(new LabelFilterPipe((String) value, FilterPipe.Filter.NOT_EQUAL));
        } else {
            return this.add(new PropertyFilterPipe(key, value, FilterPipe.Filter.NOT_EQUAL));
        }
    }

    public GremlinPipeline<S, ? extends Element> hasNot(final String key, final Tokens.T comparison, final Object value) {
        FilterPipe.Filter filter = Tokens.mapFlipFilter(comparison);
        if (key.equals(Tokens.ID)) {
            return this.add(new IdFilterPipe(value, filter));
        } else if (key.equals(Tokens.LABEL)) {
            return this.add(new LabelFilterPipe((String) value, filter));
        } else {
            return this.add(new PropertyFilterPipe(key, value, filter));
        }
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


    /**
     * Add a FunctionPipe to the end of the pipeline.
     * The provide provided PipeFunction emits whatever is defined by the function.
     * This serves as an arbitrary step computation.
     *
     * @param function the function of the FunctionPipe
     * @return the extended Pipeline
     */
    public GremlinPipeline<S, ?> step(final PipeFunction function) {
        return this.add(new FunctionPipe(function));
    }

    /**
     * Add an arbitrary Pipe to the end of the pipeline.
     *
     * @param pipe The provided pipe.
     * @param <T>  the object type emitted by the provided pipe.
     * @return the extended Pipeline
     */
    public <T> GremlinPipeline<S, T> step(final Pipe<E, T> pipe) {
        return this.add(pipe);
    }

    ////////////////////
    /// BRANCH PIPES ///
    ////////////////////

    /**
     * Add a CopySplitPipe to the end of the pipeline.
     * The incoming objects are copied to the provided pipes.
     * This "split-pipe" is used in conjunction with some type of "merge-pipe."
     *
     * @param pipes the internal pipes of the CopySplitPipe
     * @return the extended Pipeline
     */
    public GremlinPipeline<S, ?> copySplit(final Pipe<E, ?>... pipes) {
        return this.add(new CopySplitPipe(pipes));
    }

    /**
     * Add an ExhaustMergePipe to the end of the pipeline.
     * The provided pipes' emitted objects are merged where the first pipe's objects are exhausted, then the second, etc.
     *
     * @param pipes the internal pipes ExhaustMergePipe
     * @return the extended Pipeline
     */
    public GremlinPipeline<S, ?> exhaustMerge(final Pipe<E, ?>... pipes) {
        return this.add(new ExhaustMergePipe(pipes));
    }

    /**
     * Add an ExhaustMergePipe to the end of the pipeline.
     * The one-step previous MetaPipe in the pipeline's pipes are used as the internal pipes.
     * The pipes' emitted objects are merged where the first pipe's objects are exhausted, then the second, etc.
     *
     * @return the extended Pipeline
     */
    public GremlinPipeline<S, ?> exhaustMerge() {
        return this.add(new ExhaustMergePipe((((MetaPipe) FluentUtility.removePreviousPipes(this, 1).get(0)).getPipes())));
    }

    /**
     * Add a FairMergePipe to the end of the pipeline.
     * The provided pipes' emitted objects are merged in a round robin fashion.
     *
     * @param pipes the internal pipes of the FairMergePipe
     * @return the extended Pipeline
     */
    public GremlinPipeline<S, ?> fairMerge(final Pipe<E, ?>... pipes) {
        return this.add(new FairMergePipe(pipes));
    }

    /**
     * Add a FairMergePipe to the end of the Pipeline.
     * The one-step previous MetaPipe in the pipeline's pipes are used as the internal pipes.
     * The pipes' emitted objects are merged in a round robin fashion.
     *
     * @return the extended Pipeline
     */
    public GremlinPipeline<S, ?> fairMerge() {
        return this.add(new FairMergePipe((((MetaPipe) FluentUtility.removePreviousPipes(this, 1).get(0)).getPipes())));
    }

    /**
     * Add an IfThenElsePipe to the end of the Pipeline.
     * If the ifFunction is true, then the results of the thenFunction are emitted.
     * If the ifFunction is true, then the results of the elseFunction are emitted.
     *
     * @param ifFunction   the function denoting the "if" part of the pipe
     * @param thenFunction the function denoting the "then" part of the pipe
     * @param elseFunction the function denoting the "else" part of the pipe
     * @return the extended Pipeline
     */
    public GremlinPipeline<S, ?> ifThenElse(final PipeFunction<E, Boolean> ifFunction, final PipeFunction<E, ?> thenFunction, final PipeFunction<E, ?> elseFunction) {
        return this.add(new IfThenElsePipe(ifFunction, thenFunction, elseFunction));
    }

    /**
     * Add a LoopPipe to the end of the Pipeline.
     * Looping is useful for repeating a section of a pipeline.
     * The provided whileFunction determines when to drop out of the loop.
     * The whileFunction is provided a LoopBundle object which contains the object in loop along with other useful metadata.
     *
     * @param numberedStep  the number of steps to loop back to
     * @param whileFunction whether or not to continue looping on the current object
     * @return the extended Pipeline
     */
    public GremlinPipeline<S, E> loop(final int numberedStep, final PipeFunction<LoopPipe.LoopBundle<E>, Boolean> whileFunction) {
        return this.add(new LoopPipe(new Pipeline(FluentUtility.removePreviousPipes(this, numberedStep)), whileFunction));
    }

    /**
     * Add a LoopPipe to the end of the Pipeline.
     * Looping is useful for repeating a section of a pipeline.
     * The provided whileFunction determines when to drop out of the loop.
     * The whileFunction is provided a LoopBundle object which contains the object in loop along with other useful metadata.
     *
     * @param namedStep     the name of the step to loop back to
     * @param whileFunction whether or not to continue looping on the current object
     * @return the extended Pipeline
     */
    public GremlinPipeline<S, E> loop(final String namedStep, final PipeFunction<LoopPipe.LoopBundle<E>, Boolean> whileFunction) {
        return this.add(new LoopPipe(new Pipeline(FluentUtility.removePreviousPipes(this, namedStep)), whileFunction));
    }

    /**
     * Add a LoopPipe to the end of the Pipeline.
     * Looping is useful for repeating a section of a pipeline.
     * The provided whileFunction determines when to drop out of the loop.
     * The provided emitFunction can be used to emit objects that are still going through a loop.
     * The whileFunction and emitFunctions are provided a LoopBundle object which contains the object in loop along with other useful metadata.
     *
     * @param numberedStep  the number of steps to loop back to
     * @param whileFunction whether or not to continue looping on the current object
     * @param emitFunction  whether or not to emit the current object (irrespective of looping)
     * @return the extended Pipeline
     */
    public GremlinPipeline<S, E> loop(final int numberedStep, final PipeFunction<LoopPipe.LoopBundle<E>, Boolean> whileFunction, final PipeFunction<LoopPipe.LoopBundle<E>, Boolean> emitFunction) {
        return this.add(new LoopPipe(new Pipeline(FluentUtility.removePreviousPipes(this, numberedStep)), whileFunction, emitFunction));
    }

    /**
     * Add a LoopPipe to the end of the Pipeline.
     * Looping is useful for repeating a section of a pipeline.
     * The provided whileFunction determines when to drop out of the loop.
     * The provided emitFunction can be used to emit objects that are still going through a loop.
     * The whileFunction and emitFunctions are provided a LoopBundle object which contains the object in loop along with other useful metadata.
     *
     * @param namedStep     the number of steps to loop back to
     * @param whileFunction whether or not to continue looping on the current object
     * @param emitFunction  whether or not to emit the current object (irrespective of looping)
     * @return the extended Pipeline
     */
    public GremlinPipeline<S, E> loop(final String namedStep, final PipeFunction<LoopPipe.LoopBundle<E>, Boolean> whileFunction, final PipeFunction<LoopPipe.LoopBundle<E>, Boolean> emitFunction) {
        return this.add(new LoopPipe(new Pipeline(FluentUtility.removePreviousPipes(this, namedStep)), whileFunction, emitFunction));
    }

    ////////////////////
    /// FILTER PIPES ///
    ////////////////////

    /**
     * Add an AndFilterPipe to the end the Pipeline.
     * If the internal pipes all yield objects, then the object is not filtered.
     * The provided pipes are provided the object as their starts.
     *
     * @param pipes the internal pipes of the AndFilterPipe
     * @return the extended Pipeline
     */
    public GremlinPipeline<S, E> and(final Pipe<E, ?>... pipes) {
        return this.add(new AndFilterPipe<E>(pipes));
    }

    /**
     * Add a BackFilterPipe to the end of the Pipeline.
     * The object that was seen numberedSteps ago is emitted.
     *
     * @param numberedStep the number of steps previous to back up to
     * @return the extended Pipeline
     */
    public GremlinPipeline<S, ?> back(final int numberedStep) {
        return this.add(new BackFilterPipe(new Pipeline(FluentUtility.removePreviousPipes(this, numberedStep))));
    }

    /**
     * Add a BackFilterPipe to the end of the Pipeline.
     * The object that was seen namedSteps ago is emitted.
     *
     * @param namedStep the name of the step previous to back up to
     * @return the extended Pipeline
     */
    public GremlinPipeline<S, ?> back(final String namedStep) {
        return this.add(new BackFilterPipe(new Pipeline(FluentUtility.removePreviousPipes(this, namedStep))));
    }

    /**
     * Add a DuplicateFilterPipe to the end of the Pipeline.
     * Will only emit the object if it has not been seen before.
     *
     * @return the extended Pipeline
     */
    public GremlinPipeline<S, E> dedup() {
        return this.add(new DuplicateFilterPipe<E>());
    }

    /**
     * Add a DuplicateFilterPipe to the end of the Pipeline.
     * Will only emit the object if the object generated by its function hasn't been seen before.
     *
     * @param dedupFunction a function to call on the object to yield the object to dedup on
     * @return the extended Pipeline
     */
    public GremlinPipeline<S, E> dedup(final PipeFunction<E, ?> dedupFunction) {
        return this.add(new DuplicateFilterPipe<E>(dedupFunction));
    }

    /**
     * Add an ExceptFilterPipe to the end of the Pipeline.
     * Will only emit the object if it is not in the provided collection.
     *
     * @param collection the collection except from the stream
     * @return the extended Pipeline
     */
    public GremlinPipeline<S, E> except(final Collection<E> collection) {
        return this.add(new ExceptFilterPipe<E>(collection));
    }

    /**
     * Add an FilterFunctionPipe to the end of the Pipeline.
     * The serves are an arbitrary filter where the filter criteria is provided by the filterFunction.
     *
     * @param filterFunction the filter function of the pipe
     * @return the extended Pipeline
     */
    public GremlinPipeline<S, E> filter(final PipeFunction<E, Boolean> filterFunction) {
        return this.add(new FilterFunctionPipe<E>(filterFunction));
    }

    /**
     * Add an OrFilterPipe to the end the Pipeline.
     * Will only emit the object if one or more of the provides pipes yields an object.
     * The provided pipes are provided the object as their starts.
     *
     * @param pipes the internal pipes of the OrFilterPipe
     * @return the extended Pipeline
     */
    public GremlinPipeline<S, E> or(final Pipe<E, ?>... pipes) {
        return this.add(new OrFilterPipe<E>(pipes));
    }

    /**
     * Add a RandomFilterPipe to the end of the Pipeline.
     * A biased coin toss determines if the object is emitted or not.
     *
     * @param bias the bias of the random coin
     * @return the extended Pipeline
     */
    public GremlinPipeline<S, E> random(final Double bias) {
        return this.add(new RandomFilterPipe<E>(bias));
    }

    /**
     * Add a RageFilterPipe to the end of the Pipeline.
     * Analogous to a high/low index lookup.
     *
     * @param low  the low end of the range
     * @param high the high end of the range
     * @return the extended Pipeline
     */
    public GremlinPipeline<S, E> range(final int low, final int high) {
        return this.add(new RangeFilterPipe<E>(low, high));
    }

    /**
     * Add a RetainFilterPipe to the end of the Pipeline.
     * Will emit the object only if it is in the provided collection.
     *
     * @param collection the collection to retain
     * @return the extended Pipeline
     */
    public GremlinPipeline<S, E> retain(final Collection<E> collection) {
        return this.add(new RetainFilterPipe<E>(collection));
    }

    /**
     * Add a CyclicPathFilterPipe to the end of the Pipeline.
     * If the object's path is repeating (looping), then the object is filtered.
     * Thus, what is emitted are those objects whose history is composed of unique objects.
     *
     * @return the extended Pipeline
     */
    public GremlinPipeline<S, E> simplePath() {
        return this.add(new CyclicPathFilterPipe<E>());
    }

    /////////////////////////
    /// SIDE-EFFECT PIPES ///
    /////////////////////////

    /**
     * Add an AggregatePipe to the end of the Pipeline.
     * The objects prior to aggregate are greedily collected into an ArrayList.
     *
     * @return the extended Pipeline
     */
    public GremlinPipeline<S, E> aggregate() {
        return this.aggregate(new ArrayList<E>());
    }

    /**
     * Add an AggregatePipe to the end of the Pipeline.
     * The objects prior to aggregate are greedily collected into the provided collection.
     *
     * @param aggregate the collection to aggregate results into
     * @return the extended Pipeline
     */
    public GremlinPipeline<S, E> aggregate(final Collection<E> aggregate) {
        return this.add(new AggregatePipe<E>(aggregate));
    }

    /**
     * Add an AggregatePipe to the end of the Pipeline.
     * The results of the function evaluated on the objects prior to the aggregate are greedily collected into the provided collection.
     *
     * @param aggregate         the collection to aggregate results into
     * @param aggregateFunction the function to run over each object prior to insertion into the aggregate
     * @return the extended Pipeline
     */
    public GremlinPipeline<S, E> aggregate(final Collection aggregate, final PipeFunction<E, ?> aggregateFunction) {
        return this.add(new AggregatePipe<E>(aggregate, aggregateFunction));
    }

    /**
     * Add an AggregatePipe to the end of the Pipeline.
     * The results of the function evaluated on the objects prior to the aggregate are greedily collected into an ArrayList.
     *
     * @param aggregateFunction the function to run over each object prior to insertion into the aggregate
     * @return the extended Pipeline
     */
    public GremlinPipeline<S, E> aggregate(final PipeFunction<E, ?> aggregateFunction) {
        return this.aggregate(new ArrayList(), aggregateFunction);
    }

    /**
     * Add an OptionalPipe to the end of the Pipeline.
     * The section of pipeline back to the numbered step is evaluated.
     *
     * @param numberedStep the number of steps previous to optional back to
     * @return the extended Pipeline
     */
    public GremlinPipeline<S, ?> optional(final int numberedStep) {
        return this.add(new OptionalPipe(new Pipeline(FluentUtility.removePreviousPipes(this, numberedStep))));
    }

    /**
     * Add an OptionalPipe to the end of the Pipeline.
     * The section of pipeline back to the partition step is evaluated.
     *
     * @param namedStep the name of the step previous to optional back to
     * @return the extended Pipeline
     */
    public GremlinPipeline<S, ?> optional(final String namedStep) {
        return this.add(new OptionalPipe(new Pipeline(FluentUtility.removePreviousPipes(this, namedStep))));
    }

    /**
     * Add a GroupByPipe to the end of the Pipeline.
     * Group the objects inputted objects according to a key generated from the object and a value generated from the object.
     * The grouping map has values that are Lists.
     *
     * @param map           the map to store the grouping in
     * @param keyFunction   the function that generates the key from the object
     * @param valueFunction the function that generates the value from the function
     * @return the extended Pipeline
     */
    public GremlinPipeline<S, E> groupBy(final Map<?, List<?>> map, final PipeFunction keyFunction, final PipeFunction valueFunction) {
        return this.add(new GroupByPipe(map, keyFunction, valueFunction));
    }

    /**
     * Add a GroupByPipe to the end of the Pipeline.
     * Group the objects inputted objects according to a key generated from the object and a value generated from the object.
     * The grouping map has values that are Lists.
     *
     * @param keyFunction   the function that generates the key from the object
     * @param valueFunction the function that generates the value from the function
     * @return the extended Pipeline
     */
    public GremlinPipeline<S, E> groupBy(final PipeFunction keyFunction, final PipeFunction valueFunction) {
        return this.add(new GroupByPipe(keyFunction, valueFunction));
    }

    /**
     * Add a GroupByReducePipe to the end of the Pipeline.
     * Group the objects inputted objects according to a key generated from the object and a value generated from the object.
     * The grouping map has values that are Lists.
     * When the pipe has no more incoming objects, apply the reduce function to the keyed Lists.
     * The sideEffect is only fully available when the pipe is empty.
     *
     * @param reduceMap      a map to perform the reduce operation on (good for having a later reference)
     * @param keyFunction    the function that generates the key from the object
     * @param valueFunction  the function that generates the value from the function
     * @param reduceFunction the function that reduces the value lists
     * @return the extended Pipeline
     */
    public GremlinPipeline<S, E> groupBy(final Map reduceMap, final PipeFunction keyFunction, final PipeFunction valueFunction, final PipeFunction reduceFunction) {
        return this.add(new GroupByReducePipe(reduceMap, keyFunction, valueFunction, reduceFunction));
    }

    /**
     * Add a GroupByReducePipe to the end of the Pipeline.
     * Group the objects inputted objects according to a key generated from the object and a value generated from the object.
     * The grouping map has values that are Lists.
     * When the pipe has no more incoming objects, apply the reduce function to the keyed Lists.
     * The sideEffect is only fully available when the pipe is empty.
     *
     * @param keyFunction    the function that generates the key from the object
     * @param valueFunction  the function that generates the value from the function
     * @param reduceFunction the function that reduces the value lists
     * @return the extended Pipeline
     */
    public GremlinPipeline<S, E> groupBy(final PipeFunction keyFunction, final PipeFunction valueFunction, final PipeFunction reduceFunction) {
        return this.add(new GroupByReducePipe(keyFunction, valueFunction, reduceFunction));
    }

    /**
     * Add a GroupCountPipe or GroupCountFunctionPipe to the end of the Pipeline.
     * A map is maintained of counts.
     * The map keys are determined by the function on the incoming object.
     * The map values are determined by the function on the incoming object (getA()) and the previous value (getB()).
     *
     * @param map           a provided count map
     * @param keyFunction   the key function to determine map key
     * @param valueFunction the value function to determine map value
     * @return the extended Pipeline
     */
    public GremlinPipeline<S, E> groupCount(final Map<?, Number> map, final PipeFunction keyFunction, final PipeFunction<Pair<?, Number>, Number> valueFunction) {
        return this.add(new GroupCountFunctionPipe(map, keyFunction, valueFunction));
    }

    /**
     * Add a GroupCountPipe or GroupCountFunctionPipe to the end of the Pipeline.
     * map is maintained of counts.
     * The map keys are determined by the function on the incoming object.
     * The map values are determined by the function on the incoming object (getA()) and the previous value (getB()).
     *
     * @param keyFunction   the key function to determine map key
     * @param valueFunction the value function to determine map value
     * @return the extended Pipeline
     */
    public GremlinPipeline<S, E> groupCount(final PipeFunction keyFunction, final PipeFunction<Pair<?, Number>, Number> valueFunction) {
        return this.add(new GroupCountFunctionPipe(keyFunction, valueFunction));
    }

    /**
     * Add a GroupCountPipe or GroupCountFunctionPipe to the end of the Pipeline.
     * A map is maintained of counts.
     * The map keys are determined by the function on the incoming object.
     * The map values are 1 plus the previous value for that key.
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
     * A map is maintained of counts.
     * The map keys are determined by the function on the incoming object.
     * The map values are 1 plus the previous value for that key.
     *
     * @param keyFunction the key function to determine map key
     * @return the extended Pipeline
     */
    public GremlinPipeline<S, E> groupCount(final PipeFunction keyFunction) {
        return this.add(new GroupCountFunctionPipe(keyFunction, null));
    }

    /**
     * Add a GroupCountPipe to the end of the Pipeline.
     * A map is maintained of counts.
     * The map keys are the incoming objects.
     * The map values are 1 plus the previous value for that key.
     *
     * @param map a provided count map
     * @return the extended Pipeline
     */
    public GremlinPipeline<S, E> groupCount(final Map<?, Number> map) {
        return this.add(new GroupCountPipe(map));
    }

    /**
     * Add a GroupCountPipe to the end of the Pipeline.
     * A map is maintained of counts.
     * The map keys are the incoming objects.
     * The map values are 1 plus the previous value for that key.
     *
     * @return the extended Pipeline
     */
    public GremlinPipeline<S, E> groupCount() {
        return this.add(new GroupCountPipe());
    }

    /**
     * Add a SideEffectFunctionPipe to the end of the Pipeline.
     * The provided function is evaluated and the incoming object is the outgoing object.
     *
     * @param sideEffectFunction the function of the pipe
     * @return the extended Pipeline
     */
    public GremlinPipeline<S, E> sideEffect(final PipeFunction<E, ?> sideEffectFunction) {
        return this.add(new SideEffectFunctionPipe(sideEffectFunction));
    }

    /**
     * Add a StorePipe to the end of the Pipeline.
     * Lazily store the incoming objects into the provided collection.
     *
     * @param storage the collection to store results into
     * @return the extended Pipeline
     */
    public GremlinPipeline<S, E> store(final Collection<E> storage) {
        return this.add(new StorePipe<E>(storage));
    }

    /**
     * Add a StorePipe to the end of the Pipeline.
     * Lazily store the object returned by the function over the incoming object into the provided collection.
     *
     * @param storage         the collection to store results into
     * @param storageFunction the function to run over each object prior to insertion into the storage collection
     * @return the extended Pipeline
     */
    public GremlinPipeline<S, E> store(final Collection storage, final PipeFunction<E, ?> storageFunction) {
        return this.add(new StorePipe<E>(storage, storageFunction));
    }

    /**
     * Add an StorePipe to the end of the Pipeline.
     * An ArrayList storage collection is provided and filled lazily with incoming objects.
     *
     * @return the extended Pipeline
     */
    public GremlinPipeline<S, E> store() {
        return this.store(new ArrayList<E>());
    }

    /**
     * Add a StorePipe to the end of the Pipeline.
     * An ArrayList storage collection is provided and filled lazily with the return of the function evaluated over the incoming objects.
     *
     * @param storageFunction the function to run over each object prior to insertion into the storage collection
     * @return the extended Pipeline
     */
    public GremlinPipeline<S, E> store(final PipeFunction<E, ?> storageFunction) {
        return this.store(new ArrayList(), storageFunction);
    }

    /**
     * Add a TablePipe to the end of the Pipeline.
     * This step is used for grabbing previously seen objects the pipeline as identified by as-steps.
     *
     * @param table           the table to fill
     * @param stepNames       the partition steps to include in the filling
     * @param columnFunctions the post-processing function for each column
     * @return the extended Pipeline
     */
    public GremlinPipeline<S, E> table(final Table table, final Collection<String> stepNames, final PipeFunction... columnFunctions) {
        return this.add(new TablePipe(table, stepNames, FluentUtility.getAsPipes(this), columnFunctions));
    }

    /**
     * Add a TablePipe to the end of the Pipeline.
     * This step is used for grabbing previously seen objects the pipeline as identified by as-steps.
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
     * This step is used for grabbing previously seen objects the pipeline as identified by as-steps.
     *
     * @param columnFunctions the post-processing function for each column
     * @return the extended Pipeline
     */
    public GremlinPipeline<S, E> table(final PipeFunction... columnFunctions) {
        return this.add(new TablePipe(new Table(), null, FluentUtility.getAsPipes(this), columnFunctions));
    }

    /**
     * Add a TablePipe to the end of the Pipeline.
     * This step is used for grabbing previously seen objects the pipeline as identified by as-steps.
     *
     * @param table the table to fill
     * @return the extended Pipeline
     */
    public GremlinPipeline<S, E> table(final Table table) {
        return this.add(new TablePipe(table, null, FluentUtility.getAsPipes(this)));
    }

    /**
     * Add a TablePipe to the end of the Pipeline.
     * This step is used for grabbing previously seen objects the pipeline as identified by as-steps.
     *
     * @return the extended Pipeline
     */
    public GremlinPipeline<S, E> table() {
        return this.add(new TablePipe(new Table(), null, FluentUtility.getAsPipes(this)));
    }

    /**
     * Add a TreePipe to the end of the Pipeline
     * This step maintains an internal tree representation of the paths that have flowed through the step.
     *
     * @param tree            an embedded Map data structure to store the tree representation in
     * @param branchFunctions functions to apply to each path object in a round robin fashion
     * @return the extended Pipeline
     */
    public GremlinPipeline<S, E> tree(final Tree tree, final PipeFunction... branchFunctions) {
        return this.add(new TreePipe<E>(tree, branchFunctions));
    }

    /**
     * Add a TreePipe to the end of the Pipeline
     * This step maintains an internal tree representation of the paths that have flowed through the step.
     *
     * @param branchFunctions functions to apply to each path object in a round robin fashion
     * @return the extended Pipeline
     */
    public GremlinPipeline<S, E> tree(final PipeFunction... branchFunctions) {
        return this.add(new TreePipe<E>(branchFunctions));
    }

    ///////////////////////
    /// TRANSFORM PIPES ///
    ///////////////////////

    /**
     * Add a GatherPipe to the end of the Pipeline.
     * All the objects previous to this step are aggregated in a greedy fashion and emitted as a List.
     *
     * @return the extended Pipeline
     */
    public GremlinPipeline<S, List> gather() {
        return this.add(new GatherPipe());
    }

    /**
     * Add a GatherPipe to the end of the Pipeline.
     * All the objects previous to this step are aggregated in a greedy fashion into a List.
     * The provided function is applied to the aggregate and the results of the function are emitted.
     * Typically, the output of the function is a pruned List.
     * This is good for selective breadth-first searching.
     *
     * @param function a transformation to apply to the gathered list
     * @return the extended Pipeline
     */
    public GremlinPipeline<S, List> gather(PipeFunction<List, List> function) {
        return this.add(new GatherPipe(function));
    }

    /**
     * Add an IdentityPipe to the end of the Pipeline.
     * Useful in various situations where a step is needed without processing.
     * For example, useful when two as-steps are needed in a row.
     *
     * @return the extended Pipeline
     */
    public GremlinPipeline<S, E> _() {
        return this.add(new IdentityPipe());
    }

    /**
     * Add a MemoizePipe to the end of the Pipeline.
     * This step will hold a Map of the objects that have entered into its pipeline section.
     * If an input is seen twice, then the map stored output is emitted instead of recomputing the pipeline section.
     *
     * @param namedStep the name of the step previous to memoize to
     * @return the extended Pipeline
     */
    public GremlinPipeline<S, E> memoize(final String namedStep) {
        return this.add(new MemoizePipe(new Pipeline(FluentUtility.removePreviousPipes(this, namedStep))));
    }

    /**
     * Add a MemoizePipe to the end of the Pipeline.
     * This step will hold a Map of the objects that have entered into its pipeline section.
     * If an input is seen twice, then the map stored output is emitted instead of recomputing the pipeline section.
     *
     * @param numberedStep the number of the step previous to memoize to
     * @return the extended Pipeline
     */
    public GremlinPipeline<S, E> memoize(final int numberedStep) {
        return this.add(new MemoizePipe(new Pipeline(FluentUtility.removePreviousPipes(this, numberedStep))));
    }

    /**
     * Add a MemoizePipe to the end of the Pipeline.
     * This step will hold a Map of the objects that have entered into its pipeline section.
     * If an input is seen twice, then the map stored output is emitted instead of recomputing the pipeline section.
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
     * This step will hold a Map of the objects that have entered into its pipeline section.
     * If an input is seen twice, then the map stored output is emitted instead of recomputing the pipeline section.
     *
     * @param numberedStep the number of the step previous to memoize to
     * @param map          the memoization map
     * @return the extended Pipeline
     */
    public GremlinPipeline<S, E> memoize(final int numberedStep, final Map map) {
        return this.add(new MemoizePipe(new Pipeline(FluentUtility.removePreviousPipes(this, numberedStep)), map));
    }

    /**
     * Add a PathPipe or PathPipe to the end of the Pipeline.
     * This will emit the path that has been seen thus far.
     * If path functions are provided, then they are evaluated in a round robin fashion on the objects of the path.
     *
     * @param pathFunctions the path function of the PathPipe
     * @return the extended Pipeline
     */
    public GremlinPipeline<S, List> path(final PipeFunction... pathFunctions) {
        return this.add(new PathPipe<Object>(pathFunctions));
    }

    /**
     * Add a ScatterPipe to the end of the Pipeline.
     * Any inputted iterator or iterable is unrolled and the iterator/iterable's objects are emitted one at a time.
     *
     * @return the extended Pipeline
     */
    public GremlinPipeline<S, ?> scatter() {
        return this.add(new ScatterPipe());
    }

    /**
     * Add a SelectPipe to the end of the Pipeline.
     * The objects of the named steps (via as) previous in the pipeline are emitted as a Row object.
     * A Row object extends ArrayList and simply provides named columns and some helper methods.
     * If column functions are provided, then they are evaluated in a round robin fashion on the objects of the Row.
     *
     * @param stepNames       the name of the steps in the expression to retrieve the objects from
     * @param columnFunctions the functions to apply to the column objects prior to filling the Row
     * @return the extended Pipeline
     */
    public GremlinPipeline<S, Row> select(final Collection<String> stepNames, final PipeFunction... columnFunctions) {
        return this.add(new SelectPipe(stepNames, FluentUtility.getAsPipes(this), columnFunctions));
    }

    /**
     * Add a SelectPipe to the end of the Pipeline.
     * The objects of the named steps (via as) previous in the pipeline are emitted as a Row object.
     * A Row object extends ArrayList and simply provides named columns and some helper methods.
     * If column functions are provided, then they are evaluated in a round robin fashion on the objects of the Row.
     *
     * @param columnFunctions the functions to apply to the column objects prior to filling the Row
     * @return the extended Pipeline
     */
    public GremlinPipeline<S, Row> select(final PipeFunction... columnFunctions) {
        return this.add(new SelectPipe(null, FluentUtility.getAsPipes(this), columnFunctions));
    }

    /**
     * Add a SelectPipe to the end of the Pipeline.
     * The objects of the named steps (via as) previous in the pipeline are emitted as a Row object.
     * A Row object extends ArrayList and simply provides named columns and some helper methods.
     *
     * @return the extended Pipeline
     */
    public GremlinPipeline<S, Row> select() {
        return this.add(new SelectPipe(null, FluentUtility.getAsPipes(this)));
    }

    /**
     * Add a SideEffectCapPipe to the end of the Pipeline.
     * When the previous step in the pipeline is implements SideEffectPipe, then it has a method called getSideEffect().
     * The cap step will greedily iterate the pipeline and then, when its empty, emit the side effect of the previous pipe.
     *
     * @return the extended Pipeline
     */
    public GremlinPipeline<S, ?> cap() {
        return this.add(new SideEffectCapPipe((SideEffectPipe) FluentUtility.removePreviousPipes(this, 1).get(0)));

    }

    /**
     * Add a TransformFunctionPipe to the end of the Pipeline.
     * Given an input, the provided function is computed on the input and the output of that function is emitted.
     *
     * @param function the transformation function of the pipe
     * @return the extended Pipeline
     */
    public <T> GremlinPipeline<S, T> transform(final PipeFunction<E, T> function) {
        return this.add(new TransformFunctionPipe(function));
    }

    //////////////////////
    /// UTILITY PIPES ///
    //////////////////////

    /**
     * Wrap the previous step in an AsPipe.
     * Useful for naming steps and is used in conjunction with various other steps including: loop, select, back, table, etc.
     *
     * @param name the name of the AsPipe
     * @return the extended Pipeline
     */
    public GremlinPipeline<S, E> as(final String name) {
        return this.add(new AsPipe(name, FluentUtility.removePreviousPipes(this, 1).get(0)));
    }

    /**
     * Add a StartPipe to the end of the pipeline.
     * Though, in practice, a StartPipe is usually the beginning.
     * Moreover, the constructor of the Pipeline will internally use StartPipe.
     *
     * @param object the object that serves as the start of the pipeline (iterator/iterable are unfolded)
     * @return the extended Pipeline
     */
    public GremlinPipeline<S, S> start(final S object) {
        this.add(new StartPipe<S>(object));
        FluentUtility.setStarts(this, object);
        return (GremlinPipeline<S, S>) this;
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

    /**
     * Fill the provided collection with the objects in the pipeline.
     *
     * @param collection the collection to fill
     * @return the collection filled
     */
    public Collection<E> fill(final Collection<E> collection) {
        PipeHelper.fillCollection(this, collection);
        return collection;
    }
}