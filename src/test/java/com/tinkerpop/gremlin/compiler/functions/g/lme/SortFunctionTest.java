package com.tinkerpop.gremlin.compiler.functions.g.lme;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.compiler.Atom;
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
        Map<Atom, Atom> map = new HashMap<Atom, Atom>();
        map.put(new Atom<String>("marko"), new Atom<Integer>(2));
        map.put(new Atom<String>("josh"), new Atom<Integer>(1));
        map.put(new Atom<String>("peter"), new Atom<Integer>(3));
        Function<Object> function = new SortFunction();
        this.stopWatch();
        Map<Atom, Atom> sortedMap = (Map<Atom, Atom>) (function.compute(createUnaryArgs(map, "value", true))).getValue();
        printPerformance(function.getFunctionName() + " function", 3, "entry map (reverse by value)", this.stopWatch());
        assertEquals(map.get(new Atom<String>("marko")), new Atom<Integer>(2));
        assertEquals(map.get(new Atom<String>("josh")), new Atom<Integer>(1));
        assertEquals(map.get(new Atom<String>("peter")), new Atom<Integer>(3));

        List values = new ArrayList(sortedMap.values());
        assertEquals(values.get(0), new Atom<Integer>(3));
        assertEquals(values.get(1), new Atom<Integer>(2));
        assertEquals(values.get(2), new Atom<Integer>(1));

        this.stopWatch();
        sortedMap = (Map<Atom, Atom>) (function.compute(createUnaryArgs(map, "value", false))).getValue();
        printPerformance(function.getFunctionName() + " function", 3, "entry map (normal by value)", this.stopWatch());
        values = new ArrayList(sortedMap.values());
        assertEquals(values.get(0), new Atom<Integer>(1));
        assertEquals(values.get(1), new Atom<Integer>(2));
        assertEquals(values.get(2), new Atom<Integer>(3));

        this.stopWatch();
        sortedMap = (Map<Atom, Atom>) (function.compute(createUnaryArgs(map, "key", true))).getValue();
        printPerformance(function.getFunctionName() + " function", 3, "entry map (reverse by key)", this.stopWatch());
        List keys = new ArrayList(sortedMap.keySet());
        assertEquals(keys.get(0), new Atom<String>("peter"));
        assertEquals(keys.get(1), new Atom<String>("marko"));
        assertEquals(keys.get(2), new Atom<String>("josh"));

        this.stopWatch();
        sortedMap = (Map<Atom, Atom>) (function.compute(createUnaryArgs(map, "key", false))).getValue();
        printPerformance(function.getFunctionName() + " function", 3, "entry map (normal by key)", this.stopWatch());
        keys = new ArrayList(sortedMap.keySet());
        assertEquals(keys.get(0), new Atom<String>("josh"));
        assertEquals(keys.get(1), new Atom<String>("marko"));
        assertEquals(keys.get(2), new Atom<String>("peter"));

        assertEquals(map.get(new Atom<String>("marko")), new Atom<Integer>(2));
        assertEquals(map.get(new Atom<String>("josh")), new Atom<Integer>(1));
        assertEquals(map.get(new Atom<String>("peter")), new Atom<Integer>(3));
    }

    public void testSortFunctionList() {
        List<Atom<Integer>> list = new ArrayList<Atom<Integer>>();
        list.add(new Atom<Integer>(2));
        list.add(new Atom<Integer>(1));
        list.add(new Atom<Integer>(3));

        Function<Object> function = new SortFunction();
        this.stopWatch();
        List sortedList = (List<Atom>) (function.compute(createUnaryArgs(list, true))).getValue();
        printPerformance(function.getFunctionName() + " function", 3, "item list (reverse)", this.stopWatch());
        assertEquals(sortedList.get(0), new Atom<Integer>(3));
        assertEquals(sortedList.get(1), new Atom<Integer>(2));
        assertEquals(sortedList.get(2), new Atom<Integer>(1));

        this.stopWatch();
        sortedList = (List<Atom>) (function.compute(createUnaryArgs(list, false))).getValue();
        printPerformance(function.getFunctionName() + " function", 3, "item list (normal)", this.stopWatch());
        assertEquals(sortedList.get(0), new Atom<Integer>(1));
        assertEquals(sortedList.get(1), new Atom<Integer>(2));
        assertEquals(sortedList.get(2), new Atom<Integer>(3));

        assertEquals(list.get(0), new Atom<Integer>(2));
        assertEquals(list.get(1), new Atom<Integer>(1));
        assertEquals(list.get(2), new Atom<Integer>(3));
    }
}
