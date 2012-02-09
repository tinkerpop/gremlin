package com.tinkerpop.gremlin.test.filter;

import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.Vertex;
import com.tinkerpop.pipes.Pipe;
import junit.framework.TestCase;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class HasNotStepTest extends TestCase {

    public void testCompliance() {
        assertTrue(true);
    }

    public void test_g_V_hasNotXname_markoX(Pipe<Graph, Vertex> pipe) {
        int counter = 0;
        while (pipe.hasNext()) {
            counter++;
            assertNotSame(pipe.next().getProperty("name"), "marko");
        }
        assertEquals(counter, 5);
    }

    public void test_g_V_hasNotXname_blahX(Pipe<Graph, Vertex> pipe) {
        int counter = 0;
        while (pipe.hasNext()) {
            counter++;
            pipe.next();
        }
        assertEquals(counter, 6);
    }

    public void test_g_V_hasNotXblah_nullX(Pipe<Graph, Vertex> pipe) {
        assertFalse(pipe.hasNext());
    }

}