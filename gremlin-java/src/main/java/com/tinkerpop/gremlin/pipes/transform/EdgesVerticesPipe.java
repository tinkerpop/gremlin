package com.tinkerpop.gremlin.pipes.transform;

import com.tinkerpop.blueprints.Direction;
import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.pipes.AbstractPipe;
import com.tinkerpop.pipes.transform.TransformPipe;
import com.tinkerpop.pipes.util.PipeHelper;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class EdgesVerticesPipe extends AbstractPipe<Edge, Vertex> implements TransformPipe {

    protected Direction direction;
    protected Vertex nextVertex = null;

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

    public String toString() {
        return PipeHelper.makePipeString(this, direction.name().toLowerCase());
    }

}