package com.tinkerpop.gremlin.test;

import com.tinkerpop.blueprints.pgm.Vertex;
import com.tinkerpop.pipes.Pipe;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class FunctionStepTest extends TestCase {

    public void testCompliance() {
        assertTrue(true);
    }

    public void test_g_v1_out_stepXnext_nameX(Pipe<Vertex, String> pipe) {
        List<String> names = new ArrayList<String>();
        while (pipe.hasNext()) {
            names.add(pipe.next());
        }
        assertEquals(names.size(), 3);
        assertTrue(names.contains("josh"));
        assertTrue(names.contains("vadas"));
        assertTrue(names.contains("lop"));
    }
}