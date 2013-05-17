package com.tinkerpop.gremlin.pipes.transform;

import com.tinkerpop.blueprints.Direction;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.pipes.AbstractPipe;
import com.tinkerpop.pipes.transform.TransformPipe;
import com.tinkerpop.pipes.util.PipeHelper;

import java.util.Arrays;
import java.util.Iterator;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class VerticesVerticesPipe extends AbstractPipe<Vertex, Vertex> implements TransformPipe<Vertex, Vertex> {

    protected Direction direction;
    protected String[] labels;
    protected Iterator<Vertex> nextEnds = PipeHelper.emptyIterator();

    public VerticesVerticesPipe(final Direction direction, final String... labels) {
        this.direction = direction;
        this.labels = labels;
    }

    public void reset() {
        this.nextEnds = PipeHelper.emptyIterator();
        super.reset();
    }


    protected Vertex processNextStart() {
        while (true) {
            if (this.nextEnds.hasNext()) {
                return this.nextEnds.next();
            } else {
                this.nextEnds = this.starts.next().getVertices(this.direction, this.labels).iterator();
            }
        }
    }

    public Direction getDirection() {
        return this.direction;
    }

    public String[] getLabels() {
        return this.labels;
    }

    public String toString() {
        return PipeHelper.makePipeString(this, direction.name().toLowerCase(), Arrays.asList(labels));
    }

}
