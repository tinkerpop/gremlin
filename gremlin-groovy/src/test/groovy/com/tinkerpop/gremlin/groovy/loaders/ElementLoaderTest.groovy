package com.tinkerpop.gremlin.groovy.loaders

import com.tinkerpop.blueprints.Graph
import com.tinkerpop.blueprints.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.groovy.Gremlin
import junit.framework.TestCase

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class ElementLoaderTest extends TestCase {

    public void testGetAtWithKey() {
        Gremlin.load();
        Graph g = TinkerGraphFactory.createTinkerGraph();
        assertEquals(g.v(1)['name'], 'marko')
        assertEquals(g.v(1)['id'], '1')
        assertEquals(g.v(1)['age'], 29)

        assertEquals(g.e(7)['label'], 'knows')
        assertEquals(g.e(7)['weight'], 0.5f)
        assertEquals(g.e(7)['id'], '7')
    }

    public void testSetAtWithKey() {
        Gremlin.load();
        Graph g = TinkerGraphFactory.createTinkerGraph();
        g.v(1)['name'] = 'marko2'
        assertEquals(g.v(1)['name'], 'marko2')
        g.v(1)['age'] = 31
        assertEquals(g.v(1)['age'], 31)

        g.e(7)['weight'] = 100f
        assertEquals(g.e(7).weight, 100f)

        try {
            g.v(1)['id'] = 10
            assertFalse(true)
        } catch (Exception e) {
            assertTrue(true)
        }

        try {
            g.e(7)['id'] = 10
            assertFalse(true)
        } catch (Exception e) {
            assertTrue(true)
        }

        try {
            g.e(7)['label'] = 'new label'
            assertFalse(true)
        } catch (Exception e) {
            assertTrue(true)
        }
    }

    public void testKeysValuesMapOnElement() {
        Gremlin.load();
        Graph g = TinkerGraphFactory.createTinkerGraph();
        assertEquals(g.v(1).values().size(), 2);
        assertEquals(g.v(1).keys().size(), 2);
        assertEquals(g.v(1).map().keySet(), g.v(1).keys());
        assertTrue(g.v(1).values().contains("marko"));
        assertTrue(g.v(1).values().contains(29));
        assertTrue(g.v(1).keys().contains("name"));
        assertTrue(g.v(1).keys().contains("age"));
    }

    public void testGetPropertiesOnElement() {
        Gremlin.load();
        Graph g = TinkerGraphFactory.createTinkerGraph()
        assertEquals(g.v(1).name, "marko")
        assertEquals(g.v(1).age, 29)
        def results = []
        [g.v(1), g.v(2)].name._().fill(results)
        assertEquals(results.size(), 2)
        assertEquals(results.get(0), "marko")
        assertEquals(results.get(1), "vadas")
    }

    public void testSetPropertiesOnElement() {
        Gremlin.load();
        Graph g = TinkerGraphFactory.createTinkerGraph()
        assertEquals(g.v(1).name = 'marko rodriguez', "marko rodriguez")
        assertEquals(g.v(1).age = 32, 32)
        def results = []
        [g.v(1), g.v(2)]._().name.fill(results)
        assertEquals(results.size(), 2)
        assertEquals(results.get(0), "marko rodriguez")
        assertEquals(results.get(1), "vadas")
    }
}
