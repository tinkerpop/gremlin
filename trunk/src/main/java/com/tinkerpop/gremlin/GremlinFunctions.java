package com.tinkerpop.gremlin;

import com.tinkerpop.gremlin.model.Graph;
import org.apache.commons.jxpath.ExpressionContext;
import org.apache.commons.jxpath.NodeSet;
import org.apache.commons.jxpath.Pointer;

import java.util.Collection;
import java.util.LinkedList;
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
            return null;
        else
            return (graph.getVertex(indexKey));
    }


    public static Object set(ExpressionContext context, String variable, Object value) {
        if (FunctionHelper.isLastInContext(context))
            FunctionHelper.getGremlin(context).setVariable(variable, value);
        return value;
    }

    public static Object set(ExpressionContext context, String variableName) {
        return GremlinFunctions.set(context, variableName, FunctionHelper.asValue(context.getContextNodeList()));
    }

    public static Object unset(ExpressionContext context, String variable) {
        FunctionHelper.getGremlin(context).removeVariable(variable);
        return Boolean.TRUE;
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

    public static Object random(Integer value) {
        return random.nextInt(value);
    }

    public static Object coin() {
        return random.nextBoolean();
    }

       /*public static Object append(ExpressionContext context, String variable) {
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
        NodeSet history;
        try {
            history = (NodeSet) context.getJXPathContext().getVariables().getVariable("$" + variable);
        } catch (Exception e) {
            return Boolean.TRUE;
        }

        Object value = ((Pointer) context.getContextNodeList().get(context.getPosition() - 1)).getValue();
        return !history.getValues().contains(value);
    }*/
}
