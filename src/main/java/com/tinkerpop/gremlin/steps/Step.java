package com.tinkerpop.gremlin.steps;

import com.tinkerpop.pipes.Pipe;

import java.lang.reflect.Constructor;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class Step {

    private final Class<? extends Pipe> pipeClass;
    private final Object[] constructorArgs;
    private final Constructor<? extends Pipe> constructor;
    private final String stepName;

    public Step(String stepName, Class<? extends Pipe> pipeClass, Object[] constructorArgs) {
        this.stepName = stepName;
        this.pipeClass = pipeClass;
        this.constructorArgs = constructorArgs;
        int length;

        if (null == constructorArgs)
            length = 0;
        else
            length = this.constructorArgs.length;

        Class[] argsClasses = new Class[length];
        for (int i = 0; i < length; i++) {
            argsClasses[i] = this.constructorArgs[i].getClass();
        }
        try {
            this.constructor = this.pipeClass.getConstructor(argsClasses);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public String getStepName() {
        return this.stepName;
    }

    public Pipe createPipe() {
        try {
            return this.constructor.newInstance(this.constructorArgs);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
