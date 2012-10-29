package com.tinkerpop.gremlin.java;

import com.tinkerpop.blueprints.Direction;
import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.blueprints.Query;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.gremlin.pipes.filter.IntervalFilterPipe;
import com.tinkerpop.gremlin.pipes.filter.PropertyFilterPipe;
import com.tinkerpop.gremlin.pipes.transform.QueryPipe;
import com.tinkerpop.gremlin.pipes.transform.VerticesEdgesPipe;
import com.tinkerpop.gremlin.pipes.transform.VerticesVerticesPipe;
import com.tinkerpop.pipes.Pipe;
import com.tinkerpop.pipes.filter.FilterPipe;
import com.tinkerpop.pipes.filter.RangeFilterPipe;
import com.tinkerpop.pipes.transform.IdentityPipe;
import com.tinkerpop.pipes.util.FluentUtility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class GremlinFluentUtility extends FluentUtility {

    public static List<Pipe> removeEdgeQueryOptimizationPipes(final GremlinPipeline pipeline) {
        int numberedStep = -1;
        int pipelineSize = pipeline.size();
        boolean filtersSeen = false;
        for (int i = pipelineSize - 1; i >= 0; i--) {
            final Pipe pipe = pipeline.get(i);
            if (pipe instanceof VerticesEdgesPipe) {
                numberedStep = pipelineSize - i;
                break;
            } else if (pipe instanceof PropertyFilterPipe || pipe instanceof IntervalFilterPipe || pipe instanceof RangeFilterPipe) {
                // todo: support non-zero low
                if (pipe instanceof RangeFilterPipe && ((RangeFilterPipe) pipe).getLowRange() != 0)
                    break;
                else
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

    public static GremlinPipeline optimizePipelineForVertexRange(final GremlinPipeline pipeline) {
        if (pipeline.get(pipeline.size() - 1) instanceof RangeFilterPipe && pipeline.get(pipeline.size() - 2) instanceof VerticesVerticesPipe) {
            final RangeFilterPipe range = (RangeFilterPipe) pipeline.remove(pipeline.size() - 1);
            // todo: support non-zero low
            if (range.getLowRange() == 0l) {
                final VerticesVerticesPipe vertices = (VerticesVerticesPipe) pipeline.remove(pipeline.size() - 1);
                pipeline.add(new QueryPipe(Vertex.class, vertices.getDirection(),
                        (List) Collections.emptyList(), (List) Collections.emptyList(), range.getHighRange() + 1, vertices.getLabels()));
                pipeline.add(new IdentityPipe());
            }
        }
        return pipeline;
    }

    public static GremlinPipeline optimizePipelineForEdgeConstraints(final GremlinPipeline pipeline) {
        final List<Pipe> removedPipes = removeEdgeQueryOptimizationPipes(pipeline);

        if (removedPipes.size() > 0) {
            final List<QueryPipe.HasContainer> hasContainers = new ArrayList<QueryPipe.HasContainer>();
            final List<QueryPipe.IntervalContainer> intervalContainers = new ArrayList<QueryPipe.IntervalContainer>();
            long limit = -1l;
            String[] labels = new String[]{};
            Direction direction = Direction.BOTH;

            for (final Pipe pipe : removedPipes) {
                if (pipe instanceof PropertyFilterPipe) {
                    final PropertyFilterPipe temp = (PropertyFilterPipe) pipe;
                    hasContainers.add(new QueryPipe.HasContainer(temp.getKey(), temp.getValue(), convertFromFilter(temp.getFilter())));
                } else if (pipe instanceof IntervalFilterPipe) {
                    final IntervalFilterPipe temp = (IntervalFilterPipe) pipe;
                    intervalContainers.add(new QueryPipe.IntervalContainer(temp.getKey(), temp.getStartValue(), temp.getEndValue()));
                } else if (pipe instanceof VerticesEdgesPipe) {
                    labels = ((VerticesEdgesPipe) pipe).getLabels();
                    direction = ((VerticesEdgesPipe) pipe).getDirection();
                } else if (pipe instanceof RangeFilterPipe) {
                    limit = ((RangeFilterPipe) pipe).getHighRange() + 1;
                }
            }

            pipeline.addPipe(new QueryPipe(Edge.class, direction, hasContainers, intervalContainers, limit, labels));
            for (int i = 0; i < removedPipes.size() - 1; i++) {
                pipeline.addPipe(new IdentityPipe());
            }
        }
        return pipeline;
    }

    private static Query.Compare convertFromFilter(final FilterPipe.Filter filter) {
        if (filter.equals(FilterPipe.Filter.EQUAL))
            return Query.Compare.EQUAL;
        else if (filter.equals(FilterPipe.Filter.GREATER_THAN))
            return Query.Compare.GREATER_THAN;
        else if (filter.equals(FilterPipe.Filter.GREATER_THAN_EQUAL))
            return Query.Compare.GREATER_THAN_EQUAL;
        else if (filter.equals(FilterPipe.Filter.LESS_THAN))
            return Query.Compare.LESS_THAN;
        else if (filter.equals(FilterPipe.Filter.LESS_THAN_EQUAL))
            return Query.Compare.LESS_THAN_EQUAL;
        else if (filter.equals(FilterPipe.Filter.NOT_EQUAL))
            return Query.Compare.NOT_EQUAL;
        else
            throw new IllegalStateException("The provided filter is not a legal filter: " + filter);
    }
}
