package com.tinkerpop.gremlin.test.sideeffect;

import com.tinkerpop.blueprints.Vertex;
import junit.framework.TestCase;

import java.util.Iterator;
import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class GroupCountStepTest extends TestCase {

    public void testCompliance() {
        assertTrue(true);
    }

    public void test_g_V_outXcreatedX_groupCountXm__nameX(Iterator<Vertex> pipe, Map<String, Number> m) {
        int counter = 0;
        while (pipe.hasNext()) {
            Vertex vertex = pipe.next();
            counter++;
            assertTrue(vertex.getProperty("name").equals("lop") || vertex.getProperty("name").equals("ripple"));
        }
        assertEquals(counter, 4);
        assertEquals(m.size(), 2);
        assertEquals(m.get("lop"), 3l);
        assertEquals(m.get("ripple"), 1l);
    }

    public void test_g_V_outXcreatedX_groupCountXm__name__plus_2X(Iterator<Vertex> pipe, Map<String, Number> m) {
        int counter = 0;
        while (pipe.hasNext()) {
            Vertex vertex = pipe.next();
            counter++;
            assertTrue(vertex.getProperty("name").equals("lop") || vertex.getProperty("name").equals("ripple"));
        }
        assertEquals(counter, 4);
        assertEquals(m.size(), 2);
        assertEquals(m.get("lop"), 6l);
        assertEquals(m.get("ripple"), 2l);
    }

    public void test_g_V_outXcreatedX_groupCountXnameX_cap(Iterator<Map<String, Number>> pipe) {
        Map m = pipe.next();
        assertFalse(pipe.hasNext());
        assertEquals(m.size(), 2);
        assertEquals(m.get("lop"), 3l);
        assertEquals(m.get("ripple"), 1l);
    }
}