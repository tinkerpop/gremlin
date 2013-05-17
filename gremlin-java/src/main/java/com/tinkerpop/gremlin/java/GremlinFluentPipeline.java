package com.tinkerpop.gremlin.java;

import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.blueprints.Element;
import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.gremlin.Tokens;
import com.tinkerpop.pipes.util.PipesFluentPipeline;

import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public interface GremlinFluentPipeline<S, E> extends PipesFluentPipeline<S, E> {

    /**
     * Add an IdFilterPipe, LabelFilterPipe, or PropertyFilterPipe to the end of the Pipeline.
     * If the incoming element has the provided key/value as check with .equals(), then let the element pass.
     * If the key is id or label, then use respect id or label filtering.
     *
     * @param key   the property key to check
     * @param value the object to filter on
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline<S, ? extends Element> has(final String key, final Object value);

    /**
     * Add an IdFilterPipe, LabelFilterPipe, or PropertyFilterPipe to the end of the Pipeline.
     * If the incoming element has the provided key/value as check with .equals(), then let the element pass.
     * If the key is id or label, then use respect id or label filtering.
     *
     * @param key        the property key to check
     * @param comparison the comparison to use
     * @param value      the object to filter on
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline<S, ? extends Element> has(final String key, final Tokens.T comparison, final Object value);

    /**
     * Add an IdFilterPipe, LabelFilterPipe, or PropertyFilterPipe to the end of the Pipeline.
     * If the incoming element has the provided key/value as check with .equals(), then filter the element.
     * If the key is id or label, then use respect id or label filtering.
     *
     * @param key   the property key to check
     * @param value the object to filter on
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline<S, ? extends Element> hasNot(final String key, final Object value);

    /**
     * Add an IdFilterPipe, LabelFilterPipe, or PropertyFilterPipe to the end of the Pipeline.
     * If the incoming element has the provided key/value as check with .equals(), then filter the element.
     * If the key is id or label, then use respect id or label filtering.
     *
     * @param key        the property key to check
     * @param comparison the comparison to use
     * @param value      the object to filter on
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline<S, ? extends Element> hasNot(final String key, final Tokens.T comparison, final Object value);

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
    public GremlinFluentPipeline<S, ? extends Element> interval(final String key, final Object startValue, final Object endValue);

    /**
     * Add a BothEdgesPipe to the end of the Pipeline.
     * Emit both incoming and outgoing edges for the incoming vertex.
     *
     * @param labels the edge labels to traverse
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline<S, Edge> bothE(final String... labels);

    /**
     * Add a BothPipe to the end of the Pipeline.
     * Emit both the incoming and outgoing adjacent vertices for the incoming vertex.
     *
     * @param labels the edge labels to traverse
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline<S, Vertex> both(final String... labels);

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
     * @param labels the edge labels to traverse
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline<S, Vertex> in(final String... labels);

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
     * Add an OutPipe to the end of the Pipeline.
     * Emit the adjacent outgoing vertices of the incoming vertex.
     *
     * @param labels the edge labels to traverse
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline<S, Vertex> out(final String... labels);

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


    /**
     * Returns the current pipeline with a new end type.
     * Useful if the end type of the pipeline cannot be implicitly derived.
     *
     * @return returns the current pipeline with the new end type.
     */
    @Override
    public <E> GremlinFluentPipeline<S, E> cast(Class<E> end);
}
