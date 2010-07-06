package com.tinkerpop.gremlin.compiler.functions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public abstract class AbstractFunctions implements Functions {

    protected List<Function> functions = new ArrayList<Function>();

    public Function getFunction(final String functionName) throws RuntimeException {
        for (Function fn : functions) {
            if (fn.getFunctionName().equals(functionName))
                return fn;
        }
        throw new RuntimeException("Unregistered function: " + functionName);
    }

    public void addFunction(Function function) {
        this.functions.add(function);
    }

}
