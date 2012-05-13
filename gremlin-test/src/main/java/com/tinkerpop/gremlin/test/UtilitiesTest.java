package com.tinkerpop.gremlin.test;

import com.tinkerpop.blueprints.Vertex;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class UtilitiesTest extends TestCase {

    public void testCompliance() {
        assertTrue(true);
    }

    public void test_g_v1_out_toList(List<Vertex> vertices) {
        assertEquals(vertices.size(), 3);
        List<String> names = new ArrayList<String>();
        for (Vertex vertex : vertices) {
            names.add((String) vertex.getProperty("name"));
        }
        assertEquals(names.size(), 3);
        assertTrue(names.contains("josh"));
        assertTrue(names.contains("lop"));
        assertTrue(names.contains("vadas"));
    }

    public void test_g_v1_out_nextX1X(List<Vertex> vertices) {
        assertEquals(vertices.size(), 1);
        Vertex vertex = vertices.get(0);
        List<String> names = Arrays.asList("josh", "vadas", "lop");
        assertTrue(names.contains((String) vertex.getProperty("name")));
    }

    public void test_g_v1_out_fillXlistX(Collection<Vertex> list) {
        this.test_g_v1_out_toList(new ArrayList<Vertex>(list));
    }

    public void test_g_V_countXX(Long count) {
        assertEquals(count, new Long(6));
    }

    // test pipeline equality
}
