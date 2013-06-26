package com.tinkerpop.gremlin.java;

import com.tinkerpop.blueprints.Direction;
import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.pipes.IdentityPipe;
import com.tinkerpop.pipes.Pipe;
import com.tinkerpop.pipes.filter.IntervalFilterPipe;
import com.tinkerpop.pipes.filter.PropertyFilterPipe;
import com.tinkerpop.pipes.filter.RangeFilterPipe;
import com.tinkerpop.pipes.transform.GraphQueryPipe;
import com.tinkerpop.pipes.transform.QueryPipe;
import com.tinkerpop.pipes.transform.VertexQueryPipe;
import com.tinkerpop.pipes.transform.VerticesEdgesPipe;
import com.tinkerpop.pipes.transform.VerticesVerticesPipe;
import com.tinkerpop.pipes.util.FluentUtility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class GremlinFluentUtility extends FluentUtility {

    public static List<Pipe> removeVertexQueryOptimizationPipes(final GremlinPipeline pipeline) {
        int numberedStep = -1;
        int pipelineSize = pipeline.size();
        boolean filtersSeen = false;
        for (int i = pipelineSize - 1; i >= 0; i--) {
            final Pipe pipe = pipeline.get(i);
            if (pipe instanceof VerticesEdgesPipe) {
                numberedStep = pipelineSize - i;
                break;
            } else if (pipe instanceof PropertyFilterPipe || pipe instanceof IntervalFilterPipe || pipe instanceof RangeFilterPipe) {
                filtersSeen = true;
            } else if (!(pipe instanceof IdentityPipe)) {
                break;
            }
        }
        if (numberedStep != -1 && filtersSeen)
            return FluentUtility.removePreviousPipes(pipeline, numberedStep);
        else
            return Collections.emptyList();
    }

    public static GremlinPipeline optimizePipelineForVertexQueryRange(final GremlinPipeline pipeline) {
        if (pipeline.get(pipeline.size() - 1) instanceof RangeFilterPipe && pipeline.get(pipeline.size() - 2) instanceof VerticesVerticesPipe) {
            final RangeFilterPipe range = (RangeFilterPipe) pipeline.remove(pipeline.size() - 1);
            final VerticesVerticesPipe vertices = (VerticesVerticesPipe) pipeline.remove(pipeline.size() - 1);
            pipeline.add(new VertexQueryPipe(Vertex.class, vertices.getDirection(), null, null, range.getLowRange(), range.getHighRange(), vertices.getLabels()));
            pipeline.add(new IdentityPipe());
        }
        return pipeline;
    }

    public static GremlinPipeline optimizePipelineForVertexQuery(final GremlinPipeline pipeline) {
        final List<Pipe> removedPipes = removeVertexQueryOptimizationPipes(pipeline);

        if (removedPipes.size() > 0) {
            final List<QueryPipe.HasContainer> hasContainers = new ArrayList<QueryPipe.HasContainer>();
            final List<QueryPipe.IntervalContainer> intervalContainers = new ArrayList<QueryPipe.IntervalContainer>();
            int lowRange = Integer.MIN_VALUE;
            int highRange = Integer.MAX_VALUE;
            String[] labels = new String[]{};
            Direction direction = Direction.BOTH;

            for (final Pipe pipe : removedPipes) {
                if (pipe instanceof PropertyFilterPipe) {
                    final PropertyFilterPipe temp = (PropertyFilterPipe) pipe;
                    hasContainers.add(new QueryPipe.HasContainer(temp.getKey(), temp.getCompareRelation(), temp.getValue()));
                } else if (pipe instanceof IntervalFilterPipe) {
                    final IntervalFilterPipe temp = (IntervalFilterPipe) pipe;
                    intervalContainers.add(new QueryPipe.IntervalContainer(temp.getKey(), temp.getStartValue(), temp.getEndValue()));
                } else if (pipe instanceof VerticesEdgesPipe) {
                    labels = ((VerticesEdgesPipe) pipe).getLabels();
                    direction = ((VerticesEdgesPipe) pipe).getDirection();
                } else if (pipe instanceof RangeFilterPipe) {
                    lowRange = ((RangeFilterPipe) pipe).getLowRange();
                    highRange = ((RangeFilterPipe) pipe).getHighRange();
                }
            }

            pipeline.addPipe(new VertexQueryPipe(Edge.class, direction, hasContainers, intervalContainers, lowRange, highRange, labels));
            for (int i = 0; i < removedPipes.size() - 1; i++) {
                pipeline.addPipe(new IdentityPipe());
            }
        }
        return pipeline;
    }

    public static GremlinPipeline optimizePipelineForGraphQuery(final GremlinPipeline pipeline, final Pipe pipe) {
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
                queryPipe.addHasContainer(new QueryPipe.HasContainer(temp.getKey(), temp.getCompareRelation(), temp.getValue()));
            } else if (pipe instanceof IntervalFilterPipe) {
                final IntervalFilterPipe temp = (IntervalFilterPipe) pipe;
                queryPipe.addIntervalContainer(new QueryPipe.IntervalContainer(temp.getKey(), temp.getStartValue(), temp.getEndValue()));
            } else if (pipe instanceof RangeFilterPipe) {
                queryPipe.setLowRange(((RangeFilterPipe) pipe).getLowRange());
                queryPipe.setHighRange(((RangeFilterPipe) pipe).getHighRange());
            }
            pipeline.addPipe(new IdentityPipe());
        } else {
            pipeline.add(pipe);
        }
        return pipeline;
    }
}
