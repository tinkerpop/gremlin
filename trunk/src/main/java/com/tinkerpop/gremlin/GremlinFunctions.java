package com.tinkerpop.gremlin;

import org.apache.commons.jxpath.ExpressionContext;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.NodeSet;
import org.apache.commons.jxpath.Pointer;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class GremlinFunctions {

    public static final String NAMESPACE_PREFIX = "g";
    private static final Random random = new Random();


    public static Object get_v(Graph graph, Object indexKey) {
        if (graph == null)
            return Boolean.FALSE;
        else
            return (graph.getVertex(indexKey));
    }

    public static Object set_root(ExpressionContext context, Object root) {
        if (root instanceof List) {
            if (((List) root).size() == 1) {
                root = ((List) root).get(0);
            }
        }
        FunctionHelper.getGremlin(context).setContextBean(root);
        return root;
    }

    public static Object set_root(ExpressionContext context) {
        return GremlinFunctions.set_root(context, FunctionHelper.asValue(context.getContextNodeList()));
    }

    public static Object random(Integer value) {
        return random.nextInt(value);
    }

    public static Object coin() {
        return random.nextBoolean();
    }

    public static Object set(ExpressionContext context, String variableName, Object value) {
        variableName = FunctionHelper.getVariable(variableName);
        if (FunctionHelper.isLastInContext(context))
            context.getJXPathContext().getVariables().declareVariable(variableName, value);
        return Boolean.TRUE;
    }

    public static Object set(ExpressionContext context, String variableName) {
        GremlinFunctions.set(context, variableName, FunctionHelper.asValue(context.getContextNodeList()));
        return context.getContextNodeList();
    }

    public static Object unset(ExpressionContext context, String variable) {
        variable = FunctionHelper.getVariable(variable);
        context.getJXPathContext().getVariables().undeclareVariable(variable);
        return Boolean.TRUE;
    }

    public static Object append(ExpressionContext context, String variable) {
        variable = FunctionHelper.getVariable(variable);
        Collection<Object> currentValue;
        try {
            currentValue = (Collection<Object>) context.getJXPathContext().getVariables().getVariable(variable);
        } catch (IllegalArgumentException e) {
            context.getJXPathContext().getVariables().declareVariable(variable, new LinkedList<Object>());
            currentValue = (Collection<Object>) context.getJXPathContext().getVariables().getVariable(variable);
        }
        currentValue.add(context.getContextNodePointer().getValue());
        context.getJXPathContext().getVariables().declareVariable(variable, currentValue);

        return Boolean.TRUE;
    }

    public static Object filter(ExpressionContext context, String variable) {
        variable = FunctionHelper.getVariable(variable);
        NodeSet history;
        try {
            history = (NodeSet) context.getJXPathContext().getVariables().getVariable("$" + variable);
        } catch (Exception e) {
            return Boolean.TRUE;
        }

        Object value = ((Pointer) context.getContextNodeList().get(context.getPosition() - 1)).getValue();
        return !history.getValues().contains(value);
    }

    public static Object halt(boolean halt) {
        return new Boolean(!halt);
    }

    public static Object cont(boolean cont) {
        return new Boolean(cont);
    }

    public static Object noop() {
        return Boolean.TRUE;
    }

    public static Object print(ExpressionContext context) {
        System.out.println(context.getContextNodePointer().getValue());
        return Boolean.TRUE;
    }

    public static Object print(String line) {
        System.out.println(line);
        return Boolean.TRUE;
    }

    public static Object loop(ExpressionContext context, String path, Integer times) {
        List<Object> results = FunctionHelper.asValue(context.getContextNodeList());
        List<Object> finalResults = new LinkedList<Object>();
        JXPathContext base = context.getJXPathContext();
        int counter = 0;
        if (FunctionHelper.isLastInContext(context)) {
            for (int i = 0; i < times; i++) {
                //System.out.println("looping " + counter++ + " on path " + path + " with " + results);
                finalResults.clear();
                for (Object o : results) {
                    base = JXPathContext.newContext(base, o);
                    finalResults.addAll(base.selectNodes(path));
                }
                results.clear();
                results.addAll(finalResults);
            }
            //System.out.println("results: " + finalResults);
        }
        return finalResults;
    }

    public static Object loopX(ExpressionContext context, Integer times) {
        List<Object> results = new LinkedList<Object>();
        results.add(context.getJXPathContext().getContextBean());
        String path = (String) context.getContextNodePointer().getValue();
        List<Object> finalResults = new LinkedList<Object>();
        JXPathContext base = JXPathContext.newContext(null);
        int counter = 0;
        if (FunctionHelper.isLastInContext(context)) {
            for (int i = 0; i < times; i++) {
                System.out.println("looping " + counter++ + " on path " + path + " with " + results);
                finalResults.clear();
                for (Object o : results) {
                    base = JXPathContext.newContext(base, o);
                    finalResults.addAll(base.selectNodes(path));
                }
                results.clear();
                results.addAll(finalResults);
            }
            System.out.println("results: " + finalResults);
        }
        return finalResults;
    }


    public static Object pointer(ExpressionContext context) {
        return context.getContextNodePointer();
    }
}
