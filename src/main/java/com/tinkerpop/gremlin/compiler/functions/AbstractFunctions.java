package com.tinkerpop.gremlin.compiler.functions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public abstract class AbstractFunctions implements Functions {

    protected List<Function> functions = new ArrayList<Function>();

    public Function getFunction(final String functionName) throws RuntimeException {
        for (Function function : this.functions) {
            if (function.getFunctionName().equals(functionName))
                return function;
        }
        throw new RuntimeException("Unregistered function: " + this.getNamespace() + ":" + functionName);
    }

    public void addFunction(final Function function) {
        this.functions.add(function);
    }
}
