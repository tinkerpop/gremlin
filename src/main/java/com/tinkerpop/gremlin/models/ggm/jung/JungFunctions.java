package com.tinkerpop.gremlin.models.ggm.jung;

import org.apache.commons.jxpath.Function;
import org.apache.commons.jxpath.Functions;

import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;

import com.tinkerpop.gremlin.statements.EvaluationException;
import com.tinkerpop.gremlin.functions.FunctionHelper;
import com.tinkerpop.gremlin.models.ggm.jung.functions.scoring.PageRankFunction;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class JungFunctions implements Functions {

    public static final String NAMESPACE_PREFIX = "jung";

    private static Set<String> namespaces = new HashSet<String>();
    private static Map<String, Function> functionMap = new HashMap<String, Function>();

    static {
        namespaces.add(NAMESPACE_PREFIX);
        functionMap.put(PageRankFunction.FUNCTION_NAME, new PageRankFunction());

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
