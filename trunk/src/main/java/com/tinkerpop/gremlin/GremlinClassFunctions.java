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

    public static Object get_vertex(Graph graph, Object indexKey) {
        if (graph == null)
            return null;
        else
            return (graph.getVertex(indexKey));
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

    public static Object print(Object object) {
        System.out.println(object);
        return object;
    }

    // TODO make this an incr assign?
    public static Boolean incr_value(ExpressionContext context, Map map, Double incr) {
        Object key = context.getContextNodePointer().getValue();
        Object value = map.get(key);
        if (null == value)
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

}
