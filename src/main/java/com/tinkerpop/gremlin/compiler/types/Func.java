package com.tinkerpop.gremlin.compiler.types;

import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.functions.Function;

import java.util.List;

/**
 * @author Pavel A. Yaskevich
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class Func extends DynamicEntity {

    private final Function function;
    private List<Operation> arguments;
    private final GremlinScriptContext context;
    private boolean done = false;

    public Func(final Function function, final List<Operation> arguments, final GremlinScriptContext context) {
        this.function = function;
        this.arguments = arguments;
        this.context = context;
    }

    public Object getValue() {
        if (!done) {
            internalCompute();
            this.done = true;
        }
        return this.value;
    }

    public Function getFunction() {
        return function;
    }

    public List<Operation> getArguments() {
        return arguments;
    }

    public GremlinScriptContext getContext() {
        return this.context;
    }

    public int hashCode() {
        return this.function.hashCode();
    }

    private void internalCompute() {
        this.value = function.compute(this.arguments, this.context).getValue();
    }

    public boolean isNull() {
        if (!done) {
            internalCompute();
            this.done = true;
        }
        return this.value == null;
    }

}
