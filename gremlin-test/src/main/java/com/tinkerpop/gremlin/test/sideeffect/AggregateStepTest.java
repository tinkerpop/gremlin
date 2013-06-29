package com.tinkerpop.gremlin.test.sideeffect;

import com.tinkerpop.blueprints.Vertex;
import junit.framework.TestCase;

import java.util.Iterator;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class AggregateStepTest extends TestCase {

    public void testCompliance() {
        assertTrue(true);
    }

    public void test_g_v1_aggregateXxX_outXcreatedX_inXcreatedX_exceptXxX(final Iterator<Vertex> pipe) {
        int counter = 0;
        while (pipe.hasNext()) {
            counter++;
            Vertex vertex = pipe.next();
            assertTrue(vertex.getProperty("name").equals("peter") || vertex.getProperty("name").equals("josh"));
        }
        assertEquals(counter, 2);
    }

    public void test_g_V_propertyXnameX_aggregate_cap(final Iterator<List<String>> pipe) {
        List<String> names = pipe.next();
        assertFalse(pipe.hasNext());
        assertEquals(names.size(), 6);
        assertTrue(names.contains("marko"));
        assertTrue(names.contains("josh"));
        assertTrue(names.contains("peter"));
        assertTrue(names.contains("lop"));
        assertTrue(names.contains("vadas"));
        assertTrue(names.contains("ripple"));
    }

    public void test_g_V_aggregateXnameX_cap(final Iterator<List<String>> pipe) {
        this.test_g_V_propertyXnameX_aggregate_cap(pipe);
    }
}