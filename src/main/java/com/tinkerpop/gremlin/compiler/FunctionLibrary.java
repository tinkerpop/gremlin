package com.tinkerpop.gremlin.compiler;

import com.tinkerpop.gremlin.compiler.functions.Function;
import com.tinkerpop.gremlin.compiler.functions.g.GremlinFunctionLibrary;
import com.tinkerpop.gremlin.compiler.functions.tg.TinkerGraphFunctionLibrary;
import com.tinkerpop.gremlin.compiler.operations.Operation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Pavel A. Yaskevich
 */
public class FunctionLibrary {

    Map<String, List<Function>> functionsByNamespace;

    public FunctionLibrary() {
        this.functionsByNamespace = new HashMap<String, List<Function>>();

        this.registerFunctions("g", GremlinFunctionLibrary.library());
        this.registerFunctions("tg", TinkerGraphFunctionLibrary.library());
    }

    public void registerFunctions(final String namespace, final List<Function> functions) {
        for (int i = 0; i < functions.size(); i++) {
            this.registerFunction(namespace, functions.get(i));
        }
    }

    public void registerFunction(final String namespace, final Function fn) {
        List<Function> functions = this.functionsByNamespace.get(namespace);

        if (functions == null) {
            functions = new ArrayList<Function>();
            functions.add(fn);
        } else {
            functions.add(fn);
        }

        this.functionsByNamespace.put(namespace, functions);
    }

    public Function getFunction(final String namespace, final String functionName) throws RuntimeException {
        List<Function> functions = this.functionsByNamespace.get(namespace);

        if (functions == null) {
            throw new RuntimeException("No such namespace: " + namespace);
        } else {
            for (Function fn : functions) {
                if (fn.getFunctionName().equals(functionName))
                    return fn;
            }
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

    public Map<String, List<Function>> getRawLibrary() {
        return this.functionsByNamespace;
    }

}
