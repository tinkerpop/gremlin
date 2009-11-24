package com.tinkerpop.gremlin;

import com.tinkerpop.gremlin.model.Graph;
import org.apache.commons.jxpath.ExpressionContext;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Random;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class GremlinFunctions {

    public static final String NAMESPACE_PREFIX = "g";
    private static final Random RANDOM = new Random();
    private static final String HASHSET = "hashset";
    private static final String ARRAYLIST = "arraylist";
    private static final String UNMODIFIABLE = "unmodifiablerandomaccesslist";
    private static final String SET = "assign";
    private static final String LIST = "list";

    public static Object get_vertex(Graph graph, Object indexKey) {
        if (graph == null)
            return null;
        else
            return (graph.getVertex(indexKey));
    }


    public static Object assign(ExpressionContext context, String variable, Object value) {
        //System.out.println(context.getPosition() + "--" + value);
        if (FunctionHelper.isLastInContext(context))
            FunctionHelper.getGremlin(context).setVariable(variable, value);
        return context.getContextNodeList();
    }

    public static Object assign(ExpressionContext context, String variable) {
        return GremlinFunctions.assign(context, variable, FunctionHelper.asValue(context.getContextNodeList()));
    }

    public static Object unassign(ExpressionContext context, String variable) {
        FunctionHelper.getGremlin(context).removeVariable(variable);
        return context.getContextNodeList();
    }

    public static Object cont(ExpressionContext context, boolean cont) {
        if (cont)
            return context.getContextNodeList();
        else
            return null;
    }

    public static Object halt(ExpressionContext context, boolean halt) {
        return GremlinFunctions.cont(context, !halt);
    }


    public static Object noop(ExpressionContext context) {
        return context.getContextNodeList();
    }

    public static Object print(ExpressionContext context) {
        return GremlinFunctions.print(context, context.getContextNodePointer().getValue());
    }

    public static Object print(ExpressionContext context, Object object) {
        System.out.println(object);
        return context.getContextNodeList();
    }

    public static Object random(Integer value) {
        return RANDOM.nextInt(value);
    }

    public static Object coin() {
        return RANDOM.nextBoolean();
    }

    public static Object make_list() {
        return new ArrayList();
    }

    public static Object make_set() {
        return new HashSet();
    }

    public static String type(Object object) {
        String type = object.getClass().getSimpleName().toLowerCase();
        if(type.equals(HASHSET))
            type = SET;
        else if(type.equals(ARRAYLIST))
            type= LIST;
        return type;
    }

    public static Object append(ExpressionContext context, String variable) {
        GremlinPathContext gremlin = FunctionHelper.getGremlin(context);
        Collection value = (Collection) gremlin.getVariable(variable);
        if (null == value) {
            value = new ArrayList();
        }
        value.add(context.getContextNodePointer().getValue());
        gremlin.setVariable(variable, value);
        return context.getContextNodeList();
    }

    /*public static Object filter(ExpressionContext context, String variable) {
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
