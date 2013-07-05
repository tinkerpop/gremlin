package com.tinkerpop.gremlin.test.transform;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class TransformStepTest extends TestCase {

    public void testCompliance() {
        assertTrue(true);
    }

    public void test_g_v1_transformXnameX(final Iterator<String> pipe) {
        assertEquals(pipe.next(), "marko");
        assertFalse(pipe.hasNext());
    }

    public void test_g_v1_outE_label_transformXlengthX(final Iterator<Integer> pipe) {
        List<Integer> lengths = new ArrayList<Integer>();
        while (pipe.hasNext()) {
            lengths.add(pipe.next());
        }
        assertTrue(lengths.contains("created".length()));
        assertTrue(lengths.contains("knows".length()));
        assertEquals(lengths.size(), 3);
    }

    public void test_g_v1_out_transformXnameX_transformXlengthX(final Iterator<Integer> pipe) {
        List<Integer> lengths = new ArrayList<Integer>();
        while (pipe.hasNext()) {
            lengths.add(pipe.next());
        }
        assertTrue(lengths.contains("josh".length()));
        assertTrue(lengths.contains("vadas".length()));
        assertTrue(lengths.contains("lop".length()));
        assertEquals(lengths.size(), 3);
    }

    public void test_g_V_asXaX_out_transformXa_nameX(final Iterator<String> pipe) {
        int marko = 0;
        int peter = 0;
        int josh = 0;
        int other = 0;
        while (pipe.hasNext()) {
            String name = pipe.next();
            if (name.equals("marko")) marko++;
            else if (name.equals("peter")) peter++;
            else if (name.equals("josh")) josh++;
            else other++;
        }
        assertEquals(marko, 3);
        assertEquals(josh, 2);
        assertEquals(peter, 1);
        assertEquals(other, 0);
    }
}
