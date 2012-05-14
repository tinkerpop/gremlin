package com.tinkerpop.gremlin.pipes.transform;

import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.blueprints.Element;
import com.tinkerpop.blueprints.Query;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.pipes.AbstractPipe;
import com.tinkerpop.pipes.util.PipeHelper;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * QueryPipe makes use of the Vertex.query() method in Blueprints which allows for intelligent edge look ups from the underlying graph.
 * Note that QueryPipe is automatically constructed by a GremlinPipeline when a pattern of the following is seen:
 * <p>outE(x).has(x).interval(x).inV()</p>
 * The final inV() can be either inV(), outV(), or bothV().
 *
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class QueryPipe<E extends Element> extends AbstractPipe<Vertex, E> {

    private Query.Direction direction = Query.Direction.BOTH;
    private String[] labels;
    private List<HasContainer> hasContainers;
    private List<IntervalContainer> intervalContainers;
    private final Class<E> elementClass;

    private Iterator<E> currentIterator = PipeHelper.emptyIterator();

    public QueryPipe(final Class<E> resultingElementClass, final Query.Direction direction, final List<HasContainer> hasContainers, final List<IntervalContainer> intervalContainers, final String... labels) {
        this.elementClass = resultingElementClass;
        this.direction = direction;
        this.hasContainers = hasContainers;
        this.intervalContainers = intervalContainers;
        this.labels = labels;

        if (!resultingElementClass.equals(Vertex.class) && !resultingElementClass.equals(Edge.class))
            throw new IllegalArgumentException("The provided element class must be either Vertex or Edge");
    }

    public void reset() {
        super.reset();
        this.currentIterator = PipeHelper.emptyIterator();
    }

    public String toString() {
        return PipeHelper.makePipeString(this, this.direction.name().toLowerCase(), Arrays.asList(labels), elementClass.getSimpleName().toLowerCase());
    }

    public E processNextStart() {
        while (true) {
            if (this.currentIterator.hasNext())
                return currentIterator.next();
            else {
                final Vertex vertex = this.starts.next();
                Query query = vertex.query();
                query = query.direction(this.direction);
                if (this.labels.length > 0)
                    query = query.labels(this.labels);
                if (this.hasContainers.size() > 0) {
                    for (final HasContainer hasContainer : hasContainers) {
                        query = query.has(hasContainer.key, hasContainer.value, hasContainer.compare);
                    }
                }
                if (this.intervalContainers.size() > 0) {
                    for (final IntervalContainer intervalContainer : intervalContainers) {
                        query = query.interval(intervalContainer.key, intervalContainer.startValue, intervalContainer.endValue);
                    }
                }
                if (this.elementClass.equals(Vertex.class))
                    this.currentIterator = (Iterator<E>) query.vertices().iterator();
                else
                    this.currentIterator = (Iterator<E>) query.edges().iterator();
            }
        }
    }

    public static class HasContainer {
        public String key;
        public Object value;
        public Query.Compare compare;

        public HasContainer(final String key, final Object value, final Query.Compare compare) {
            this.key = key;
            this.value = value;
            this.compare = compare;
        }
    }

    public static class IntervalContainer {
        public String key;
        public Object startValue;
        public Object endValue;

        public IntervalContainer(final String key, final Object startValue, final Object endValue) {
            this.key = key;
            this.startValue = startValue;
            this.endValue = endValue;
        }
    }

}
