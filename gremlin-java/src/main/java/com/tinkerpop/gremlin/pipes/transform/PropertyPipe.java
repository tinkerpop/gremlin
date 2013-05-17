package com.tinkerpop.gremlin.pipes.transform;

import com.tinkerpop.blueprints.Element;
import com.tinkerpop.pipes.AbstractPipe;
import com.tinkerpop.pipes.transform.TransformPipe;
import com.tinkerpop.pipes.util.PipeHelper;

/**
 * The PropertyPipe returns the property value of the Element identified by the provided key.
 *
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class PropertyPipe<S extends Element, E> extends AbstractPipe<S, E> implements TransformPipe<S, E> {

    private final String key;
    private final boolean allowNull;

    public PropertyPipe(final String key) {
        this.key = key;
        this.allowNull = true;
    }

    public PropertyPipe(final String key, final boolean allowNull) {
        this.key = key;
        this.allowNull = allowNull;
    }

    protected E processNextStart() {
        while (true) {
            Element e = this.starts.next();
            E value = (E) e.getProperty(this.key);
            if (this.allowNull || value != null)
                return value;
        }
    }

    public String toString() {
        return PipeHelper.makePipeString(this, this.key);
    }
}
