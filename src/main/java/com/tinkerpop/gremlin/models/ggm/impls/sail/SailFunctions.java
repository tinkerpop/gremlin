package com.tinkerpop.gremlin.models.ggm.impls.sail;

import com.tinkerpop.gremlin.functions.FunctionHelper;
import com.tinkerpop.gremlin.models.ggm.impls.sail.functions.*;
import com.tinkerpop.gremlin.statements.EvaluationException;
import org.apache.commons.jxpath.Function;
import org.apache.commons.jxpath.Functions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class SailFunctions implements Functions {

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
        functionMap.put(PrefixFunction.FUNCTION_NAME, new PrefixFunction());
        functionMap.put(NamespaceFunction.FUNCTION_NAME, new NamespaceFunction());
        functionMap.put(SparqlFunction.FUNCTION_NAME, new SparqlFunction());
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
