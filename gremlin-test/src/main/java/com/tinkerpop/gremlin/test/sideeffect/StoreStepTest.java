package com.tinkerpop.gremlin.test.sideeffect;

import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.pipes.Pipe;
import junit.framework.TestCase;

import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class StoreStepTest extends TestCase {

    public void testCompliance() {
        assertTrue(true);
    }


    public void test_g_V_propertyXnameX_store_cap(final Pipe<Graph, List<String>> pipe) {
        List<String> names = pipe.next();
        assertFalse(pipe.hasNext());
        assertEquals(names.size(), 6);
        assertTrue(names.contains("marko"));
        assertTrue(names.contains("josh"));
        assertTrue(names.contains("peter"));
        assertTrue(names.contains("lop"));
        assertTrue(names.contains("vadas"));
        assertTrue(names.contains("ripple"));
    }

    public void test_g_V_storeXnameX_cap(final Pipe<Graph, List<String>> pipe) {
        this.test_g_V_propertyXnameX_store_cap(pipe);
    }
}