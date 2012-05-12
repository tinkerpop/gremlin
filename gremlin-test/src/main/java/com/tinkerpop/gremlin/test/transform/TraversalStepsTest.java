package com.tinkerpop.gremlin.test.transform;

import com.tinkerpop.blueprints.pgm.Edge;
import com.tinkerpop.blueprints.pgm.Vertex;
import com.tinkerpop.pipes.Pipe;
import junit.framework.TestCase;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class TraversalStepsTest extends TestCase {

    public void testCompliance() {
        assertTrue(true);
    }

    // VERTEX ADJACENCY

    public void test_g_V(final Pipe<Vertex, Vertex> pipe) {
        int counter = 0;
        Set<Vertex> vertices = new HashSet<Vertex>();
        while (pipe.hasNext()) {
            counter++;
            vertices.add(pipe.next());
        }
        assertEquals(vertices.size(), 6);
        assertEquals(counter, 6);
    }

    public void test_g_v1_out(final Pipe<Vertex, Vertex> pipe) {
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

    public void test_g_v2_in(final Pipe<Vertex, Vertex> pipe) {
        int counter = 0;
        while (pipe.hasNext()) {
            counter++;
            assertEquals(pipe.next().getProperty("name"), "marko");
        }
        assertEquals(counter, 1);
    }

    public void test_g_v4_both(final Pipe<Vertex, Vertex> pipe) {
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

    // EDGE ADJACENCY

    public void test_g_E(final Pipe<Edge, Edge> pipe) {
        int counter = 0;
        Set<Edge> edges = new HashSet<Edge>();
        while (pipe.hasNext()) {
            counter++;
            edges.add(pipe.next());
        }
        assertEquals(edges.size(), 6);
        assertEquals(counter, 6);
    }

    public void test_g_v1_outE(final Pipe<Vertex, Edge> pipe) {
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

    public void test_g_v2_inE(final Pipe<Vertex, Edge> pipe) {
        int counter = 0;
        while (pipe.hasNext()) {
            counter++;
            assertEquals(pipe.next().getLabel(), "knows");
        }
        assertEquals(counter, 1);
    }

    public void test_g_v4_bothE(final Pipe<Vertex, Edge> pipe) {
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

    // EDGE/VERTEX ADJACENCY

    public void test_g_v1_outE_inV(final Pipe<Vertex, Vertex> pipe) {
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
