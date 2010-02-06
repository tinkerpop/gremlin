package com.tinkerpop.gremlin.functions.lme;

import com.tinkerpop.gremlin.functions.FunctionHelper;
import com.tinkerpop.gremlin.functions.GremlinFunctions;
import com.tinkerpop.gremlin.statements.EvaluationException;
import org.apache.commons.jxpath.ExpressionContext;
import org.apache.commons.jxpath.Function;

import java.util.*;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class SortFunction implements Function {

    public static final String FUNCTION_NAME = "sort";

    private static final String VALUE = "value";
    private static final String KEY = "key";

    public Object invoke(final ExpressionContext context, final Object[] parameters) {

        if (null != parameters) {
            Object[] objects = FunctionHelper.nodeSetConversion(parameters);
            if (objects.length == 3 && objects[0] instanceof Map && objects[1] instanceof String && objects[2] instanceof Boolean) {
                // g:sort(map, 'key' | 'value', reverse?)
                if (objects[1].equals(VALUE)) {
                    return sortByValue((Map) objects[0], (Boolean) objects[2]);
                } else if (objects[1].equals(KEY)) {
                    return sortByKey((Map) objects[0], (Boolean) objects[2]);
                }
            } else if (objects.length == 2 && objects[0] instanceof List && objects[1] instanceof Boolean) {
                // g:sort(list, reverse?)
                List list = (List) objects[0];
                List sortedList = new ArrayList(list);
                Collections.sort(sortedList);
                if ((Boolean) objects[1])
                    Collections.reverse(sortedList);
                return sortedList;
            }
        }
        throw EvaluationException.createException(FunctionHelper.makeFunctionName(GremlinFunctions.NAMESPACE_PREFIX, FUNCTION_NAME), EvaluationException.EvaluationErrorType.UNSUPPORTED_PARAMETERS);

    }

    private static Map sortByValue(final Map map, final boolean reverse) {
        List mapKeys = new ArrayList(map.keySet());
        List mapValues = new ArrayList(map.values());
        //Collections.sort(mapKeys); TODO: decide if we want to sort keys (causes problems if they don't implement comparable e.g. vertices)
        Collections.sort(mapValues);

        if (reverse)
            Collections.reverse(mapValues);

        LinkedHashMap sortedMap = new LinkedHashMap();
        HashMap oldMap = new HashMap(map);

        Iterator ittyValue = mapValues.iterator();
        while (ittyValue.hasNext()) {
            Object value = ittyValue.next();
            Iterator ittyKey = mapKeys.iterator();
            while (ittyKey.hasNext()) {
                Object key = ittyKey.next();
                String comp1 = map.get(key).toString();
                String comp2 = value.toString();
                if (comp1.equals(comp2)) {
                    map.remove(key);
                    mapKeys.remove(key);
                    sortedMap.put(key, value);
                    break;
                }
            }
        }

        map.putAll(oldMap);
        return sortedMap;
    }

    private static Map sortByKey(Map map, final boolean reverse) {
        map = new TreeMap(map);
        if (reverse)
            map = ((TreeMap) map).descendingMap();
        return map;
    }
}
