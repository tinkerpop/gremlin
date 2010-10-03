package com.tinkerpop.gremlin.steps;

import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.util.CodeBlock;
import com.tinkerpop.pipes.AbstractPipe;

import java.util.Iterator;

/**
 * @author Pavel A. Yaskevich
 */
public class NativePipe extends AbstractPipe<Object, Object> {

    private final CodeBlock block;
    private final GremlinScriptContext context;
    private Iterator<Object> tempIterator;

    public NativePipe(final GremlinScriptContext context, final CodeBlock block) {
        this.context = context;
        this.block = block;
    }

    public Object processNextStart() {
        while (true) {
            if (null != this.tempIterator && this.tempIterator.hasNext())
                return this.tempIterator.next();
            else {
                this.context.setCurrentPoint(this.starts.next());
                Object object = this.block.invoke().getValue();
                if (object instanceof Iterator)
                    this.tempIterator = (Iterator<Object>) object;
                else if (object instanceof Iterable)
                    this.tempIterator = ((Iterable<Object>) object).iterator();
                else
                    return object;
            }
        }
    }
}
