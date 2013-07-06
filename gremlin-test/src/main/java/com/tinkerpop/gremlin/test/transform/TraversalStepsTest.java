package com.tinkerpop.gremlin.test.transform;

import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.pipes.Pipe;
import junit.framework.TestCase;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class TraversalStepsTest extends TestCase {

    public void testCompliance() {
        assertTrue(true);
    }

    // VERTEX ADJACENCY

    public void test_g_V(final Iterator<Vertex> pipe) {
        int counter = 0;
        Set<Vertex> vertices = new HashSet<Vertex>();
        while (pipe.hasNext()) {
            counter++;
            vertices.add(pipe.next());
        }
        assertEquals(vertices.size(), 6);
        assertEquals(counter, 6);
    }

    public void test_g_v1_out(final Iterator<Vertex> pipe) {
        int counter = 0;
        Set<Vertex> vertices = new HashSet<Vertex>();
        while (pipe.hasNext()) {
            counter++;
            Vertex vertex = pipe.next();
            vertices.add(vertex);
            assertTrue(vertex.getProperty("name").equals("vadas") ||
                    vertex.getProperty("name").equals("josh") ||
                    vertex.getProperty("name").equals("lop"));
        }
        assertEquals(counter, 3);
        assertEquals(vertices.size(), 3);
    }

    public void test_g_v2_in(final Iterator<Vertex> pipe) {
        int counter = 0;
        while (pipe.hasNext()) {
            counter++;
            assertEquals(pipe.next().getProperty("name"), "marko");
        }
        assertEquals(counter, 1);
    }

    public void test_g_v4_both(final Iterator<Vertex> pipe) {
        int counter = 0;
        Set<Vertex> vertices = new HashSet<Vertex>();
        while (pipe.hasNext()) {
            counter++;
            Vertex vertex = pipe.next();
            vertices.add(vertex);
            assertTrue(vertex.getProperty("name").equals("marko") ||
                    vertex.getProperty("name").equals("ripple") ||
                    vertex.getProperty("name").equals("lop"));
        }
        assertEquals(counter, 3);
        assertEquals(vertices.size(), 3);
    }

    public void test_g_v1_outX1_knowsX_name(final Iterator<String> pipe) {
        final String name = pipe.next();
        assertTrue(name.equals("vadas") || name.equals("josh"));
        assertFalse(pipe.hasNext());
    }

    public void test_g_V_bothX1_createdX_name(final Iterator<String> pipe) {
        int counter = 0;
        while (pipe.hasNext()) {
            counter++;
            final String name = pipe.next();
            assertTrue(name.equals("marko") || name.equals("lop") || name.equals("josh") || name.equals("ripple") || name.equals("peter"));
        }
        assertEquals(counter, 5);
    }

    // EDGE ADJACENCY

    public void test_g_E(final Iterator<Edge> pipe) {
        int counter = 0;
        Set<Edge> edges = new HashSet<Edge>();
        while (pipe.hasNext()) {
            counter++;
            edges.add(pipe.next());
        }
        assertEquals(edges.size(), 6);
        assertEquals(counter, 6);
    }

    public void test_g_v1_outE(final Iterator<Edge> pipe) {
        int counter = 0;
        Set<Edge> edges = new HashSet<Edge>();
        while (pipe.hasNext()) {
            counter++;
            Edge edge = pipe.next();
            edges.add(edge);
            assertTrue(edge.getLabel().equals("knows") || edge.getLabel().equals("created"));
        }
        assertEquals(counter, 3);
        assertEquals(edges.size(), 3);
    }

    public void test_g_v2_inE(final Iterator<Edge> pipe) {
        int counter = 0;
        while (pipe.hasNext()) {
            counter++;
            assertEquals(pipe.next().getLabel(), "knows");
        }
        assertEquals(counter, 1);
    }

    public void test_g_v4_bothE(final Iterator<Edge> pipe) {
        int counter = 0;
        Set<Edge> edges = new HashSet<Edge>();
        while (pipe.hasNext()) {
            counter++;
            Edge edge = pipe.next();
            edges.add(edge);
            assertTrue(edge.getLabel().equals("knows") || edge.getLabel().equals("created"));
        }
        assertEquals(counter, 3);
        assertEquals(edges.size(), 3);
    }

    public void test_g_v4_bothEX1_createdX(final Iterator<Edge> pipe) {
        final Edge edge = pipe.next();
        assertEquals(edge.getLabel(), "created");
        assertTrue(edge.getProperty("weight").equals(1.0f) || edge.getProperty("weight").equals(0.4f));
        assertFalse(pipe.hasNext());
    }

    public void test_g_V_inEX2_knowsX_outV_name(final Iterator<String> pipe) {
        int counter = 0;
        while (pipe.hasNext()) {
            counter++;
            assertEquals(pipe.next(), "marko");
        }
        assertFalse(pipe.hasNext());
        assertEquals(counter, 2);
    }

    // EDGE/VERTEX ADJACENCY

    public void test_g_v1_outE_inV(final Iterator<Vertex> pipe) {
        this.test_g_v1_out(pipe);
    }

    public void test_g_v2_inE_outV(final Pipe<Vertex, Vertex> pipe) {
        this.test_g_v2_in(pipe);
    }

    // VERTEX EDGE LABEL ADJACENCY

    public void test_g_v1_outXknowsX(final Pipe<Vertex, Vertex> pipe) {
        int counter = 0;
        Set<Vertex> vertices = new HashSet<Vertex>();
        while (pipe.hasNext()) {
            counter++;
            Vertex vertex = pipe.next();
            vertices.add(vertex);
            assertTrue(vertex.getProperty("name").equals("vadas") ||
                    vertex.getProperty("name").equals("josh"));
        }
        assertEquals(counter, 2);
        assertEquals(vertices.size(), 2);
    }

    public void test_g_v1_outXknows_createdX(final Pipe<Vertex, Vertex> pipe) {
        this.test_g_v1_out(pipe);
    }

    public void test_g_v1_outEXknowsX_inV(final Pipe<Vertex, Vertex> pipe) {
        this.test_g_v1_outXknowsX(pipe);
    }

    public void test_g_v1_outEXknows_createdX_inV(final Pipe<Vertex, Vertex> pipe) {
        this.test_g_v1_outE_inV(pipe);
    }

    public void test_g_V_out_out(final Pipe<Vertex, Vertex> pipe) {
        int counter = 0;
        Set<Vertex> vertices = new HashSet<Vertex>();
        while (pipe.hasNext()) {
            counter++;
            Vertex vertex = pipe.next();
            vertices.add(vertex);
            assertTrue(vertex.getProperty("name").equals("lop") ||
                    vertex.getProperty("name").equals("ripple"));
        }
        assertEquals(counter, 2);
        assertEquals(vertices.size(), 2);
    }

    public void test_g_v1_out_out_out(final Pipe<Vertex, Vertex> pipe) {
        assertFalse(pipe.hasNext());
    }

    // PROPERTY TESTING

    public void test_g_v1_out_propertyXnameX(final Pipe<Vertex, Object> pipe) {
        int counter = 0;
        Set<String> names = new HashSet<String>();
        while (pipe.hasNext()) {
            counter++;
            String name = (String) pipe.next();
            names.add(name);
            assertTrue(name.equals("vadas") ||
                    name.equals("josh") ||
                    name.equals("lop"));
        }
        assertEquals(counter, 3);
        assertEquals(names.size(), 3);
    }
}
