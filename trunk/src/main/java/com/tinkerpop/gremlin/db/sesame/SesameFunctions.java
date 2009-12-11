package com.tinkerpop.gremlin.db.sesame;

import com.tinkerpop.gremlin.FunctionHelper;
import com.tinkerpop.gremlin.db.sesame.functions.*;
import com.tinkerpop.gremlin.statements.EvaluationException;
import org.apache.commons.jxpath.Function;
import org.apache.commons.jxpath.Functions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class SesameFunctions implements Functions {

    public static final String NAMESPACE_PREFIX = "sail";

    private static Set<String> namespaces = new HashSet<String>();
    private static final Map<String, Function> functionMap = new HashMap<String, Function>();

    static {
        namespaces.add(NAMESPACE_PREFIX);
        functionMap.put(OpenFunction.FUNCTION_NAME, new OpenFunction());
        functionMap.put(AddNamespaceFunction.FUNCTION_NAME, new AddNamespaceFunction());
        functionMap.put(RemoveNamespaceFunction.FUNCTION_NAME, new RemoveNamespaceFunction());
        functionMap.put(GetNamespacesFunction.FUNCTION_NAME, new GetNamespacesFunction());
        functionMap.put(LoadFunction.FUNCTION_NAME, new LoadFunction());
    }

    public Function getFunction(String namespace, String name, Object[] parameters) {
        Function function = functionMap.get(name);
        if (null != function)
            return function;

        throw EvaluationException.createException(FunctionHelper.makeFunctionName(namespace, name), EvaluationException.EvaluationErrorType.NO_FUNCTION);
    }

    public Set getUsedNamespaces() {
        return namespaces;
    }


}
