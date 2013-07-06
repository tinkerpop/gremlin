package com.tinkerpop.gremlin.java;

import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.blueprints.Element;
import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.Predicate;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.gremlin.Tokens;
import com.tinkerpop.pipes.Pipe;
import com.tinkerpop.pipes.PipeFunction;
import com.tinkerpop.pipes.branch.LoopPipe;
import com.tinkerpop.pipes.transform.TransformPipe;
import com.tinkerpop.pipes.util.structures.Pair;
import com.tinkerpop.pipes.util.structures.Row;
import com.tinkerpop.pipes.util.structures.Table;
import com.tinkerpop.pipes.util.structures.Tree;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public interface GremlinFluentPipeline<S, E> {

    /**
     * Add a FunctionPipe to the end of the pipeline.
     * The provide provided PipeFunction emits whatever is defined by the function.
     * This serves as an arbitrary step computation.
     *
     * @param function the function of the FunctionPipe
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline<S, ?> step(final PipeFunction function);

    /**
     * Add an arbitrary Pipe to the end of the pipeline.
     *
     * @param pipe The provided pipe.
     * @param <T>  the object type emitted by the provided pipe.
     * @return the extended Pipeline
     */
    public <T> GremlinFluentPipeline<S, T> step(final Pipe<E, T> pipe);

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
    public GremlinFluentPipeline<S, ?> copySplit(final Pipe<E, ?>... pipes);

    /**
     * Add an ExhaustMergePipe to the end of the pipeline.
     * The one-step previous MetaPipe in the pipeline's pipes are used as the internal pipes.
     * The pipes' emitted objects are merged where the first pipe's objects are exhausted, then the second, etc.
     *
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline<S, ?> exhaustMerge();

    /**
     * Add a FairMergePipe to the end of the Pipeline.
     * The one-step previous MetaPipe in the pipeline's pipes are used as the internal pipes.
     * The pipes' emitted objects are merged in a round robin fashion.
     *
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline<S, ?> fairMerge();

    /**
     * Add an IfThenElsePipe to the end of the Pipeline.
     * If the ifFunction is true, then the results of the thenFunction are emitted.
     * If the ifFunction is false, then the results of the elseFunction are emitted.
     *
     * @param ifFunction   the function denoting the "if" part of the pipe
     * @param thenFunction the function denoting the "then" part of the pipe
     * @param elseFunction the function denoting the "else" part of the pipe
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline<S, ?> ifThenElse(final PipeFunction<E, Boolean> ifFunction, final PipeFunction<E, ?> thenFunction, final PipeFunction<E, ?> elseFunction);

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
    @Deprecated
    public GremlinFluentPipeline<S, E> loop(final int numberedStep, final PipeFunction<LoopPipe.LoopBundle<E>, Boolean> whileFunction);

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
    public GremlinFluentPipeline<S, E> loop(final String namedStep, final PipeFunction<LoopPipe.LoopBundle<E>, Boolean> whileFunction);

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
    @Deprecated
    public GremlinFluentPipeline<S, E> loop(final int numberedStep, final PipeFunction<LoopPipe.LoopBundle<E>, Boolean> whileFunction, final PipeFunction<LoopPipe.LoopBundle<E>, Boolean> emitFunction);

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
    public GremlinFluentPipeline<S, E> loop(final String namedStep, final PipeFunction<LoopPipe.LoopBundle<E>, Boolean> whileFunction, final PipeFunction<LoopPipe.LoopBundle<E>, Boolean> emitFunction);

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
    public GremlinFluentPipeline<S, E> and(final Pipe<E, ?>... pipes);

    /**
     * Add a BackFilterPipe to the end of the Pipeline.
     * The object that was seen numberedSteps ago is emitted.
     *
     * @param numberedStep the number of steps previous to back up to
     * @return the extended Pipeline
     */
    @Deprecated
    public GremlinFluentPipeline<S, ?> back(final int numberedStep);

    /**
     * Add a BackFilterPipe to the end of the Pipeline.
     * The object that was seen namedSteps ago is emitted.
     *
     * @param namedStep the name of the step previous to back up to
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline<S, ?> back(final String namedStep);

    /**
     * Add a DuplicateFilterPipe to the end of the Pipeline.
     * Will only emit the object if it has not been seen before.
     *
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline<S, E> dedup();

    /**
     * Add a DuplicateFilterPipe to the end of the Pipeline.
     * Will only emit the object if the object generated by its function hasn't been seen before.
     *
     * @param dedupFunction a function to call on the object to yield the object to dedup on
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline<S, E> dedup(final PipeFunction<E, ?> dedupFunction);

    /**
     * Add an ExceptFilterPipe to the end of the Pipeline.
     * Will only emit the object if it is not in the provided collection.
     *
     * @param collection the collection except from the stream
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline<S, E> except(final Collection<E> collection);

    /**
     * Add an ExceptFilterPipe to the end of the Pipeline.
     * Will only emit the object if it is not equal to any of the objects contained at the named steps.
     *
     * @param namedSteps the named steps in the pipeline
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline<S, E> except(final String... namedSteps);

    /**
     * Add an FilterFunctionPipe to the end of the Pipeline.
     * The serves are an arbitrary filter where the filter criteria is provided by the filterFunction.
     *
     * @param filterFunction the filter function of the pipe
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline<S, E> filter(final PipeFunction<E, Boolean> filterFunction);

    /**
     * Add an OrFilterPipe to the end the Pipeline.
     * Will only emit the object if one or more of the provides pipes yields an object.
     * The provided pipes are provided the object as their starts.
     *
     * @param pipes the internal pipes of the OrFilterPipe
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline<S, E> or(final Pipe<E, ?>... pipes);

    /**
     * Add a RandomFilterPipe to the end of the Pipeline.
     * A biased coin toss determines if the object is emitted or not.
     *
     * @param bias the bias of the random coin
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline<S, E> random(final Double bias);

    /**
     * Add a RageFilterPipe to the end of the Pipeline.
     * Analogous to a high/low index lookup.
     *
     * @param low  the low end of the range
     * @param high the high end of the range
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline<S, E> range(final int low, final int high);

    /**
     * Add a RetainFilterPipe to the end of the Pipeline.
     * Will emit the object only if it is in the provided collection.
     *
     * @param collection the collection to retain
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline<S, E> retain(final Collection<E> collection);

    /**
     * Add a RetainFilterPipe to the end of the Pipeline.
     * Will only emit the object if it is equal to any of the objects contained at the named steps.
     *
     * @param namedSteps the named steps in the pipeline
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline<S, E> retain(final String... namedSteps);

    /**
     * Add a CyclicPathFilterPipe to the end of the Pipeline.
     * If the object's path is repeating (looping), then the object is filtered.
     * Thus, what is emitted are those objects whose history is composed of unique objects.
     *
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline<S, E> simplePath();

    /**
     * Check if the element has a property with provided key.
     *
     * @param key the property key to check
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline<S, ? extends Element> has(final String key);

    /**
     * Check if the element does not have a property with provided key.
     *
     * @param key the property key to check
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline<S, ? extends Element> hasNot(final String key);

    /**
     * Add an IdFilterPipe, LabelFilterPipe, or PropertyFilterPipe to the end of the Pipeline.
     * If the incoming element has the provided key/value as check with .equals(), then let the element pass.
     * If the key is id or label, then use respect id or label filtering.
     *
     * @param key   the property key to check
     * @param value the object to filter on (in an OR manner)
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline<S, ? extends Element> has(final String key, final Object value);

    /**
     * Add an IdFilterPipe, LabelFilterPipe, or PropertyFilterPipe to the end of the Pipeline.
     * If the incoming element has the provided key/value as check with .equals(), then let the element pass.
     * If the key is id or label, then use respect id or label filtering.
     *
     * @param key          the property key to check
     * @param compareToken the comparison to use
     * @param value        the object to filter on
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline<S, ? extends Element> has(final String key, final Tokens.T compareToken, final Object value);

    /**
     * Add an IdFilterPipe, LabelFilterPipe, or PropertyFilterPipe to the end of the Pipeline.
     * If the incoming element has the provided key/value as check with .equals(), then let the element pass.
     * If the key is id or label, then use respect id or label filtering.
     *
     * @param key       the property key to check
     * @param predicate the comparison to use
     * @param value     the object to filter on
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline<S, ? extends Element> has(final String key, final Predicate predicate, final Object value);

    /**
     * Add an IdFilterPipe, LabelFilterPipe, or PropertyFilterPipe to the end of the Pipeline.
     * If the incoming element has the provided key/value as check with .equals(), then filter the element.
     * If the key is id or label, then use respect id or label filtering.
     *
     * @param key   the property key to check
     * @param value the objects to filter on (in an OR manner)
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline<S, ? extends Element> hasNot(final String key, final Object value);

    /**
     * Add an IntervalFilterPipe to the end of the Pipeline.
     * If the incoming element has a value that is within the interval value range specified, then the element is allows to pass.
     * If hte incoming element's value for the key is null, the element is filtered.
     *
     * @param key        the property key to check
     * @param startValue the start of the interval (inclusive)
     * @param endValue   the end of the interval (exclusive)
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline<S, ? extends Element> interval(final String key, final Comparable startValue, final Comparable endValue);

    ///////////////////////
    /// TRANSFORM PIPES ///
    ///////////////////////


    /**
     * Add a GatherPipe to the end of the Pipeline.
     * All the objects previous to this step are aggregated in a greedy fashion and emitted as a List.
     *
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline<S, List> gather();

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
    public GremlinFluentPipeline<S, ?> gather(final PipeFunction<List, ?> function);

    /**
     * Add an IdentityPipe to the end of the Pipeline.
     * Useful in various situations where a step is needed without processing.
     * For example, useful when two as-steps are needed in a row.
     *
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline<S, E> _();

    /**
     * Add a MemoizePipe to the end of the Pipeline.
     * This step will hold a Map of the objects that have entered into its pipeline section.
     * If an input is seen twice, then the map stored output is emitted instead of recomputing the pipeline section.
     *
     * @param namedStep the name of the step previous to memoize to
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline<S, E> memoize(final String namedStep);

    /**
     * Add a MemoizePipe to the end of the Pipeline.
     * This step will hold a Map of the objects that have entered into its pipeline section.
     * If an input is seen twice, then the map stored output is emitted instead of recomputing the pipeline section.
     *
     * @param numberedStep the number of the step previous to memoize to
     * @return the extended Pipeline
     */
    @Deprecated
    public GremlinFluentPipeline<S, E> memoize(final int numberedStep);

    /**
     * Add a MemoizePipe to the end of the Pipeline.
     * This step will hold a Map of the objects that have entered into its pipeline section.
     * If an input is seen twice, then the map stored output is emitted instead of recomputing the pipeline section.
     *
     * @param namedStep the name of the step previous to memoize to
     * @param map       the memoization map
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline<S, E> memoize(final String namedStep, final Map map);

    /**
     * Add a MemoizePipe to the end of the Pipeline.
     * This step will hold a Map of the objects that have entered into its pipeline section.
     * If an input is seen twice, then the map stored output is emitted instead of recomputing the pipeline section.
     *
     * @param numberedStep the number of the step previous to memoize to
     * @param map          the memoization map
     * @return the extended Pipeline
     */
    @Deprecated
    public GremlinFluentPipeline<S, E> memoize(final int numberedStep, final Map map);

    /**
     * Add an OrderPipe to the end of the Pipeline.
     * This step will sort the objects in the stream in a default Comparable order.
     *
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline<S, E> order();

    /**
     * Add an OrderPipe to the end of the Pipeline.
     * This step will sort the objects in the stream in a default Comparable order.
     *
     * @param order if the stream is composed of comparable objects, then increment or decrement can be specified
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline<S, E> order(TransformPipe.Order order);

    /**
     * Add an OrderPipe to the end of the Pipeline.
     * This step will sort the objects in the stream according to a comparator defined in the provided function.
     *
     * @param compareFunction a comparator function of two objects of type E
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline<S, E> order(final PipeFunction<Pair<E, E>, Integer> compareFunction);

    /**
     * Add a PathPipe or PathPipe to the end of the Pipeline.
     * This will emit the path that has been seen thus far.
     * If path functions are provided, then they are evaluated in a round robin fashion on the objects of the path.
     *
     * @param pathFunctions the path function of the PathPipe
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline<S, List> path(final PipeFunction... pathFunctions);

    /**
     * Add a ScatterPipe to the end of the Pipeline.
     * Any inputted iterator or iterable is unrolled and the iterator/iterable's objects are emitted one at a time.
     *
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline<S, ?> scatter();

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
    public GremlinFluentPipeline<S, Row> select(final Collection<String> stepNames, final PipeFunction... columnFunctions);

    /**
     * Add a SelectPipe to the end of the Pipeline.
     * The objects of the named steps (via as) previous in the pipeline are emitted as a Row object.
     * A Row object extends ArrayList and simply provides named columns and some helper methods.
     * If column functions are provided, then they are evaluated in a round robin fashion on the objects of the Row.
     *
     * @param columnFunctions the functions to apply to the column objects prior to filling the Row
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline<S, Row> select(final PipeFunction... columnFunctions);

    /**
     * Add a SelectPipe to the end of the Pipeline.
     * The objects of the named steps (via as) previous in the pipeline are emitted as a Row object.
     * A Row object extends ArrayList and simply provides named columns and some helper methods.
     *
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline<S, Row> select();

    /**
     * Add a ShufflePipe to the end of the Pipeline.
     * All the objects previous to this step are aggregated in a greedy fashion, their order randomized and emitted
     * as a List.
     *
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline<S, List> shuffle();

    /**
     * Add a SideEffectCapPipe to the end of the Pipeline.
     * When the previous step in the pipeline is implements SideEffectPipe, then it has a method called getSideEffect().
     * The cap step will greedily iterate the pipeline and then, when its empty, emit the side effect of the previous pipe.
     *
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline<S, ?> cap();

    /**
     * Add a OrderMapPipe to the end of the Pipeline
     * Given a Map as an input, the map is first ordered and then the keys are emitted in the order.
     *
     * @param order if the values implement Comparable, then a increment or decrement sort is usable
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline<S, ?> orderMap(TransformPipe.Order order);

    /**
     * Add a OrderMapPipe to the end of the Pipeline
     * Given a Map as an input, the map is first ordered and then the keys are emitted in the order.
     *
     * @param compareFunction a function to compare to map entries
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline<S, ?> orderMap(PipeFunction<Pair<Map.Entry, Map.Entry>, Integer> compareFunction);

    /**
     * Add a TransformFunctionPipe to the end of the Pipeline.
     * Given an input, the provided function is computed on the input and the output of that function is emitted.
     *
     * @param function the transformation function of the pipe
     * @return the extended Pipeline
     */
    public <T> GremlinFluentPipeline<S, T> transform(final PipeFunction<E, T> function);

    /**
     * Add a BothEdgesPipe to the end of the Pipeline.
     * Emit both incoming and outgoing edges for the incoming vertex.
     *
     * @param labels the edge labels to traverse
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline<S, Edge> bothE(final String... labels);

    /**
     * Add a BothEdgesPipe to the end of the Pipeline.
     * Emit the adjacent incoming edges for the incoming vertex.
     *
     * @param branchFactor the number of max incident edges for each incoming vertex
     * @param labels       the edge labels to traverse
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline<S, Edge> bothE(final int branchFactor, final String... labels);

    /**
     * Add a BothPipe to the end of the Pipeline.
     * Emit both the incoming and outgoing adjacent vertices for the incoming vertex.
     *
     * @param labels the edge labels to traverse
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline<S, Vertex> both(final String... labels);

    /**
     * Add a BothPipe to the end of the Pipeline.
     * Emit the adjacent incoming vertices for the incoming vertex.
     *
     * @param branchFactor the number of max adjacent vertices for each incoming vertex
     * @param labels       the edge labels to traverse
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline<S, Vertex> both(final int branchFactor, final String... labels);

    /**
     * Add a BothVerticesPipe to the end of the Pipeline.
     * Emit both the tail and head vertices of the incoming edge.
     *
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline<S, Vertex> bothV();

    /**
     * Add an IdEdgePipe to the end of the Pipeline.
     * Emit the edges of the graph whose ids are those of the incoming id objects.
     *
     * @param graph the graph of the pipe
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline<S, Edge> idEdge(final Graph graph);

    /**
     * Add an IdPipe to the end of the Pipeline.
     * Emit the id of the incoming element.
     *
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline<S, Object> id();

    /**
     * Add an IdVertexPipe to the end of the Pipeline.
     * Emit the vertices of the graph whose ids are those of the incoming id objects.
     *
     * @param graph the graph of the pipe
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline<S, Vertex> idVertex(final Graph graph);

    /**
     * Add an InEdgesPipe to the end of the Pipeline.
     * Emit the incoming edges for the incoming vertex.
     *
     * @param labels the edge labels to traverse
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline<S, Edge> inE(final String... labels);

    /**
     * Add a InPipe to the end of the Pipeline.
     * Emit the adjacent incoming vertices for the incoming vertex.
     *
     * @param branchFactor the number of max incident edges for each incoming vertex
     * @param labels       the edge labels to traverse
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline<S, Edge> inE(final int branchFactor, final String... labels);

    /**
     * Add a InPipe to the end of the Pipeline.
     * Emit the adjacent incoming vertices for the incoming vertex.
     *
     * @param labels the edge labels to traverse
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline<S, Vertex> in(final String... labels);

    /**
     * Add a InPipe to the end of the Pipeline.
     * Emit the adjacent incoming vertices for the incoming vertex.
     *
     * @param branchFactor the number of max adjacent vertices for each incoming vertex
     * @param labels       the edge labels to traverse
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline<S, Vertex> in(final int branchFactor, final String... labels);

    /**
     * Add an InVertexPipe to the end of the Pipeline.
     * Emit the head vertex of the incoming edge.
     *
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline<S, Vertex> inV();

    /**
     * Add an LabelPipe to the end of the Pipeline.
     * Emit the label of the incoming edge.
     *
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline<S, String> label();

    /**
     * Add an OutEdgesPipe to the end of the Pipeline.
     * Emit the outgoing edges for the incoming vertex.
     *
     * @param labels the edge labels to traverse
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline<S, Edge> outE(final String... labels);

    /**
     * Add an OutEdgesPipe to the end of the Pipeline.
     * Emit the outgoing edges for the incoming vertex.
     *
     * @param branchFactor the number of max incident edges for each incoming vertex
     * @param labels       the edge labels to traverse
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline<S, Edge> outE(final int branchFactor, final String... labels);

    /**
     * Add an OutPipe to the end of the Pipeline.
     * Emit the adjacent outgoing vertices of the incoming vertex.
     *
     * @param labels the edge labels to traverse
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline<S, Vertex> out(final String... labels);

    /**
     * Add an OutPipe to the end of the Pipeline.
     * Emit the adjacent outgoing vertices of the incoming vertex.
     *
     * @param branchFactor the number of max adjacent vertices for each incoming vertex
     * @param labels       the edge labels to traverse
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline<S, Vertex> out(final int branchFactor, final String... labels);

    /**
     * Add an OutVertexPipe to the end of the Pipeline.
     * Emit the tail vertex of the incoming edge.
     *
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline<S, Vertex> outV();

    /**
     * Add a PropertyMapPipe to the end of the Pipeline.
     * Emit the properties of the incoming element as a java.util.Map.
     *
     * @param keys the keys to get from the element (if none provided, all keys retrieved)
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline<S, Map<String, Object>> map(final String... keys);

    /**
     * Add a PropertyPipe to the end of the Pipeline.
     * Emit the respective property of the incoming element.
     *
     * @param key the property key
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline<S, Object> property(final String key);


    /////////////////////////
    /// SIDE-EFFECT PIPES ///
    /////////////////////////

    /**
     * Add an AggregatePipe to the end of the Pipeline.
     * The objects prior to aggregate are greedily collected into an ArrayList.
     *
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline<S, E> aggregate();

    /**
     * Add an AggregatePipe to the end of the Pipeline.
     * The objects prior to aggregate are greedily collected into the provided collection.
     *
     * @param aggregate the collection to aggregate results into
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline<S, E> aggregate(final Collection<E> aggregate);

    /**
     * Add an AggregatePipe to the end of the Pipeline.
     * The results of the function evaluated on the objects prior to the aggregate are greedily collected into the provided collection.
     *
     * @param aggregate         the collection to aggregate results into
     * @param aggregateFunction the function to run over each object prior to insertion into the aggregate
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline<S, E> aggregate(final Collection aggregate, final PipeFunction<E, ?> aggregateFunction);

    /**
     * Add an AggregatePipe to the end of the Pipeline.
     * The results of the function evaluated on the objects prior to the aggregate are greedily collected into an ArrayList.
     *
     * @param aggregateFunction the function to run over each object prior to insertion into the aggregate
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline<S, E> aggregate(final PipeFunction<E, ?> aggregateFunction);

    /**
     * Add an OptionalPipe to the end of the Pipeline.
     * The section of pipeline back to the numbered step is evaluated.
     *
     * @param numberedStep the number of steps previous to optional back to
     * @return the extended Pipeline
     */
    @Deprecated
    public GremlinFluentPipeline<S, ?> optional(final int numberedStep);

    /**
     * Add an OptionalPipe to the end of the Pipeline.
     * The section of pipeline back to the partition step is evaluated.
     *
     * @param namedStep the name of the step previous to optional back to
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline<S, ?> optional(final String namedStep);

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
    public GremlinFluentPipeline<S, E> groupBy(final Map<?, List<?>> map, final PipeFunction keyFunction, final PipeFunction valueFunction);

    /**
     * Add a GroupByPipe to the end of the Pipeline.
     * Group the objects inputted objects according to a key generated from the object and a value generated from the object.
     * The grouping map has values that are Lists.
     *
     * @param keyFunction   the function that generates the key from the object
     * @param valueFunction the function that generates the value from the function
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline<S, E> groupBy(final PipeFunction keyFunction, final PipeFunction valueFunction);

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
    public GremlinFluentPipeline<S, E> groupBy(final Map reduceMap, final PipeFunction keyFunction, final PipeFunction valueFunction, final PipeFunction reduceFunction);


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
    public GremlinFluentPipeline<S, E> groupBy(final PipeFunction keyFunction, final PipeFunction valueFunction, final PipeFunction reduceFunction);

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
    public GremlinFluentPipeline<S, E> groupCount(final Map<?, Number> map, final PipeFunction keyFunction, final PipeFunction<Pair<?, Number>, Number> valueFunction);

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
    public GremlinFluentPipeline<S, E> groupCount(final PipeFunction keyFunction, final PipeFunction<Pair<?, Number>, Number> valueFunction);


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
    public GremlinFluentPipeline<S, E> groupCount(final Map<?, Number> map, final PipeFunction keyFunction);

    /**
     * Add a GroupCountPipe or GroupCountFunctionPipe to the end of the Pipeline.
     * A map is maintained of counts.
     * The map keys are determined by the function on the incoming object.
     * The map values are 1 plus the previous value for that key.
     *
     * @param keyFunction the key function to determine map key
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline<S, E> groupCount(final PipeFunction keyFunction);


    /**
     * Add a GroupCountPipe to the end of the Pipeline.
     * A map is maintained of counts.
     * The map keys are the incoming objects.
     * The map values are 1 plus the previous value for that key.
     *
     * @param map a provided count map
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline<S, E> groupCount(final Map<?, Number> map);

    /**
     * Add a GroupCountPipe to the end of the Pipeline.
     * A map is maintained of counts.
     * The map keys are the incoming objects.
     * The map values are 1 plus the previous value for that key.
     *
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline<S, E> groupCount();


    /**
     * Add a SideEffectFunctionPipe to the end of the Pipeline.
     * The provided function is evaluated and the incoming object is the outgoing object.
     *
     * @param sideEffectFunction the function of the pipe
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline<S, E> sideEffect(final PipeFunction<E, ?> sideEffectFunction);

    /**
     * Add a StorePipe to the end of the Pipeline.
     * Lazily store the incoming objects into the provided collection.
     *
     * @param storage the collection to store results into
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline<S, E> store(final Collection<E> storage);


    /**
     * Add a StorePipe to the end of the Pipeline.
     * Lazily store the object returned by the function over the incoming object into the provided collection.
     *
     * @param storage         the collection to store results into
     * @param storageFunction the function to run over each object prior to insertion into the storage collection
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline<S, E> store(final Collection storage, final PipeFunction<E, ?> storageFunction);

    /**
     * Add an StorePipe to the end of the Pipeline.
     * An ArrayList storage collection is provided and filled lazily with incoming objects.
     *
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline<S, E> store();

    /**
     * Add a StorePipe to the end of the Pipeline.
     * An ArrayList storage collection is provided and filled lazily with the return of the function evaluated over the incoming objects.
     *
     * @param storageFunction the function to run over each object prior to insertion into the storage collection
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline<S, E> store(final PipeFunction<E, ?> storageFunction);

    /**
     * Add a TablePipe to the end of the Pipeline.
     * This step is used for grabbing previously seen objects the pipeline as identified by as-steps.
     *
     * @param table           the table to fill
     * @param stepNames       the partition steps to include in the filling
     * @param columnFunctions the post-processing function for each column
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline<S, E> table(final Table table, final Collection<String> stepNames, final PipeFunction... columnFunctions);

    /**
     * Add a TablePipe to the end of the Pipeline.
     * This step is used for grabbing previously seen objects the pipeline as identified by as-steps.
     *
     * @param table           the table to fill
     * @param columnFunctions the post-processing function for each column
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline<S, E> table(final Table table, final PipeFunction... columnFunctions);

    /**
     * Add a TablePipe to the end of the Pipeline.
     * This step is used for grabbing previously seen objects the pipeline as identified by as-steps.
     *
     * @param columnFunctions the post-processing function for each column
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline<S, E> table(final PipeFunction... columnFunctions);

    /**
     * Add a TablePipe to the end of the Pipeline.
     * This step is used for grabbing previously seen objects the pipeline as identified by as-steps.
     *
     * @param table the table to fill
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline<S, E> table(final Table table);

    /**
     * Add a TablePipe to the end of the Pipeline.
     * This step is used for grabbing previously seen objects the pipeline as identified by as-steps.
     *
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline<S, E> table();

    /**
     * Add a TreePipe to the end of the Pipeline
     * This step maintains an internal tree representation of the paths that have flowed through the step.
     *
     * @param tree            an embedded Map data structure to store the tree representation in
     * @param branchFunctions functions to apply to each path object in a round robin fashion
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline<S, E> tree(final Tree tree, final PipeFunction... branchFunctions);


    /**
     * Add a TreePipe to the end of the Pipeline
     * This step maintains an internal tree representation of the paths that have flowed through the step.
     *
     * @param branchFunctions functions to apply to each path object in a round robin fashion
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline<S, E> tree(final PipeFunction... branchFunctions);


    /**
     * Add a LinkPipe to the end of the Pipeline.
     * Emit the incoming vertex, but have other vertex provide an outgoing edge to incoming vertex.
     *
     * @param label     the edge label
     * @param namedStep the step name that has the other vertex to link to
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline<S, ? extends Element> linkOut(final String label, final String namedStep);

    /**
     * Add a LinkPipe to the end of the Pipeline.
     * Emit the incoming vertex, but have other vertex provide an incoming edge to incoming vertex.
     *
     * @param label     the edge label
     * @param namedStep the step name that has the other vertex to link to
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline<S, ? extends Element> linkIn(final String label, final String namedStep);

    /**
     * Add a LinkPipe to the end of the Pipeline.
     * Emit the incoming vertex, but have other vertex provide an incoming and outgoing edge to incoming vertex.
     *
     * @param label     the edge label
     * @param namedStep the step name that has the other vertex to link to
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline<S, ? extends Element> linkBoth(final String label, final String namedStep);

    /**
     * Add a LinkPipe to the end of the Pipeline.
     * Emit the incoming vertex, but have other vertex provide an outgoing edge to incoming vertex.
     *
     * @param label the edge label
     * @param other the other vertex
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline<S, ? extends Element> linkOut(final String label, final Vertex other);

    /**
     * Add a LinkPipe to the end of the Pipeline.
     * Emit the incoming vertex, but have other vertex provide an incoming edge to incoming vertex.
     *
     * @param label the edge label
     * @param other the other vertex
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline<S, ? extends Element> linkIn(final String label, final Vertex other);

    /**
     * Add a LinkPipe to the end of the Pipeline.
     * Emit the incoming vertex, but have other vertex provide an incoming and outgoing edge to incoming vertex.
     *
     * @param label the edge label
     * @param other the other vertex
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline<S, ? extends Element> linkBoth(final String label, final Vertex other);

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
    public GremlinFluentPipeline<S, E> as(final String name);

    /**
     * Add a StartPipe to the end of the pipeline.
     * Though, in practice, a StartPipe is usually the beginning.
     * Moreover, the constructor of the Pipeline will internally use StartPipe.
     *
     * @param object the object that serves as the start of the pipeline (iterator/iterable are unfolded)
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline<S, S> start(final S object);

    ///////////////////////
    /// UTILITY METHODS ///
    ///////////////////////

    /**
     * Return the number of objects iterated through the pipeline.
     *
     * @return the number of objects iterated
     */
    public long count();

    /**
     * Completely drain the pipeline of its objects.
     * Useful when a sideEffect of the pipeline is desired.
     */
    public void iterate();

    /**
     * Return the next X objects in the pipeline as a list.
     *
     * @param number the number of objects to return
     * @return a list of X objects (if X objects occur)
     */
    public List<E> next(final int number);

    /**
     * Return a list of all the objects in the pipeline.
     *
     * @return a list of all the objects
     */
    public List<E> toList();

    /**
     * Fill the provided collection with the objects in the pipeline.
     *
     * @param collection the collection to fill
     * @return the collection filled
     */
    public Collection<E> fill(final Collection<E> collection);

    /**
     * Enable path calculations in the pipeline.
     * This is typically handled automatically and on rare occasions requires an explicit call.
     *
     * @return the path-enabled Pipeline
     */
    public GremlinFluentPipeline<S, E> enablePath();

    /**
     * Returns the current pipeline with a new end type.
     * Useful if the end type of the pipeline cannot be implicitly derived.
     *
     * @return returns the current pipeline with the new end type.
     */
    public <E> GremlinFluentPipeline<S, E> cast(Class<E> end);
}
