package com.tinkerpop.gremlin.test.transform;

import com.tinkerpop.blueprints.pgm.Vertex;
import com.tinkerpop.pipes.Pipe;
import junit.framework.TestCase;

import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class MapStepTest extends TestCase {

    public void testCompliance() {
        assertTrue(true);
    }

    public void test_g_v1_map(final Pipe<Vertex, Map> pipe) {
        Map map = pipe.next();
        assertFalse(pipe.hasNext());
        assertEquals(map.get("name"), "marko");
        assertEquals(map.get("age"), 29);
        assertEquals(map.size(), 2);
    }

    public void test_g_v1_outXknowsX_map(final Pipe<Vertex, Map> pipe) {
        int counter = 0;
        while (pipe.hasNext()) {
            Map map = pipe.next();
            if (map.get("name").equals("vadas")) {
                assertEquals(map.get("age"), 27);
            } else if (map.get("name").equals("josh")) {
                assertEquals(map.get("age"), 32);
            } else {
                assertFalse(true);
            }
            counter++;
        }
        assertEquals(counter, 2);
    }
}