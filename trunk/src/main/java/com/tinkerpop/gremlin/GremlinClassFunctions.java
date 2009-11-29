package com.tinkerpop.gremlin;

import com.tinkerpop.gremlin.model.Edge;
import com.tinkerpop.gremlin.model.Graph;
import com.tinkerpop.gremlin.model.Vertex;
import org.apache.commons.jxpath.ExpressionContext;

import java.util.*;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class GremlinClassFunctions {

    private static final Random RANDOM = new Random();
    private static final String UNMODIFIABLE = "unmodifiablerandomaccesslist";
    private static final String SET = "assign";
    private static final String LIST = "list";
    private static final String EDGE = "edge";
    private static final String VERTEX = "vertex";
    private static final String GRAPH = "graph";
    private static final String MAP = "map";
    private static final String NUMBER = "number";


    public static Object get_vertex(Graph graph, Object indexKey) {
        if (graph == null)
            return null;
        else
            return (graph.getVertex(indexKey));
    }

    public static Boolean cont(Boolean cont) {
        return cont;
    }

    public static Boolean halt(Boolean halt) {
        return !halt;
    }

    public static Boolean print(ExpressionContext context) {
        System.out.println((context.getContextNodePointer().getValue()));
        return Boolean.TRUE;
    }

    public static Integer random(Integer value) {
        return RANDOM.nextInt(value) + 1;
    }

    public static Integer random(ExpressionContext context) {
        return RANDOM.nextInt(context.getContextNodeList().size()) + 1;
    }

    /*public static Boolean prob_dist(ExpressionContext context, String weightLabel) {
        if(FunctionHelper.isFirstInContext(context)) {

        }
    }*/

    public static Boolean coin(Float bias) {
        Float r = RANDOM.nextFloat();
        return r < bias;      
    }

    public static Map as_map() {
        return new HashMap();
    }

    public static Object print(Object object) {
        System.out.println(object);
        return object;
    }

    // TODO make this an incr assign?
    public static Boolean incr_value(ExpressionContext context, Map map, Double incr) {
        Object key = context.getContextNodePointer().getValue();
        Object value = map.get(key);
        if(null == value)
            map.put(key, incr);
        else {
            map.put(key, Double.valueOf(value.toString()) + incr);
        }
        return Boolean.TRUE;  
    }

    public static List values(Map map) {
        List list = new ArrayList();
        list.addAll(map.values());
        return list;
    }

    public static Set keys(Map map) {
        return map.keySet();
    }

    public static String type(Object object) {
        String type = object.getClass().getSimpleName().toLowerCase();
        if (type.equals(UNMODIFIABLE)) {
            List list = (List) object;
            if (list.size() == 1)
                return type(list.get(0));
            else
                return LIST;
        }

        if (object instanceof Set)
            return SET;
        else if (object instanceof List)
            return LIST;
        else if (object instanceof Edge)
            return EDGE;
        else if (object instanceof Vertex)
            return VERTEX;
        else if (object instanceof Graph)
            return GRAPH;
        else if (object instanceof Map)
            return MAP;
        else if (object instanceof Double || object instanceof Integer)
            return NUMBER;
        else
            return type; // handles string or others.
    }
}
