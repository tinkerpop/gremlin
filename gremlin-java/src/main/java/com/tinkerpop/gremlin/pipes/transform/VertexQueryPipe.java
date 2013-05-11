package com.tinkerpop.gremlin.pipes.transform;

import com.tinkerpop.blueprints.Direction;
import com.tinkerpop.blueprints.Element;
import com.tinkerpop.blueprints.Query;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.VertexQuery;
import com.tinkerpop.pipes.util.FastNoSuchElementException;
import com.tinkerpop.pipes.util.PipeHelper;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * QueryPipe makes use of the Vertex.query() method in Blueprints which allows for intelligent edge look ups from the underlying graph.
 * Note that VertexQueryPipe is automatically constructed by a GremlinPipeline when a pattern of the following is seen:
 * <p>outE(x).has(x).interval(x).xV()</p>
 * The final xV() can be either inV(), outV(), or bothV().
 *
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class VertexQueryPipe<E extends Element> extends QueryPipe<Vertex, E> {

    private Direction direction = Direction.BOTH;
    private String[] labels;

    /**
     * Construct a new VertexQuery pipe that wraps an underlying Blueprints VertexQuery object.
     * Given the optional nature of many of the parameters, note the "wildcard" settings for each parameter.
     *
     * @param resultingElementClass this must be either Vertex.class or Edge.class (anything else will throw an IllegalArgumentException)
     * @param direction             this must be a legal direction representing the direction of the edge.
     * @param hasContainers         this must be a collection of 'has'-filters (i.e. property filters). Provide an empty list if no such filters are to be applied.
     * @param intervalContainers    this must be a collection of 'interval'-filters (i.e. property filters within a range). Provide an empty list if no such filters are to be applied.
     * @param lowRange              this must be a long value representing the low range of elements to emit
     * @param highRange             this must be a long value representing the high range of elements to emit
     * @param labels                this is a list of Strings representing the edge label filters to apply. Do not provide any Strings if no such filtering is desired.
     */
    public VertexQueryPipe(final Class<E> resultingElementClass, final Direction direction, final List<HasContainer> hasContainers, final List<IntervalContainer> intervalContainers, final long lowRange, final long highRange, final String... labels) {
        this.setResultingElementClass(resultingElementClass);
        this.direction = direction;
        if (null != hasContainers) {
            for (final HasContainer container : hasContainers) {
                super.addHasContainer(container);
            }
        }
        if (null != intervalContainers) {
            for (final IntervalContainer container : intervalContainers) {
                super.addIntervalContainer(container);
            }
        }
        super.setLowRange(lowRange);
        super.setHighRange(highRange);
        this.labels = labels;
    }

    public String toString() {
        return PipeHelper.makePipeString(this, this.direction.name().toLowerCase(), Arrays.asList(this.labels), super.toString());
    }

    public E processNextStart() {
        while (true) {
            if (this.count >= this.highRange) {
                throw FastNoSuchElementException.instance();
            } else if (this.currentIterator.hasNext()) {
                this.count++;
                final E e = currentIterator.next();
                if (this.count > this.lowRange)
                    return e;
            } else {
                final Vertex vertex = this.starts.next();
                VertexQuery query = vertex.query();
                query = query.direction(this.direction);
                if (this.labels.length > 0)
                    query = query.labels(this.labels);
                if (null != this.hasContainers) {
                    for (final HasContainer hasContainer : this.hasContainers) {
                        if (hasContainer.compare.equals(Query.Compare.EQUAL))
                            query = query.has(hasContainer.key, hasContainer.value);
                        else
                            query = query.has(hasContainer.key, hasContainer.compare, (Comparable) hasContainer.value);
                    }
                }
                if (null != this.intervalContainers) {
                    for (final IntervalContainer intervalContainer : this.intervalContainers) {
                        query = query.interval(intervalContainer.key, (Comparable) intervalContainer.startValue, (Comparable) intervalContainer.endValue);
                    }
                }
                if (this.highRange != Long.MAX_VALUE) {
                    query = query.limit(this.highRange - this.count);
                }
                if (this.elementClass.equals(Vertex.class))
                    this.currentIterator = (Iterator<E>) query.vertices().iterator();
                else
                    this.currentIterator = (Iterator<E>) query.edges().iterator();
            }
        }
    }


}
