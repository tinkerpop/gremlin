package com.tinkerpop.gremlin.test.filter;

import com.tinkerpop.blueprints.Vertex;
import junit.framework.TestCase;

import java.util.Iterator;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class IntervalStepTest extends TestCase {

    public void testCompliance() {
        assertTrue(true);
    }

    public void test_g_v1_outE_intervalXweight_0_06X_inV(Iterator<Vertex> pipe) {
        while (pipe.hasNext()) {
            Vertex vertex = pipe.next();
            assertTrue(vertex.getProperty("name").equals("vadas") || vertex.getProperty("name").equals("lop"));
        }
        assertFalse(pipe.hasNext());
    }
}