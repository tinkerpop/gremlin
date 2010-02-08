package com.tinkerpop.gremlin.statements;

import com.tinkerpop.gremlin.functions.Function;
import com.tinkerpop.gremlin.functions.FunctionHelper;
import com.tinkerpop.gremlin.functions.Functions;
import junit.framework.TestCase;
import org.apache.commons.jxpath.ExpressionContext;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class TestFunctions extends TestCase implements Functions {

    public static final String NAMESPACE_PREFIX = "test";

    Map<String, Map<String, Function>> functions = new HashMap<String, Map<String, Function>>();

    public void addFunction(String namespace, Function function) {
        Map<String, Function> namespacedFunctions = this.functions.get(namespace);
        if (null == namespacedFunctions) {
            namespacedFunctions = new HashMap<String, Function>();
            this.functions.put(namespace, namespacedFunctions);
        }
        namespacedFunctions.put(function.getName(), function);

    }

    public void addFunctions(Functions functions) {
        Map<String, Map<String, Function>> functionMap = functions.getFunctions();
        for (String namespace : functionMap.keySet()) {
            Map<String, Function> namespacedFunctions = functionMap.get(namespace);
            for (String name : namespacedFunctions.keySet()) {
                this.addFunction(namespace, namespacedFunctions.get(name));
            }
        }
    }

    public Function getFunction(String namespace, String name, Object[] params) {
        Map<String, Function> namespacedFunctions = this.functions.get(namespace);
        if (null != namespacedFunctions) {
            Function function = namespacedFunctions.get(name);
            if (null != function) {
                return function;
            }
        }
        throw EvaluationException.createException(FunctionHelper.makeFunctionName(namespace, name), EvaluationException.EvaluationErrorType.NO_FUNCTION);
    }

    public Map<String, Map<String, Function>> getFunctions() {
        return this.functions;
    }

    public Set getUsedNamespaces() {
        return this.functions.keySet();
    }

    public TestFunctions() {
        this.addFunction(NAMESPACE_PREFIX, new TestFunctionOne());
        this.addFunction(NAMESPACE_PREFIX, new TestFunctionTwo());

    }


    private static class TestFunctionOne implements Function {
        public Object invoke(ExpressionContext context, Object[] parameters) {
            return new Integer(187);
        }

        public String getName() {
            return "test-func-1";
        }
    }

    private static class TestFunctionTwo implements Function {
        public Object invoke(ExpressionContext context, Object[] parameters) {
            return "marko was here";
        }

        public String getName() {
            return "test-func-2";
        }
    }


    public void testTrue() {
        assertTrue(true);
    }

}
