package com.tinkerpop.gremlin.groovy.loaders

import com.tinkerpop.blueprints.Edge
import com.tinkerpop.blueprints.Graph
import com.tinkerpop.blueprints.Vertex
import com.tinkerpop.blueprints.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.groovy.Gremlin
import junit.framework.TestCase

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class IndexLoaderTest extends TestCase {

    public void testIndexShortcuts() throws Exception {
        Gremlin.load();
        Graph g = TinkerGraphFactory.createTinkerGraph();
        g.createKeyIndex('name', Vertex.class);
        g.createKeyIndex('weight', Edge.class);
        assertEquals(g.v(1), g.V('name', 'marko').next());
        assertEquals(2, g.E('weight', 0.4f).count());
    }

    public void testIndexHitIntoTraversal() throws Exception {
        Gremlin.load();
        Graph g = TinkerGraphFactory.createTinkerGraph();
        g.createKeyIndex('lang', Vertex.class);

        def results = [];
        g.V('lang', 'java').inE.outV.fill(results);
        assertEquals(results.size(), 4);
        assertTrue(results.contains(g.v(1)));
        assertTrue(results.contains(g.v(6)));
        assertTrue(results.contains(g.v(4)));
    }

    public void testIndexLookupError() throws Exception {
        Gremlin.load();
        Graph g = TinkerGraphFactory.createTinkerGraph();
        assertNull(g.idx('blah'))
    }
}
