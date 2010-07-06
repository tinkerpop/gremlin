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

    Map<String, Functions> functionsByNamespace;

    public FunctionLibrary() {
        this.functionsByNamespace = new HashMap<String, Functions>();
        ServiceLoader<Functions> functionsService = ServiceLoader.load(Functions.class);
        for (Functions functions : functionsService) {
            this.registerFunctions(functions);
        }
    }

    public void registerFunctions(final Functions functions) {
        this.functionsByNamespace.put(functions.getNamespace(), functions);
    }

    public void registerFunction(final String namespace, final Function fn) {
        Functions functions = this.functionsByNamespace.get(namespace);

        if (functions == null) {
            functions = new NativeFunctions(namespace);
            functions.addFunction(fn);
        } else {
            functions.addFunction(fn);
        }

        this.functionsByNamespace.put(namespace, functions);
    }

    public Function getFunction(final String namespace, final String functionName) throws RuntimeException {
        Functions functions = this.functionsByNamespace.get(namespace);

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
        Function fn = this.getFunction(namespace, functionName);

        Atom result = new Atom(null);

        result.setPersistent(false);
        result.setFunction(fn, params);

        return result;
    }


}
