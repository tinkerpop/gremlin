package com.tinkerpop.gremlin.pipes;

import com.tinkerpop.blueprints.pgm.Element;
import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.Index;
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
import com.tinkerpop.pipes.Pipe;
import com.tinkerpop.pipes.filter.FilterPipe;
import com.tinkerpop.pipes.util.FluentPipeline;
import com.tinkerpop.pipes.util.StartPipe;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class GremlinFluentPipeline<S, E> extends FluentPipeline<S, E, GremlinFluentPipeline> {

    public GremlinFluentPipeline() {
        super();
    }

    /**
     * Construct a new GremlinFluentPipeline with a StartPipe as the first pipe given provide start object.
     *
     * @param starts start object (if iterable/iterator, it is unfolded)
     */
    public GremlinFluentPipeline(final Object starts) {
        super(new StartPipe(starts));
    }

    public <T extends Element> GremlinFluentPipeline(final Index<T> index, final String key, final Object value) {
        super(new IndexElementsPipe<T>(index, key, value));
    }

    /**
     * Add an arbitrary Pipe to the end of the pipeline.
     *
     * @param pipe the pipe to concatenate to the end of the pipeline
     * @return the extended FluentPipeline
     */
    public GremlinFluentPipeline add(final Pipe pipe) {
        this.addPipe(pipe);
        return this;
    }

    /**
     * Add an IdFilterPipe to the end of the Pipeline.
     *
     * @param id     the id to filter on
     * @param filter the filter of the pipe
     * @return the extended FluentPipeline
     */
    public GremlinFluentPipeline idFilter(final Object id, final FilterPipe.Filter filter) {
        return this.add(new IdFilterPipe(id, filter));
    }

    /**
     * Add a LabelFilterPipe to the end of the Pipeline.
     *
     * @param label  the label to filter on
     * @param filter the filter of the pipe
     * @return the extended FluentPipeline
     */
    public GremlinFluentPipeline labelFilter(final String label, final FilterPipe.Filter filter) {
        return this.add(new LabelFilterPipe(label, filter));
    }

    /**
     * Add a PropertyFilterPipe to the end of the Pipeline.
     *
     * @param key    the property key to check
     * @param filter the filter of the pipe
     * @param value  the object to filter on
     * @return the extended FluentPipeline
     */
    public GremlinFluentPipeline propertyFilter(final String key, final FilterPipe.Filter filter, final Object value) {
        return this.add(new PropertyFilterPipe(key, value, filter));
    }

    /**
     * Add a BothEdgesPipe to the end of the Pipeline.
     *
     * @param labels the edge labels to traverse
     * @return the extended FluentPipeline
     */
    public GremlinFluentPipeline bothEdges(final String... labels) {
        return this.add(new BothEdgesPipe(labels));
    }

    /**
     * Add a BothEdgesPipe to the end of the Pipeline.
     *
     * @param labels the edges labels to traverse
     * @return the extended FluentPipeline
     */
    public GremlinFluentPipeline bothE(final String... labels) {
        return this.bothEdges(labels);
    }

    /**
     * Add a BothPipe to the end of the Pipeline.
     *
     * @param labels the edge labels to traverse
     * @return the extended FluentPipeline
     */
    public GremlinFluentPipeline both(final String... labels) {
        return this.add(new BothPipe(labels));
    }

    /**
     * Add a BothVerticesPipe to the end of the Pipeline.
     *
     * @return the extended FluentPipeline
     */
    public GremlinFluentPipeline bothVertices() {
        return this.add(new BothVerticesPipe());
    }

    /**
     * Add a BothVerticesPipe to the end of the Pipeline.
     *
     * @return the extended FluentPipeline
     */
    public GremlinFluentPipeline bothV() {
        return this.bothVertices();
    }

    /**
     * Add an EdgesPipe to the end of the Pipeline.
     *
     * @return the extended FluentPipeline
     */
    public GremlinFluentPipeline edges() {
        return this.add(new EdgesPipe());
    }

    /**
     * Add an EdgesPipe to the end of the Pipeline.
     *
     * @return the extended FluentPipeline
     */
    public GremlinFluentPipeline E() {
        return this.edges();
    }

    /**
     * Add an IdEdgePipe to the end of the Pipeline.
     *
     * @param graph the graph of the pipe
     * @return the extended FluentPipeline
     */
    public GremlinFluentPipeline idEdge(final Graph graph) {
        return this.add(new IdEdgePipe(graph));
    }

    /**
     * Add an IdPipe to the end of the Pipeline.
     *
     * @return the extended FluentPipeline
     */
    public GremlinFluentPipeline id() {
        return this.add(new IdPipe());
    }

    /**
     * Add an IdVertexPipe to the end of the Pipeline.
     *
     * @param graph the graph of the pipe
     * @return the extended FluentPipeline
     */
    public GremlinFluentPipeline idVertex(final Graph graph) {
        return this.add(new IdVertexPipe(graph));
    }

    /**
     * Add an InEdgesPipe to the end of the Pipeline.
     *
     * @param labels the edge labels to traverse
     * @return the extended FluentPipeline
     */
    public GremlinFluentPipeline inEdges(final String... labels) {
        return this.add(new InEdgesPipe(labels));
    }

    /**
     * Add an InEdgesPipe to the end of the Pipeline.
     *
     * @param labels the edge labels to traverse
     * @return the extended FluentPipeline
     */
    public GremlinFluentPipeline inE(final String... labels) {
        return this.inEdges(labels);
    }

    /**
     * Add a InPipe to the end of the Pipeline.
     *
     * @param labels the edge labels to traverse
     * @return the extended FluentPipeline
     */
    public GremlinFluentPipeline in(final String... labels) {
        return this.add(new InPipe(labels));
    }

    /**
     * Add an InVertexPipe to the end of the Pipeline.
     *
     * @return the extended FluentPipeline
     */
    public GremlinFluentPipeline inVertex() {
        return this.add(new InVertexPipe());
    }

    /**
     * Add an InVertexPipe to the end of the Pipeline.
     *
     * @return the extended FluentPipeline
     */
    public GremlinFluentPipeline inV() {
        return this.inVertex();
    }

    /**
     * Add an LabelPipe to the end of the Pipeline
     *
     * @return the extended FluentPipeline
     */
    public GremlinFluentPipeline label() {
        return this.add(new LabelPipe());
    }

    /**
     * Add an OutEdgesPipe to the end of the Pipeline.
     *
     * @param labels the edge labels to traverse
     * @return the extended FluentPipeline
     */
    public GremlinFluentPipeline outEdges(final String... labels) {
        this.addPipe(new OutEdgesPipe(labels));
        return this;
    }

    /**
     * Add an OutEdgesPipe to the end of the Pipeline.
     *
     * @param labels the edge labels to traverse
     * @return the extended FluentPipeline
     */
    public GremlinFluentPipeline outE(final String... labels) {
        return this.outEdges(labels);
    }

    /**
     * Add an OutPipe to the end of the Pipeline.
     *
     * @param labels the edge labels to traverse
     * @return the extended FluentPipeline
     */
    public GremlinFluentPipeline out(final String... labels) {
        return this.add(new OutPipe(labels));
    }

    /**
     * Add an OutVertexPipe to the end of the Pipeline.
     *
     * @return the extended FluentPipeline
     */
    public GremlinFluentPipeline outVertex() {
        return this.add(new OutVertexPipe());
    }

    /**
     * Add an OutVertexPipe to the end of the Pipeline.
     *
     * @return the extended FluentPipeline
     */
    public GremlinFluentPipeline outV() {
        return this.outVertex();
    }

    /**
     * Add a PropertyMapPipe to the end of the Pipeline.
     *
     * @return the extended FluentPipeline
     */
    public GremlinFluentPipeline propertyMap() {
        this.addPipe(new PropertyMapPipe());
        return this;
    }

    /**
     * Add a PropertyMapPipe to the end of the Pipeline.
     *
     * @return the extended FluentPipeline
     */
    public GremlinFluentPipeline map() {
        return this.propertyMap();
    }

    /**
     * Add a PropertyPipe to the end of the Pipeline.
     *
     * @param key the property key
     * @return the extended FluentPipeline
     */
    public GremlinFluentPipeline property(final String key) {
        this.addPipe(new PropertyPipe(key));
        return this;
    }

    /**
     * Add a VerticesPipe to the end of the Pipeline
     *
     * @return the extended FluentPipeline
     */
    public GremlinFluentPipeline vertices() {
        return this.add(new VerticesPipe());
    }

    /**
     * Add a VerticesPipe to the end of the Pipeline
     *
     * @return the extended FluentPipeline
     */
    public GremlinFluentPipeline V() {
        return this.vertices();
    }

    // utility

    public <T extends Element> GremlinFluentPipeline index(final Index<T> index, final String key, final Object value) {
        return this.add(new IndexElementsPipe<T>(index, key, value));
    }
}
