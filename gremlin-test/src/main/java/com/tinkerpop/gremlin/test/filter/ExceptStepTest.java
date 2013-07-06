package com.tinkerpop.gremlin.test.filter;

import com.tinkerpop.blueprints.Vertex;
import junit.framework.TestCase;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class ExceptStepTest extends TestCase {

    public void testCompliance() {
        assertTrue(true);
    }

    public void test_g_v1_out_exceptXg_v2X(Iterator<Vertex> pipe) {
        int counter = 0;
        Set<Vertex> vertices = new HashSet<Vertex>();
        while (pipe.hasNext()) {
            counter++;
            Vertex vertex = pipe.next();
            vertices.add(vertex);
            assertTrue(vertex.getProperty("name").equals("josh") || vertex.getProperty("name").equals("lop"));
        }
        assertEquals(counter, 2);
        assertEquals(vertices.size(), 2);
    }

    public void test_g_v1_out_aggregateXxX_out_exceptXxX(Iterator<Vertex> pipe) {
        assertEquals(pipe.next().getProperty("name"), "ripple");
        assertFalse(pipe.hasNext());
    }

    public void test_g_v1_outXcreatedX_inXcreatedX_exceptXg_v1X_propertyXnameX(Iterator<String> pipe) {
        List<String> names = Arrays.asList(pipe.next(), pipe.next());
        assertFalse(pipe.hasNext());
        assertEquals(names.size(), 2);
        assertTrue(names.contains("peter"));
        assertTrue(names.contains("josh"));
    }
}