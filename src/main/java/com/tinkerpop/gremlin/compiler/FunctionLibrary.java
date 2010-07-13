package com.tinkerpop.gremlin.compiler;

import com.tinkerpop.gremlin.compiler.functions.Function;
import com.tinkerpop.gremlin.compiler.functions.Functions;
import com.tinkerpop.gremlin.compiler.functions.NativeFunctions;
import com.tinkerpop.gremlin.compiler.operations.Operation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ServiceLoader;

/**
 * @author Pavel A. Yaskevich
 */
public class FunctionLibrary {

    final Map<String, Functions> functionsByNamespace;

    public FunctionLibrary() {
        this.functionsByNamespace = new HashMap<String, Functions>();
        final ServiceLoader<Functions> functionsService = ServiceLoader.load(Functions.class);
        for (final Functions functions : functionsService) {
            this.registerFunctions(functions);
        }
    }

    public void registerFunctions(final Functions functions) {
        this.functionsByNamespace.put(functions.getNamespace(), functions);
    }

    public void registerFunction(final String namespace, final Function function) {
        Functions functions = this.functionsByNamespace.get(namespace);

        if (functions == null) {
            functions = new NativeFunctions(namespace);
            functions.addFunction(function);
        } else {
            functions.addFunction(function);
        }

        this.functionsByNamespace.put(namespace, functions);
    }

    public Function getFunction(final String namespace, final String functionName) throws RuntimeException {
        final Functions functions = this.functionsByNamespace.get(namespace);

        if (functions == null) {
            throw new RuntimeException("No such namespace: " + namespace);
        } else {
            Function function = functions.getFunction(functionName);
            if (null != function)
                return function;
        }

        throw new RuntimeException("Unregistered function: " + namespace + ":" + functionName);
    }

    public Atom runFunction(final String namespace, final String functionName, final List<Operation> params) throws Exception {
        final Function fn = this.getFunction(namespace, functionName);

        final Atom result = new Atom(null);

        result.setPersistent(false);
        result.setFunction(fn, params);

        return result;
    }


}
