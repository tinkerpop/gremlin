package com.tinkerpop.gremlin.steps;

import com.tinkerpop.gremlin.compiler.util.CodeBlock;
import com.tinkerpop.pipes.AbstractPipe;

import java.util.Iterator;

/**
 * @author Marko A. Rodriguez
 */
public class NativePipe extends AbstractPipe<Object, Object> {

    private final CodeBlock block;
    private Iterator tempIterator;

    public NativePipe(final CodeBlock block) {
        this.block = block;
    }

    public Object processNextStart() {
        while (true) {
            if (null != this.tempIterator && this.tempIterator.hasNext()) {
                return this.tempIterator.next();
            } else {
                Object object = this.block.invoke(this.starts.next()).getValue();

                if (object instanceof Iterator)
                    this.tempIterator = (Iterator) object;
                else if (object instanceof Iterable)
                    this.tempIterator = ((Iterable) object).iterator();
                else
                    return object;
            }
        }
    }
}
