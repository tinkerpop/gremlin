package com.tinkerpop.gremlin.test.filter;

import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.Vertex;
import com.tinkerpop.pipes.Pipe;
import junit.framework.TestCase;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class HasStepTest extends TestCase {

    public void testCompliance() {
        assertTrue(true);
    }

    public void test_g_V_hasXname_markoX(Pipe<Graph, Vertex> pipe) {
        assertEquals(pipe.next().getProperty("name"), "marko");
        assertFalse(pipe.hasNext());
    }

    public void test_g_V_hasXname_blahX(Pipe<Graph, Vertex> pipe) {
        assertFalse(pipe.hasNext());
    }

    public void test_g_V_hasXblah_nullX(Pipe<Graph, Vertex> pipe) {
        int counter = 0;
        while (pipe.hasNext()) {
            pipe.next();
            counter++;
        }
        assertEquals(counter, 6);
    }

}