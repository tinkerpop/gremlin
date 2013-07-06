package com.tinkerpop.gremlin.test.branch;

import com.tinkerpop.blueprints.Vertex;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class SplitMergeStepsTest extends TestCase {

    public void testCompliance() {
        assertTrue(true);
    }

    public void test_g_v1_out_copySplitXpropertyXnameX__propertyXageXX_fairMerge(Iterator<Object> pipe) {
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

    public void test_g_v1_outXknowsX_copySplitXpropertyXnameX__propertyXageXX_exhaustMerge(Iterator<Object> pipe) {
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

    public void test_g_v1_outXknowsX_copySplitXpropertyXnameX__propertyXageXX_exhaustMerge_path(Iterator<List> pipe) {
        List<List> names = new ArrayList<List>();
        names.add(pipe.next());
        names.add(pipe.next());
        List<List> ages = new ArrayList<List>();
        ages.add(pipe.next());
        ages.add(pipe.next());

        assertFalse(pipe.hasNext());
        assertEquals(names.size(), 2);
        assertEquals(ages.size(), 2);
        assertEquals(names.get(0).size(), 3);
        assertEquals(ages.get(0).size(), 3);
        assertEquals(((Vertex) (names.get(0)).get(0)).getId(), "1");
        assertEquals(((Vertex) (ages.get(0)).get(0)).getId(), "1");
        assertEquals(((Vertex) (names.get(1)).get(0)).getId(), "1");
        assertEquals(((Vertex) (ages.get(1)).get(0)).getId(), "1");

        assertEquals(((Vertex) (names.get(0)).get(1)).getId(), "2");
        assertEquals(((Vertex) (ages.get(0)).get(1)).getId(), "2");
        assertEquals(((Vertex) (names.get(1)).get(1)).getId(), "4");
        assertEquals(((Vertex) (ages.get(1)).get(1)).getId(), "4");

        assertEquals(names.get(0).get(2), "vadas");
        assertEquals(ages.get(0).get(2), 27);
        assertEquals(names.get(1).get(2), "josh");
        assertEquals(ages.get(1).get(2), 32);

    }
}
