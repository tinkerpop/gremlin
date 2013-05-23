package com.tinkerpop.gremlin.test.filter;

import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.pipes.Pipe;
import com.tinkerpop.pipes.util.PipeHelper;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class HasNotStepTest extends TestCase {

    public void testCompliance() {
        assertTrue(true);
    }

    public void test_g_V_hasNotXname_markoX(Pipe<Vertex, Vertex> pipe) {
        int counter = 0;
        while (pipe.hasNext()) {
            counter++;
            assertNotSame(pipe.next().getProperty("name"), "marko");
        }
        assertEquals(counter, 5);
    }

    public void test_g_V_hasNotXage_gt_32X(Pipe<Vertex, Vertex> pipe) {
        List<Vertex> list = new ArrayList<Vertex>();
        PipeHelper.fillCollection(pipe, list);
        assertEquals(list.size(), 3);
        for (Vertex v : list) {
            assertTrue((Integer) v.getProperty("age") <= 32);
        }
    }

    public void test_g_V_hasNotXname_blahX(Pipe<Vertex, Vertex> pipe) {
        int counter = 0;
        while (pipe.hasNext()) {
            counter++;
            pipe.next();
        }
        assertEquals(counter, 6);
    }

    public void test_g_V_hasNotXblahX(Pipe<Vertex, Vertex> pipe) {
        int counter = 0;
        while (pipe.hasNext()) {
            pipe.next();
            counter++;
        }
        assertEquals(counter, 6);
    }


}