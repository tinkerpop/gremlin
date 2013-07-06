package com.tinkerpop.gremlin.test.transform;

import com.tinkerpop.blueprints.Vertex;
import junit.framework.TestCase;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class PathStepTest extends TestCase {

    public void testCompliance() {
        assertTrue(true);
    }

    public void test_g_v1_propertyXnameX_path(final Iterator<List> pipe) {
        List list = pipe.next();
        assertFalse(pipe.hasNext());
        assertEquals(list.size(), 2);
        assertEquals(((Vertex) list.get(0)).getProperty("name"), "marko");
        assertEquals(list.get(1), "marko");
    }

    public void test_g_v1_out_pathXage__nameX(final Iterator<List> pipe) {
        int counter = 0;
        Set<String> names = new HashSet<String>();
        while (pipe.hasNext()) {
            counter++;
            List list = pipe.next();
            assertEquals(list.get(0), 29);
            assertTrue(list.get(1).equals("josh") || list.get(1).equals("vadas") || list.get(1).equals("lop"));
            names.add((String) list.get(1));
        }
        assertEquals(counter, 3);
        assertEquals(names.size(), 3);
    }

    public void test_g_V_out_loopX1__loops_lt_3X_pathXit__name__langX(final Iterator<List> pipe) {
        int counter = 0;
        while (pipe.hasNext()) {
            counter++;
            List list = pipe.next();
            assertEquals(list.size(), 3);
            assertEquals(((Vertex) list.get(0)).getProperty("name"), "marko");
            assertEquals(list.get(1), "josh");
            assertEquals(list.get(2), "java");
        }
        assertEquals(counter, 2);
    }
}