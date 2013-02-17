package com.tinkerpop.gremlin.pipes.sideeffect;

import com.tinkerpop.blueprints.Direction;
import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.pipes.AbstractPipe;
import com.tinkerpop.pipes.sideeffect.SideEffectPipe;
import com.tinkerpop.pipes.util.AsPipe;
import com.tinkerpop.pipes.util.PipeHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class LinkPipe extends AbstractPipe<Vertex, Vertex> implements SideEffectPipe.LazySideEffectPipe<Vertex, Object> {

    final private Direction direction;
    final private String label;

    private AsPipe<?, Vertex> asPipe;
    private Vertex other;

    private Object sideEffect;

    private LinkPipe(final Direction direction, final String label) {
        this.direction = direction;
        this.label = label;
        if (direction.equals(Direction.BOTH))
            this.sideEffect = new ArrayList<Edge>();
    }

    public LinkPipe(final Direction direction, final String label, final Vertex other) {
        this(direction, label);
        this.other = other;
    }

    public LinkPipe(final Direction direction, final String label, final AsPipe<?, Vertex> asPipe) {
        this(direction, label);
        this.asPipe = asPipe;
    }

    public Object getSideEffect() {
        return this.sideEffect;
    }

    protected Vertex processNextStart() {
        final Vertex vertex = this.starts.next();

        if (null != this.asPipe)
            this.other = asPipe.getCurrentEnd();
        if (this.direction.equals(Direction.BOTH))
            ((List) this.sideEffect).clear();

        if (this.direction.equals(Direction.IN) || this.direction.equals(Direction.BOTH)) {
            final Edge edge = this.other.addEdge(this.label, vertex);
            if (this.direction.equals(Direction.BOTH))
                ((List<Edge>) this.sideEffect).add(edge);
            else
                this.sideEffect = edge;
        }

        if (this.direction.equals(Direction.OUT) || this.direction.equals(Direction.BOTH)) {
            final Edge edge = vertex.addEdge(this.label, this.other);
            if (this.direction.equals(Direction.BOTH))
                ((List<Edge>) this.sideEffect).add(edge);
            else
                this.sideEffect = edge;
        }
        return vertex;
    }

    public void reset() {
        super.reset();
        this.sideEffect = null;
    }

    public String toString() {
        return PipeHelper.makePipeString(this, this.direction.name(), this.label, null == this.asPipe ? this.other : this.asPipe.getName());
    }
}
