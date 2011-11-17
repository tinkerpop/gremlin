package com.tinkerpop.gremlin.pipes.filter;

import com.tinkerpop.blueprints.pgm.Edge;
import com.tinkerpop.pipes.AbstractPipe;
import com.tinkerpop.pipes.filter.FilterPipe;
import com.tinkerpop.pipes.util.PipeHelper;

/**
 * The LabelFilterPipe either allows or disallows all Edges that have the provided label.
 *
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class LabelFilterPipe extends AbstractPipe<Edge, Edge> implements FilterPipe<Edge> {

    private final String label;
    private final FilterPipe.Filter filter;

    public LabelFilterPipe(final String label, final FilterPipe.Filter filter) {
        this.label = label;
        this.filter = filter;
    }

    protected Edge processNextStart() {
        while (true) {
            final Edge edge = this.starts.next();
            if (PipeHelper.compareObjects(this.filter, edge.getLabel(), this.label)) {
                return edge;
            }
        }
    }

    public String toString() {
        return PipeHelper.makePipeString(this, this.filter, this.label);
    }
}
