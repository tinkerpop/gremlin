package com.tinkerpop.gremlin.functions;

import com.tinkerpop.gremlin.statements.EvaluationException;
import org.apache.commons.jxpath.Function;
import org.apache.commons.jxpath.Functions;
import org.apache.commons.jxpath.JXPathContext;

import java.util.Set;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class CoreFunctions implements Functions {

    private static Functions coreFunctions = JXPathContext.newContext(null).getFunctions();

    public Function getFunction(final String namespace, final String name, final Object[] parameters) {
        return coreFunctions.getFunction(namespace, name, parameters);
    }

    public Set getUsedNamespaces() {
        return coreFunctions.getUsedNamespaces();
    }
}
