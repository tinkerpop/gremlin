package com.tinkerpop.gremlin.db.mongo;

import org.apache.commons.jxpath.Functions;
import org.apache.commons.jxpath.Function;

import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

import com.tinkerpop.gremlin.db.mongo.functions.OpenFunction;
import com.tinkerpop.gremlin.statements.EvaluationException;
import com.tinkerpop.gremlin.FunctionHelper;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class MongoFunctions  implements Functions {

    public static final String NAMESPACE_PREFIX = "mongo";

    private static Set<String> namespaces = new HashSet<String>();
    private static final Map<String, Function> functionMap = new HashMap<String, Function>();

    static {
        namespaces.add(NAMESPACE_PREFIX);
        functionMap.put(OpenFunction.FUNCTION_NAME, new OpenFunction());
    }

    public Function getFunction(final String namespace, final String name, final Object[] parameters) {
        Function function = functionMap.get(name);
        if (null != function)
            return function;


        throw EvaluationException.createException(FunctionHelper.makeFunctionName(namespace, name), EvaluationException.EvaluationErrorType.NO_FUNCTION);
    }

    public Set getUsedNamespaces() {
        return namespaces;
    }
}