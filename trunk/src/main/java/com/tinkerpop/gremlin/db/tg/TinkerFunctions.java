package com.tinkerpop.gremlin.db.tg;

import com.tinkerpop.gremlin.db.tg.functions.OpenTinkerGraphFunction;
import com.tinkerpop.gremlin.statements.EvaluationException;
import com.tinkerpop.gremlin.FunctionHelper;
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
public class TinkerFunctions implements Functions {

    public static final String NAMESPACE_PREFIX = "tg";

    private static Set<String> namespaces = new HashSet<String>();
    private static final Map<String, Function> functionMap = new HashMap<String, Function>();

    static {
        namespaces.add(NAMESPACE_PREFIX);
        functionMap.put(OpenTinkerGraphFunction.FUNCTION_NAME, new OpenTinkerGraphFunction());
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
