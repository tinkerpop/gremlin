package com.tinkerpop.gremlin.test.sideeffect;

import com.tinkerpop.blueprints.Vertex;
import junit.framework.TestCase;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class GroupByStepTest extends TestCase {

    public void testCompliance() {
        assertTrue(true);
    }

    public void test_g_V_groupByXlang_nameX(Iterator<Vertex> pipe, Map<String, List<String>> m) {
        int counter = 0;
        while (pipe.hasNext()) {
            pipe.next();
            counter++;
        }
        assertEquals(counter, 6);
        assertEquals(m.size(), 2);
        assertTrue(m.containsKey("java"));
        assertTrue(m.containsKey(null));
        assertEquals(m.get("java").size(), 2);
        assertTrue(m.get("java").contains("ripple"));
        assertTrue(m.get("java").contains("lop"));
        assertEquals(m.get(null).size(), 4);
        assertTrue(m.get(null).contains("marko"));
        assertTrue(m.get(null).contains("josh"));
        assertTrue(m.get(null).contains("peter"));
        assertTrue(m.get(null).contains("vadas"));

    }
}