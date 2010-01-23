package com.tinkerpop.gremlin;

import com.tinkerpop.gremlin.DynamicFunction;
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
    
    private static Set<String> namespaces = new HashSet<String>();
    private static Map<String, Function> functionMap = new HashMap<String, Function>();

    public DynamicFunctions(DynamicFunction function) {
        namespaces.add(function.getNamespace());
        functionMap.put(function.getFunctionName(), function);
    }

    public Function getFunction(String namespace, String name, Object[] params) {
        Function function = functionMap.get(name);
        if (null != function)
            return function;

        throw EvaluationException.createException(FunctionHelper.makeFunctionName(namespace, name), EvaluationException.EvaluationErrorType.NO_FUNCTION);

    }

    public Set getUsedNamespaces() {
        return namespaces;
    }
}
