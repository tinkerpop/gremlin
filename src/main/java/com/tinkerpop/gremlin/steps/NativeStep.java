package com.tinkerpop.gremlin.steps;

import com.tinkerpop.gremlin.compiler.util.CodeBlock;

/**
 * @author Pavel A. Yaskevich
 */
public class NativeStep extends AbstractStep<Object, Object> {

    private final String stepName;
    private final CodeBlock block;

    public NativeStep(final String stepName, final CodeBlock block) {
        this.stepName = stepName;
        this.block = block;
    }


    public Object processNextStart() {
        return this.block.invoke();
    }

    public String getStepName() {
        return this.stepName;
    }
}
