package com.tinkerpop.gremlin;

import com.tinkerpop.blueprints.pgm.Vertex;
import com.tinkerpop.pipes.Pipe;
import junit.framework.TestCase;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class TraversalStepTest extends TestCase {

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
}
