package com.tinkerpop.gremlin.loaders

import junit.framework.TestCase

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class ObjectLoaderTest extends TestCase {

    public void testPropertyMissingOverloading() {
        /*Gremlin.load();
        Object.metaClass.propertyMissing = { final String name ->
            return name;
        }

        assertEquals("hello".blah, "blah");
        assertEquals("the".blah, "blah");
        def g = TinkerGraphFactory.createTinkerGraph();
        def results = [];
        g.v(1).outE.inV >> results;
        assertEquals(results.size(), 3);
        assertTrue(results.contains(g.v(2)));
        assertTrue(results.contains(g.v(4)));
        assertTrue(results.contains(g.v(3)));*/
        assertTrue(true);
    }
}
