package com.tinkerpop.gremlin;

import com.tinkerpop.gremlin.model.Graph;
import org.apache.commons.jxpath.ExpressionContext;

import java.util.*;

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

    /*
        public static Integer sum(Integer... a) {
        int total = 0;
        for(Integer i : a) {
            total = total + i;
        }
        return total;
    }
     */

    public static Object get_vertex(Graph graph, Object indexKey) {
        if (graph == null)
            return null;
        else
            return (graph.getVertex(indexKey));
    }


    public static Object assign(ExpressionContext context, String variable, Object value) {
        if (FunctionHelper.isLastInContext(context))
            FunctionHelper.getGremlin(context).setVariable(variable, value);
        return value;
    }

    public static Boolean assign(ExpressionContext context, String variable) {
        if (FunctionHelper.isLastInContext(context))
            FunctionHelper.getGremlin(context).setVariable(variable, FunctionHelper.asValue(context.getContextNodeList()));
        return Boolean.TRUE;
    }

    public static Boolean unassign(ExpressionContext context, String variable) {
        FunctionHelper.getGremlin(context).removeVariable(variable);
        return Boolean.TRUE;
    }

    public static Boolean cont(boolean cont) {
       return cont;
    }

    public static Boolean halt(boolean halt) {
        return !halt;
    }

    public static Boolean noop() {
        return Boolean.TRUE;
    }

    public static Boolean print(ExpressionContext context) {
        GremlinFunctions.print(context.getContextNodePointer().getValue());
        return Boolean.TRUE;
    }

    public static Object print(Object object) {
        System.out.println(object);
        return object;
    }

    public static Integer random(Integer value) {
        return RANDOM.nextInt(value)+1;
    }

    public static Integer random(ExpressionContext context) {
        return RANDOM.nextInt(context.getContextNodeList().size())+1;
    }

    public static Boolean coin() {
        return RANDOM.nextBoolean();
    }

    public static List make_list() {
        return new ArrayList();
    }

    public static Set make_set() {
        return new HashSet();
    }

    public static Map make_map() {
        return new HashMap();
    }

    public static Object get_value(Map map, Object key) {
        return map.get(key);
    }

    public static Object set_value(Map map, Object key, Object value) {
        map.put(key, value);
        return null;
    }

    public static Collection get_values(Map map) {
        return map.values();
    }

    public static Set get_keys(Map map) {
        return map.keySet();
    }

    public static List as_list(Object a) {
        if(a instanceof Collection)
            return new ArrayList((Collection)a);
        else {
            List b = new ArrayList();
            b.add(a);
            return b;
        }
    }

    public static Set as_set(Object a) {
        if(a instanceof Collection)
            return new HashSet((Collection)a);
        else {
            Set b = new HashSet();
            b.add(a);
            return b;
        }
    }

    public static List append(Object a, Object b) {
        List c = new ArrayList();
        if(a instanceof Collection)
            c.addAll((Collection)a);
        else
            c.add(a);
        if(b instanceof Collection)
            c.addAll((Collection)b);
        else
            c.add(b);
        return c;
    }

    public static Set union(Object a, Object b) {
        Set c = new HashSet();
        if(a instanceof Collection)
            c.addAll((Collection)a);
        else
            c.add(a);
        if(b instanceof Collection)
            c.addAll((Collection)b);
        else
            c.add(b);
        return c;

    }

    public static Set intersect(Object a, Object b) {
        Set c = new HashSet();
        Set d = new HashSet();
        if(a instanceof Collection)
            c.addAll((Collection)a);
        else
            c.add(a);
        if(b instanceof Collection)
            d.addAll((Collection)b);
        else
            d.add(b);
        
        c.retainAll(d);
        return c;
    }

    public static Set difference(Object a, Object b) {
        Set c = new HashSet();
        Set d = new HashSet();
        if(a instanceof Collection)
            c.addAll((Collection)a);
        else
            c.add(a);
        if(b instanceof Collection)
            d.addAll((Collection)b);
        else
            d.add(b);

        c.removeAll(d);
        return c;
    }

    public static Boolean retain(ExpressionContext context, Object a) {
        Set b = new HashSet();
        if(a instanceof Collection)
            b.addAll((Collection)a);
        else
            b.add(a);

        Set c = new HashSet();
        c.add(context.getContextNodePointer().getValue());
        b.retainAll(c);
        return b.size() > 0;
    }


    public static Boolean except(ExpressionContext context, Object a) {
        Set b = new HashSet();
        if(a instanceof Collection)
            b.addAll((Collection)a);
        else
            b.add(a);

        Set c = new HashSet();
        c.add(context.getContextNodePointer().getValue());
        c.removeAll(b);
        return c.size() > 0;
    }

    public static String type(Object object) {
        String type = object.getClass().getSimpleName().toLowerCase();
        if (type.equals(HASHSET))
            type = SET;
        else if (type.equals(ARRAYLIST))
            type = LIST;
        return type;
    }
}
