package com.tinkerpop.gremlin.compiler.functions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public abstract class AbstractFunctions implements Functions {

    protected List<Function> functions = new ArrayList<Function>();

    public Function getFunction(final String functionName) throws RuntimeException {
        for (final Function function : this.functions) {
            if (function.getFunctionName().equals(functionName))
                return function;
        }
        throw new RuntimeException("Unregistered function: " + this.getNamespace() + ":" + functionName);
    }

    public void addFunction(final Function function) {
        this.removeByFunctionName(function.getFunctionName());
        this.functions.add(function);
    }

    private void removeByFunctionName(final String functionName) {
        for (int i = 0; i < this.functions.size(); i++) {
            final Function function = this.functions.get(i);
            
            if (function.getFunctionName().equals(functionName))
                this.functions.remove(function);
        }
    }
}
