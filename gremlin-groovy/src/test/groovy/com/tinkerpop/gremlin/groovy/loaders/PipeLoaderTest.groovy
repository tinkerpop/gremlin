package com.tinkerpop.gremlin.groovy.loaders

import com.tinkerpop.blueprints.Graph
import com.tinkerpop.blueprints.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.groovy.Gremlin
import junit.framework.TestCase

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class PipeLoaderTest extends TestCase {

    public void testCount() {
        Gremlin.load();
        Graph g = TinkerGraphFactory.createTinkerGraph();
        assertEquals(g.V.count(), 6l);
        assertEquals(g.E.count(), 6l);
        assertEquals(g.v(1).outE().count(), 3l);
        assertEquals(g.v(1).outE('blah').count(), 0l);
    }

    public void testMean() {
        Gremlin.load()
        def numbers = [1, 2, 3, 4, 5];
        assertEquals(numbers.mean(), 3.0d)
    }
}
