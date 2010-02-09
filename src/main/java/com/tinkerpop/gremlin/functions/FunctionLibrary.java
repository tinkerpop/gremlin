package com.tinkerpop.gremlin.functions;

import com.tinkerpop.gremlin.statements.EvaluationException;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class FunctionLibrary implements Functions {

    Map<String, Map<String, Function>> functions = new HashMap<String, Map<String, Function>>();

    public void addFunction(final String namespace, final Function function) {

        Map<String, Function> namespacedFunctions = this.functions.get(namespace);
        if (null == namespacedFunctions) {
            namespacedFunctions = new HashMap<String, Function>();
            this.functions.put(namespace, namespacedFunctions);
        }
        namespacedFunctions.put(function.getName(), function);

    }

    public void addFunctions(final Functions functions) {
        Map<String, Map<String, Function>> functionMap = functions.getFunctions();
        for (String namespace : functionMap.keySet()) {

            Map<String, Function> namespacedFunctions = functionMap.get(namespace);
            for (String name : namespacedFunctions.keySet()) {
                this.addFunction(namespace, namespacedFunctions.get(name));
            }
        }
    }

    public Function getFunction(final String namespace, final String name, final Object[] parameters) {
        Map<String, Function> namespacedFunctions = this.functions.get(namespace);
        if (null != namespacedFunctions) {
            Function function = namespacedFunctions.get(name);
            if (null != function) {
                return function;
            }
        }
        throw EvaluationException.createException(FunctionHelper.makeFunctionName(namespace, name), EvaluationException.EvaluationErrorType.NO_FUNCTION);
    }

    public Map<String, Map<String, Function>> getFunctions() {
        return this.functions;
    }

    public Set<String> getUsedNamespaces() {
        return this.functions.keySet();
    }
}
