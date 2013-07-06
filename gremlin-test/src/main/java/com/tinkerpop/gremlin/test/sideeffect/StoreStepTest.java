package com.tinkerpop.gremlin.test.sideeffect;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class StoreStepTest extends TestCase {

    public void testCompliance() {
        assertTrue(true);
    }


    public void test_g_V_propertyXnameX_store_cap(final Iterator<List<String>> pipe) {
        List<String> names = new ArrayList<String>();
        while (pipe.hasNext())
            names = pipe.next();

        assertFalse(pipe.hasNext());
        assertEquals(names.size(), 6);
        assertTrue(names.contains("marko"));
        assertTrue(names.contains("josh"));
        assertTrue(names.contains("peter"));
        assertTrue(names.contains("lop"));
        assertTrue(names.contains("vadas"));
        assertTrue(names.contains("ripple"));
    }

    public void test_g_V_storeXnameX_cap(final Iterator<List<String>> pipe) {
        this.test_g_V_propertyXnameX_store_cap(pipe);
    }
}