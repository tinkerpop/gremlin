package com.tinkerpop.gremlin;

import com.tinkerpop.gremlin.statements.EvaluationException;
import org.apache.commons.jxpath.Function;
import org.apache.commons.jxpath.Functions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Pavel A. Yaskevich
 */
public class DynamicFunctions implements Functions {

    private Set<String> namespaces = new HashSet<String>();
    private Map<String, Map<String, Function>> namespaceFunctionsMap = new HashMap<String, Map<String, Function>>();


    public void registerFunction(DynamicFunction function) {

        String namespace = function.getNamespace();
        Map<String, Function> functions = namespaceFunctionsMap.get(namespace);

        if (functions != null) {
            functions.put(function.getFunctionName(), function);
        } else {
            functions = new HashMap<String, Function>();
            functions.put(function.getFunctionName(), function);
            this.namespaceFunctionsMap.put(namespace, functions);
            this.namespaces.add(namespace);
        }
    }

    public Function getFunction(String namespace, String name, Object[] params) {
        Map<String, Function> functions = namespaceFunctionsMap.get(namespace);

        if (functions != null) {
            Function function = functions.get(name);
            if (function != null) {
                return function;
            }
        }

        throw EvaluationException.createException(FunctionHelper.makeFunctionName(namespace, name), EvaluationException.EvaluationErrorType.NO_FUNCTION);
    }

    public Set getUsedNamespaces() {
        return namespaces;
    }
}
