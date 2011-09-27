package com.tinkerpop.gremlin.pipes.transform;

import com.tinkerpop.blueprints.pgm.Element;
import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.pipes.AbstractPipe;
import com.tinkerpop.pipes.util.EmptyIterator;
import com.tinkerpop.pipes.util.PipeHelper;

import java.util.Iterator;

/**
 * The GraphElementPipe takes a start of type Graph and will return elements (i.e. vertices or edges).
 * This pipe is useful for processing all of the vertices (or edges) of a graph.
 * See respective sub-class for implementations of this abstract form.
 *
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public abstract class GraphElementPipe<E extends Element> extends AbstractPipe<Graph, E> {

    protected Iterator<E> nextEnds = new EmptyIterator<E>();

    private final ElementType elementType;

    public enum ElementType {
        VERTEX, EDGE
    }

    public GraphElementPipe(final ElementType elementType) {
        this.elementType = elementType;
    }


    protected E processNextStart() {
        while (true) {
            if (null != this.nextEnds && this.nextEnds.hasNext()) {
                return this.nextEnds.next();
            } else {
                switch (this.elementType) {
                    case VERTEX: {
                        this.nextEnds = (Iterator<E>) this.starts.next().getVertices().iterator();
                        break;
                    }
                    case EDGE: {
                        this.nextEnds = (Iterator<E>) this.starts.next().getEdges().iterator();
                        break;
                    }
                }
            }
        }
    }

    public String toString() {
        return PipeHelper.makePipeString(this, this.elementType);
    }

    public void reset() {
        super.reset();
        this.nextEnds = new EmptyIterator<E>();
    }
}
