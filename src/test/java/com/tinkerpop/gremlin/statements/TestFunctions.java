package com.tinkerpop.gremlin.statements;

import org.apache.commons.jxpath.ExpressionContext;
import org.apache.commons.jxpath.Function;
import org.apache.commons.jxpath.Functions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import junit.framework.TestCase;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class TestFunctions extends TestCase implements Functions {

    public static final String NAMESPACE_PREFIX = "test";

    private static Set<String> namespaces = new HashSet<String>();
    private static Map<String, Function> functionMap = new HashMap<String, Function>();

    static {
        namespaces.add(NAMESPACE_PREFIX);
        functionMap.put("test-func-1", new TestFunctionOne());
        functionMap.put("test-func-2", new TestFunctionTwo());

    }

    public Function getFunction(final String namespace, final String name, final Object[] parameters) {
        return functionMap.get(name);
    }

    public Set getUsedNamespaces() {
        return namespaces;
    }

    private static class TestFunctionOne implements Function {
        public Object invoke(ExpressionContext context, Object[] parameters) {
            return new Integer(187);
        }
    }

    private static class TestFunctionTwo implements Function {
        public Object invoke(ExpressionContext context, Object[] parameters) {
            return "marko was here";
        }
    }

    public void testTrue() {
        assertTrue(true);
    }

}
