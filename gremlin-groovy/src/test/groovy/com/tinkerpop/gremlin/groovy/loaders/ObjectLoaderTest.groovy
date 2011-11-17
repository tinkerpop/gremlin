package com.tinkerpop.gremlin.groovy.loaders

import com.tinkerpop.gremlin.groovy.Gremlin
import junit.framework.TestCase

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class ObjectLoaderTest extends TestCase {

    public void testMapRange() {
        Gremlin.load();
        def m = ["a": 2, "b": 3, "c": 4, "d": 5, "e": 6];
        def x = m[0..1].keySet();
        assertTrue(x.contains("a"))
        assertTrue(x.contains("b"))
        assertEquals(x.size(), 2);

        x = m[1..3].keySet();
        assertTrue(x.contains("b"))
        assertTrue(x.contains("c"))
        assertTrue(x.contains("d"))
        assertEquals(x.size(), 3);

        x = m[1..<3].keySet();
        assertTrue(x.contains("b"))
        assertTrue(x.contains("c"))
        assertEquals(x.size(), 2);

        x = m[0..20];
        assertEquals(x.size(), m.size());
        assertEquals(x, m);

    }
}
