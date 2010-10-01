package com.tinkerpop.gremlin.steps;

import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.util.CodeBlock;
import com.tinkerpop.pipes.AbstractPipe;

/**
 * @author Pavel A. Yaskevich
 */
public class NativeStep extends AbstractPipe<Object,Object> implements Step {

    private final String name;
    private final CodeBlock block;

    public NativeStep(final String name, final CodeBlock block) {
        this.name  = name;
        this.block = block;
    }


    public Object processNextStart() {
        return this.block.invoke();
    }
    
    public String getStepName() {
        return this.name;
    }
}
