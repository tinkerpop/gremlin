package com.tinkerpop.gremlin.pipes.transform;

import com.tinkerpop.blueprints.Direction;
import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.pipes.AbstractPipe;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class EdgesVerticesPipe extends AbstractPipe<Edge, Vertex> {

    private Direction direction;
    private Vertex nextVertex = null;

    public EdgesVerticesPipe(final Direction direction) {
        this.direction = direction;
    }

    public void reset() {
        this.nextVertex = null;
        super.reset();
    }

    public Vertex processNextStart() {
        if (null != nextVertex) {
            final Vertex temp = nextVertex;
            nextVertex = null;
            return temp;
        } else {
            if (direction.equals(Direction.BOTH)) {
                final Edge edge = this.starts.next();
                this.nextVertex = edge.getVertex(Direction.IN);
                return edge.getVertex(Direction.OUT);
            } else {
                return this.starts.next().getVertex(direction);
            }
        }

    }

}