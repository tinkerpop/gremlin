package com.tinkerpop.gremlin;

import com.tinkerpop.gremlin.db.tg.TinkerGraphFactory;
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

    private static final Random random = new Random();
    private static final String DOLLAR_SIGN = "$";
    private static final String EMPTY_STRING = "";

    public static Object load_tg(ExpressionContext context, String graphFile) {
        GremlinHelpers.getGremlin(context).setGraph(TinkerGraphFactory.createTinkerGraph());
        return Boolean.TRUE;
    }

    public static Object index_v(ExpressionContext context, Object indexKey) {
        Graph graph = GremlinHelpers.getGremlin(context).getGraph();
        if (graph == null)
            return Boolean.FALSE;
        return (graph.getVertex(indexKey));
    }

    public static Object root(ExpressionContext context, Object root) {
        if (root instanceof List) {
            if (((List) root).size() == 1) {
                root = ((List) root).get(0);
            }
        }
        GremlinHelpers.getGremlin(context).setContextBean(root);
        return Boolean.TRUE;
    }

    public static Object root(ExpressionContext context) {
        return GremlinFunctions.root(context, GremlinHelpers.asValue(context.getContextNodeList()));
    }

    public static Object random(Integer value) {
        return random.nextInt(value);
    }

    public static Object coin() {
        return random.nextBoolean();
    }

    public static Object set(ExpressionContext context, String variable, Object value) {
        variable = variable.replace(DOLLAR_SIGN, EMPTY_STRING);
        if (GremlinHelpers.isLastInContext(context))
            context.getJXPathContext().getVariables().declareVariable(variable, value);
        return Boolean.TRUE;
    }

    public static Object set(ExpressionContext context, String variable) {
        return GremlinFunctions.set(context, variable, GremlinHelpers.asValue(context.getContextNodeList()));
    }

    public static Object unset(ExpressionContext context, String variable) {
        variable = variable.replace(DOLLAR_SIGN, EMPTY_STRING);
        context.getJXPathContext().getVariables().undeclareVariable(variable);
        return Boolean.TRUE;
    }

    public static Object append(ExpressionContext context, String variable) {
        variable = variable.replace(DOLLAR_SIGN, EMPTY_STRING);
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
        variable = variable.replace(DOLLAR_SIGN, EMPTY_STRING);
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
        List<Object> results = GremlinHelpers.asValue(context.getContextNodeList());
        List<Object> finalResults = new LinkedList<Object>();
        JXPathContext base = context.getJXPathContext();
        int counter = 0;
        if (GremlinHelpers.isLastInContext(context)) {
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
        if (GremlinHelpers.isLastInContext(context)) {
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
