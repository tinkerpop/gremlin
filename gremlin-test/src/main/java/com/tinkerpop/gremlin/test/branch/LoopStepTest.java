package com.tinkerpop.gremlin.test.branch;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class LoopStepTest extends TestCase {

    public void testCompliance() {
        assertTrue(true);
    }

    public void test_g_v1_out_loopX1_loops_lt_3X_propertyXnameX(Iterator<String> pipe) {
        List<String> names = new ArrayList<String>();
        while (pipe.hasNext()) {
            names.add(pipe.next());
        }
        assertEquals(names.size(), 2);
        assertTrue(names.contains("ripple"));
        assertTrue(names.contains("lop"));
    }

    public void test_g_v1_asXhereX_out_loopXhere_loops_lt_3X_propertyXnameX(Iterator<String> pipe) {
        this.test_g_v1_out_loopX1_loops_lt_3X_propertyXnameX(pipe);
    }

    public void test_g_V_out_loopX1_loops_lt_3X_propertyXnameX(Iterator<String> pipe) {
        List<String> names = new ArrayList<String>();
        while (pipe.hasNext()) {
            names.add(pipe.next());
        }
        assertEquals(names.size(), 2);
        assertTrue(names.contains("ripple"));
        assertTrue(names.contains("lop"));
    }

    public void test_g_V_asXhereX_out_loopXhere_loops_lt_3X_propertyXnameX(Iterator<String> pipe) {
        this.test_g_V_out_loopX1_loops_lt_3X_propertyXnameX(pipe);
    }
}