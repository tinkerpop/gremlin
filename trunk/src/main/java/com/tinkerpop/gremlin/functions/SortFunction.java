package com.tinkerpop.gremlin.functions;

import com.tinkerpop.gremlin.FunctionHelper;
import com.tinkerpop.gremlin.GremlinFunctions;
import com.tinkerpop.gremlin.statements.EvaluationException;
import org.apache.commons.jxpath.ExpressionContext;
import org.apache.commons.jxpath.Function;

import java.util.*;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class SortFunction implements Function {

    public static final String FUNCTION_NAME = "sort";

    public Object invoke(ExpressionContext context, Object[] parameters) {

        if (null != parameters) {
            Object[] objects = FunctionHelper.nodeSetConversion(parameters);
            if (objects.length == 3 && objects[0] instanceof Map && objects[1] instanceof String && objects[2] instanceof Boolean) {
                // g:sort(map, 'key' | 'value', reverse?)
                if (objects[1].equals("value")) {
                    return sortByValue((Map) objects[0], (Boolean) objects[2]);
                } else if (objects[1].equals("key")) {
                    return sortByKey((Map) objects[0]);
                }
            } else if(objects.length == 2 && objects[0] instanceof List && objects[1] instanceof Boolean) {
                // g:sort(list, reverse?)
                List list = (List)objects[1];
                Collections.sort(list);
                if((Boolean)objects[1])
                    Collections.reverse(list);
                return list;

            }
        }
        throw EvaluationException.createException(FunctionHelper.makeFunctionName(GremlinFunctions.NAMESPACE_PREFIX, FUNCTION_NAME), EvaluationException.EvaluationErrorType.UNSUPPORTED_PARAMETERS);

    }

    private static Map sortByValue(Map map, boolean reverse) {
        // TODO: augment original map with new values
        List mapKeys = new ArrayList(map.keySet());
        List mapValues = new ArrayList(map.values());
        Collections.sort(mapKeys);
        Collections.sort(mapValues);

        if (reverse)
            Collections.reverse(mapValues);

        LinkedHashMap sortedMap = new LinkedHashMap();

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
        return sortedMap;
    }

    private static Map sortByKey(Map map) {
        // TODO: add reverse sort
        map = new TreeMap(map);
        //TODO: ((TreeMap)map). decending map?
        return map;
    }
}
