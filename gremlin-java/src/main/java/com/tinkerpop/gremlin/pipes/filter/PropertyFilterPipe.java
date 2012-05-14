package com.tinkerpop.gremlin.pipes.filter;

import com.tinkerpop.blueprints.Element;
import com.tinkerpop.pipes.AbstractPipe;
import com.tinkerpop.pipes.filter.FilterPipe;
import com.tinkerpop.pipes.util.PipeHelper;

/**
 * The PropertyFilterPipe either allows or disallows all Elements that have the provided value for a particular key.
 *
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class PropertyFilterPipe<S extends Element, T> extends AbstractPipe<S, S> implements FilterPipe<S> {

    private final String key;
    private final T value;
    private final FilterPipe.Filter filter;


    public PropertyFilterPipe(String key, final T value, final Filter filter) {
        this.key = key;
        this.value = value;
        this.filter = filter;
    }

    protected S processNextStart() {
        while (true) {
            final S element = this.starts.next();
            if (PipeHelper.compareObjects(this.filter, element.getProperty(this.key), this.value)) {
                return element;
            }
        }
    }

    public String toString() {
        return PipeHelper.makePipeString(this, this.key, this.filter, this.value);
    }

    public String getKey() {
        return this.key;
    }

    public T getValue() {
        return this.value;
    }

    public Filter getFilter() {
        return this.filter;
    }

}
