package com.tinkerpop.gremlin.test.filter;

import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.pipes.util.PipeHelper;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class HasStepTest extends TestCase {

    public void testCompliance() {
        assertTrue(true);
    }

    public void test_g_V_hasXname_markoX(Iterator<Vertex> pipe) {
        assertEquals(pipe.next().getProperty("name"), "marko");
        assertFalse(pipe.hasNext());
    }

    public void test_g_V_hasXname_blahX(Iterator<Vertex> pipe) {
        assertFalse(pipe.hasNext());
    }

    public void test_g_V_hasXage_gt_30X(Iterator<Vertex> pipe) {
        List<Vertex> list = new ArrayList<Vertex>();
        PipeHelper.fillCollection(pipe, list);
        assertEquals(list.size(), 2);
        for (Vertex v : list) {
            assertTrue((Integer) v.getProperty("age") > 30);
        }
    }

    public void test_g_v1_out_hasXid_2X(Iterator<Vertex> pipe) {
        assertTrue(pipe.hasNext());
        assertEquals(pipe.next().getId().toString(), "2");
    }

    public void test_g_V_hasXblahX(Iterator<Vertex> pipe) {
        assertFalse(pipe.hasNext());
    }

    public void test_g_E_hasXlabelXknowsX(Iterator<Edge> pipe) {
        int counter = 0;
        while (pipe.hasNext()) {
            counter++;
            assertEquals(pipe.next().getLabel(), "knows");
        }
        assertEquals(counter, 2);
    }

    public void test_g_E_hasXlabelXknows_createdX(Iterator<Edge> pipe) {
        int counter = 0;
        while (pipe.hasNext()) {
            counter++;
            String label = pipe.next().getLabel();
            assertTrue(label.equals("knows") || label.equals("created"));
        }
        assertEquals(counter, 6);
    }

}