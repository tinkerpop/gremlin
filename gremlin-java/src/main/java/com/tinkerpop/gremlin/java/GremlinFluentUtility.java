package com.tinkerpop.gremlin.java;

import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.pipes.IdentityPipe;
import com.tinkerpop.pipes.Pipe;
import com.tinkerpop.pipes.filter.IntervalFilterPipe;
import com.tinkerpop.pipes.filter.PropertyFilterPipe;
import com.tinkerpop.pipes.filter.RangeFilterPipe;
import com.tinkerpop.pipes.transform.EdgesVerticesPipe;
import com.tinkerpop.pipes.transform.GraphQueryPipe;
import com.tinkerpop.pipes.transform.QueryPipe;
import com.tinkerpop.pipes.transform.VertexQueryPipe;
import com.tinkerpop.pipes.transform.VerticesEdgesPipe;
import com.tinkerpop.pipes.transform.VerticesVerticesPipe;
import com.tinkerpop.pipes.util.FluentUtility;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class GremlinFluentUtility extends FluentUtility {

    public static GremlinPipeline optimizePipelineForQuery(final GremlinPipeline pipeline, final Pipe pipe) {
        if (!optimizePipelineForGraphQuery(pipeline, pipe))
            if (!optimizePipelineForVertexQuery(pipeline, pipe))
                pipeline.addPipe(pipe);
        return pipeline;
    }

    public static boolean optimizePipelineForVertexQuery(final GremlinPipeline pipeline, final Pipe pipe) {
        VertexQueryPipe queryPipe = null;
        for (int i = pipeline.size() - 1; i > 0; i--) {
            final Pipe temp = pipeline.get(i);
            if (temp instanceof VertexQueryPipe) {
                queryPipe = (VertexQueryPipe) temp;
                break;
            } else if (!(temp instanceof IdentityPipe))
                break;
        }

        if (null != queryPipe) {
            if (pipe instanceof EdgesVerticesPipe) {
                if (queryPipe.getResultElementClass().equals(Vertex.class))
                    return false;
                queryPipe.setResultingElementClass(Vertex.class);
            } else if (pipe instanceof VerticesVerticesPipe) {
                if (queryPipe.getResultElementClass().equals(Vertex.class))
                    return false;
                queryPipe.setDirection(((VerticesVerticesPipe) pipe).getDirection());
                queryPipe.setLabels(((VerticesVerticesPipe) pipe).getLabels());
                queryPipe.setBranchFactor(((VerticesVerticesPipe) pipe).getBranchFactor());
            } else if (pipe instanceof VerticesEdgesPipe) {
                if (queryPipe.getResultElementClass().equals(Vertex.class))
                    return false;
                queryPipe.setResultingElementClass(Edge.class);
                queryPipe.setDirection(((VerticesEdgesPipe) pipe).getDirection());
                queryPipe.setLabels(((VerticesEdgesPipe) pipe).getLabels());
                queryPipe.setBranchFactor(((VerticesEdgesPipe) pipe).getBranchFactor());
            } else if (pipe instanceof PropertyFilterPipe) {
                if (queryPipe.getResultElementClass().equals(Vertex.class))
                    return false;
                final PropertyFilterPipe temp = (PropertyFilterPipe) pipe;
                queryPipe.addHasContainer(new QueryPipe.HasContainer(temp.getKey(), temp.getPredicate(), temp.getValue()));
            } else if (pipe instanceof IntervalFilterPipe) {
                if (queryPipe.getResultElementClass().equals(Vertex.class))
                    return false;
                final IntervalFilterPipe temp = (IntervalFilterPipe) pipe;
                queryPipe.addIntervalContainer(new QueryPipe.IntervalContainer(temp.getKey(), temp.getStartValue(), temp.getEndValue()));
            } else if (pipe instanceof RangeFilterPipe) {
                queryPipe.setLowRange(((RangeFilterPipe) pipe).getLowRange());
                queryPipe.setHighRange(((RangeFilterPipe) pipe).getHighRange());
            }
            pipeline.addPipe(new IdentityPipe());
            return true;
        } else {
            return false;
        }
    }

    private static boolean optimizePipelineForGraphQuery(final GremlinPipeline pipeline, final Pipe pipe) {
        GraphQueryPipe queryPipe = null;
        for (int i = pipeline.size() - 1; i > 0; i--) {
            final Pipe temp = pipeline.get(i);
            if (temp instanceof GraphQueryPipe) {
                queryPipe = (GraphQueryPipe) temp;
                break;
            } else if (!(temp instanceof IdentityPipe))
                break;
        }

        if (null != queryPipe) {
            if (pipe instanceof PropertyFilterPipe) {
                final PropertyFilterPipe temp = (PropertyFilterPipe) pipe;
                queryPipe.addHasContainer(new QueryPipe.HasContainer(temp.getKey(), temp.getPredicate(), temp.getValue()));
            } else if (pipe instanceof IntervalFilterPipe) {
                final IntervalFilterPipe temp = (IntervalFilterPipe) pipe;
                queryPipe.addIntervalContainer(new QueryPipe.IntervalContainer(temp.getKey(), temp.getStartValue(), temp.getEndValue()));
            } else if (pipe instanceof RangeFilterPipe) {
                queryPipe.setLowRange(((RangeFilterPipe) pipe).getLowRange());
                queryPipe.setHighRange(((RangeFilterPipe) pipe).getHighRange());
            }
            pipeline.addPipe(new IdentityPipe());
            return true;
        } else {
            return false;
        }
    }
}
