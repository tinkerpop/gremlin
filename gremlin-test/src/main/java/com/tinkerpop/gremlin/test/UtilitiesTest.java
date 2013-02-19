package com.tinkerpop.gremlin.test;

import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.pipes.Pipe;
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

    public void test_g_E_remove(Graph graph) {
        int count = 0;
        for (Edge e : graph.getEdges()) {
            count++;
        }
        assertEquals(count, 0);
        for (Vertex v : graph.getVertices()) {
            count++;
        }
        assertEquals(count, 6);
    }

    public void test_g_V_hasXidX1X_name_equals_g_v1_name(Pipe pipe1, Pipe pipe2) {
        assertTrue(pipe1.equals(pipe2));
    }
}
