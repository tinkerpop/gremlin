package com.tinkerpop.gremlin.test.branch;

import com.tinkerpop.blueprints.pgm.Vertex;
import com.tinkerpop.pipes.Pipe;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class SplitMergeStepsTest extends TestCase {

    public void testCompliance() {
        assertTrue(true);
    }

    public void test_g_v1_out_copySplitXpropertyXnameX__propertyXageXX_fairMerge(Pipe<Vertex, Object> pipe) {
        while (pipe.hasNext()) {
            String name = (String) pipe.next();
            if (name.equals("vadas")) {
                assertEquals(pipe.next(), 27);
            } else if (name.equals("josh")) {
                assertEquals(pipe.next(), 32);
            } else if (name.equals("lop")) {
                assertNull(pipe.next());
            } else {
                assertFalse(true);
            }
        }
    }

    public void test_g_v1_outXknowsX_copySplitXpropertyXnameX__propertyXageXX_exhaustMerge(Pipe<Vertex, Object> pipe) {
        List<String> names = new ArrayList<String>();
        names.add((String) pipe.next());
        names.add((String) pipe.next());
        List<Integer> ages = new ArrayList<Integer>();
        ages.add((Integer) pipe.next());
        ages.add((Integer) pipe.next());

        assertFalse(pipe.hasNext());
        assertTrue(names.contains("josh"));
        assertTrue(names.contains("vadas"));
        assertTrue(ages.contains(27));
        assertTrue(ages.contains(32));
    }
}
