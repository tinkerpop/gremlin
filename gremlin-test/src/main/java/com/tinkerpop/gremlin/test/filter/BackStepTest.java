package com.tinkerpop.gremlin.test.filter;

import com.tinkerpop.blueprints.pgm.Vertex;
import com.tinkerpop.pipes.Pipe;
import junit.framework.TestCase;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class BackStepTest extends TestCase {

    public void testCompliance() {
        assertTrue(true);
    }

    public void test_g_v1_out_backX1X(Pipe<Vertex, Vertex> pipe) {
        int counter = 0;
        while (pipe.hasNext()) {
            counter++;
            assertEquals(pipe.next().getProperty("name"), "marko");
        }
        assertEquals(counter, 1);
    }

    public void test_g_v1_asXhereX_out_backXhereX(Pipe<Vertex, Vertex> pipe) {
        this.test_g_v1_out_backX1X(pipe);
    }

    public void test_g_v4_out_filterXlang_eq_javaX_backX1X(Pipe<Vertex, Vertex> pipe) {
        int counter = 0;
        while (pipe.hasNext()) {
            counter++;
            Vertex vertex = pipe.next();
            assertEquals(vertex.getProperty("lang"), "java");
            assertTrue(vertex.getProperty("name").equals("ripple") || vertex.getProperty("name").equals("lop"));
        }
        assertEquals(counter, 2);
    }

    public void test_g_v4_out_asXhereX_filterXlang_eq_javaX_backXhereX(Pipe<Vertex, Vertex> pipe) {
        this.test_g_v4_out_filterXlang_eq_javaX_backX1X(pipe);
    }

    public void test_g_v4_out_asXhereX_filterXlang_eq_javaX_backXhereX_propertyXnameX(Pipe<Vertex, String> pipe) {
        int counter = 0;
        Set<String> names = new HashSet<String>();
        while (pipe.hasNext()) {
            counter++;
            names.add(pipe.next());
        }
        assertEquals(counter, 2);
        assertEquals(names.size(), 2);
        assertTrue(names.contains("ripple"));
        assertTrue(names.contains("lop"));
    }

}
