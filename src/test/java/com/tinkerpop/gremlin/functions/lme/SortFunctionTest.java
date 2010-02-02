package com.tinkerpop.gremlin.functions.lme;

import com.tinkerpop.gremlin.XPathEvaluator;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class SortFunctionTest extends TestCase {

    public void testSortFunctionMap() {
        Map map = new HashMap();
        map.put("marko", 2);
        map.put("josh", 1);
        map.put("peter", 3);
        XPathEvaluator xe = new XPathEvaluator();
        xe.getVariables().declareVariable("$m", map);
        Map sortedMap = (Map) xe.evaluateList("g:sort($m, 'value', true())").get(0);
        assertEquals(map.get("marko"), 2);
        assertEquals(map.get("josh"), 1);
        assertEquals(map.get("peter"), 3);
        List values = new ArrayList(sortedMap.values());
        assertEquals(values.get(0), 3);
        assertEquals(values.get(1), 2);
        assertEquals(values.get(2), 1);

        sortedMap = (Map) xe.evaluateList("g:sort($m, 'value', false())").get(0);
        values = new ArrayList(sortedMap.values());
        assertEquals(values.get(0), 1);
        assertEquals(values.get(1), 2);
        assertEquals(values.get(2), 3);

        sortedMap = (Map) xe.evaluateList("g:sort($m, 'key', true())").get(0);
        List keys = new ArrayList(sortedMap.keySet());
        assertEquals(keys.get(0), "peter");
        assertEquals(keys.get(1), "marko");
        assertEquals(keys.get(2), "josh");

        sortedMap = (Map) xe.evaluateList("g:sort($m, 'key', false())").get(0);
        keys = new ArrayList(sortedMap.keySet());
        assertEquals(keys.get(0), "josh");
        assertEquals(keys.get(1), "marko");
        assertEquals(keys.get(2), "peter");

        assertEquals(map.get("marko"), 2);
        assertEquals(map.get("josh"), 1);
        assertEquals(map.get("peter"), 3);
    }

    public void testSortFunctionList() {
        List list = new ArrayList();
        list.add(2);
        list.add(1);
        list.add(3);
        XPathEvaluator xe = new XPathEvaluator();
        xe.getVariables().declareVariable("$i", list);
        List sortedList = xe.evaluateList("g:sort($i, true())");
        assertEquals(sortedList.get(0), 3);
        assertEquals(sortedList.get(1), 2);
        assertEquals(sortedList.get(2), 1);

        sortedList = xe.evaluateList("g:sort($i, false())");
        assertEquals(sortedList.get(0), 1);
        assertEquals(sortedList.get(1), 2);
        assertEquals(sortedList.get(2), 3);
        assertEquals(list.get(0), 2);
        assertEquals(list.get(1), 1);
        assertEquals(list.get(2), 3);
    }
}
