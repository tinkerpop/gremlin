package com.tinkerpop.gremlin.functions;

import com.tinkerpop.gremlin.statements.EvaluationException;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Pavel A. Yaskevich
 */
public class NativeFunctions implements Functions {

    private static Set<String> namespaces = new HashSet<String>();
    private static Map<String, Map<String, Function>> namespaceFunctionsMap = new HashMap<String, Map<String, Function>>();

    public NativeFunctions(NativeFunction function) {
        Map<String, Function> functions;
        String namespace = function.getNamespace();

        namespaces.add(namespace);

        if ((functions = namespaceFunctionsMap.get(namespace)) != null) {
            functions.put(function.getName(), function);
        } else {
            functions = new HashMap<String, Function>();
            functions.put(function.getName(), function);
            namespaceFunctionsMap.put(namespace, functions);
        }
    }

    public Function getFunction(String namespace, String name, Object[] params) {
        Map functionsByNamespace = namespaceFunctionsMap.get(namespace);

        if (functionsByNamespace != null) {
            Function specificFunction = (Function) functionsByNamespace.get(name);
            if (specificFunction != null) {
                return specificFunction;
            }
        }

        throw EvaluationException.createException(FunctionHelper.makeFunctionName(namespace, name), EvaluationException.EvaluationErrorType.NO_FUNCTION);
    }

    public void addFunctions(Functions functions) {
        throw new EvaluationException("Use constructor to add new native functions");
    }

    public Set getUsedNamespaces() {
        return namespaces;
    }
}
 