package com.tinkerpop.gremlin.test.transform;

import com.tinkerpop.blueprints.pgm.Vertex;
import com.tinkerpop.pipes.Pipe;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class TransformStepTest extends TestCase {

    public void testCompliance() {
        assertTrue(true);
    }

    public void test_g_v1_transformXnameX(final Pipe<Vertex, String> pipe) {
        assertEquals(pipe.next(), "marko");
        assertFalse(pipe.hasNext());
    }

    public void test_g_v1_outE_label_transformXlengthX(final Pipe<Vertex, Integer> pipe) {
        List<Integer> lengths = new ArrayList<Integer>();
        while (pipe.hasNext()) {
            lengths.add(pipe.next());
        }
        assertTrue(lengths.contains("created".length()));
        assertTrue(lengths.contains("knows".length()));
        assertEquals(lengths.size(), 3);
    }

    public void test_g_v1_out_transformXnameX_transformXlengthX(final Pipe<Vertex, Integer> pipe) {
        List<Integer> lengths = new ArrayList<Integer>();
        while (pipe.hasNext()) {
            lengths.add(pipe.next());
        }
        assertTrue(lengths.contains("josh".length()));
        assertTrue(lengths.contains("vadas".length()));
        assertTrue(lengths.contains("lop".length()));
        assertEquals(lengths.size(), 3);
    }

}
