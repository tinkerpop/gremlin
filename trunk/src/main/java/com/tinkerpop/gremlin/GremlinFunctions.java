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

    public static Object get_vertex(Graph graph, Object indexKey) {
        if (graph == null)
            return null;
        else
            return (graph.getVertex(indexKey));
    }


    public static Object assign(ExpressionContext context, String variable, Object value) {
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

    public static Object cont(boolean cont) {
       return cont;
    }

    public static Object halt(boolean halt) {
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
        return null;
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

    public static List as_list(Collection collection) {
        return new ArrayList(collection);
    }

    public static Set as_set(Collection collection) {
        return new HashSet(collection);
    }

    public static List append(Collection collectionA, Collection collectionB) {
        List listC = new ArrayList(collectionA);
        listC.addAll(collectionB);
        return listC;
    }

    public static Set union(Collection collectionA, Collection collectionB) {
        Set setC = new HashSet(collectionA);
        setC.addAll(collectionB);
        return setC;
    }

    public static Set intersect(Collection collectionA, Collection collectionB) {
        Set setC = new HashSet(collectionA);
        setC.retainAll(collectionB);
        return setC;
    }

    public static Set difference(Collection collectionA, Collection collectionB) {
        Set setC = new HashSet(collectionA);
        setC.removeAll(collectionB);
        return setC;
    }

    public static Boolean retain(ExpressionContext context, Collection collection) {
        Set setA = new HashSet(collection);
        Set setB = new HashSet();
        setB.add(context.getContextNodePointer().getValue());
        collection.retainAll(setB);
        return setA.size() > 0;
    }


    public static Boolean except(ExpressionContext context, Collection collection) {
        Set setA = new HashSet(collection);
        Set setB = new HashSet();
        setB.add(context.getContextNodePointer().getValue());
        setB.removeAll(setA);
        return setB.size() > 0;
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
