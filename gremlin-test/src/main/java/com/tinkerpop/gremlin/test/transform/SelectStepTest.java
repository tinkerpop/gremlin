package com.tinkerpop.gremlin.test.transform;

import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.pipes.util.structures.Row;
import junit.framework.TestCase;

import java.util.Iterator;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class SelectStepTest extends TestCase {

    public void testCompliance() {
        assertTrue(true);
    }

    public void test_g_v1_asXaX_outXknowsX_asXbX_select(final Iterator<Row> pipe) {
        int counter = 0;
        while (pipe.hasNext()) {
            counter++;
            List list = pipe.next();
            assertEquals(list.size(), 2);
            assertEquals(((Vertex) list.get(0)).getId().toString(), "1");
            assertTrue(((Vertex) list.get(1)).getId().toString().equals("2") || ((Vertex) list.get(1)).getId().toString().equals("4"));
        }
        assertEquals(counter, 2);
    }

    public void test_g_v1_asXaX_outXknowsX_asXbX_selectXnameX(final Iterator<Row> pipe) {
        int counter = 0;
        while (pipe.hasNext()) {
            counter++;
            Row list = pipe.next();
            assertEquals(list.size(), 2);
            assertEquals(list.get(0).toString(), "marko");
            assertTrue(list.get(1).toString().equals("josh") || list.get(1).toString().equals("vadas"));
            assertTrue(list.getColumn("b").toString().equals("josh") || list.getColumn("b").toString().equals("vadas"));
        }
        assertEquals(counter, 2);
    }

    public void test_g_v1_asXaX_outXknowsX_asXbX_selectXaX(final Iterator<Row> pipe) {
        int counter = 0;
        while (pipe.hasNext()) {
            counter++;
            Row list = pipe.next();
            assertEquals(list.size(), 1);
            assertEquals(((Vertex) list.get(0)).getId().toString(), "1");
            assertEquals(((Vertex) list.getColumn("a")).getId().toString(), "1");
        }
        assertEquals(counter, 2);
    }

    public void test_g_v1_asXaX_outXknowsX_asXbX_selectXa_nameX(final Iterator<Row> pipe) {
        int counter = 0;
        while (pipe.hasNext()) {
            counter++;
            Row list = pipe.next();
            assertEquals(list.size(), 1);
            assertEquals(list.get(0).toString(), "marko");
            assertEquals(list.getColumn("a"), "marko");
        }
        assertEquals(counter, 2);
    }
}