package com.tinkerpop.gremlin.test.filter;

import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.pipes.Pipe;
import junit.framework.TestCase;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class RangeStepTest extends TestCase {

    public void testCompliance() {
        assertTrue(true);
    }

    public void test_g_v1_out_rangeX0_1X(Pipe<Vertex, Vertex> pipe) {
        int counter = 0;
        while (pipe.hasNext()) {
            counter++;
            pipe.next();
        }
        assertEquals(counter, 2);
    }

    public void test_g_v1_outXknowsX_outEXcreatedX_rangeX0_0X_inV(Pipe<Vertex, Vertex> pipe) {
        int counter = 0;
        while (pipe.hasNext()) {
            counter++;
            String name = (String) pipe.next().getProperty("name");
            assertTrue(name.equals("lop") || name.equals("ripple"));
        }
        assertEquals(counter, 1);
    }

    public void test_g_v1_outXknowsX_outXcreatedX_rangeX0_0X(Pipe<Vertex, Vertex> pipe) {
        this.test_g_v1_outXknowsX_outEXcreatedX_rangeX0_0X_inV(pipe);
    }
}