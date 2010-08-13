package com.tinkerpop.gremlin.compiler.functions.g.ime;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.functions.Function;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class SortFunctionTest extends BaseTest {

    public void testSortFunctionMap() {
        GremlinScriptContext context = new GremlinScriptContext();
        
        Map map = new HashMap();
        map.put("marko", 2);
        map.put("josh", 1);
        map.put("peter", 3);
        Function<Object> function = new SortFunction();
        this.stopWatch();
        Map sortedMap = (Map) (function.compute(createUnaryArgs(map, "value", true), context)).getValue();
        printPerformance(function.getFunctionName() + " function", 3, "entry map (reverse by value)", this.stopWatch());
        assertEquals(map.get("marko"), 2);
        assertEquals(map.get("josh"), 1);
        assertEquals(map.get("peter"), 3);

        List values = new ArrayList(sortedMap.values());
        assertEquals(values.get(0), 3);
        assertEquals(values.get(1), 2);
        assertEquals(values.get(2), 1);

        this.stopWatch();
        sortedMap = (Map) (function.compute(createUnaryArgs(map, "value", false), context)).getValue();
        printPerformance(function.getFunctionName() + " function", 3, "entry map (normal by value)", this.stopWatch());
        values = new ArrayList(sortedMap.values());
        assertEquals(values.get(0), 1);
        assertEquals(values.get(1), 2);
        assertEquals(values.get(2), 3);

        this.stopWatch();
        sortedMap = (Map) (function.compute(createUnaryArgs(map, "key", true), context)).getValue();
        printPerformance(function.getFunctionName() + " function", 3, "entry map (reverse by key)", this.stopWatch());
        List keys = new ArrayList(sortedMap.keySet());
        assertEquals(keys.get(0), "peter");
        assertEquals(keys.get(1), "marko");
        assertEquals(keys.get(2), "josh");

        this.stopWatch();
        sortedMap = (Map) (function.compute(createUnaryArgs(map, "key", false), context)).getValue();
        printPerformance(function.getFunctionName() + " function", 3, "entry map (normal by key)", this.stopWatch());
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

        GremlinScriptContext context = new GremlinScriptContext();
        
        Function<Object> function = new SortFunction();
        this.stopWatch();
        List sortedList = (List) (function.compute(createUnaryArgs(list, true), context)).getValue();
        printPerformance(function.getFunctionName() + " function", 3, "item list (reverse)", this.stopWatch());
        assertEquals(sortedList.get(0), 3);
        assertEquals(sortedList.get(1), 2);
        assertEquals(sortedList.get(2), 1);

        this.stopWatch();
        sortedList = (List) (function.compute(createUnaryArgs(list, false), context)).getValue();
        printPerformance(function.getFunctionName() + " function", 3, "item list (normal)", this.stopWatch());
        assertEquals(sortedList.get(0), 1);
        assertEquals(sortedList.get(1), 2);
        assertEquals(sortedList.get(2), 3);

        assertEquals(list.get(0), 2);
        assertEquals(list.get(1), 1);
        assertEquals(list.get(2), 3);
    }
}
