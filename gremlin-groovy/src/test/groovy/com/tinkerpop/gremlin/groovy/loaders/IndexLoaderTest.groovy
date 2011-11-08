package com.tinkerpop.gremlin.groovy.loaders

import com.tinkerpop.blueprints.pgm.Graph
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.Gremlin
import com.tinkerpop.gremlin.Tokens.T
import junit.framework.TestCase

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class IndexLoaderTest extends TestCase {
    public void testIndexShortcuts() throws Exception {
        Gremlin.load();
        Graph g = TinkerGraphFactory.createTinkerGraph();

        assertEquals(g.idx(T.v)[[name: 'marko']].next(), g.v(1));
        assertEquals(g.idx(T.e)[[label: 'created']].count(), 4);
        assertEquals(g.idx(T.v).get('name', 'marko').next(), g.v(1));
        assertEquals(g.idx(T.e).get('label', 'created').count(), 4);
    }

    public void testIndexHitIntoTraversal() throws Exception {
        Gremlin.load();
        Graph g = TinkerGraphFactory.createTinkerGraph();

        def results = [];
        g.idx(T.v)[[lang: 'java']].inE.outV.fill(results);
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
