package com.tinkerpop.gremlin.pipes.sideeffect;

import com.tinkerpop.blueprints.Direction;
import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.pipes.AbstractPipe;
import com.tinkerpop.pipes.sideeffect.SideEffectPipe;
import com.tinkerpop.pipes.util.AsPipe;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class LinkPipe extends AbstractPipe<Vertex, Vertex> implements SideEffectPipe<Vertex, Edge> {

    final private Direction direction;
    final private String label;

    private AsPipe<?, Vertex> asPipe;
    private Vertex other;

    private Edge sideEffect;

    public LinkPipe(final Direction direction, final String label, final Vertex other) {
        this.direction = direction;
        this.label = label;
        this.other = other;
    }

    public LinkPipe(final Direction direction, final String label, final AsPipe<?, Vertex> asPipe) {
        this.direction = direction;
        this.label = label;
        this.asPipe = asPipe;
    }

    public Edge getSideEffect() {
        return this.sideEffect;
    }

    protected Vertex processNextStart() {
        final Vertex vertex = this.starts.next();

        if (null != this.asPipe)
            this.other = asPipe.getCurrentEnd();

        if (this.direction.equals(Direction.IN) || this.direction.equals(Direction.BOTH)) {
            this.sideEffect = this.other.addEdge(this.label, vertex);
        }

        if (this.direction.equals(Direction.OUT) || this.direction.equals(Direction.BOTH)) {
            this.sideEffect = vertex.addEdge(this.label, this.other);
        }
        return vertex;
    }

    public void reset() {
        super.reset();
        this.sideEffect = null;
    }
}
