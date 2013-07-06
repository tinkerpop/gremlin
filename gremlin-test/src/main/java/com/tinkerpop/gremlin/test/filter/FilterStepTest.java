package com.tinkerpop.gremlin.test.filter;

import com.tinkerpop.blueprints.Vertex;
import junit.framework.TestCase;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class FilterStepTest extends TestCase {

    public void testCompliance() {
        assertTrue(true);
    }

    public void test_g_V_filterXfalseX(Iterator<Vertex> pipe) {
        assertFalse(pipe.hasNext());
    }

    public void test_g_V_filterXtrueX(Iterator<Vertex> pipe) {
        int counter = 0;
        Set<Vertex> vertices = new HashSet<Vertex>();
        while (pipe.hasNext()) {
            counter++;
            vertices.add(pipe.next());
        }
        assertEquals(counter, 6);
        assertEquals(vertices.size(), 6);
    }

    public void test_g_V_filterXlang_eq_javaX(Iterator<Vertex> pipe) {
        int counter = 0;
        Set<Vertex> vertices = new HashSet<Vertex>();
        while (pipe.hasNext()) {
            counter++;
            Vertex vertex = pipe.next();
            vertices.add(vertex);
            assertTrue(vertex.getProperty("name").equals("ripple") ||
                    vertex.getProperty("name").equals("lop"));
        }
        assertEquals(counter, 2);
        assertEquals(vertices.size(), 2);
    }

    public void test_g_v1_out_filterXage_gt_30X(Iterator<Vertex> pipe) {
        assertEquals(pipe.next().getProperty("age"), 32);
        assertFalse(pipe.hasNext());
    }

    public void test_g_V_filterXname_startsWith_m_OR_name_startsWith_pX(Iterator<Vertex> pipe) {
        int counter = 0;
        Set<Vertex> vertices = new HashSet<Vertex>();
        while (pipe.hasNext()) {
            counter++;
            Vertex vertex = pipe.next();
            vertices.add(vertex);
            assertTrue(vertex.getProperty("name").equals("marko") ||
                    vertex.getProperty("name").equals("peter"));
        }
        assertEquals(counter, 2);
        assertEquals(vertices.size(), 2);
    }


}
