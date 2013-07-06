package com.tinkerpop.gremlin.test.filter;

import com.tinkerpop.pipes.util.PipeHelper;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class DedupStepTest extends TestCase {

    public void testCompliance() {
        assertTrue(true);
    }

    public void test_g_V_both_dedup_name(Iterator<String> pipe) {
        List<String> names = new ArrayList<String>();
        PipeHelper.fillCollection(pipe, names);
        assertEquals(names.size(), 6);
        assertTrue(names.contains("marko"));
        assertTrue(names.contains("vadas"));
        assertTrue(names.contains("lop"));
        assertTrue(names.contains("josh"));
        assertTrue(names.contains("ripple"));
        assertTrue(names.contains("peter"));
        assertFalse(pipe.hasNext());
    }

    public void test_g_V_both_dedupXlangX_name(Iterator<String> pipe) {
        List<String> names = new ArrayList<String>();
        PipeHelper.fillCollection(pipe, names);
        assertEquals(names.size(), 2);
        assertTrue(names.contains("marko") || names.contains("peter") || names.contains("josh") || names.contains("vadas"));
        assertTrue(names.contains("lop") || names.contains("ripple"));
        assertFalse(pipe.hasNext());
    }
}
