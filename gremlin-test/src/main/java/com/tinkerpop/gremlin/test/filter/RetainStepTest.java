package com.tinkerpop.gremlin.test.filter;

import com.tinkerpop.blueprints.Vertex;
import junit.framework.TestCase;

import java.util.Iterator;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class RetainStepTest extends TestCase {

    public void testCompliance() {
        assertTrue(true);
    }

    public void test_g_v1_out_retainXg_v2X(Iterator<Vertex> pipe) {
        assertEquals(pipe.next().getProperty("name"), "vadas");
        assertFalse(pipe.hasNext());
    }

    public void test_g_v1_out_aggregateXxX_out_retainXxX(Iterator<Vertex> pipe) {
        assertEquals(pipe.next().getProperty("name"), "lop");
        assertFalse(pipe.hasNext());
    }
}