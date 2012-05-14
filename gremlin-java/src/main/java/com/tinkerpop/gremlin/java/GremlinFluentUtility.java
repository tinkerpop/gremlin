package com.tinkerpop.gremlin.java;

import com.tinkerpop.blueprints.Direction;
import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.blueprints.Query;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.gremlin.pipes.filter.IntervalFilterPipe;
import com.tinkerpop.gremlin.pipes.filter.PropertyFilterPipe;
import com.tinkerpop.gremlin.pipes.transform.AbstractEdgesPipe;
import com.tinkerpop.gremlin.pipes.transform.BothEdgesPipe;
import com.tinkerpop.gremlin.pipes.transform.BothVerticesPipe;
import com.tinkerpop.gremlin.pipes.transform.InEdgesPipe;
import com.tinkerpop.gremlin.pipes.transform.InVertexPipe;
import com.tinkerpop.gremlin.pipes.transform.OutEdgesPipe;
import com.tinkerpop.gremlin.pipes.transform.OutVertexPipe;
import com.tinkerpop.gremlin.pipes.transform.QueryPipe;
import com.tinkerpop.pipes.Pipe;
import com.tinkerpop.pipes.filter.FilterPipe;
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
        for (int i = pipelineSize - 1; i >= 0; i--) {
            final Pipe pipe = pipeline.get(i);
            if (pipe instanceof OutEdgesPipe || pipe instanceof InEdgesPipe || pipe instanceof BothEdgesPipe) {
                numberedStep = pipelineSize - i;
                break;
            } else if (pipe instanceof PropertyFilterPipe || pipe instanceof InVertexPipe || pipe instanceof OutVertexPipe || pipe instanceof BothVerticesPipe) {
                continue;
            } else {
                break;
            }
        }
        if (numberedStep != -1)
            return FluentUtility.removePreviousPipes(pipeline, numberedStep);
        else
            return Collections.emptyList();
    }

    public static GremlinPipeline optimizePipelineForVertexQueries(final GremlinPipeline pipeline) {
        final List<QueryPipe.HasContainer> hasContainers = new ArrayList<QueryPipe.HasContainer>();
        final List<QueryPipe.IntervalContainer> intervalContainers = new ArrayList<QueryPipe.IntervalContainer>();
        String[] labels = new String[]{};
        Direction direction = Direction.BOTH;
        Class elementClass = Edge.class;

        List<Pipe> removedPipes = removeEdgeQueryOptimizationPipes(pipeline);
        for (final Pipe pipe : removedPipes) {
            if (pipe instanceof PropertyFilterPipe) {
                final PropertyFilterPipe temp = (PropertyFilterPipe) pipe;
                hasContainers.add(new QueryPipe.HasContainer(temp.getKey(), temp.getValue(), convertFromFilter(temp.getFilter())));
            } else if (pipe instanceof IntervalFilterPipe) {
                final IntervalFilterPipe temp = (IntervalFilterPipe) pipe;
                intervalContainers.add(new QueryPipe.IntervalContainer(temp.getKey(), temp.getStartValue(), temp.getEndValue()));
            } else if (pipe instanceof AbstractEdgesPipe) {
                labels = ((AbstractEdgesPipe) pipe).getLabels();
                if (pipe instanceof OutEdgesPipe) {
                    direction = Direction.OUT;
                } else if (pipe instanceof InEdgesPipe) {
                    direction = Direction.IN;
                } else if (pipe instanceof BothEdgesPipe) {
                    direction = Direction.BOTH;
                } else {
                    throw new IllegalStateException("The only supported AbstractEdgesPipe are InEdgesPipes, OutEdgesPipe, and BothEdgesPipe: " + pipe.getClass());
                }
            } else if (pipe instanceof InVertexPipe || pipe instanceof OutVertexPipe || pipe instanceof BothVerticesPipe) {
                elementClass = Vertex.class;
            }
        }
        if (removedPipes.size() > 0)
            pipeline.addPipe(new QueryPipe(elementClass, direction, hasContainers, intervalContainers, labels));
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
