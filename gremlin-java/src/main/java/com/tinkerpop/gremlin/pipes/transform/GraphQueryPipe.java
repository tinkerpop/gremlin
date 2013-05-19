package com.tinkerpop.gremlin.pipes.transform;

import com.tinkerpop.blueprints.Element;
import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.GraphQuery;
import com.tinkerpop.blueprints.Query;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.pipes.util.FastNoSuchElementException;
import com.tinkerpop.pipes.util.PipeHelper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class GraphQueryPipe<E extends Element> extends QueryPipe<Graph, E> {

    public GraphQueryPipe(final Class<E> elementClass) {
        super();
        super.setResultingElementClass(elementClass);
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
                final Graph graph = this.starts.next();
                GraphQuery query = graph.query();
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

    public String toString() {
        return PipeHelper.makePipeString(this, super.toString());
    }
}
