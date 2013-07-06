package com.tinkerpop.gremlin.test.sideeffect;

import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.pipes.util.structures.Table;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class TableStepTest extends TestCase {

    public void testCompliance() {
        assertTrue(true);
    }

    public void test_g_v1_asXaX_out_properyXnameX_asXbX_table_cap(final Iterator<Table> pipe) {
        Table t = pipe.next();
        assertFalse(pipe.hasNext());
        assertEquals(((Vertex) t.get(0, "a")).getProperty("name"), "marko");
        assertEquals(((Vertex) t.get(1, "a")).getProperty("name"), "marko");
        assertEquals(((Vertex) t.get(2, "a")).getProperty("name"), "marko");
        List<String> names = new ArrayList<String>();
        names.add((String) t.get(0, "b"));
        names.add((String) t.get(1, "b"));
        names.add((String) t.get(2, "b"));
        assertTrue(names.contains("josh"));
        assertTrue(names.contains("lop"));
        assertTrue(names.contains("vadas"));
        assertEquals(names.size(), 3);
        assertEquals(t.getColumnCount(), 2);
        assertEquals(t.getRowCount(), 3);
    }

    public void test_g_v1_asXaX_out_asXbX_tableXnameX_cap(final Iterator<Table> pipe) {
        Table t = pipe.next();
        assertFalse(pipe.hasNext());
        assertEquals(((String) t.get(0, "a")), "marko");
        assertEquals(((String) t.get(1, "a")), "marko");
        assertEquals(((String) t.get(2, "a")), "marko");
        List<String> names = new ArrayList<String>();
        names.add((String) t.get(0, "b"));
        names.add((String) t.get(1, "b"));
        names.add((String) t.get(2, "b"));
        assertTrue(names.contains("josh"));
        assertTrue(names.contains("lop"));
        assertTrue(names.contains("vadas"));
        assertEquals(names.size(), 3);
        assertEquals(t.getColumnCount(), 2);
        assertEquals(t.getRowCount(), 3);
    }

    public void test_g_v1_asXaX_out_propertyXnameX_asXbX_tableXname_lengthX_cap(final Iterator<Table> pipe) {
        Table t = pipe.next();
        assertFalse(pipe.hasNext());
        assertEquals(((String) t.get(0, "a")), "marko");
        assertEquals(((String) t.get(1, "a")), "marko");
        assertEquals(((String) t.get(2, "a")), "marko");
        List<Integer> lengths = new ArrayList<Integer>();
        lengths.add((Integer) t.get(0, "b"));
        lengths.add((Integer) t.get(1, "b"));
        lengths.add((Integer) t.get(2, "b"));
        assertTrue(lengths.contains(4));
        assertTrue(lengths.contains(3));
        assertTrue(lengths.contains(5));
        assertEquals(lengths.size(), 3);
        assertEquals(t.getColumnCount(), 2);
        assertEquals(t.getRowCount(), 3);
    }
}