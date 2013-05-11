package com.tinkerpop.gremlin.pipes.transform;

import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.blueprints.Element;
import com.tinkerpop.blueprints.Query;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.pipes.AbstractPipe;
import com.tinkerpop.pipes.transform.TransformPipe;
import com.tinkerpop.pipes.util.PipeHelper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public abstract class QueryPipe<S, E extends Element> extends AbstractPipe<S, E> implements TransformPipe<S, E> {

    protected List<HasContainer> hasContainers = new ArrayList<HasContainer>();
    protected List<IntervalContainer> intervalContainers = new ArrayList<IntervalContainer>();
    protected Class<E> elementClass;
    protected long lowRange = 0l;
    protected long highRange = Long.MAX_VALUE;

    protected long count = 0l;

    protected Iterator<E> currentIterator = PipeHelper.emptyIterator();

    public void setResultingElementClass(final Class<? extends Element> elementClass) {
        if (!elementClass.equals(Vertex.class) && !elementClass.equals(Edge.class))
            throw new IllegalArgumentException("The provided element class must be either Vertex or Edge");

        this.elementClass = (Class) elementClass;
    }

    public void addHasContainer(final HasContainer container) {
        this.hasContainers.add(container);
    }

    public void addIntervalContainer(final IntervalContainer container) {
        this.intervalContainers.add(container);
    }

    public void setHighRange(final long highRange) {
        this.highRange = (highRange == Long.MAX_VALUE) ? Long.MAX_VALUE : highRange + 1;
    }

    public void setLowRange(final long lowRange) {
        this.lowRange = (lowRange < 0l) ? 0 : lowRange;
    }

    public void reset() {
        super.reset();
        this.currentIterator = PipeHelper.emptyIterator();
        this.count = 0;
    }

    public String toString() {
        StringBuilder extra = new StringBuilder();
        if (null != this.hasContainers && this.hasContainers.size() > 0)
            extra.append("has");
        if (null != this.intervalContainers && this.intervalContainers.size() > 0) {
            if (extra.length() != 0) extra.append(",");
            extra.append("interval");
        }
        if (this.lowRange != 0 || highRange != Long.MAX_VALUE) {
            if (extra.length() != 0) extra.append(",");
            extra.append("range:[");
            extra.append(this.lowRange);
            extra.append(",");
            extra.append(this.highRange - 1);
            extra.append("]");
        }
        if (extra.length() != 0) extra.append(",");
        extra.append(this.elementClass.getSimpleName().toLowerCase());
        return extra.toString();
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
