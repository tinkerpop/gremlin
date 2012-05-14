package com.tinkerpop.gremlin.pipes.filter;

import com.tinkerpop.blueprints.Element;
import com.tinkerpop.pipes.AbstractPipe;
import com.tinkerpop.pipes.filter.FilterPipe;
import com.tinkerpop.pipes.util.PipeHelper;

/**
 * IntervalFilterPipe will filter an element flowing through it according to whether a particular property value of the element is within provided range.
 * For those objects who property value for provided key is null, the element is filtered out of the stream.
 *
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class IntervalFilterPipe<T extends Element> extends AbstractPipe<T, T> implements FilterPipe<T> {

    private final String key;
    private final Object startValue;
    private final Object endValue;

    public IntervalFilterPipe(final String key, final Object startValue, final Object endValue) {
        this.key = key;
        this.startValue = startValue;
        this.endValue = endValue;
    }

    public T processNextStart() {
        while (true) {
            final T t = this.starts.next();
            final Object value = t.getProperty(key);
            if (null == value)
                continue;
            else {
                if (PipeHelper.compareObjects(Filter.GREATER_THAN_EQUAL, value, this.startValue) && PipeHelper.compareObjects(Filter.LESS_THAN, value, this.endValue))
                    return t;
            }
        }
    }

    public String getKey() {
        return this.key;
    }

    public Object getStartValue() {
        return this.startValue;
    }

    public Object getEndValue() {
        return this.endValue;
    }
}
