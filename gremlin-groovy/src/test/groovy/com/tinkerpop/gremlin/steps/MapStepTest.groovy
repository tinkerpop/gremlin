package com.tinkerpop.gremlin.steps

import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.Gremlin
import junit.framework.TestCase

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class MapStepTest extends TestCase {

    public void testPropertyMaps() {
        Gremlin.load();
        def g = TinkerGraphFactory.createTinkerGraph();
        def results = []
        g.V.map.transform {it.name} >> results;
        assertEquals(results, ["lop", "vadas", "marko", "peter", "ripple", "josh"]);
    }
}
