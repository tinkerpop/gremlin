package com.tinkerpop.gremlin;

import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.gremlin.pipes.GremlinPipeline;
import com.tinkerpop.pipes.filter.FilterPipe;
import com.tinkerpop.pipes.util.FluentPipeline;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public interface GremlinFluentPipeline<S, E> extends FluentPipeline<S, E> {

    /**
     * Add an IdFilterPipe to the end of the Pipeline.
     *
     * @param id     the id to filter on
     * @param filter the filter of the pipe
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline idFilter(final Object id, final FilterPipe.Filter filter);

    /**
     * Add a LabelFilterPipe to the end of the Pipeline.
     *
     * @param label  the label to filter on
     * @param filter the filter of the pipe
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline labelFilter(final String label, final FilterPipe.Filter filter);

    /**
     * Add a PropertyFilterPipe to the end of the Pipeline.
     *
     * @param key    the property key to check
     * @param filter the filter of the pipe
     * @param value  the object to filter on
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline propertyFilter(final String key, final FilterPipe.Filter filter, final Object value);

    public GremlinFluentPipeline propertyFilter(final String key, final Tokens.T t, final Object value);

    /**
     * Add a BothEdgesPipe to the end of the Pipeline.
     *
     * @param labels the edge labels to traverse
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline bothE(final String... labels);

    /**
     * Add a BothPipe to the end of the Pipeline.
     *
     * @param labels the edge labels to traverse
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline both(final String... labels);

    /**
     * Add a BothVerticesPipe to the end of the Pipeline.
     *
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline bothV();

    /**
     * Add an EdgesPipe to the end of the Pipeline.
     *
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline E();

    /**
     * Add an IdEdgePipe to the end of the Pipeline.
     *
     * @param graph the graph of the pipe
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline idEdge(final Graph graph);

    /**
     * Add an IdPipe to the end of the Pipeline.
     *
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline id();

    /**
     * Add an IdVertexPipe to the end of the Pipeline.
     *
     * @param graph the graph of the pipe
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline idVertex(final Graph graph);

    /**
     * Add an InEdgesPipe to the end of the Pipeline.
     *
     * @param labels the edge labels to traverse
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline inE(final String... labels);

    /**
     * Add a InPipe to the end of the Pipeline.
     *
     * @param labels the edge labels to traverse
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline in(final String... labels);

    /**
     * Add an InVertexPipe to the end of the Pipeline.
     *
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline inV();

    /**
     * Add an LabelPipe to the end of the Pipeline
     *
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline label();

    /**
     * Add an OutEdgesPipe to the end of the Pipeline.
     *
     * @param labels the edge labels to traverse
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline outE(final String... labels);

    /**
     * Add an OutPipe to the end of the Pipeline.
     *
     * @param labels the edge labels to traverse
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline out(final String... labels);

    /**
     * Add an OutVertexPipe to the end of the Pipeline.
     *
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline outV();

    /**
     * Add a PropertyMapPipe to the end of the Pipeline.
     *
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline map();

    /**
     * Add a PropertyPipe to the end of the Pipeline.
     *
     * @param key the property key
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline property(final String key);

    /**
     * Add a VerticesPipe to the end of the Pipeline
     *
     * @return the extended Pipeline
     */
    public GremlinFluentPipeline V();
}
