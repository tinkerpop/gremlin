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
        Map<String, Function> functions;
        String namespace = function.getNamespace();

        this.namespaces.add(namespace);

        if ((functions = namespaceFunctionsMap.get(namespace)) != null) {
            functions.put(function.getFunctionName(), function);
        } else {
            functions = new HashMap<String, Function>();
            functions.put(function.getFunctionName(), function);
            this.namespaceFunctionsMap.put(namespace, functions);
        }
    }

    public Function getFunction(String namespace, String name, Object[] params) {
        Map<String, Function> functionsByNamespace = namespaceFunctionsMap.get(namespace);

        if (functionsByNamespace != null) {
            Function specificFunction = functionsByNamespace.get(name);
            if (specificFunction != null) {
                return specificFunction;
            }
        }

        throw EvaluationException.createException(FunctionHelper.makeFunctionName(namespace, name), EvaluationException.EvaluationErrorType.NO_FUNCTION);
    }

    public Set getUsedNamespaces() {
        return namespaces;
    }
}
