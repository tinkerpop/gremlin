package com.tinkerpop.gremlin.test.transform;

import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.pipes.Pipe;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class OrderStepTest extends TestCase {

    public void testCompliance() {
        assertTrue(true);
    }

    public void test_g_V_name_order(final Iterator<String> pipe) {
        List<String> names = new ArrayList<String>();
        while (pipe.hasNext()) {
            names.add(pipe.next());
        }
        assertEquals(names.size(), 6);
        assertEquals(names.get(0), "josh");
        assertEquals(names.get(1), "lop");
        assertEquals(names.get(2), "marko");
        assertEquals(names.get(3), "peter");
        assertEquals(names.get(4), "ripple");
        assertEquals(names.get(5), "vadas");
    }

    public void test_g_V_name_orderXabX(final Iterator<String> pipe) {
        List<String> names = new ArrayList<String>();
        while (pipe.hasNext()) {
            names.add(pipe.next());
        }
        assertEquals(names.size(), 6);
        assertEquals(names.get(5), "josh");
        assertEquals(names.get(4), "lop");
        assertEquals(names.get(3), "marko");
        assertEquals(names.get(2), "peter");
        assertEquals(names.get(1), "ripple");
        assertEquals(names.get(0), "vadas");


    }

    public void test_g_V_orderXa_nameXb_nameX_name(final Pipe<Vertex, String> pipe) {
        List<String> names = new ArrayList<String>();
        while (pipe.hasNext()) {
            names.add(pipe.next());
        }
        assertEquals(names.size(), 6);
        assertEquals(names.get(5), "josh");
        assertEquals(names.get(4), "lop");
        assertEquals(names.get(3), "marko");
        assertEquals(names.get(2), "peter");
        assertEquals(names.get(1), "ripple");
        assertEquals(names.get(0), "vadas");


    }

    public void test_g_V_name_orderXdecrX(final Pipe<Vertex, String> pipe) {
        this.test_g_V_orderXa_nameXb_nameX_name(pipe);
    }

}
